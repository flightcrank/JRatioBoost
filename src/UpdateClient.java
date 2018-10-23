
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.text.*;
import java.util.HashMap;

public class UpdateClient extends JDialog {
	
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton buttonCancel;
	private JComboBox comboBox1;
	private JFormattedTextField formattedTextField1;
	private JSpinner spinner1;
	HashMap<String, String> clients;
	
	public UpdateClient(TorrentInfo ti) {
		
		clients = new HashMap<String, String>();
		clients.put("KTorrent", "KT");
		clients.put("Transmission", "TR");
		clients.put("JavaTorrent", "JT");
		clients.put("qBittorrent", "qB");
		clients.put("µTorrent", "UT");
		
		for (String val : clients.keySet()) {
			
			comboBox1.addItem(val);
		}
		
		DefaultFormatterFactory factory = new DefaultFormatterFactory(versionFormat("#.#.#.#"));
		formattedTextField1.setFormatterFactory(factory);
		
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);
		
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOK(ti);
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});
		
		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});
		
		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	}
	
	private void onOK(TorrentInfo ti) {
		
		// add your code here
		String version = (String) formattedTextField1.getValue();
		
		if (version != null) {
			
			String name = (String) comboBox1.getSelectedItem();
			ti.computePeerId(new String(clients.get(name) + version.replace(".", "")));
		}
		
		dispose();
	}
	
	private void onCancel() {
		// add your code here if necessary
		dispose();
	}
	
	protected MaskFormatter versionFormat(String s) {
		
		MaskFormatter formatter = null;
		
		try {
			formatter = new MaskFormatter(s);
			formatter.setPlaceholderCharacter('0');
			
		} catch (ParseException exc) {
			
			System.err.println("formatter is bad: " + exc.getMessage());
		}
		
		return formatter;
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
		contentPane = new JPanel();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setPreferredSize(new Dimension(270, 170));
		contentPane.setRequestFocusEnabled(true);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		contentPane.add(panel1, gbc);
		panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Change Torrent Client"));
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel2, gbc);
		final JLabel label1 = new JLabel();
		label1.setText("Client Name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(0, 0, 0, 5);
		panel2.add(label1, gbc);
		comboBox1 = new JComboBox();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 5);
		panel2.add(comboBox1, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("Version:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.insets = new Insets(5, 0, 0, 5);
		panel2.add(label2, gbc);
		formattedTextField1 = new JFormattedTextField();
		formattedTextField1.setColumns(5);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 0, 0, 0);
		panel2.add(formattedTextField1, gbc);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		gbc.insets = new Insets(5, 5, 5, 5);
		panel1.add(panel3, gbc);
		buttonOK = new JButton();
		buttonOK.setText("OK");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 5);
		panel3.add(buttonOK, gbc);
		buttonCancel = new JButton();
		buttonCancel.setText("Cancel");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel3.add(buttonCancel, gbc);
	}
	
	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contentPane;
	}
}
