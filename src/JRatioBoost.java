
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
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
	ArrayList<TorrentElement> torrentElement; 
	ImageIcon img;
	
	public JRatioBoost(String[] args) {

		img = new ImageIcon(getClass().getResource("icons/rocket-fly.png"));
		initComponents();
		torrentList.setCellRenderer(new customRenderer());
		torrentElement = new ArrayList<>();
		jProgressBar1.setVisible(false);
		this.setIconImage(img.getImage());
		this.pack();
		loadArgs(args);
	}

        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                jSeparator1 = new javax.swing.JSeparator();
                jPopupMenu1 = new javax.swing.JPopupMenu();
                changeTracker = new javax.swing.JMenu();
                changeClientMenu = new javax.swing.JMenu();
                jPopupMenu1.add(changeTracker);
                jPopupMenu1.add(changeClientMenu);
                updatePortMenu = new javax.swing.JMenuItem();
                updateIntervalMenu = new javax.swing.JMenuItem();
                jPopupMenu1.add(updateIntervalMenu);
                jPopupMenu1.add(updatePortMenu);
                jPopupMenu1.add(jSeparator1);
                aboutMenuItem = new javax.swing.JMenuItem();
                jPopupMenu1.add(aboutMenuItem);
                kTorrentMenuItem = new javax.swing.JMenuItem();
                transmissionMenuItem = new javax.swing.JMenuItem();
                customClientMenu = new javax.swing.JMenuItem();
                changeClientMenu.add(kTorrentMenuItem);
                changeClientMenu.add(transmissionMenuItem);
                changeClientMenu.add(customClientMenu);
                jSpinLoader1 = null;
                jFileChooser1 = new javax.swing.JFileChooser();
                updateIntervalDialog = new javax.swing.JDialog();
                jPanel7 = new javax.swing.JPanel();
                jPanel5 = new javax.swing.JPanel();
                jLabel10 = new javax.swing.JLabel();
                changeUpdateSpinner = new javax.swing.JSpinner();
                jPanel6 = new javax.swing.JPanel();
                changeUpdateOkButton = new javax.swing.JButton();
                changeUpdateCancelButton = new javax.swing.JButton();
                changePortDialog = new javax.swing.JDialog();
                jPanel8 = new javax.swing.JPanel();
                jPanel9 = new javax.swing.JPanel();
                jLabel11 = new javax.swing.JLabel();
                changePortSpinner = new javax.swing.JSpinner();
                jPanel10 = new javax.swing.JPanel();
                changePortOkButton = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                customClientDialog = new javax.swing.JDialog();
                jPanel13 = new javax.swing.JPanel();
                jPanel12 = new javax.swing.JPanel();
                jLabel12 = new javax.swing.JLabel();
                clientComboBox = new javax.swing.JComboBox<>();
                jLabel13 = new javax.swing.JLabel();
                changeClientVersionSpinner = new javax.swing.JSpinner();
                jPanel11 = new javax.swing.JPanel();
                changeClientOkButton = new javax.swing.JButton();
                changeClientCancelButton = new javax.swing.JButton();
                msgDialog = new javax.swing.JDialog(this);
                jPanel14 = new javax.swing.JPanel();
                msgLabel = new javax.swing.JLabel();
                jScrollPane2 = new javax.swing.JScrollPane();
                msgEditorPane = new javax.swing.JEditorPane();
                jPanel15 = new javax.swing.JPanel();
                msgOkButton = new javax.swing.JButton();
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
                toolBar = new javax.swing.JPanel();
                jToolBar1 = new javax.swing.JToolBar();
                errorsButton = new javax.swing.JButton();
                uploadsSentButton = new javax.swing.JButton();
                announceButton = new javax.swing.JButton();
                openPanel = new javax.swing.JPanel();
                torrent_name = new javax.swing.JLabel();
                openFileButton = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
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
                uploadSpeedSpinner = new javax.swing.JSpinner();
                connectButton = new javax.swing.JButton();
                jSpinLoader1 = new JSpinLoader(25, 25, connectButton);
                connectButton.setIcon(new ImageIcon(jSpinLoader1.createSpinnerImage(25, 25, 0f)));
                //connectButton.setHorizontalTextPosition(textPosition);
                jArrow1 = new JArrow();
                jLabel6 = new javax.swing.JLabel();

                jPopupMenu1.setFont(new java.awt.Font("Noto Sans Regular", 0, 17)); // NOI18N
                jPopupMenu1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
                        public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                        }
                        public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                        }
                        public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                                jPopupMenu1PopupMenuWillBecomeVisible(evt);
                        }
                });

                changeTracker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/globe-green.png"))); // NOI18N
                changeTracker.setText("Tracker");
                changeTracker.setEnabled(false);
                changeTracker.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

                changeClientMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application--plus.png"))); // NOI18N
                changeClientMenu.setText("Client");
                changeClientMenu.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N

                updatePortMenu.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                updatePortMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/network-ethernet.png"))); // NOI18N
                updatePortMenu.setText("Update Port");
                updatePortMenu.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updatePortMenuActionPerformed(evt);
                        }
                });

                updateIntervalMenu.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                updateIntervalMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hourglass.png"))); // NOI18N
                updateIntervalMenu.setText("Update Interval");
                updateIntervalMenu.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                updateIntervalMenuActionPerformed(evt);
                        }
                });

                aboutMenuItem.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
                aboutMenuItem.setText("About");
                aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                aboutMenuItemActionPerformed(evt);
                        }
                });

                kTorrentMenuItem.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                kTorrentMenuItem.setText("KTorrent 5.11");
                kTorrentMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                kTorrentMenuItemActionPerformed(evt);
                        }
                });

                transmissionMenuItem.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                transmissionMenuItem.setText("Transmission 4.06");
                transmissionMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                transmissionMenuItemActionPerformed(evt);
                        }
                });

                customClientMenu.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                customClientMenu.setText("Custom Client");
                customClientMenu.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                customClientMenuActionPerformed(evt);
                        }
                });

                jFileChooser1.setDialogTitle("Open Torrents");
                jFileChooser1.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
                jFileChooser1.setPreferredSize(new java.awt.Dimension(700, 500));

                updateIntervalDialog.setTitle("Change Update Interval");
                updateIntervalDialog.setIconImage(this.img.getImage());

                jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel7.setLayout(new java.awt.BorderLayout());

                jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Change Update Interval", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 1, 17))); // NOI18N
                jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

                jLabel10.setFont(jLabel10.getFont().deriveFont(jLabel10.getFont().getSize()+4f));
                jLabel10.setText("Update Interval");
                jPanel5.add(jLabel10);

                changeUpdateSpinner.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changeUpdateSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 1, 5000, 1));
                changeUpdateSpinner.setOpaque(true);
                jPanel5.add(changeUpdateSpinner);

                jPanel7.add(jPanel5, java.awt.BorderLayout.CENTER);

                jPanel6.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jPanel6.setInheritsPopupMenu(true);
                jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

                changeUpdateOkButton.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changeUpdateOkButton.setText("OK");
                changeUpdateOkButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                changeUpdateOkButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changeUpdateOkButtonActionPerformed(evt);
                        }
                });
                jPanel6.add(changeUpdateOkButton);

                changeUpdateCancelButton.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changeUpdateCancelButton.setText("Cancel");
                changeUpdateCancelButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                changeUpdateCancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changeUpdateCancelButtonActionPerformed(evt);
                        }
                });
                jPanel6.add(changeUpdateCancelButton);

                jPanel7.add(jPanel6, java.awt.BorderLayout.SOUTH);

                updateIntervalDialog.getContentPane().add(jPanel7, java.awt.BorderLayout.CENTER);

                changePortDialog.setTitle("Change Port");
                changePortDialog.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changePortDialog.setIconImage(this.img.getImage());

                jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel8.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jPanel8.setPreferredSize(new java.awt.Dimension(350, 200));
                jPanel8.setLayout(new java.awt.BorderLayout());

                jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Change Port", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 1, 17))); // NOI18N
                jPanel9.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N

                jLabel11.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jLabel11.setText("Port Number");
                jPanel9.add(jLabel11);

                changePortSpinner.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changePortSpinner.setModel(new javax.swing.SpinnerNumberModel(6881, 0, 9999, 1));
                changePortSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(changePortSpinner, "#"));
                jPanel9.add(changePortSpinner);

                jPanel8.add(jPanel9, java.awt.BorderLayout.CENTER);

                jPanel10.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

                changePortOkButton.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changePortOkButton.setText("OK");
                changePortOkButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                changePortOkButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changePortOkButtonActionPerformed(evt);
                        }
                });
                jPanel10.add(changePortOkButton);

                jButton2.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jButton2.setText("Cancel");
                jButton2.setMargin(new java.awt.Insets(5, 15, 5, 15));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });
                jPanel10.add(jButton2);

                jPanel8.add(jPanel10, java.awt.BorderLayout.SOUTH);

                changePortDialog.getContentPane().add(jPanel8, java.awt.BorderLayout.CENTER);

                customClientDialog.setTitle("Custom Client");
                customClientDialog.setIconImage(this.img.getImage());

                jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel13.setPreferredSize(new java.awt.Dimension(350, 250));
                jPanel13.setLayout(new java.awt.BorderLayout());

                jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Change Client", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 1, 16))); // NOI18N
                jPanel12.setLayout(new java.awt.GridBagLayout());

                jLabel12.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jLabel12.setText("Client");
                jLabel12.setToolTipText("");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                jPanel12.add(jLabel12, gridBagConstraints);

                clientComboBox.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                clientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KTorrent", "Transmission", "qBitTorrent", "µTorrent" }));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
                jPanel12.add(clientComboBox, gridBagConstraints);

                jLabel13.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                jLabel13.setText("Version");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                jPanel12.add(jLabel13, gridBagConstraints);

                changeClientVersionSpinner.setFont(new java.awt.Font("Noto Sans", 0, 16)); // NOI18N
                changeClientVersionSpinner.setModel(new javax.swing.SpinnerNumberModel(1000, 0, 9999, 1));
                changeClientVersionSpinner.setEditor(new javax.swing.JSpinner.NumberEditor(changeClientVersionSpinner, "#"));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
                jPanel12.add(changeClientVersionSpinner, gridBagConstraints);

                jPanel13.add(jPanel12, java.awt.BorderLayout.CENTER);

                jPanel11.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

                changeClientOkButton.setText("OK");
                changeClientOkButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                changeClientOkButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                changeClientOkButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changeClientOkButtonActionPerformed(evt);
                        }
                });
                jPanel11.add(changeClientOkButton);

                changeClientCancelButton.setText("Cancel");
                changeClientCancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                changeClientCancelButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                changeClientCancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                changeClientCancelButtonActionPerformed(evt);
                        }
                });
                jPanel11.add(changeClientCancelButton);

                jPanel13.add(jPanel11, java.awt.BorderLayout.SOUTH);

                customClientDialog.getContentPane().add(jPanel13, java.awt.BorderLayout.CENTER);

                msgDialog.setIconImage(this.img.getImage());
                msgDialog.setPreferredSize(new java.awt.Dimension(600, 400));
                msgDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
                        public void componentShown(java.awt.event.ComponentEvent evt) {
                                msgDialogComponentShown(evt);
                        }
                });

                jPanel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
                jPanel14.setLayout(new java.awt.BorderLayout());

                msgLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
                msgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                msgLabel.setIcon(new javax.swing.ImageIcon("/home/karma/Downloads/icons/fugue-icons-3.5.6/bonus/icons-32/exclamation.png")); // NOI18N
                msgLabel.setText("Errors");
                msgLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 10, 1));
                msgLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                msgLabel.setIconTextGap(10);
                jPanel14.add(msgLabel, java.awt.BorderLayout.NORTH);

                msgEditorPane.setEditable(false);
                msgEditorPane.setContentType("text/html"); // NOI18N
                msgEditorPane.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                msgEditorPane.setText("");
                jScrollPane2.setViewportView(msgEditorPane);

                jPanel14.add(jScrollPane2, java.awt.BorderLayout.CENTER);

                msgOkButton.setText("OK");
                msgOkButton.setMargin(new java.awt.Insets(5, 15, 5, 15));
                msgOkButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                msgOkButtonActionPerformed(evt);
                        }
                });
                jPanel15.add(msgOkButton);

                jPanel14.add(jPanel15, java.awt.BorderLayout.SOUTH);

                msgDialog.getContentPane().add(jPanel14, java.awt.BorderLayout.CENTER);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("JRatioBoost");
                setName("JRatioBoost"); // NOI18N
                setSize(new java.awt.Dimension(788, 600));

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
                listPanel.setLayout(new java.awt.BorderLayout());

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Torrent List", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

                jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

                torrentList.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                torrentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                jScrollPane1.setViewportView(torrentList);

                jPanel1.add(jScrollPane1);

                listPanel.add(jPanel1, java.awt.BorderLayout.CENTER);

                jToolBar1.setFloatable(false);
                jToolBar1.setRollover(true);
                jToolBar1.setBorderPainted(false);
                jToolBar1.setName("infoToolBar"); // NOI18N

                errorsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exclamation.png"))); // NOI18N
                errorsButton.setText("0");
                errorsButton.setToolTipText("Error messages");
                errorsButton.setFocusable(false);
                errorsButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                errorsButton.setIconTextGap(5);
                errorsButton.setMargin(new java.awt.Insets(5, 5, 5, 5));
                errorsButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                errorsButtonActionPerformed(evt);
                        }
                });
                jToolBar1.add(errorsButton);

                uploadsSentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/counter.png"))); // NOI18N
                uploadsSentButton.setText("0");
                uploadsSentButton.setToolTipText("Upload amount sent to the tracker");
                uploadsSentButton.setFocusable(false);
                uploadsSentButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                uploadsSentButton.setIconTextGap(5);
                uploadsSentButton.setMargin(new java.awt.Insets(5, 5, 5, 5));
                uploadsSentButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                uploadsSentButtonActionPerformed(evt);
                        }
                });
                jToolBar1.add(uploadsSentButton);

                announceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/megaphone.png"))); // NOI18N
                announceButton.setText("0");
                announceButton.setToolTipText("Announcements recieved by the tracker");
                announceButton.setFocusable(false);
                announceButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
                announceButton.setIconTextGap(5);
                announceButton.setMargin(new java.awt.Insets(5, 5, 5, 5));
                announceButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                announceButtonActionPerformed(evt);
                        }
                });
                jToolBar1.add(announceButton);

                toolBar.add(jToolBar1);

                listPanel.add(toolBar, java.awt.BorderLayout.SOUTH);

                WindowPanel.add(listPanel, java.awt.BorderLayout.WEST);

                openPanel.setLayout(new java.awt.BorderLayout());

                torrent_name.setFont(torrent_name.getFont().deriveFont(torrent_name.getFont().getSize()+10f));
                torrent_name.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
                torrent_name.setPreferredSize(new java.awt.Dimension(300, 0));
                openPanel.add(torrent_name, java.awt.BorderLayout.CENTER);

                openFileButton.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                openFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder-horizontal-open.png"))); // NOI18N
                openFileButton.setText("Open Torrent");
                openFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                openFileButton.setIconTextGap(5);
                openFileButton.setPreferredSize(new java.awt.Dimension(250, 40));
                openFileButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                openFileButtonActionPerformed(evt);
                        }
                });
                openPanel.add(openFileButton, java.awt.BorderLayout.WEST);

                WindowPanel.add(openPanel, java.awt.BorderLayout.NORTH);

                jPanel2.setLayout(new java.awt.BorderLayout());

                TorrentDataPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 0, 0));
                TorrentDataPanel.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                TorrentDataPanel.setInheritsPopupMenu(true);
                TorrentDataPanel.setLayout(new javax.swing.BoxLayout(TorrentDataPanel, javax.swing.BoxLayout.Y_AXIS));

                InfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Torrent Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                InfoPanel.setLayout(new java.awt.GridBagLayout());

                jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/globe-green.png"))); // NOI18N
                jLabel1.setText("Tracker");
                jLabel1.setAlignmentX(0.5F);
                jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
                InfoPanel.add(jLabel1, gridBagConstraints);

                jLabel3.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-number.png"))); // NOI18N
                jLabel3.setText("Info_Hash");
                jLabel3.setAlignmentX(0.5F);
                jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel3, gridBagConstraints);

                jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel4.setIcon(new javax.swing.ImageIcon("/home/karma/Downloads/icons/fugue-icons-3.5.6/icons/edit-number.png")); // NOI18N
                jLabel4.setText("Peer_ID");
                jLabel4.setAlignmentX(0.5F);
                jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel4, gridBagConstraints);

                jLabel8.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/chart-pie-separate.png"))); // NOI18N
                jLabel8.setText("Size");
                jLabel8.setAlignmentX(0.5F);
                jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                InfoPanel.add(jLabel8, gridBagConstraints);

                jLabel9.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar-day.png"))); // NOI18N
                jLabel9.setText("Date");
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
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
                InfoPanel.add(tracker, gridBagConstraints);

                info_hash.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                info_hash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                InfoPanel.add(info_hash, gridBagConstraints);

                peer_id.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                peer_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                InfoPanel.add(peer_id, gridBagConstraints);

                size.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                size.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                InfoPanel.add(size, gridBagConstraints);

                date.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                InfoPanel.add(date, gridBagConstraints);

                TorrentDataPanel.add(InfoPanel);

                OutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tracker Output", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Noto Sans", 0, 17))); // NOI18N
                OutputPanel.setLayout(new java.awt.GridBagLayout());

                jLabel2.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-branch-090.png"))); // NOI18N
                jLabel2.setText("Seeders");
                jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 0);
                OutputPanel.add(jLabel2, gridBagConstraints);

                jLabel15.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-branch-270.png"))); // NOI18N
                jLabel15.setText("Leechers");
                jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel15, gridBagConstraints);

                jLabel16.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel16.setIcon(new javax.swing.ImageIcon("/home/karma/Downloads/icons/fugue-icons-3.5.6/icons/arrow-270.png")); // NOI18N
                jLabel16.setText("Downloads");
                jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel16, gridBagConstraints);

                jLabel17.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow-090.png"))); // NOI18N
                jLabel17.setText("Uploads");
                jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel17, gridBagConstraints);

                jLabel18.setFont(new java.awt.Font("Noto Sans", 1, 15)); // NOI18N
                jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hourglass.png"))); // NOI18N
                jLabel18.setText("Update Interval");
                jLabel18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 5, 5, 0);
                OutputPanel.add(jLabel18, gridBagConstraints);

                seeders.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                seeders.setIconTextGap(5);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 5);
                OutputPanel.add(seeders, gridBagConstraints);

                leechers.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                leechers.setIconTextGap(5);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                OutputPanel.add(leechers, gridBagConstraints);

                downloaded.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                downloaded.setIconTextGap(5);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                OutputPanel.add(downloaded, gridBagConstraints);

                uploaded.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                uploaded.setIconTextGap(5);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                OutputPanel.add(uploaded, gridBagConstraints);

                update.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                update.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                update.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                update.setIconTextGap(5);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 1.0;
                gridBagConstraints.insets = new java.awt.Insets(0, 10, 5, 5);
                OutputPanel.add(update, gridBagConstraints);

                jProgressBar1.setFont(new java.awt.Font("Noto Sans Regular", 0, 14)); // NOI18N
                jProgressBar1.setString("");
                jProgressBar1.setStringPainted(true);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1000.0;
                gridBagConstraints.weighty = 1.0;
                OutputPanel.add(jProgressBar1, gridBagConstraints);

                TorrentDataPanel.add(OutputPanel);

                jPanel2.add(TorrentDataPanel, java.awt.BorderLayout.CENTER);

                ConnectPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
                ConnectPanel.setPreferredSize(new java.awt.Dimension(500, 50));
                ConnectPanel.setLayout(new java.awt.GridBagLayout());

                uploadSpeedSpinner.setFont(new java.awt.Font("Noto Sans Regular", 0, 17)); // NOI18N
                uploadSpeedSpinner.setModel(new javax.swing.SpinnerNumberModel(40, 0, 9999, 1));
                uploadSpeedSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
                        public void stateChanged(javax.swing.event.ChangeEvent evt) {
                                jSpinnerStateChanged(evt);
                        }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.weightx = 0.5;
                ConnectPanel.add(uploadSpeedSpinner, gridBagConstraints);

                connectButton.setFont(new java.awt.Font("Noto Sans", 0, 14)); // NOI18N
                connectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/plug-connect.png"))); // NOI18N
                connectButton.setText("Connect");
                connectButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
                connectButton.setIconTextGap(5);
                connectButton.setPreferredSize(new java.awt.Dimension(150, 32));
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

                jPanel2.add(ConnectPanel, java.awt.BorderLayout.SOUTH);

                WindowPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

                getContentPane().add(WindowPanel, java.awt.BorderLayout.CENTER);

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void loadArgs(String[] a) {
		
		File[] f = new File[a.length];
		
		for (int i = 0; i < a.length; i++) {
			
			f[i] = new File(a[i]);	
			String s = f[i].getAbsolutePath();
			//System.out.println(s);
			openTorrentFile(s);
		}
	}
	
	public void setFileChooserFont(Component[] comp) {
	
		Font font = new Font("SansSerif",Font.PLAIN, 16);
		
		for (int x = 0; x < comp.length; x++) {
		
			if (comp[x] instanceof Container) {
			
				setFileChooserFont(((Container) comp[x]).getComponents());
			}
			
			try {
			
				comp[x].setFont(font);

			} catch (Exception e) {
			}//do nothing
		}
	}
	
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

		torrent_name.setText(tInfo.name);
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
	}

	private void stopAction(int tIndex) {

		openFileButton.setEnabled(true);
		connectButton.setText("Connect");
		updatePortMenu.setEnabled(true);
		jSpinLoader1.stop();
		
		TorrentElement te = torrentElement.get(tIndex);
		Timer timer = te.getTimer();

		if (timer != null) {

			timer.cancel();
		}

		te.setTimer(null);
		torrentList.repaint();
	}

	private void openTorrentFile(String filePath) {

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

			JOptionPane.showMessageDialog(this, "Error: Could not find file \n(" + filePath + ")\n" + ex.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);

		} catch (IOException ex) {

			JOptionPane.showMessageDialog(this, "IO Error: Could not read file contents \n(" + filePath + ")\n" + ex.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);

		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog(this, "Error: Invalid torrent file. \n(" + filePath + ")\n" + ex.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		FileNameExtensionFilter ff = new FileNameExtensionFilter("Torrents", "torrent");
		jFileChooser1.setFileFilter(ff);
		jFileChooser1.setMultiSelectionEnabled(true);
		setFileChooserFont(jFileChooser1.getComponents());
		int res = jFileChooser1.showDialog(this, "open");

		//if a new torrent file is open make sure the spinloader isn't active for a previous torrent
		//that may be running. Also make sure the button is in its connect state. As a previous torrent that 
		//is running with change it to its stopped state
		jSpinLoader1.stop();
		connectButton.setText("Connect");	
		
		//clear any old data from labels because a new file has been opened
		uploaded.setText("");
		seeders.setText("");
		leechers.setText("");
		downloaded.setText("");
		update.setText("");
		jProgressBar1.setVisible(false);
		uploadsSentButton.setText("0");
		announceButton.setText("0");
		errorsButton.setText("0");
		
		if (res == JFileChooser.APPROVE_OPTION) {

			File[] files = jFileChooser1.getSelectedFiles();
			String[] paths = new String[files.length];
			
			for (int i = 0; i < files.length; i++) {
			
				paths[i] = files[i].getAbsolutePath();
			}

			loadArgs(paths);
		}
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		if (torrentElement.isEmpty()) {
			
			return;
		}
		
		if (connectButton.getText().equals("Connect")) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			te.settConn(null);
			updatePortMenu.setEnabled(false);
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

			stopAction(indexSelected);
		}
	}

        private void updatePortMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePortMenuActionPerformed

			changePortDialog.pack();
			changePortDialog.setLocationRelativeTo(null);
			changePortDialog.setVisible(true);
        }//GEN-LAST:event_updatePortMenuActionPerformed

        private void jSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerStateChanged

		//If there a items in the list
		if (!torrentList.isSelectionEmpty()) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			te.setUploadSpeed((Integer) uploadSpeedSpinner.getValue());
			//System.out.println(te.getUploadSpeed());
		} 
        }//GEN-LAST:event_jSpinnerStateChanged
	
	//This function commits the value in the JSpinner when ever the user clicks
	//outside anywhere in the window. So you don't have to press enter when manually
	//entering a number in the JSpinner
        private void windowFocus(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowFocus
		
		try {
	
			uploadSpeedSpinner.commitEdit();
			
		} catch (ParseException ex) {
			
			System.out.println(ex);
			// Do nothing
		}
        }//GEN-LAST:event_windowFocus

        private void changeUpdateCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUpdateCancelButtonActionPerformed
		
		updateIntervalDialog.setVisible(false);
        }//GEN-LAST:event_changeUpdateCancelButtonActionPerformed

        private void changeUpdateOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUpdateOkButtonActionPerformed
		
		TorrentElement te = torrentElement.get(indexSelected);
		int sVal = (Integer) changeUpdateSpinner.getValue();
		te.setTimeLeft(sVal);
		updateIntervalDialog.setVisible(false);
        }//GEN-LAST:event_changeUpdateOkButtonActionPerformed

        private void jPopupMenu1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenu1PopupMenuWillBecomeVisible
		
		//disable options in the popup menu if there are not opened torrents for them to operate on
		if (torrentElement.isEmpty()) {
			
			updateIntervalMenu.setEnabled(false);
			changeTracker.setEnabled(false);
			changeClientMenu.setEnabled(false);
			updatePortMenu.setEnabled(false);
		
		} else {

			TorrentElement te = torrentElement.get(indexSelected);
			
			if (te.getTimer() != null) {
				
				updateIntervalMenu.setEnabled(true);
				updatePortMenu.setEnabled(false);

			} else {
				
				updateIntervalMenu.setEnabled(false);
				changeClientMenu.setEnabled(true);
				updatePortMenu.setEnabled(true);
			}
		}
        }//GEN-LAST:event_jPopupMenu1PopupMenuWillBecomeVisible

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                
		changePortDialog.setVisible(false);
        }//GEN-LAST:event_jButton2ActionPerformed

        private void changePortOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePortOkButtonActionPerformed
		
		TorrentElement te = torrentElement.get(indexSelected);
		
		int i = (Integer) changePortSpinner.getValue();
		te.setPort(String.format("%d", i));
		changePortDialog.setVisible(false);
        }//GEN-LAST:event_changePortOkButtonActionPerformed

        private void changeClientCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeClientCancelButtonActionPerformed
		
		customClientDialog.setVisible(false);
        }//GEN-LAST:event_changeClientCancelButtonActionPerformed

        private void changeClientOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeClientOkButtonActionPerformed
		
		TorrentElement te = torrentElement.get(indexSelected);
		
		String client = (String) clientComboBox.getModel().getSelectedItem();
		String clientCode;
		int version = (Integer) changeClientVersionSpinner.getValue();
		
		switch (client) {

			case "KTorrent":

				clientCode = "KT";
				break;
	
			case "Transmission":

				clientCode = "TR";
				break;
				
			case "qBitTorrent":

				clientCode = "qB";
				break;
						
			case "µTorrent":

				clientCode = "UT";
				break;
					
			default:				
				
				clientCode = "KT";
		}

		String codeVersion = String.format("%s%d", clientCode, version);
		te.gettInfo().computePeerId(codeVersion);
		peer_id.setText(te.gettInfo().hexString(te.gettInfo().peerId));
		customClientDialog.setVisible(false);
        }//GEN-LAST:event_changeClientOkButtonActionPerformed

        private void msgOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgOkButtonActionPerformed
		
		msgDialog.setVisible(false);
        }//GEN-LAST:event_msgOkButtonActionPerformed

        private void errorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorsButtonActionPerformed
		
		String s = errorsButton.getText();
		
		if (!s.equals("0")) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			String line = "";
			
			for (int i = 0; i < te.getErrorMsg().size(); i++) {
			
				if (i % 2 == 0) {
					
					String tmp = String.format("<br /><center><font size=\"6\" color=\"#FF000000\">%s</font></center>\n", te.getErrorMsg().get(i));
					line = line.concat(tmp);
					
				} else {
					
					line = line.concat(String.format("<font size=\"5\">%s</font><br />", te.getErrorMsg().get(i)));
				}
			}

			msgEditorPane.setText(line);
			
		} else {

			//there are no errors
			msgEditorPane.setText("<center><br /><font size =\"5\">There have been no errors !</center></font><br />");
		}
		
		msgLabel.setText("<html><h1>Error Messages</h2></html>");
		msgLabel.setIcon(new ImageIcon(getClass().getResource("/icons/icons-32/exclamation.png")));
		msgDialog.setTitle("Error Messages");
		msgDialog.pack();
		msgDialog.setLocationRelativeTo(null);
		msgDialog.getRootPane().repaint();
		msgDialog.setVisible(true);
        }//GEN-LAST:event_errorsButtonActionPerformed

        private void uploadsSentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadsSentButtonActionPerformed
		
		if (!uploadsSentButton.getText().equals("0")) {
			
			TorrentElement te = torrentElement.get(indexSelected);
			String s = uploadsSentButton.getText();
			String lineOne = String.format("<br /><font size=\"6\"><center><b>%s</b></font><br /><font size=\"5\">has been successfully spoofed and recieved by the tracker</font><br /></center>", s);
			msgEditorPane.setText(lineOne);
	
		} else {
			
			msgEditorPane.setText("<br /><center><font size=\"5\">No upload data has been sent to the tracker</font></center><br />");
		}
		
		msgLabel.setIcon(new ImageIcon(getClass().getResource("/icons/icons-32/counter.png")));
		msgLabel.setText("<html><h1>Upload Amount</h2></html>");
		msgDialog.setTitle("Upload Amount");
		msgDialog.pack();
		msgDialog.setLocationRelativeTo(null);
		msgDialog.getRootPane().repaint();
		msgDialog.setVisible(true);
        }//GEN-LAST:event_uploadsSentButtonActionPerformed

        private void announceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_announceButtonActionPerformed
		
		if (!announceButton.getText().equals("0")) {
		
			TorrentElement te = torrentElement.get(indexSelected);
			String line = "<br /><center><font size=\"5\">The following announcements have been sent to the tracker</font></center><br />";
			
			for (String val : te.getNumAnnouce()) {
				
				line = line.concat(String.format("<font size=\"5\">%s</font><br />", val));
			}
			
			line = line.concat("<br />");
			msgEditorPane.setText(line);
			
		} else {

			msgEditorPane.setText("<br /><center><font size=\"5\">No announcements have been made</font></center><br />");
			
		}
		
		msgLabel.setIcon(new ImageIcon(getClass().getResource("/icons/icons-32/megaphone.png")));
		msgLabel.setText("<html><h1>Announcements</h2></html>");
		msgDialog.setTitle("Announcements");
		msgDialog.pack();
		msgDialog.setLocationRelativeTo(null);
		msgDialog.getRootPane().repaint();
		msgDialog.setVisible(true);
        }//GEN-LAST:event_announceButtonActionPerformed

	//this is needed to render properly with java 8
        private void msgDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_msgDialogComponentShown
		
		msgDialog.repaint();
        }//GEN-LAST:event_msgDialogComponentShown
	
	private void listListen(ListSelectionEvent e) {
		
		if (e.getValueIsAdjusting()) {
				
			if (!torrentList.isSelectionEmpty()) {
				
				indexSelected = torrentList.getSelectedIndex();
				
				TorrentElement te = torrentElement.get(indexSelected);
				TorrentInfo tInfo = te.gettInfo();
				updateLabels(te);
				uploadSpeedSpinner.setValue(te.getUploadSpeed());
				jProgressBar1.setVisible(false);
				uploadsSentButton.setText(new SizeConvert(te.getUploadSent()).toString());
				announceButton.setText(String.format("%d", te.getNumAnnouce().size()));
				errorsButton.setText(String.format("%d", te.getErrorMsg().size() / 2));

				if (te.getTimer() == null) {
					
					connectButton.setText("Connect");
					jSpinLoader1.stop();

					//clear labels if there is not a thread running to clear out any old data that may still be there
					uploaded.setText("");
					seeders.setText("");
					leechers.setText("");
					downloaded.setText("");
					update.setText("");
					jProgressBar1.setValue(0);
					jProgressBar1.setString(null);
			
				} else {
					
					connectButton.setText("Stop");
					jSpinLoader1.start();
				}
			}
		}
	}
	
	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		
		String line = String.format("<font size=\"5\"><br /><b>Version:</b> 2.0<br /><b>Author:</b> Karma Chameleon<br /><b>Web site:</b> https://gitlab.com/karma_chameleon/j-ratio-boost<br/><b>Fugue Icons by:</b> https://p.yusukekamiyamane.com/</font><br />", null);
		
		msgEditorPane.setText(line);
		msgLabel.setText("<html><h1>JRatioBoost</h2></html>");
		Image img = new ImageIcon(getClass().getResource("icons/rocket-fly.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
		msgLabel.setIcon(new ImageIcon(img));
		msgDialog.setTitle("About");
		msgDialog.pack();
		msgDialog.setLocationRelativeTo(null);
		msgDialog.setVisible(true);
	}

	private void updateIntervalMenuActionPerformed(java.awt.event.ActionEvent evt) {
		
		TorrentElement te = torrentElement.get(indexSelected);
		TrackerConnect tc = te.gettConn();
		updateIntervalDialog.pack();
		updateIntervalDialog.setLocationRelativeTo(null);
		updateIntervalDialog.setVisible(true);
	}

	private void kTorrentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		tInfo.computePeerId("KT5110");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
	}

	private void transmissionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {

		int n = torrentList.getSelectedIndex();
		TorrentInfo tInfo = torrentElement.get(indexSelected).gettInfo();
		
		tInfo.computePeerId("TR4060");
		peer_id.setText(tInfo.hexString(tInfo.peerId));
	}

	private void customClientMenuActionPerformed(java.awt.event.ActionEvent evt) {

		customClientDialog.pack();
		customClientDialog.setLocationRelativeTo(null);
		customClientDialog.setVisible(true);
	}

	public static void main(String args[]) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				//Use native look and feel
				try {
					//for Linux systems just use nimbus look and feel
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

				te.settConn(new TrackerConnect(tInfo, te.getPort()));
				tc = te.gettConn();
				String announce = String.format("%s?info_hash=%s&peer_id=%s&port=%s&uploaded=0&downloaded=0&left=0&compact=1&event=started", tInfo.announce, tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), tc.port);
				te.getNumAnnouce().add(announce);

			} catch (MalformedURLException ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: Malformed URL. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				stopAction(te.getIndex());

			} catch (IOException ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: IO error. " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				stopAction(te.getIndex());

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(WindowPanel, "Error: " + ex, "Error message", JOptionPane.ERROR_MESSAGE);
				stopAction(te.getIndex());
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
				torrentList.repaint();
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
			this.tInfo = te.gettInfo();
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
				jProgressBar1.setVisible(true);
				announceButton.setText("" + te.getNumAnnouce().size());
				uploadsSentButton.setText(new SizeConvert(te.getUploadSent()).toString());
			}

			if (te.getTimeLeft() <= 0) {

				//stop the timer thread from executing to prevent the timer task
				//from continuing to execute while the http request is being made
				//by the TrackerConnect instance
				timer.cancel();

				try {

					//send get request to tracker with upload/download data
					tc.connect(String.format("%d", te.getUploadAmount()), "0");

					//keep track if the amount of spoofed uploads that has been sent so far
					int num = te.getUploadSent() + (te.getUploadAmount() - te.getUploadSent());
					te.setUploadSent(num);

					//add a new announcement to the list
					String announce = String.format("%s?info_hash=%s&peer_id=%s&port=%s&uploaded=%d&downloaded=%d&left=0&compact=1", tInfo.announce, tInfo.hexStringUrlEnc(0), tInfo.hexStringUrlEnc(1), tc.port, te.getUploadAmount(), te.getDownloadAmount());
					te.getNumAnnouce().add(announce);
					
					//the new http request has been made, start a new timer task
					te.setTimer(new Timer());
					te.getTimer().scheduleAtFixedRate(new UpdateTask(te), 1000, 1000);

				} catch (MalformedURLException ex) {

					te.getErrorMsg().add("Error: IO Exception");
					te.getErrorMsg().add(ex.getMessage());
					int numError = te.getErrorMsg().size() / 2;	//there are 2 messages per error so divide by 2 to find the number of errors
					errorsButton.setText("" + numError);
					stopAction(te.getIndex());

				} catch (IOException ex) {

					te.getErrorMsg().add("Error: IO Exception.");
					te.getErrorMsg().add(ex.getMessage());
					int numError = te.getErrorMsg().size() / 2;	//there are 2 messages per error so divide by 2 to find the number of errors
					errorsButton.setText("" + numError);
					stopAction(te.getIndex());

				} catch (Exception ex) {

					te.getErrorMsg().add("Error: Tracker failure response.");
					te.getErrorMsg().add(ex.getMessage());
					int numError = te.getErrorMsg().size() / 2;	//there are 2 messages per error so divide by 2 to find the number of errors
					errorsButton.setText("" + numError);
					stopAction(te.getIndex());
				}

                        }
			
			int total = Integer.parseInt(tc.interval);
			int num = total - te.getTimeLeft();
			
			//percentage of time left until the next update is preformed
			float pc = (float) num / total;
			
			//only update the progress bar for the currently selected torrent, otherwise all running torrents
			//would be updating the same progress bar at the same time
			if (te.getIndex() == indexSelected) {
				
				int max = jProgressBar1.getMaximum();
				float v = pc * max;
				jProgressBar1.setValue((int) v);
				jProgressBar1.setString(String.format("%d/%d", num, total));
			}
			
			//update the variable that determines how much time is left for the selected torrent until it updates
			te.setTimeLeft(te.getTimeLeft() - 1);
                }
        }

	public class customRenderer extends DefaultListCellRenderer {
		
		@Override
		public Component getListCellRendererComponent(JList l, Object val, int index, boolean isSelected, boolean cellHasFocus) {
			
			JLabel label = (JLabel) super.getListCellRendererComponent(l, val, index, isSelected, cellHasFocus);
			label.setHorizontalTextPosition(JLabel.RIGHT);

			TorrentElement te = torrentElement.get(index);
			
			//if torrents are running
			if (te.getTimer() != null) {
				
				//display green icon
				label.setIcon(new ImageIcon(getClass().getResource("icons/status.png")));
			
			//torrents are not running
			} else {
				
				//if the torrent has no errors
				if (te.getErrorMsg().isEmpty()) {
					
					//display transparent icon
					label.setIcon(new ImageIcon(getClass().getResource("icons/status-offline.png")));
				
				} else {
					
					//display red icon
					label.setIcon(new ImageIcon(getClass().getResource("icons/status-busy.png")));
				}
			}
			
			return label;
		}
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel ConnectPanel;
        private javax.swing.JPanel InfoPanel;
        private javax.swing.JPanel OutputPanel;
        private javax.swing.JPanel TorrentDataPanel;
        private javax.swing.JPanel WindowPanel;
        private javax.swing.JMenuItem aboutMenuItem;
        private javax.swing.JButton announceButton;
        private javax.swing.JButton changeClientCancelButton;
        private javax.swing.JMenu changeClientMenu;
        private javax.swing.JButton changeClientOkButton;
        private javax.swing.JSpinner changeClientVersionSpinner;
        private javax.swing.JDialog changePortDialog;
        private javax.swing.JButton changePortOkButton;
        private javax.swing.JSpinner changePortSpinner;
        private javax.swing.JMenu changeTracker;
        private javax.swing.JButton changeUpdateCancelButton;
        private javax.swing.JButton changeUpdateOkButton;
        private javax.swing.JSpinner changeUpdateSpinner;
        private javax.swing.JComboBox<String> clientComboBox;
        private javax.swing.JButton connectButton;
        private javax.swing.JDialog customClientDialog;
        private javax.swing.JMenuItem customClientMenu;
        private javax.swing.JLabel date;
        private javax.swing.JLabel downloaded;
        private javax.swing.JButton errorsButton;
        private javax.swing.JLabel info_hash;
        private JArrow jArrow1;
        private javax.swing.JButton jButton2;
        private javax.swing.JFileChooser jFileChooser1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
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
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel10;
        private javax.swing.JPanel jPanel11;
        private javax.swing.JPanel jPanel12;
        private javax.swing.JPanel jPanel13;
        private javax.swing.JPanel jPanel14;
        private javax.swing.JPanel jPanel15;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel6;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JPanel jPanel8;
        private javax.swing.JPanel jPanel9;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JProgressBar jProgressBar1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JSeparator jSeparator1;
        private JSpinLoader jSpinLoader1;
        private javax.swing.JToolBar jToolBar1;
        private javax.swing.JMenuItem kTorrentMenuItem;
        private javax.swing.JLabel leechers;
        private javax.swing.JPanel listPanel;
        private javax.swing.JDialog msgDialog;
        private javax.swing.JEditorPane msgEditorPane;
        private javax.swing.JLabel msgLabel;
        private javax.swing.JButton msgOkButton;
        private javax.swing.JButton openFileButton;
        private javax.swing.JPanel openPanel;
        private javax.swing.JLabel peer_id;
        private javax.swing.JLabel seeders;
        private javax.swing.JLabel size;
        private javax.swing.JPanel toolBar;
        private javax.swing.JList<String> torrentList;
        private javax.swing.JLabel torrent_name;
        private javax.swing.JLabel tracker;
        private javax.swing.JMenuItem transmissionMenuItem;
        private javax.swing.JLabel update;
        private javax.swing.JDialog updateIntervalDialog;
        private javax.swing.JMenuItem updateIntervalMenu;
        private javax.swing.JMenuItem updatePortMenu;
        private javax.swing.JSpinner uploadSpeedSpinner;
        private javax.swing.JLabel uploaded;
        private javax.swing.JButton uploadsSentButton;
        // End of variables declaration//GEN-END:variables
}
