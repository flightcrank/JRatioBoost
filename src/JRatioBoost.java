
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

public class JRatioBoost extends javax.swing.JFrame {

	long upAmount = 0;
	TorrentInfo tInfo;
	TrackerConnect tc;
	Timer timer;

	public JRatioBoost() {

		initComponents();
	}

        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                jSeparator1 = new javax.swing.JSeparator();
                jPopupMenu1 = new javax.swing.JPopupMenu();
                changeTracker = new javax.swing.JMenu();
                changeClient = new javax.swing.JMenu();
                jPopupMenu1.add(changeTracker);
                jPopupMenu1.add(changeClient);
                jMenuItem3 = new javax.swing.JMenuItem();
                jPopupMenu1.add(jMenuItem3);
                jPopupMenu1.add(jSeparator1);
                jMenuItem4 = new javax.swing.JMenuItem();
                jPopupMenu1.add(jMenuItem4);
                jMenuItem5 = new javax.swing.JMenuItem();
                jMenuItem6 = new javax.swing.JMenuItem();
                jMenuItem7 = new javax.swing.JMenuItem();
                changeClient.add(jMenuItem5);
                changeClient.add(jMenuItem6);
                changeClient.add(jMenuItem7);
                jPanel6 = new javax.swing.JPanel();
                jPanel6.setComponentPopupMenu(jPopupMenu1);
                jPanel3 = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                tracker = new javax.swing.JLabel();
                info_hash = new javax.swing.JLabel();
                peer_id = new javax.swing.JLabel();
                size = new javax.swing.JLabel();
                date = new javax.swing.JLabel();
                jPanel2 = new javax.swing.JPanel();
                jLabel2 = new javax.swing.JLabel();
                jLabel15 = new javax.swing.JLabel();
                jLabel16 = new javax.swing.JLabel();
                jLabel17 = new javax.swing.JLabel();
                jLabel18 = new javax.swing.JLabel();
                seeders = new javax.swing.JLabel();
                leechers = new javax.swing.JLabel();
                downloaded = new javax.swing.JLabel();
                uploaded = new javax.swing.JLabel();
                update = new javax.swing.JLabel();
                jPanel4 = new javax.swing.JPanel();
                openFileButton = new javax.swing.JButton();
                torrent_name = new javax.swing.JLabel();
                jSpinLoader1 = new JSpinLoader();
                jSpinLoader1.setSize(6);
                jPanel5 = new javax.swing.JPanel();
                jLabel6 = new javax.swing.JLabel();
                jSpinner1 = new javax.swing.JSpinner();
                connectButton = new javax.swing.JButton();
                jLabel7 = new javax.swing.JLabel();
                jSpinner4 = new javax.swing.JSpinner();
                jArrow1 = new JArrow();
                jArrow2 = new JArrow();
                jArrow2.setDirection(JArrow.DOWN);

                changeTracker.setText("Tracker");
                changeTracker.setEnabled(false);

                changeClient.setText("Client");
                changeClient.setEnabled(false);

                jMenuItem3.setText("Update Interval");
                jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem3ActionPerformed(evt);
                        }
                });

                jMenuItem4.setText("About");
                jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem4ActionPerformed(evt);
                        }
                });

                jMenuItem5.setText("KTorrent 5.11");
                jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem5ActionPerformed(evt);
                        }
                });

                jMenuItem6.setText("Transmission 2.94");
                jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem6ActionPerformed(evt);
                        }
                });

                jMenuItem7.setText("Custom Client");
                jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem7ActionPerformed(evt);
                        }
                });

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("JRatioBoost");

                jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
                jPanel6.setLayout(new java.awt.BorderLayout());

                jPanel3.setLayout(new java.awt.GridLayout(2, 0));

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Torrent Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                jPanel1.setLayout(new java.awt.GridBagLayout());

                jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel1.setText("Tracker:");
                jLabel1.setAlignmentX(0.5F);
                jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
                jPanel1.add(jLabel1, gridBagConstraints);

                jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel3.setText("Info_Hash:");
                jLabel3.setAlignmentX(0.5F);
                jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                jPanel1.add(jLabel3, gridBagConstraints);

                jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel4.setText("Peer_ID:");
                jLabel4.setAlignmentX(0.5F);
                jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                jPanel1.add(jLabel4, gridBagConstraints);

                jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel8.setText("Size:");
                jLabel8.setAlignmentX(0.5F);
                jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                jPanel1.add(jLabel8, gridBagConstraints);

                jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel9.setText("Date:");
                jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                jLabel9.setAlignmentY(0.0F);
                jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                jPanel1.add(jLabel9, gridBagConstraints);

                tracker.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                jPanel1.add(tracker, gridBagConstraints);

                info_hash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel1.add(info_hash, gridBagConstraints);

                peer_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel1.add(peer_id, gridBagConstraints);

                size.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel1.add(size, gridBagConstraints);

                date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                date.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                jPanel1.add(date, gridBagConstraints);

                jPanel3.add(jPanel1);

                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tracker Output", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                jPanel2.setLayout(new java.awt.GridBagLayout());

                jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel2.setText("Seeders:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
                jPanel2.add(jLabel2, gridBagConstraints);

                jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel15.setText("Leechers:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                jPanel2.add(jLabel15, gridBagConstraints);

                jLabel16.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel16.setText("Downloaded:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                jPanel2.add(jLabel16, gridBagConstraints);

                jLabel17.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel17.setText("Uploaded:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                jPanel2.add(jLabel17, gridBagConstraints);

                jLabel18.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
                jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel18.setText("Update Interval:");
                jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                jPanel2.add(jLabel18, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
                jPanel2.add(seeders, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel2.add(leechers, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel2.add(downloaded, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel2.add(uploaded, gridBagConstraints);

                update.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                jPanel2.add(update, gridBagConstraints);

                jPanel3.add(jPanel2);

                jPanel6.add(jPanel3, java.awt.BorderLayout.CENTER);

                jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
                jPanel4.setLayout(new java.awt.GridBagLayout());

                openFileButton.setText("Open Torrent");
                openFileButton.setMargin(new java.awt.Insets(5, 0, 5, 0));
                openFileButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openFileButtonActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
                jPanel4.add(openFileButton, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                jPanel4.add(torrent_name, gridBagConstraints);

                jSpinLoader1.setMinimumSize(new java.awt.Dimension(30, 30));
                jPanel4.add(jSpinLoader1, new java.awt.GridBagConstraints());

                jPanel6.add(jPanel4, java.awt.BorderLayout.PAGE_START);

                jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
                jPanel5.setLayout(new java.awt.GridBagLayout());

                jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel6.setText("Upload (kb/s)");
                jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                jPanel5.add(jLabel6, gridBagConstraints);

                jSpinner1.setModel(new javax.swing.SpinnerNumberModel(40, 0, 9999, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.5;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel5.add(jSpinner1, gridBagConstraints);

                connectButton.setText("Connect");
                connectButton.setMargin(new java.awt.Insets(0, 10, 0, 10));
                connectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                connectButtonActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridheight = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 0.5;
                jPanel5.add(connectButton, gridBagConstraints);

                jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel7.setText("Download (kb/s)");
                jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                jPanel5.add(jLabel7, gridBagConstraints);

                jSpinner4.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9999, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.5;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                jPanel5.add(jSpinner4, gridBagConstraints);

                jArrow1.setMinimumSize(new java.awt.Dimension(20, 20));
                jArrow1.setPreferredSize(new java.awt.Dimension(20, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                jPanel5.add(jArrow1, gridBagConstraints);

                jArrow2.setMinimumSize(new java.awt.Dimension(20, 20));
                jArrow2.setPreferredSize(new java.awt.Dimension(20, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                jPanel5.add(jArrow2, gridBagConstraints);

                jPanel6.add(jPanel5, java.awt.BorderLayout.SOUTH);

                getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed

	FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
	    fd.setVisible(true);
	    changeTracker.setEnabled(false);
	    changeClient.setEnabled(true);

	    if (fd.getFile() != null) {

		    try {

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

		    } catch (Exception ex) {

			    JOptionPane.showMessageDialog(this, "Error: Invalid torrent file. \n" + ex, "Error message", JOptionPane.ERROR_MESSAGE);
			    ex.printStackTrace();
		    }
	    }
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
	    
		if (connectButton.getText().equals("Connect")) {

			openFileButton.setEnabled(false);
			upAmount = 0;
			connectButton.setText("Connecting..");
			jSpinLoader1.start();

			//connect to tracker in a different thread so it wont
			//stop the GUI from responding while the TrackerConnect object
			//precesses the request
			ConnectTask ct = new ConnectTask();
			ct.execute();

		//stop button was pressed
		} else {

			openFileButton.setEnabled(true);
			connectButton.setText("Connect");
			timer.cancel();
			jSpinLoader1.stop();
		}
    }//GEN-LAST:event_connectButtonActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

	    About a = new About();
	    a.pack();
	    a.setLocationRelativeTo(null);
	    a.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

        private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
		
		UpdateAmount ua = new UpdateAmount(tc);
		ua.pack();
		ua.setLocationRelativeTo(null);
		ua.setVisible(true);          
        }//GEN-LAST:event_jMenuItem3ActionPerformed

        private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
                
		tInfo.computePeerId("KT5110");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
        }//GEN-LAST:event_jMenuItem5ActionPerformed

        private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
		
		tInfo.computePeerId("TR2940");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
        }//GEN-LAST:event_jMenuItem6ActionPerformed

        private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
		
		UpdateClient c = new UpdateClient(tInfo);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);          
		peer_id.setText(tInfo.hexString(tInfo.peerId));
        }//GEN-LAST:event_jMenuItem7ActionPerformed

	class ChangeTrackerAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JMenuItem item = (JMenuItem) e.getSource();
			tInfo.announce = item.getText();

			Pattern p = Pattern.compile("\\.\\w+\\.\\w+{2,3}");
			Matcher m = p.matcher(tInfo.announce);

			if (m.find()) {

				tracker.setText(m.group().substring(1));

			} else {

				tracker.setText(tInfo.announce);
			}
		}
	}
	
	class ConnectTask extends SwingWorker<Void, Void> {
		
		//execute this method in its own background thread
		@Override
		public Void doInBackground() {
			
			jPanel6.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			tc = new TrackerConnect(tInfo);
			return null;
		}
		
		//execute this function on Swings event dispatch thread when
		//background thread has finished executing its statements
		@Override
		protected void done() {
			
			jPanel6.setCursor(null);
			connectButton.setText("Stop");
			
			//send request at regular intervals
			timer = new Timer();
			timer.scheduleAtFixedRate(new UpdateTask(), 1000, 1000);
		}
	}
	
	class UpdateTask extends TimerTask {
		
		@Override
		public void run() {
			
			int upSpeed = (Integer) jSpinner1.getValue();
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

	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				//Use native look and feel
				try {
					//for linux systems just use nimbus look and feel
					if (System.getProperty("os.name").equals("Linux")) {

						//UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

					} else {

						//native l&f
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}

				} catch (Exception e) {

					System.out.println(e);
				}

				//create and show the Swing GUI
				new JRatioBoost().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu changeClient;
        private javax.swing.JMenu changeTracker;
        private javax.swing.JButton connectButton;
        private javax.swing.JLabel date;
        private javax.swing.JLabel downloaded;
        private javax.swing.JLabel info_hash;
        private JArrow jArrow1;
        private JArrow jArrow2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JMenuItem jMenuItem3;
        private javax.swing.JMenuItem jMenuItem4;
        private javax.swing.JMenuItem jMenuItem5;
        private javax.swing.JMenuItem jMenuItem6;
        private javax.swing.JMenuItem jMenuItem7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JSeparator jSeparator1;
        private JSpinLoader jSpinLoader1;
        private javax.swing.JSpinner jSpinner1;
        private javax.swing.JSpinner jSpinner4;
        private javax.swing.JLabel leechers;
        private javax.swing.JButton openFileButton;
        private javax.swing.JLabel peer_id;
        private javax.swing.JLabel seeders;
        private javax.swing.JLabel size;
        private javax.swing.JLabel torrent_name;
        private javax.swing.JLabel tracker;
        private javax.swing.JLabel update;
        private javax.swing.JLabel uploaded;
        // End of variables declaration//GEN-END:variables
}
