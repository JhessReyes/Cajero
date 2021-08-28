/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import AssetsLogin.TextPrompt;
import static Interfaz.Main.gest;
import static Interfaz.Main.init;
import clases.usuarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jhess
 */
public class Login extends javax.swing.JFrame {

    File uses = new File("usuarios.txt");
    ArrayList<usuarios> Listausuarios = new ArrayList<>();

    public ArrayList<usuarios> getListausuarios() {
        return Listausuarios;
    }

    public void setListausuarios(ArrayList<usuarios> Listausuarios) {
        this.Listausuarios = Listausuarios;
    }

    public Login() {
        AgregarDatos(uses);
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt User = new TextPrompt("Numero de Tarjeta", txtarjeta);
        TextPrompt Pass = new TextPrompt("Contraseña", jpassword);

    }

    public void AgregarDatos(File f) {
        String a = "";
        String TipoUser = "";
        String token = "";
        try {
            FileReader Fr = new FileReader(f);
            BufferedReader Br = new BufferedReader(Fr);

            while ((a = Br.readLine()) != null) {

                int cnt = 0;
                String[] Usuarios = new String[6];
                for (int x = 0; x < a.length(); x++) {
                    char c = a.charAt(x);
                    var regex = "\t";
                    if (!Pattern.matches(regex, String.valueOf(c))) {
                        TipoUser += String.valueOf(c);
                    } else {
                        if (cnt == 0) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 1) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 2) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 3) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 4) {
                            Usuarios[cnt] = TipoUser;
                        }

//                        if (cnt == 5) {
//                            Usuarios[cnt] = TipoUser;
//                        }

                        cnt++;
                        TipoUser = "";

                    }
                    if (cnt == 5) {
                        Usuarios[cnt] = TipoUser;
                    }
                }
                Listausuarios.add(new usuarios(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5]));
                //JOptionPane.showMessageDialog(null,Listausuarios.get(0).getNombre());
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
    }

    public String Lector(File a) {
        String texto = "";
        String b = "";
        int fila = 0;
        try {
            FileReader Fr = new FileReader(a);
            BufferedReader Br = new BufferedReader(Fr);
            while ((b = Br.readLine()) != null) {
                fila++;
                texto += b + "\n";
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "No se Encontro", HEIGHT);
        }
        return texto;
    }

    public void iniciosecion() {
        String tarjeta = "", contraseña = "";
        for (int i = 0; i < jpassword.getPassword().length; i++) {
            contraseña += jpassword.getPassword()[i];
        }
        tarjeta = txtarjeta.getText();

        for (int i = 0; i < Listausuarios.size(); i++) {
            if (Listausuarios.get(i).getNumTarjeta().equals(tarjeta)) {
                if (Listausuarios.get(i).getPassword().equals(contraseña)) {
                    //JOptionPane.showMessageDialog(null, "BIENVENIDO");
                    tiposusuarios();
                }
            }
        }

    }

    public void tiposusuarios() {
        String tarjeta = txtarjeta.getText();
        int cnt = 0;
        for (int i = 0; i < Listausuarios.size(); i++) {
            if (Listausuarios.get(i).getNumTarjeta().equals(tarjeta)) {

                if (Listausuarios.get(cnt).getTipoUsuario().equals("admin")) {
                    //JOptionPane.showMessageDialog(null, "BIENBENIDO ADMIN");
                     this.setVisible(false);
                     init.setVisible(false);
                     gest.setVisible(true);
                }

                if (Listausuarios.get(cnt).getTipoUsuario().equals("usuario")) {
                    JOptionPane.showMessageDialog(null, "BIENBENIDO USUARIOS");
                }

            }
            cnt++;
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

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtarjeta = new javax.swing.JTextField();
        jpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(325, 455));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AssetsLogin/Tarjet.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AssetsLogin/pass.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 30, 30));

        txtarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtarjetaActionPerformed(evt);
            }
        });
        txtarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtarjetaKeyReleased(evt);
            }
        });
        getContentPane().add(txtarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 200, 30));
        getContentPane().add(jpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 200, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("INGRESAR");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 250, 30));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Castellar", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AssetsLogin/loginU.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 250, 240));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AssetsLogin/login back.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtarjetaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtarjetaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtarjetaKeyReleased

    private void txtarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtarjetaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciosecion();

    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Ocean".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jpassword;
    private javax.swing.JTextField txtarjeta;
    // End of variables declaration//GEN-END:variables
}
