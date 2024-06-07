
import java.awt.Cursor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JRatioBoost extends javax.swing.JFrame {

	int indexSelected = 0;
	String port;
	ArrayList<TorrentElement> torrentElement; 

	public JRatioBoost(String[] args) {

		initComponents();
		this.port = "6881";
		torrentElement = new ArrayList<>();
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
                jMenuItem1 = new javax.swing.JMenuItem();
                jMenuItem3 = new javax.swing.JMenuItem();
                jPopupMenu1.add(jMenuItem3);
                jPopupMenu1.add(jMenuItem1);
                jPopupMenu1.add(jSeparator1);
                jMenuItem4 = new javax.swing.JMenuItem();
                jPopupMenu1.add(jMenuItem4);
                jMenuItem5 = new javax.swing.JMenuItem();
                jMenuItem6 = new javax.swing.JMenuItem();
                jMenuItem7 = new javax.swing.JMenuItem();
                changeClient.add(jMenuItem5);
                changeClient.add(jMenuItem6);
                changeClient.add(jMenuItem7);
                jSpinLoader1 = null;
                WindowPanel = new javax.swing.JPanel();

                WindowPanel.setComponentPopupMenu(jPopupMenu1);
                listPanel = new javax.swing.JPanel();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                torrentList = new javax.swing.JList<>();
                DefaultListModel demoList = new DefaultListModel();
                torrentList.setModel(demoList);

                torrentList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {

                                listListen(e);
                        }
                });
                TorrentDataPanel = new javax.swing.JPanel();
                InfoPanel = new javax.swing.JPanel();
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
                OutputPanel = new javax.swing.JPanel();
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
                jProgressBar1 = new javax.swing.JProgressBar();
                ConnectPanel = new javax.swing.JPanel();
                jSpinner1 = new javax.swing.JSpinner();
                connectButton = new javax.swing.JButton();
                jSpinLoader1 = new JSpinLoader(25, 25, connectButton);
                connectButton.setIcon(new ImageIcon(jSpinLoader1.createSpinnerImage(25, 25, 0f)));
                //connectButton.setHorizontalTextPosition(textPosition);
                jArrow1 = new JArrow();
                jLabel6 = new javax.swing.JLabel();
                openPanel = new javax.swing.JPanel();
                torrent_name = new javax.swing.JLabel();
                openFileButton = new javax.swing.JButton();

                jPopupMenu1.setFont(new java.awt.Font("Noto Sans Regular", 0, 17)); // NOI18N

                changeTracker.setText("Tracker");
                changeTracker.setEnabled(false);
                changeTracker.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

                changeClient.setText("Client");
                changeClient.setEnabled(false);
                changeClient.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

                jMenuItem1.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem1.setText("Update Port");
                jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem1ActionPerformed(evt);
                        }
                });

                jMenuItem3.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem3.setText("Update Interval");
                jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem3ActionPerformed(evt);
                        }
                });

                jMenuItem4.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem4.setText("About");
                jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem4ActionPerformed(evt);
                        }
                });

                jMenuItem5.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem5.setText("KTorrent 5.11");
                jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem5ActionPerformed(evt);
                        }
                });

                jMenuItem6.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem6.setText("Transmission 2.94");
                jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem6ActionPerformed(evt);
                        }
                });

                jMenuItem7.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jMenuItem7.setText("Custom Client");
                jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jMenuItem7ActionPerformed(evt);
                        }
                });

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("JRatioBoost");
                setPreferredSize(new java.awt.Dimension(640, 480));

                WindowPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                WindowPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                windowFocus(evt);
                        }
                });
                WindowPanel.setLayout(new java.awt.BorderLayout());

                listPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
                listPanel.setOpaque(false);
                listPanel.setPreferredSize(new java.awt.Dimension(250, 159));
                listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.LINE_AXIS));

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Torrent List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

                jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

                torrentList.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                torrentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                jScrollPane1.setViewportView(torrentList);

                jPanel1.add(jScrollPane1);

                listPanel.add(jPanel1);

                WindowPanel.add(listPanel, java.awt.BorderLayout.WEST);

                TorrentDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 0, 0));
                TorrentDataPanel.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                TorrentDataPanel.setInheritsPopupMenu(true);
                TorrentDataPanel.setLayout(new javax.swing.BoxLayout(TorrentDataPanel, javax.swing.BoxLayout.Y_AXIS));

                InfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Torrent Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                InfoPanel.setLayout(new java.awt.GridBagLayout());

                jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel1.setText("Tracker:");
                jLabel1.setAlignmentX(0.5F);
                jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel1, gridBagConstraints);

                jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel3.setText("Info_Hash:");
                jLabel3.setAlignmentX(0.5F);
                jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel3, gridBagConstraints);

                jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel4.setText("Peer_ID:");
                jLabel4.setAlignmentX(0.5F);
                jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel4, gridBagConstraints);

                jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel8.setText("Size:");
                jLabel8.setAlignmentX(0.5F);
                jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel8, gridBagConstraints);

                jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
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
                InfoPanel.add(jLabel9, gridBagConstraints);

                tracker.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                tracker.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                InfoPanel.add(tracker, gridBagConstraints);

                info_hash.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                info_hash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                InfoPanel.add(info_hash, gridBagConstraints);

                peer_id.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                peer_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                InfoPanel.add(peer_id, gridBagConstraints);

                size.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                size.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                InfoPanel.add(size, gridBagConstraints);

                date.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                InfoPanel.add(date, gridBagConstraints);

                TorrentDataPanel.add(InfoPanel);

                OutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tracker Output", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                OutputPanel.setLayout(new java.awt.GridBagLayout());

                jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel2.setText("Seeders:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel2, gridBagConstraints);

                jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel15.setText("Leechers:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel15, gridBagConstraints);

                jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel16.setText("Downloaded:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel16, gridBagConstraints);

                jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel17.setText("Uploaded:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel17, gridBagConstraints);

                jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
                jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel18.setText("Update Interval:");
                jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel18, gridBagConstraints);

                seeders.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                OutputPanel.add(seeders, gridBagConstraints);

                leechers.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                OutputPanel.add(leechers, gridBagConstraints);

                downloaded.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                OutputPanel.add(downloaded, gridBagConstraints);

                uploaded.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                OutputPanel.add(uploaded, gridBagConstraints);

                update.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                update.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                update.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 5);
                OutputPanel.add(update, gridBagConstraints);

                jProgressBar1.setString("");
                jProgressBar1.setStringPainted(true);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1000.0;
                gridBagConstraints.weighty = 1.0;
                OutputPanel.add(jProgressBar1, gridBagConstraints);

                TorrentDataPanel.add(OutputPanel);

                WindowPanel.add(TorrentDataPanel, java.awt.BorderLayout.CENTER);

                ConnectPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
                ConnectPanel.setPreferredSize(new java.awt.Dimension(315, 50));
                ConnectPanel.setLayout(new java.awt.GridBagLayout());

                jSpinner1.setFont(new java.awt.Font("Noto Sans Regular", 0, 17)); // NOI18N
                jSpinner1.setModel(new javax.swing.SpinnerNumberModel(40, 0, 9999, 1));
                jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                jSpinnerStateChanged(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.5;
                ConnectPanel.add(jSpinner1, gridBagConstraints);

                connectButton.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                connectButton.setText("Connect");
                connectButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                connectButton.setIconTextGap(10);
                connectButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                connectButtonActionPerformed(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
                ConnectPanel.add(connectButton, gridBagConstraints);

                jArrow1.setMinimumSize(new java.awt.Dimension(20, 20));
                jArrow1.setPreferredSize(new java.awt.Dimension(20, 20));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                ConnectPanel.add(jArrow1, gridBagConstraints);

                jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel6.setText("Upload (kb/s)");
                jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
                ConnectPanel.add(jLabel6, gridBagConstraints);

                WindowPanel.add(ConnectPanel, java.awt.BorderLayout.SOUTH);

                openPanel.setLayout(new java.awt.BorderLayout());

                torrent_name.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
                openPanel.add(torrent_name, java.awt.BorderLayout.CENTER);

                openFileButton.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                openFileButton.setText("Open Torrent");
                openFileButton.setPreferredSize(new java.awt.Dimension(250, 40));
                openFileButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openFileButtonActionPerformed(evt);
                        }
                });
                openPanel.add(openFileButton, java.awt.BorderLayout.WEST);

                WindowPanel.add(openPanel, java.awt.BorderLayout.NORTH);

                getContentPane().add(WindowPanel, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void updateLabels(TorrentElement te) {

		TorrentInfo tInfo = te.gettInfo();
		TrackerConnect tConn = te.gettConn();
		
		//update Labels
		Pattern p = Pattern.compile("//[a-z.]+");
		Matcher m = p.matcher(tInfo.announce);

		if (m.find()) {

			tracker.setText(m.group().substring(2));

		} else {

			tracker.setText(tInfo.announce);
		}

		torrent_name.setText("<html><font size=5>" + tInfo.name + "</font><html>");
		info_hash.setText(tInfo.hexString(tInfo.infoHash));
		peer_id.setText(tInfo.hexString(tInfo.peerId));
		size.setText(new SizeConvert(Long.parseLong(tInfo.size)).toString());

		if (tInfo.creationDate != null) {

			Date d = new Date(Long.parseLong(tInfo.creationDate) * 1000);
			date.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(d));

		} else {

			date.setText("Unknown");
		}

		//resize window to fit updated JLabels
		//this.pack();
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

		//update the tracker connection labels
		
	}

	private void stopAction() {

		openFileButton.setEnabled(true);
		connectButton.setText("Connect");
		jMenuItem1.setEnabled(true);
		jSpinLoader1.stop();
		
		TorrentElement te = torrentElement.get(indexSelected);
		Timer timer = te.getTimer();

		if (timer != null) {

			timer.cancel();
		}

		te.setTimer(null);
		
		printTimers(torrentElement);
	}

	private void printTimers(ArrayList<TorrentElement> te) {
		
		for (int i = 0; i < te.size(); i++) {
			
			if (te.get(i).getTimer() != null) {
				
				System.out.println(String.format("Timer %d is running", i));
			
			} else {
				
				System.out.println(String.format("Timer %d is NOT running", i));
			}
		}
	}

	private void openTorrentFile(String filePath) {

		changeTracker.setEnabled(false);
		changeClient.setEnabled(true);

		try (FileInputStream file = new FileInputStream(filePath)) {
			
			//create a new TorrentElemnt object 
			TorrentElement te = new TorrentElement();
			
			//populate the torrent element object with the info found in the torrent file
			//and add it to the torrentElement array
			te.settInfo(new TorrentInfo(file));
			torrentElement.add(te);
			
			//display torret info on the GUI
			TorrentInfo tInfo = te.gettInfo();
			updateLabels(te);
			
			//Add the torrent opened to the JList
			DefaultListModel mod = (DefaultListModel) torrentList.getModel();
			mod.addElement(tInfo.name);
	
			int lastIndex = torrentList.getLastVisibleIndex();
			torrentList.setSelectedIndex(lastIndex);
			//make the index of the sleceted list item global
			indexSelected = lastIndex;
			te.setIndex(indexSelected);
			System.out.println(String.format("index: = %d", indexSelected));

			//resize window to fit updated JLabels
			this.pack();

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
                			item.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
				}
			}

		} catch (FileNotFoundException ex) {

			JOptionPane.showMessageDialog(this, "Error: Could not find file \n" + ex, "Error message", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();

		} catch (IOException ex) {

			JOptionPane.showMessageDialog(this, "IO Error: Could not read file contence \n" + ex, "Error message", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(this, "Error: Invalid torrent file. \n" + ex, "Error message", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {

		JFileChooser jfc = new JFileChooser(".");
		FileNameExtensionFilter ff = new FileNameExtensionFilter("Torrents", "torrent");
		jfc.setFileFilter(ff);
		int res = jfc.showDialog(this, "open");

		changeTracker.setEnabled(false);
		changeClient.setEnabled(true);

		//if a new torrent file is open make sure the the spinloader isnt active for a previouse torrent
		//that may be running. Also make sure the button is in its connect state. as a previouse torrent that 
		//is running with change it to its stopped state
		jSpinLoader1.stop();
		connectButton.setText("Connect");	
		
		//also clear labels if there is not a thread running to clear out any old data that may still be there
		uploaded.setText("");
		seeders.setText("");
		leechers.setText("");
		downloaded.setText("");
		update.setText("");
		
		if (res == JFileChooser.APPROVE_OPTION) {

			openTorrentFile(jfc.getSelectedFile().getAbsolutePath());
		}
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {

		if (connectButton.getText().equals("Connect")) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			te.settConn(null);
			jMenuItem1.setEnabled(false);
			te.setUploadAmount(0);
			connectButton.setText("Connecting..");
			jSpinLoader1.start();

			//connect to tracker in a different thread so it wont
			//stop the GUI from responding while the TrackerConnect object
			//precesses the request
			ConnectTask ct = new ConnectTask(te);
			ct.execute();

			//stop button was pressed
		} else {

			stopAction();
		}
	}

        private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

			UpdatePort c = new UpdatePort(this);
			c.pack();
			c.setLocationRelativeTo(null);
			c.setVisible(true);
        }//GEN-LAST:event_jMenuItem1ActionPerformed

        private void jSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerStateChanged

		//If there a items in the list
		if (!torrentList.isSelectionEmpty()) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			te.setUploadSpeed((Integer) jSpinner1.getValue());
			//System.out.println(te.getUploadSpeed());
		} 
        }//GEN-LAST:event_jSpinnerStateChanged
	
	//This function commits the value in the JSpinner when ever the user clicks
	//outside anywhere in the window. So you dont have to press enter when manually
	//entering a number in the JSpinner
        private void windowFocus(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowFocus
		
		try {
	
			jSpinner1.commitEdit();
			
		} catch (ParseException ex) {
			
			System.out.println(ex);
			// Do nothing
		}
        }//GEN-LAST:event_windowFocus
	
	private void listListen(ListSelectionEvent e) {

		if (e.getValueIsAdjusting()) {
				
			if (!torrentList.isSelectionEmpty()) {
				
				indexSelected = torrentList.getSelectedIndex();
				
				TorrentElement te = torrentElement.get(indexSelected);
				TorrentInfo tInfo = te.gettInfo();
				updateLabels(te);
				jSpinner1.setValue(te.getUploadSpeed());

				if (te.getTimer() == null) {
					
					connectButton.setText("Connect");
					jSpinLoader1.stop();

					//clear labels if there is not a thread running to clear out any old data that may still be there
					uploaded.setText("");
					seeders.setText("");
					leechers.setText("");
					downloaded.setText("");
					update.setText("");
				
				} else {
					
					connectButton.setText("Stop");
					jSpinLoader1.start();
				}
			}
			
			System.out.println(String.format("selectedIndex: %d", indexSelected));
		}
	}
	
	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {

		About a = new About();
		a.pack();
		a.setLocationRelativeTo(null);
		a.setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		
		TorrentElement te = torrentElement.get(indexSelected);
		TrackerConnect tc = te.gettConn();
		
		UpdateAmount ua = new UpdateAmount(tc);
		ua.pack();
		ua.setLocationRelativeTo(null);
		ua.setVisible(true);
	}

	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		tInfo.computePeerId("KT5110");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
	}

	private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		tInfo.computePeerId("TR2940");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
	}

	private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		UpdateClient c = new UpdateClient(tInfo);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		peer_id.setText(tInfo.hexString(tInfo.peerId));
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
				new JRatioBoost(args).setVisible(true);
			}
		});
	}

	class ChangeTrackerAction implements ActionListener {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		@Override
		public void actionPerformed(ActionEvent e) {

			JMenuItem item = (JMenuItem) e.getSource();
			tInfo.announce = item.getText();

			Pattern p = Pattern.compile("[^\\/]+\\.[comorgnetvlub]{2,4}");
			Matcher m = p.matcher(tInfo.announce);

			if (m.find()) {

				tracker.setText(m.group());

			} else {

				tracker.setText(tInfo.announce);
			}
		}
	}

	class ConnectTask extends SwingWorker<Void, Void> {
		
		private TorrentElement te;
		private TrackerConnect tc;
		private TorrentInfo tInfo;
		
		public ConnectTask (TorrentElement te) {
		
			this.te = te;
			this.tInfo = te.gettInfo();
		}
		
		//execute this method in its own background thread
		@Override
		public Void doInBackground() {

			WindowPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

			try {

				te.settConn(new TrackerConnect(tInfo, port));
				tc = te.gettConn();

			} catch (MalformedURLException ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: Malformed URL. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
				stopAction();

			} catch (IOException ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: IO error. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
				stopAction();

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
				stopAction();
			}

			return null;
		}

		//execute this function on Swings event dispatch thread when
		//background thread has finished executing its statements
		@Override
		protected void done() {

			WindowPanel.setCursor(null);

			//valid connection made
			if (tc != null && tc.valid == true) {

				connectButton.setText("Stop");

				//send request at regular intervals
				te.setTimer(new Timer());
				te.getTimer().scheduleAtFixedRate(new UpdateTask(te), 1000, 1000);
			}
		}
	}

	class UpdateTask extends TimerTask {
		
		private TorrentElement te;
		private TrackerConnect tc;
		private TorrentInfo tInfo;
		private Timer timer;
		
		public UpdateTask(TorrentElement te) {
			
			this.te = te;
			this.tc = te.gettConn();
			this.timer = te.getTimer();
			te.setTimeLeft(Integer.parseInt(tc.interval));
		}
		
		@Override
		public void run() {
			
			int upSpeed = te.getUploadSpeed();
			int n = te.getUploadAmount();
			te.setUploadAmount(n += SizeConvert.KBToB(upSpeed));
			
			if (te.getIndex() == indexSelected) {
				
				//update GUI label with tracker response info
				seeders.setText(tc.seeders);
				leechers.setText(tc.leechers);
				update.setText(tc.interval);
				downloaded.setText("100%");
				uploaded.setText(new SizeConvert(te.getUploadAmount()).toString());
			}

			if (te.getTimeLeft() <= 0) {

				//stop the timer thread from executing to prevent the timer task
				//from continuing to execute while the http request is being made
				//by the TrackerConnect instance
				timer.cancel();

				//send get request to tracker with upload/download data
				try {

					tc.connect(String.format("%d", te.getUploadAmount()), "0");

				} catch (MalformedURLException ex) {

					JOptionPane.showMessageDialog(WindowPanel, "Error: Malformed URL. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					stopAction();

				} catch (IOException ex) {

					JOptionPane.showMessageDialog(WindowPanel, "Error: IO Exception. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					stopAction();

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(WindowPanel, "Error: Tracker failue responce. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
					stopAction();
				}

                                //the new http request has been made, start a new timer task
				te.setTimer(new Timer());
				te.getTimer().scheduleAtFixedRate(new UpdateTask(te), 1000, 1000);
                        }
			
			int total = Integer.parseInt(tc.interval);
			int num = total - te.getTimeLeft();
			
			//percentage of time left untill the next update is preformed
			float pc = (float) num / total;
			
			int max = jProgressBar1.getMaximum();
			float v = pc * max;
			jProgressBar1.setValue((int) v);
			jProgressBar1.setString(String.format("%d/%d", num, total));
			
			//update the variable that determins how much time is left for the selected torrent untill it updates
			te.setTimeLeft(te.getTimeLeft() - 1);
			//update the variable that the GUI  uses to display how much time untill the next update
                }
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel ConnectPanel;
        private javax.swing.JPanel InfoPanel;
        private javax.swing.JPanel OutputPanel;
        private javax.swing.JPanel TorrentDataPanel;
        private javax.swing.JPanel WindowPanel;
        private javax.swing.JMenu changeClient;
        private javax.swing.JMenu changeTracker;
        private javax.swing.JButton connectButton;
        private javax.swing.JLabel date;
        private javax.swing.JLabel downloaded;
        private javax.swing.JLabel info_hash;
        private JArrow jArrow1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel16;
        private javax.swing.JLabel jLabel17;
        private javax.swing.JLabel jLabel18;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JMenuItem jMenuItem3;
        private javax.swing.JMenuItem jMenuItem4;
        private javax.swing.JMenuItem jMenuItem5;
        private javax.swing.JMenuItem jMenuItem6;
        private javax.swing.JMenuItem jMenuItem7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JProgressBar jProgressBar1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JSeparator jSeparator1;
        private JSpinLoader jSpinLoader1;
        private javax.swing.JSpinner jSpinner1;
        private javax.swing.JLabel leechers;
        private javax.swing.JPanel listPanel;
        private javax.swing.JButton openFileButton;
        private javax.swing.JPanel openPanel;
        private javax.swing.JLabel peer_id;
        private javax.swing.JLabel seeders;
        private javax.swing.JLabel size;
        private javax.swing.JList<String> torrentList;
        private javax.swing.JLabel torrent_name;
        private javax.swing.JLabel tracker;
        private javax.swing.JLabel update;
        private javax.swing.JLabel uploaded;
        // End of variables declaration//GEN-END:variables
}
