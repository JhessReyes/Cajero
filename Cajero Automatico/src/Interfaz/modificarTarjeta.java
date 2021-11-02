/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Login.idUser;
import static Interfaz.Main.Conexion;
import static Interfaz.Main.gest;
import static Interfaz.Time.FeYHo;
import clases.TarjetaU;
import clases.usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class modificarTarjeta extends javax.swing.JInternalFrame {

    File tarjeta = new File("tarjetas.txt");
    File user = new File("usuarios.txt");
    ArrayList<usuarios> ListaUser = new ArrayList<>();
    ArrayList<TarjetaU> ListaTarj = new ArrayList<>();

    /**
     * Creates new form modificarTarjeta
     */
    public modificarTarjeta() {
        initComponents();
    }

    public void cambpin() {
        AgregarDatosU(user);

        String nuevopin;
        String pinant;

        pinant = this.jTextField2.getText();
        nuevopin = this.jTextField1.getText();

        ModificarDatosU(ListaUser, user, nuevopin, pinant);
    }
    
    
    public void cambtarjeta() {
        AgregarDatosTJ(tarjeta);
        String nuevopin;
        String pinant;

        pinant = this.jTextField2.getText();
        nuevopin = this.jTextField1.getText();

        this.ModificarDatosTJ(ListaTarj, tarjeta, nuevopin, pinant);
    }

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
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
    }

    public void ModificarDatosU(ArrayList<usuarios> a, File b, String pinnuevo, String pinant) {
        String dato = "";
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getNumTarjeta().equals(pinant)) {
                a.get(i).setNumTarjeta(pinnuevo);
            }
        }
        

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
                JOptionPane.showMessageDialog(null, "SE A CAMBIADO EL NUMERO DE TARJETA");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
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
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
    }

    
    public void ModificarDatosTJ(ArrayList<TarjetaU> a, File b,String pinnuevo, String pinant) {
        String dato = "";
        
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getNumTarjeta().equals(pinant)) {
                a.get(i).setNumTarjeta(pinnuevo);
            }
        }
        
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
                limpiar();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
    
    public void limpiar(){
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.setVisible(false);
        gest.setVisible(true);
    }
    
    public void modificar(){
        PreparedStatement Declaracion;
        ResultSet result;
        try{
            Declaracion= Conexion.prepareStatement("EXEC MODIFICAR_TARJETA ?,?,?,?");
            Declaracion.setString(1,idUser);
            Declaracion.setString(2,FeYHo.getText());
            Declaracion.setString(3,jTextField2.getText().trim());
            Declaracion.setString(4,jTextField1.getText().trim());
            result = Declaracion.executeQuery();
            while(result.next()){
            }
            System.out.println("TARJETA MODIFICADO");
        }catch(Exception e) {System.out.println(e);}
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("INGRESE EL NUMERO DE TARJETA");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setText("No. TARJETA");

        jLabel2.setText("No. TARJETA NUEVO");

        jButton1.setText("ACEPTAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(251, 251, 251))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jLabel4.setText("DEL USUARIO ");

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        cambpin();
        if(jTextField2.getText().trim().length()!=14
               || jTextField1.getText().trim().length()!=14) 
            JOptionPane.showMessageDialog(null, "INGRESE DATOS VALIDOS (16 caracteres)");
        modificar();
        limpiar();
       // cambtarjeta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
