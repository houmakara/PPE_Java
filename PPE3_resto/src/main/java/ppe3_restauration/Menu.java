/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppe3_restauration;

import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author sio2020
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        /*Passerelle.createUser("infirmier", "infirmier", 1);
        Passerelle.createUser("restaurateur", "restaurateur", 2);
        Passerelle.createUser("admin", "admin", 3);*/
        initComponents();
        lblBackground.setIcon(new ImageIcon("src/main/java/design_img/Page_de_démarrage.png"));
        if (Passerelle.connection() == null) {
            //Remove
            panelConnection.removeAll();
            panelConnection.repaint();
            panelConnection.revalidate();

            //Affichage
            panelConnection.add(panelInvalid);
            panelConnection.repaint();
            panelConnection.revalidate();

            //Disabled button
            btnConnexion.setEnabled(false);
        } else {
            //Remove
            panelConnection.removeAll();
            panelConnection.repaint();
            panelConnection.revalidate();

            //Affichage
            panelConnection.add(panelValid);
            panelConnection.repaint();
            panelConnection.revalidate();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMenu = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnConnexion = new javax.swing.JButton();
        panelConnection = new javax.swing.JPanel();
        panelInvalid = new javax.swing.JPanel();
        panelValid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenu.setFont(new java.awt.Font("Berlin Sans FB", 0, 40)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(0, 0, 0));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("MENU");
        jPanel1.add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        lblBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 960, 600));

        btnExit.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        btnExit.setText("QUITTER");
        btnExit.setBorder(null);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 290, 60));

        btnConnexion.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        btnConnexion.setText("CONNEXION DU PERSONNEL");
        btnConnexion.setBorder(null);
        btnConnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnexionMouseClicked(evt);
            }
        });
        jPanel1.add(btnConnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 290, 70));

        panelConnection.setLayout(new javax.swing.OverlayLayout(panelConnection));

        panelInvalid.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelInvalidLayout = new javax.swing.GroupLayout(panelInvalid);
        panelInvalid.setLayout(panelInvalidLayout);
        panelInvalidLayout.setHorizontalGroup(
            panelInvalidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelInvalidLayout.setVerticalGroup(
            panelInvalidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelConnection.add(panelInvalid);

        panelValid.setBackground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout panelValidLayout = new javax.swing.GroupLayout(panelValid);
        panelValid.setLayout(panelValidLayout);
        panelValidLayout.setHorizontalGroup(
            panelValidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        panelValidLayout.setVerticalGroup(
            panelValidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelConnection.add(panelValid);

        jPanel1.add(panelConnection, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 29, 40, 40));

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnexionMouseClicked
        Connection con = null;
        if (Passerelle.connection() == con) {
            //Rien ne se passe
        } else {
            Authentification au = new Authentification();
            au.setLocationRelativeTo(null);
            au.setResizable(false);
            au.show();
            this.dispose();
        }
    }

    /*
        aa.show();    }//GEN-LAST:event_btnConnexionMouseClicked
*/
    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Menu m = new Menu();
                m.setLocationRelativeTo(null);
                m.setResizable(false);
                m.setVisible(true);
                if (Passerelle.connection() == null) {
                    //Affichage message d'erreur
                    JOptionPane.showMessageDialog(null, "ERREUR SURVENUE\n\nUne erreur a été identifiée.\nVeuillez vous adresser au service technique.");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnexion;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel panelConnection;
    private javax.swing.JPanel panelInvalid;
    private javax.swing.JPanel panelValid;
    // End of variables declaration//GEN-END:variables
}
