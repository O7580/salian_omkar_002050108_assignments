/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.AccountManager;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Person;
import model.PersonDirectory;

/**
 *
 * @author omkarsalian
 */
public class ManageProfileJPanel extends javax.swing.JPanel {
    JPanel personProcess;
    PersonDirectory personDirectory;

    /**
     * Creates new form ManageProfileJPanel
     */
    public ManageProfileJPanel(JPanel container, PersonDirectory directory) {
        initComponents();
        personProcess = container;
        personDirectory = directory;
        populateTable();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblManageProfile = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonProfile = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnViewDetails = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 255, 255));

        lblManageProfile.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblManageProfile.setForeground(new java.awt.Color(0, 51, 153));
        lblManageProfile.setText("Manage Profile");

        btnBack.setBackground(new java.awt.Color(204, 204, 204));
        btnBack.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 51, 153));
        btnBack.setText("<<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblPersonProfile.setBackground(new java.awt.Color(102, 102, 102));
        tblPersonProfile.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tblPersonProfile.setForeground(new java.awt.Color(204, 204, 204));
        tblPersonProfile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FirstName", "Last Name", "Home City", "Home Zipcode", "Work City", "Work Zipcode"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPersonProfile);

        btnSearch.setBackground(new java.awt.Color(204, 204, 204));
        btnSearch.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(0, 51, 153));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnViewDetails.setBackground(new java.awt.Color(204, 204, 204));
        btnViewDetails.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnViewDetails.setForeground(new java.awt.Color(0, 51, 153));
        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 204, 204));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 51, 153));
        btnDelete.setText("Delete Profile");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnBack)
                        .addGap(277, 277, 277)
                        .addComponent(lblManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnViewDetails)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
            personProcess.remove(this);
            CardLayout layout = (CardLayout) personProcess.getLayout();
            layout.previous(personProcess);        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       int selectedRow = tblPersonProfile.getSelectedRow();
        if (selectedRow >= 0) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this profile?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            Person  selectedProfile = (Person) tblPersonProfile.getValueAt(selectedRow, 0);
            personDirectory.deleteProfile(selectedProfile);
            populateTable();
        }
        
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int selectedRow = tblPersonProfile.getSelectedRow();
        if(selectedRow >= 0){
            Person  selectedProfile = (Person) tblPersonProfile.getValueAt(selectedRow, 0);
            ViewProfileJPanel panel = new ViewProfileJPanel(personProcess, personDirectory,selectedProfile);
            personProcess.add("ViewProfileJPanel", panel);
            CardLayout layout = (CardLayout) personProcess.getLayout();
            layout.next(personProcess);
                    }
        else{
            JOptionPane.showMessageDialog( null, "Please select a profile from list to view", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            if (!txtSearch.getText().isBlank()){
            String searchTxt = txtSearch.getText();
            Person foundProfile = personDirectory.searchPerson(searchTxt);
            
            if (foundProfile != null){
                
                ViewProfileJPanel panel = new ViewProfileJPanel(personProcess, personDirectory, foundProfile);
                personProcess.add("ViewProfileJPanel", panel);
                CardLayout layout = (CardLayout) personProcess.getLayout();
                layout.next(personProcess);
            }
            else{
                JOptionPane.showMessageDialog(null,"Profile not found. Please check the input and try again.","Warning",JOptionPane.WARNING_MESSAGE);
            }
            txtSearch.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"Please type the Person Details.","Warning",JOptionPane.WARNING_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblPersonProfile.getModel();
        model.setRowCount(0);
        
       for (Person p : personDirectory.getProfile()){
           
       Object[] row = new Object[6];
        row[0] = p;
        row[1] = p.getLastname();
        row[2] = p.getHomeAddress().getCity();
        row[3] = p.getHomeAddress().getZipcode();
        row[4] = p.getWorkAddress().getCity();
        row[5] = p.getWorkAddress().getZipcode();
        
        //row[3] = String.valueOf(a.getBalance());
        
        model.addRow(row);
       }
                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManageProfile;
    private javax.swing.JTable tblPersonProfile;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
