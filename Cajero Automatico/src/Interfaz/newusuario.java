/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.gest;
import clases.Ingreso;
import clases.TarjetaU;
import clases.TarjetaUsuario;
import clases.usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class newusuario extends javax.swing.JInternalFrame {

    File tarjeta = new File("tarjetas.txt");
    File user = new File("usuarios.txt");

    ArrayList<String> DatosUser = new ArrayList<>();
    ArrayList<Ingreso> DatosIngreso = new ArrayList<>();
    TarjetaU DTarjeta;
    usuarios DUser;
    ArrayList<usuarios> ListaUser = new ArrayList<>();
    ArrayList<TarjetaU> ListaTarj = new ArrayList<>();

    /**
     * Creates new form usuario_nuevo
     */
    public newusuario() {
        initComponents();
        autoid(user);
    }

    public void autoid(File f) {
        String a = "";
        String contenido = "";
        int linea = 0;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((a = br.readLine()) != null) {
                contenido = contenido + "" + a + "/n";
                if (contenido.contains("")) {
                    linea++;
                }
            }
            this.jtid.setText(String.valueOf(linea));
        } catch (Exception ex) {
        }
    }

    public usuarios GuardarUser() {
        DUser = new usuarios(jtid.getText(), jtnombre.getText(), jtapellido.getText(), jtpass.getText(), jtntarjeta.getText(), jtipous.getText());
        return DUser;
    }

    public TarjetaU GuardarTarjeta() {
        Ingreso ing = new Ingreso(jtid.getText(), jtsaldoi.getText(), "hoy", "nose", "Saldo Inicial");
        DTarjeta = new TarjetaU(jtid.getText(), jtntarjeta.getText(), jtsaldoi.getText(), jtlimret.getText(), "", "", jtsaldoi.getText());
        return DTarjeta;
    }

//    public void GuardarDatos(){
//    DUser = new usuarios(jtid.getText(), jtapellido.getText(), jtpass.getText(), jtntarjeta.getText(), jtipous.getText(), jtsaldoi.getText());
//    Ingreso ing = new Ingreso(jtid.getText(),jtsaldoi.getText(),"hoy","nose", "Saldo Inicial");
//    DTarjeta = new TarjetaU(jtntarjeta.getText(), jtsaldoi.getText(), jtlimret.getText(),ing, null, jtsaldoi.getText());
//    }
    public void AgregarDatosU(File f) {
        String a = "";
        String TipoUser = "";
        ListaUser.clear();
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

                        cnt++;
                        TipoUser = "";

                    }
                    if (cnt == 5) {
                        Usuarios[cnt] = TipoUser;
                    }
                }
                ListaUser.add(new usuarios(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5]));
                TipoUser = "";
                //JOptionPane.showMessageDialog(null,Listausuarios.get(0).getNombre());

            }
            ListaUser.add(GuardarUser());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
        ModificarDatosU(ListaUser, user);
    }

    public void AgregarDatosTJ(File f) {
        String a = "";
        String TipoUser = "";
        String token = "";
        ListaUser.clear();
        try {
            FileReader Fr = new FileReader(f);
            BufferedReader Br = new BufferedReader(Fr);
            while ((a = Br.readLine()) != null) {
                int cnt = 0;
                String[] Usuarios = new String[7];
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
                        if (cnt == 5) {
                            Usuarios[cnt] = TipoUser;
                        }

                        cnt++;
                        TipoUser = "";

                    }
                    if (cnt == 6) {
                        Usuarios[cnt] = TipoUser;
                    }
                }

                ListaTarj.add(new TarjetaU(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5], Usuarios[6]));
                TipoUser = "";
//JOptionPane.showMessageDialog(null,Listausuarios.get(0).getNombre());

            }
            ListaTarj.add(GuardarTarjeta());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
        ModificarDatosTJ(ListaTarj, tarjeta);
    }

    public void guardar(String texto, File a) {
        String cadena = texto;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(a));
            bw.write("");
            try ( FileWriter FlWr = new FileWriter(a, true)) {
                FlWr.write(cadena);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void ModificarDatosU(ArrayList<usuarios> a, File b) {
        String dato = "";
        for (int i = 0; i < a.size(); i++) {
            dato += a.get(i).getIdUsuario() + "\t"
                    + a.get(i).getNombre() + "\t"
                    + a.get(i).getApellido() + "\t"
                    + a.get(i).getPassword() + "\t"
                    + a.get(i).getNumTarjeta() + "\t"
                    + a.get(i).getTipoUsuario() + "\n";
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(b));
            bw.write("");
            try ( FileWriter FlWr = new FileWriter(b, true)) {
                FlWr.write(dato);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public void ModificarDatosTJ(ArrayList<TarjetaU> a, File b) {
        String dato = "";
        for (int i = 0; i < a.size(); i++) {
            dato += a.get(i).getIdTarjeta() + "\t"
                    + a.get(i).getNumTarjeta() + "\t"
                    + a.get(i).getMInicial() + "\t"
                    + a.get(i).getLRetiro() + "\t"
                    + a.get(i).getIngresos() + "\t"
                    + a.get(i).getEgresos() + "\t"
                    + a.get(i).getSaldo() + "\n";
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(b));
            bw.write("");
            try ( FileWriter FlWr = new FileWriter(b, true)) {
                FlWr.write(dato);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }

    public void limpiar() {
        this.jtapellido.setText("");
        autoid(user);
        this.jtipous.setText("");
        this.jtlimret.setText("");
        this.jtnombre.setText("");
        this.jtntarjeta.setText("");
        this.jtpass.setText("");
        this.jtsaldoi.setText("");
        this.setVisible(false);
        
        gest.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtid = new javax.swing.JTextField();
        jtnombre = new javax.swing.JTextField();
        jtapellido = new javax.swing.JTextField();
        jtntarjeta = new javax.swing.JTextField();
        jtpass = new javax.swing.JTextField();
        jtipous = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jtsaldoi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtlimret = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("NOMBRE");

        jLabel2.setText("APELLIDO");

        jLabel3.setText("PASSWORD");

        jLabel4.setText("No. TARJETA");

        jLabel5.setText("TIPO USUARIO");

        jLabel6.setText("ID USUARIO");

        jtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtidActionPerformed(evt);
            }
        });

        jtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtnombreActionPerformed(evt);
            }
        });

        jtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtapellidoActionPerformed(evt);
            }
        });

        jtntarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtntarjetaActionPerformed(evt);
            }
        });

        jtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtpassActionPerformed(evt);
            }
        });

        jtipous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtipousActionPerformed(evt);
            }
        });

        jButton1.setText("LISTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("SALDO INICIAL");

        jtsaldoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtsaldoiActionPerformed(evt);
            }
        });

        jLabel8.setText("LIMITE RETIRO");

        jtlimret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtlimretActionPerformed(evt);
            }
        });

        jLabel9.setText("Q");

        jLabel10.setText("Q");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(187, 187, 187))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtlimret, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtipous, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtntarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtsaldoi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtntarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jtipous, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtsaldoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtlimret, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtidActionPerformed

    private void jtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnombreActionPerformed

    private void jtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtapellidoActionPerformed

    private void jtntarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtntarjetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtntarjetaActionPerformed

    private void jtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtpassActionPerformed

    private void jtipousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtipousActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtipousActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //guardar datos Txt

        AgregarDatosU(user);
        AgregarDatosTJ(tarjeta);
        limpiar();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtsaldoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtsaldoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtsaldoiActionPerformed

    private void jtlimretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtlimretActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtlimretActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtapellido;
    private javax.swing.JTextField jtid;
    private javax.swing.JTextField jtipous;
    private javax.swing.JTextField jtlimret;
    private javax.swing.JTextField jtnombre;
    private javax.swing.JTextField jtntarjeta;
    private javax.swing.JTextField jtpass;
    private javax.swing.JTextField jtsaldoi;
    // End of variables declaration//GEN-END:variables
}
