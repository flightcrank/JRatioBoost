
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Date;
import java.util.regex.*;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//Swing GUI program that lets you report to a private torrent tracker that you are uploading data from a torrent
//when you really are not uploading anyhting at all
public class JRatioBoost {
	
	private static JFrame frame;
	private JPanel panel1;
	private JButton openFileButton;
	private JSpinner spinner1;
	private JSpinner spinner2;
	private JButton connectButton;
	private JLabel torrent_name;
	private JLabel tracker;
	private JLabel info_hash;
	private JLabel peer_id;
	private JLabel size;
	private JLabel seeders;
	private JLabel leechers;
	private JLabel update;
	private JLabel uploaded;
	private JLabel downloaded;
	private JLabel date;
	private JPopupMenu menu;
	private JMenuItem[] trackerList;
	private JMenuItem about;
	private JMenuItem updateInterval;
	private JMenu changeTracker;
	
	long upAmount = 0;
	TorrentInfo tInfo;
	TrackerConnect tc;
	Timer timer;
	
	public JRatioBoost() {
	
		//set up the program window frame
		frame = new JFrame("JRatioBoost");
		frame.setContentPane(panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//set up menu
		menu = new JPopupMenu();
		about = new JMenuItem("About");
		updateInterval = new JMenuItem("Update Interval");
		changeTracker = new JMenu("Tracker");
		changeTracker.setEnabled(false);
		menu.add(changeTracker);
		menu.add(updateInterval);
		menu.addSeparator();
		menu.add(about);
		
		//attach action listeners to UI widgets
		//open button
		openFileButton.addActionListener(new OpenAction());
		connectButton.addActionListener(new ConnectAction());
		panel1.setComponentPopupMenu(menu);
		about.addActionListener(new AboutAction());
		updateInterval.addActionListener(new UpdateAction());
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
				} catch (Exception e) {
				
				}
				
				new JRatioBoost();
			}
		});
	}

	class OpenAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD);
			fd.setFile("*.torrent");
			fd.setVisible(true);
			changeTracker.setEnabled(false);
			
			if (fd.getFile() != null) {
				
				tInfo = new TorrentInfo(fd.getFiles()[0].getPath());
				//update Labels
				Pattern p = Pattern.compile("\\.\\w+\\.\\w+{2,3}");
				Matcher m = p.matcher(tInfo.announce);
				
				if (m.find()) {
					
					tracker.setText(m.group().substring(1));
					
				} else {
					
					tracker.setText(tInfo.announce);
				}
				
				torrent_name.setText("<html><font size=5>" + tInfo.name + "</font><html>");
				info_hash.setText(tInfo.hexString(tInfo.infoHash));
				peer_id.setText(tInfo.hexString(tInfo.peerId));
				size.setText(new SizeConvert(Long.parseLong(tInfo.size)).toString());
				Date d = new Date(Long.parseLong(tInfo.creationDate) * 1000);
				date.setText(DateFormat.getDateInstance().format(d));
				
				//remove all item from the tracker submenu so any subsequent calls to
				//OpenAction doesn't continual add list of JMenuItems to the submenu
				changeTracker.removeAll();
				
				//if torrent has multiple trackers listed, add them to a popumenu list
				int arrSize = tInfo.announceList.size();
				
				if (arrSize > 0) {
					
					changeTracker.setEnabled(true);
					
					for (String val : tInfo.announceList) {
						
						JMenuItem item = changeTracker.add(val);
						item.addActionListener(new ChangeTrackerAction());
					}
				}
			}
		}
	}
	
	class ChangeTrackerAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JMenuItem item = (JMenuItem) e.getSource();
			tInfo.announce = item.getText();
			
			Pattern p = Pattern.compile("\\.\\w+\\.\\w+{2,3}");
			Matcher m = p.matcher(tInfo.announce);
			
			if (m.find()) {
				
				tracker.setText("<html><a href=\"www.google.com\">" + m.group().substring(1) + "</a></html>");
				tracker.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			} else {
				
				tracker.setText(tInfo.announce);
			}
			
		}
	}
	
	class ConnectAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//connect button was pressed
			if (connectButton.getText().equals("Connect")) {
			
				upAmount = 0;
				connectButton.setText("Connecting..");
				
				//connect to tracker in a diffrent thread so it wont
				//stop the GUI from respoding while the TrackerConnect object
				//precesses the request
				ConnectTask ct = new ConnectTask();
				ct.execute();
				
			//stop button was pressed
			} else {
				
				connectButton.setText("Connect");
				//connectButton.setIcon(UIManager.getIcon("FileView.computerIcon"));
				timer.cancel();
			}
		}
	}
	
	class UpdateAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			UpdateAmount ua = new UpdateAmount(tc);
			ua.pack();
			ua.setLocationRelativeTo(null);
			ua.setVisible(true);
		}
	}
	
	class AboutAction implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			About a = new About();
			a.pack();
			a.setLocationRelativeTo(null);
			a.setVisible(true);
		}
	}
	
	class ConnectTask extends SwingWorker<Void, Void> {
		
		//execute this method in its own background thread
		@Override
		public Void doInBackground() {
			
			panel1.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tc = new TrackerConnect(tInfo);
			return null;
		}
		
		//execute this function on Swings event dispatch thread when
		//background thread has finished executing its statements
		@Override
		protected void done() {
			
			panel1.setCursor(null);
			connectButton.setText("Stop");

			//send request at regular intervals
			timer = new Timer();
			timer.scheduleAtFixedRate(new UpdateTask(), 1000, 1000);
		}
	}

	class UpdateTask extends TimerTask {
		
		@Override
		public void run() {
			
			int upSpeed = (Integer) spinner1.getValue();
			upAmount += SizeConvert.KBToB(upSpeed);
			
			//update GUI label with tracker response info
			seeders.setText(tc.seeders);
			leechers.setText(tc.leechers);
			update.setText(tc.interval);
			downloaded.setText("100%");
			uploaded.setText(new SizeConvert(upAmount).toString());
			
			int nextUpdate = Integer.parseInt(update.getText());
			
			if (nextUpdate <= 0) {
				
				//stop the timer thread from executing to prevent the timer task
				//from continuing to execute while the http request is being made
				//by the TrackerConnect instance
				timer.cancel();
				
				//send get request to tracker with upload/download data
				tc.connect(String.format("%d", upAmount), "0");
				nextUpdate = Integer.parseInt(tc.interval);
				
				//the new http request has been made, start a new timer task
				timer = new Timer();
				timer.scheduleAtFixedRate(new UpdateTask(), 1000, 1000);
			}
			
			nextUpdate--;
			
			tc.interval = String.format("%d", nextUpdate);
		}
	}
	
	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}
	
	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		panel1.setMinimumSize(new Dimension(450, 400));
		panel1.setPreferredSize(new Dimension(450, 400));
		panel1.setRequestFocusEnabled(false);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel2, gbc);
		openFileButton = new JButton();
		openFileButton.setIcon(UIManager.getIcon("FileView.directoryIcon"));
		openFileButton.setText("Open File");
		openFileButton.setToolTipText("Open torrent file");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.ipadx = 5;
		gbc.ipady = 5;
		panel2.add(openFileButton, gbc);
		torrent_name = new JLabel();
		torrent_name.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 5, 0, 5);
		panel2.add(torrent_name, gbc);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel3, gbc);
		panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Torrent Info"));
		final JLabel label1 = new JLabel();
		label1.setText("<html><b>Tracker:</b></html>");
		label1.setToolTipText("The Tracker to report upload/download amounts too");
		label1.putClientProperty("html.disable", Boolean.FALSE);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);
		panel3.add(label1, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("<html><b>Info Hash:</b></html>");
		label2.setToolTipText("20byte URLencoded hash generated from the torrent files \"info\" value");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(label2, gbc);
		final JLabel label3 = new JLabel();
		label3.setText("<html><b>Size:</b></html>");
		label3.setToolTipText("The file size of the torrents file or files");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(label3, gbc);
		final JLabel label4 = new JLabel();
		label4.setText("<html><b>Peer ID:</b></html>");
		label4.setToolTipText("20byte URLencoded peer id, used to tell the tracker what torrent client is being used");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(label4, gbc);
		tracker = new JLabel();
		tracker.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(tracker, gbc);
		info_hash = new JLabel();
		info_hash.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(info_hash, gbc);
		peer_id = new JLabel();
		peer_id.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(peer_id, gbc);
		size = new JLabel();
		size.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0, 5, 0, 0);
		panel3.add(size, gbc);
		final JLabel label5 = new JLabel();
		label5.setText("<html><b>Date:</b></html>");
		label5.setToolTipText("The date the torrent file was made");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0, 5, 5, 0);
		panel3.add(label5, gbc);
		date = new JLabel();
		date.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets = new Insets(0, 5, 5, 0);
		panel3.add(date, gbc);
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel4, gbc);
		panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tracker Input/Ouput"));
		final JLabel label6 = new JLabel();
		label6.setText("<html><b>Seeders:</b></html>");
		label6.setToolTipText("How many people are uploading the torrent");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 0, 5);
		panel4.add(label6, gbc);
		final JLabel label7 = new JLabel();
		label7.setText("<html><b>Leechers:</b></html>");
		label7.setToolTipText("How many people are downloaded the torrent");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 0, 5);
		panel4.add(label7, gbc);
		seeders = new JLabel();
		seeders.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(seeders, gbc);
		leechers = new JLabel();
		leechers.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(leechers, gbc);
		final JLabel label8 = new JLabel();
		label8.setText("<html><b>Downloaded:</b></html>");
		label8.setToolTipText("Amount that has been downloaded");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 0, 5);
		panel4.add(label8, gbc);
		final JLabel label9 = new JLabel();
		label9.setText("<html><b>Uploaded:</b></html>");
		label9.setToolTipText("Amount that has been uploaded");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 5, 0, 5);
		panel4.add(label9, gbc);
		final JLabel label10 = new JLabel();
		label10.setText("<html><b>Update Interval:</b></html>");
		label10.setToolTipText("Number of seconds that a report will be made to the tracker");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 5, 5, 5);
		panel4.add(label10, gbc);
		uploaded = new JLabel();
		uploaded.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(uploaded, gbc);
		update = new JLabel();
		update.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel4.add(update, gbc);
		downloaded = new JLabel();
		downloaded.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		panel4.add(downloaded, gbc);
		final JPanel panel5 = new JPanel();
		panel5.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel5, gbc);
		final JLabel label11 = new JLabel();
		//label11.setIcon(new ImageIcon(getClass().getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
		label11.setText("<html><b>Upload Speed:</b></html>");
		label11.setToolTipText("Upload speed in KB/s");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		panel5.add(label11, gbc);
		final JLabel label12 = new JLabel();
		//label12.setIcon(new ImageIcon(getClass().getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		label12.setText("<html><b>Download Speed:</b></html>");
		label12.setToolTipText("Download speed in Kb/s");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panel5.add(label12, gbc);
		connectButton = new JButton();
		connectButton.setIcon(UIManager.getIcon("FileView.computerIcon"));
		connectButton.setText("Connect");
		connectButton.setToolTipText("Connect to the torrent Tracker");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		panel5.add(connectButton, gbc);
		spinner1 = new JSpinner();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 5, 5, 5);
		panel5.add(spinner1, gbc);
		spinner2 = new JSpinner();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 5, 0, 5);
		panel5.add(spinner2, gbc);
	}
	
	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return panel1;
	}
	
}
