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
        btnViewProfile = new javax.swing.JButton();

        btnCreateProfile.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnCreateProfile.setText("Create Profile");
        btnCreateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProfileActionPerformed(evt);
            }
        });

        btnViewProfile.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        btnViewProfile.setText("View Profile");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnViewProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(767, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnCreateProfile)
                .addGap(33, 33, 33)
                .addComponent(btnViewProfile)
                .addContainerGap(510, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProfileActionPerformed
        CreateProfileJPanel panel = new CreateProfileJPanel(personProcess, personDirectory);
        personProcess.add("CreateProfileJPanel", panel);

        CardLayout layout = (CardLayout) personProcess.getLayout();
        layout.next(personProcess);
            
    }//GEN-LAST:event_btnCreateProfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProfile;
    private javax.swing.JButton btnViewProfile;
    // End of variables declaration//GEN-END:variables
}