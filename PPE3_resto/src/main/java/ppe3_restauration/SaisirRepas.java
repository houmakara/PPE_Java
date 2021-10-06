/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SaisirRepas extends javax.swing.JFrame {

    public SaisirRepas() {
        initComponents();
        lblBackground.setIcon(new ImageIcon("src/main/java/design_img/Page_saisir_repas.png"));
        //Liste Commande
        DefaultListModel listModel2 = new DefaultListModel();
        ArrayList<Commande> lesCommandes = Passerelle.lesCommandes();
        for (Commande uneCommande : lesCommandes) {
            listModel2.addElement(uneCommande);
        }
        listCommandes.setModel(listModel2);

        //Liste déroulante (Type Patient)        
        DefaultComboBoxModel listePatient = new DefaultComboBoxModel();
        ArrayList<Patient> lesPatients = Passerelle.tousLesPatients();
        listePatient.addElement("Choisir un patient");
        for (Patient unPatient : lesPatients) {
            listePatient.addElement(unPatient);
        }
        comboBoxPatient.setModel(listePatient);

        //Liste déroulante (Type Pepas)
        DefaultComboBoxModel listeRepas = new DefaultComboBoxModel();
        ArrayList<Repas> lesRepas = Passerelle.tousLesRepas();
        listeRepas.addElement("Choisir un repas");
        for (Repas unRepas : lesRepas) {
            listeRepas.addElement(unRepas);
        }
        comboBoxRepas.setModel(listeRepas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jColorChooser1 = new javax.swing.JColorChooser();
        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblListeCommandes = new javax.swing.JLabel();
        comboBoxPatient = new javax.swing.JComboBox<>();
        lblFormat = new javax.swing.JLabel();
        btnSupprimer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listCommandes = new javax.swing.JList<>();
        lblPatient = new javax.swing.JLabel();
        comboBoxRepas = new javax.swing.JComboBox<>();
        lblRepas = new javax.swing.JLabel();
        btnValider = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();
        btnTerminer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblListeCommandes.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblListeCommandes.setText("Liste des commandes");
        jPanel1.add(lblListeCommandes, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        comboBoxPatient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboBoxPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 150, -1));

        lblFormat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFormat.setText("Format : idPatient - idRepas - Date");
        jPanel1.add(lblFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        btnSupprimer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupprimer.setText("Supprimer");
        btnSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupprimerMouseClicked(evt);
            }
        });
        jPanel1.add(btnSupprimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        listCommandes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listCommandes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 200, -1));

        lblPatient.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblPatient.setText("Choisir le patient");
        jPanel1.add(lblPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        comboBoxRepas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboBoxRepas, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 150, -1));

        lblRepas.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lblRepas.setText("Choisir le menu");
        jPanel1.add(lblRepas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        btnValider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnValider.setText("Valider");
        btnValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValiderMouseClicked(evt);
            }
        });
        jPanel1.add(btnValider, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 110, 50));

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -7, -1, 600));

        btnTerminer.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnTerminer.setText("TERMINER");
        btnTerminer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTerminerMouseClicked(evt);
            }
        });
        jPanel1.add(btnTerminer, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 100, 50));

        jMenu1.setText("Rafraîchir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Retour");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTerminerMouseClicked
        MenuPersonnel mp = new MenuPersonnel();
        this.dispose();
        mp.setLocationRelativeTo(null);
        mp.show();
    }//GEN-LAST:event_btnTerminerMouseClicked

    private void btnValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValiderMouseClicked
        int indexP = comboBoxPatient.getSelectedIndex();
        Object p = comboBoxPatient.getModel().getElementAt(indexP);
        Patient unPatient = (Patient) p;

        int indexR = comboBoxRepas.getSelectedIndex();
        Object r = comboBoxRepas.getModel().getElementAt(indexR);
        Repas unRepas = (Repas) r;

        if (Passerelle.limiteRepas(unPatient.getId()) == true) {
            Passerelle.commander(unPatient, unRepas);
        } else {
            JOptionPane.showMessageDialog(this, "Votre commande n'a pas pu être effectué. \nLe patient à soit atteint sa limite journalière ou a commandé plusieurs fois ce même repas.");
        }

        //Refresh table
        SaisirRepas aa = new SaisirRepas();
        this.dispose();
        aa.setLocationRelativeTo(null);
        aa.show();
    }//GEN-LAST:event_btnValiderMouseClicked

    private void btnSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprimerMouseClicked
        int indexP = listCommandes.getSelectedIndex();
        Object p = listCommandes.getModel().getElementAt(indexP);
        Commande uneCommande = (Commande) p;

        DefaultListModel listModel2 = (DefaultListModel) listCommandes.getModel();
        listModel2.remove(indexP);
        Passerelle.supprimerCommande(uneCommande);
        JOptionPane.showMessageDialog(this, "Une commande vient d'être supprimée");

        SaisirRepas aa = new SaisirRepas();
        this.dispose();
        aa.setLocationRelativeTo(null);
        aa.show();
    }//GEN-LAST:event_btnSupprimerMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        SaisirRepas aa = new SaisirRepas();
        this.dispose();
        aa.setLocationRelativeTo(null);
        aa.show();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        MenuPersonnel mp = new MenuPersonnel();
        this.dispose();
        mp.setLocationRelativeTo(null);
          mp.show();}/*    }//GEN-LAST:event_jMenu3MouseClicked
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SaisirRepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaisirRepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaisirRepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaisirRepas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SaisirRepas sr = new SaisirRepas();
                sr.setLocationRelativeTo(null);
                sr.setResizable(false);
                sr.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JButton btnTerminer;
    private javax.swing.JButton btnValider;
    private javax.swing.JComboBox<String> comboBoxPatient;
    private javax.swing.JComboBox<String> comboBoxRepas;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblFormat;
    private javax.swing.JLabel lblListeCommandes;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblRepas;
    private javax.swing.JList<String> listCommandes;
    // End of variables declaration//GEN-END:variables
}
