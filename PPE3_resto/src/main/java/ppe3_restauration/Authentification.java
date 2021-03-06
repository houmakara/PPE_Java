/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author sio2020
 */
public class Authentification extends javax.swing.JFrame {

    /**
     * Creates new form Authentification
     */
    public Authentification() {
        initComponents();
        lblBackground.setIcon(new ImageIcon("src/main/java/design_img/Page_de_connexion.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pswd = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        lblBackground = new javax.swing.JLabel();
        btnValider = new javax.swing.JButton();
        btnRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pswd.setBackground(new java.awt.Color(255, 255, 255));
        pswd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pswd.setForeground(new java.awt.Color(0, 0, 0));
        pswd.setBorder(null);
        jPanel1.add(pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 200, 40));

        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        txtUsername.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(0, 0, 0));
        txtUsername.setBorder(null);
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 200, 40));

        lblBackground.setBackground(new java.awt.Color(255, 255, 255));
        lblBackground.setForeground(new java.awt.Color(255, 255, 255));
        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 940, 600));

        btnValider.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        btnValider.setForeground(new java.awt.Color(0, 0, 0));
        btnValider.setText("VALIDER");
        btnValider.setBorder(null);
        btnValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValiderMouseClicked(evt);
            }
        });
        jPanel1.add(btnValider, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 100, 50));

        btnRetour.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        btnRetour.setForeground(new java.awt.Color(0, 0, 0));
        btnRetour.setText("RETOUR");
        btnRetour.setBorder(null);
        btnRetour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetourMouseClicked(evt);
            }
        });
        jPanel1.add(btnRetour, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 530, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValiderMouseClicked
        MenuPersonnel mp = new MenuPersonnel();
        MenuRestaurateur mr = new MenuRestaurateur();
        ArrayList serviceSoignant = Passerelle.tousLesNomsServices();
        serviceSoignant.remove("restaurateur");

        if (Passerelle.authentificationPersonnel(txtUsername.getText(), pswd.getText()) == true) {
            //Si l'utilisateur est restaurateur [5] on lui affiche sa page
            int idPersonnel = Passerelle.donnerIdPersonnel(txtUsername.getText());
            Passerelle.personnelConnecte = Passerelle.donnerUnPersonnel(idPersonnel);
            if (Passerelle.donnerUnPersonnel(idPersonnel) != null) {
                int idService = Passerelle.donnerUnPersonnel(idPersonnel).getIdservice();
                String nomService = Passerelle.donnerNomService(idService).getLibelle();
                if (nomService.compareTo("Restaurateur") == 0 || nomService.compareTo("restaurateur") == 0) {
                    mr.show();
                    mr.setLocationRelativeTo(null);
                    mr.setResizable(false);
                    this.dispose();
                } else if (serviceSoignant.contains(nomService)) {
                    mp.show();
                    mp.setLocationRelativeTo(null);
                    mp.setResizable(false);
                    this.dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Authentification ??chou??e !");
            pswd.setText("");
        }    }//GEN-LAST:event_btnValiderMouseClicked

    private void btnRetourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetourMouseClicked
        Menu aa = new Menu();
        aa.setLocationRelativeTo(null);
        aa.setResizable(false);
        this.dispose();
        aa.show();
    }/*
        aa.show();    }//GEN-LAST:event_btnRetourMouseClicked

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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Authentification a = new Authentification();
                a.setLocationRelativeTo(null);
                a.setResizable(false);
                a.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRetour;
    private javax.swing.JButton btnValider;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
