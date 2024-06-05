

public class UpdatePort extends javax.swing.JDialog {

	/**
	 * Creates new form UpdatePort
	 */
	
	private JRatioBoost app;
	
	public UpdatePort(JRatioBoost app) {
		
		this.app = app;
		initComponents();
	}

        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {
                java.awt.GridBagConstraints gridBagConstraints;

                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jSpinner1 = new javax.swing.JSpinner();
                jPanel1 = new javax.swing.JPanel();
                okButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setTitle("Update Port");
                getContentPane().setLayout(new java.awt.GridBagLayout());

                jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Update Port", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
                jPanel2.setLayout(new java.awt.GridBagLayout());

                jLabel1.setText("Port Number:");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
                jPanel2.add(jLabel1, gridBagConstraints);

                jSpinner1.setModel(new javax.swing.SpinnerNumberModel(6881, 0, 9999, 1));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                jPanel2.add(jSpinner1, gridBagConstraints);

                okButton.setText("OK");
                okButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                okButtonActionPerformed(evt);
                        }
                });
                jPanel1.add(okButton);

                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cancelButtonActionPerformed(evt);
                        }
                });
                jPanel1.add(cancelButton);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                jPanel2.add(jPanel1, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
                getContentPane().add(jPanel2, gridBagConstraints);

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

		app.port = jSpinner1.getValue().toString();
		System.out.println("Updating port Number to: " + app.port);
		dispose();
        }//GEN-LAST:event_okButtonActionPerformed

        private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
                
		dispose();
        }//GEN-LAST:event_cancelButtonActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JSpinner jSpinner1;
        private javax.swing.JButton okButton;
        // End of variables declaration//GEN-END:variables
}
