/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.AccountManager;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.PersonDirectory;

/**
 *
 * @author omkarsalian
 */
public class PersonMngWorkAreaJPanel extends javax.swing.JPanel {
    JPanel personProcess;
    PersonDirectory personDirectory;
    /**
     * Creates new form PersonMngWorkAreaJPanel
     */
    public PersonMngWorkAreaJPanel(JPanel container, PersonDirectory directory) {
        initComponents();
        
        personProcess = container;
        personDirectory = directory;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateProfile = new javax.swing.JButton();
        btnManageProfile = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(new java.awt.Color(204, 255, 255));

        btnCreateProfile.setBackground(new java.awt.Color(204, 204, 204));
        btnCreateProfile.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnCreateProfile.setForeground(new java.awt.Color(0, 51, 153));
        btnCreateProfile.setText("Create Profile");
        btnCreateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProfileActionPerformed(evt);
            }
        });

        btnManageProfile.setBackground(new java.awt.Color(204, 204, 204));
        btnManageProfile.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnManageProfile.setForeground(new java.awt.Color(0, 51, 153));
        btnManageProfile.setText("Manage Profile");
        btnManageProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(763, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnCreateProfile)
                .addGap(33, 33, 33)
                .addComponent(btnManageProfile)
                .addContainerGap(512, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProfileActionPerformed
        CreateProfileJPanel panel = new CreateProfileJPanel(personProcess, personDirectory);
        personProcess.add("CreateProfileJPanel", panel);

        CardLayout layout = (CardLayout) personProcess.getLayout();
        layout.next(personProcess);
            
    }//GEN-LAST:event_btnCreateProfileActionPerformed

    private void btnManageProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProfileActionPerformed
        ManageProfileJPanel panel = new ManageProfileJPanel(personProcess, personDirectory);
        personProcess.add("ManageProfileJPanel", panel);

        CardLayout layout = (CardLayout) personProcess.getLayout();
        layout.next(personProcess);        // TODO add your handling code here:
    }//GEN-LAST:event_btnManageProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProfile;
    private javax.swing.JButton btnManageProfile;
    // End of variables declaration//GEN-END:variables
}
