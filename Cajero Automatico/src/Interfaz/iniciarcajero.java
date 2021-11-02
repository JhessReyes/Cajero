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
import clases.cajero;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class iniciarcajero extends javax.swing.JInternalFrame {

    File billete = new File("billetes.txt");

    /**
     * Creates new form iniciarcajero
     */
    public iniciarcajero() {
        initComponents();
        this.jtlimite.setText(String.valueOf(10000));
         this.jbguardar.setVisible(false);
    }

    cajero DatosB;
    ArrayList<cajero> ListaBillete = new ArrayList<>();

    public cajero GuardarBill() {
        DatosB = new cajero(jtbilletes1.getText(), jtbilletes2.getText(), jtbilletes3.getText(),
                jtbilletes4.getText(), jtbilletes5.getText(), jtbilletes6.getText(), jtbilletes7.getText(),
                jtlimite.getText(), jtsuma.getText()
        );
        return DatosB;
    }

    public void AgregarDatosB(File f) {
        String a = "";
        String TipoUser = "";
        limpiartxt(f);
        ListaBillete.clear();
        try {
            FileReader Fr = new FileReader(f);
            BufferedReader Br = new BufferedReader(Fr);
            while ((a = Br.readLine()) != null) {
                int cnt = 0;
                String[] Usuarios = new String[9];
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
                        if (cnt == 4) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 5) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 6) {
                            Usuarios[cnt] = TipoUser;
                        }
                        if (cnt == 7) {
                            Usuarios[cnt] = TipoUser;
                        }

                        cnt++;
                        TipoUser = "";

                    }
                    if (cnt == 8) {
                        Usuarios[cnt] = TipoUser;
                    }
                }
                ListaBillete.add(new cajero(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5], Usuarios[6], Usuarios[7], Usuarios[8]));
                TipoUser = "";
                //JOptionPane.showMessageDialog(null,Listausuarios.get(0).getNombre());

            }
            ListaBillete.add(GuardarBill());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
        ModificarDatosB(ListaBillete, billete);
    }

    public void ModificarDatosB(ArrayList<cajero> a, File b) {
        String dato = "";
        for (int i = 0; i < a.size(); i++) {
            dato += a.get(i).getB1() + "\t"
                    + a.get(i).getB5() + "\t"
                    + a.get(i).getB10() + "\t"
                    + a.get(i).getB20() + "\t"
                    + a.get(i).getB50() + "\t"
                    + a.get(i).getB100() + "\t"
                    + a.get(i).getB200() + "\t"
                    + a.get(i).getTotal() + "\t"
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
    
    public void limpiartxt(File f){
        
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("");
        } catch (IOException ex) {
            Logger.getLogger(iniciarcajero.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    

    public void limitecajero() {
        int b1,b2,b3,b4,b5,b6,b7,sum,var2,dif;
        b1= Integer.valueOf(jtbilletes1.getText());
        b2= Integer.valueOf(jtbilletes2.getText());
        b3= Integer.valueOf(jtbilletes3.getText());
        b4= Integer.valueOf(jtbilletes4.getText());
        b5= Integer.valueOf(jtbilletes5.getText());
        b6= Integer.valueOf(jtbilletes6.getText());
        b7= Integer.valueOf(jtbilletes7.getText());
        var2=10000;
        sum=(b1*1)+(b2*5)+(b3*10)+(b4*20)+(b5*50)+(b6*100)+(b7*200);
        dif=var2-sum;
        this.jtsuma.setText(String.valueOf(sum));
        this.jtdif.setText(String.valueOf(dif));
        
        if(dif >0 ){
            JOptionPane.showMessageDialog(null, "CONFIGURACION ACEPTADA, PUEDE GUARDAR");
            this.jbguardar.setVisible(true);
            
        }
        if(dif<0){
            JOptionPane.showMessageDialog(null, "NO SE PUEDE GUARDAR ESTA CONFIGURACION");
        }
        
    }
    
    public void limpiar(){
        this.jtbilletes1.setText("0");
        this.jtbilletes2.setText("0");
        this.jtbilletes3.setText("0");
        this.jtbilletes4.setText("0");
        this.jtbilletes5.setText("0");
        this.jtbilletes6.setText("0");
        this.jtbilletes7.setText("0");
        this.jtlimite.setText("10000");
        this.jtsuma.setText("");
        this.setVisible(false);
        gest.setVisible(true);
    
    }
    
    public void INICIALIZAR(){
        PreparedStatement Declaracion;
        ResultSet result;
         int a,b,c,d,e,f,g;
        a= Integer.valueOf(jtbilletes1.getText().trim());
        b= Integer.valueOf(jtbilletes2.getText().trim());
        c= Integer.valueOf(jtbilletes3.getText().trim());
        d= Integer.valueOf(jtbilletes4.getText().trim());
        e= Integer.valueOf(jtbilletes5.getText().trim());
        f= Integer.valueOf(jtbilletes6.getText().trim());
        g= Integer.valueOf(jtbilletes7.getText().trim());
        try{
            Declaracion= Conexion.prepareStatement("EXEC INICIALIZAR_CAJA ?,?,?,?,?,?,?,?,?");
            Declaracion.setInt(1, a);
            Declaracion.setInt(2, b);
            Declaracion.setInt(3, c);
            Declaracion.setInt(4, d);
            Declaracion.setInt(5, e);
            Declaracion.setInt(6, f);
            Declaracion.setInt(7, g);
            Declaracion.setString(8,FeYHo.getText());
            Declaracion.setString(9, idUser);
            result = Declaracion.executeQuery();
            while(result.next()){
            JOptionPane.showMessageDialog(null, ""+result.getString("ESTADO"));
            }
        }catch (Exception R) {System.out.println(R);}
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtbilletes1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtbilletes2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtbilletes3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtbilletes4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtbilletes5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtbilletes6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtbilletes7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtlimite = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtsuma = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtdif = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jbguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jbsalir = new javax.swing.JButton();

        jLabel1.setText("INGRESE LA CANTIDAD DE DINERO DEL DIA");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("INGRESE LA CANTIDAD DE BILLETES");

        jLabel3.setText("Q1");

        jtbilletes1.setText("0");
        jtbilletes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Q5");

        jtbilletes2.setText("0");
        jtbilletes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Q10");

        jtbilletes3.setText("0");
        jtbilletes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Q20");

        jtbilletes4.setText("0");
        jtbilletes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Q50");

        jtbilletes5.setText("0");
        jtbilletes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Q100");

        jtbilletes6.setText("0");
        jtbilletes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes6ActionPerformed(evt);
            }
        });

        jLabel9.setText("Q200");

        jtbilletes7.setText("0");
        jtbilletes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtbilletes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jtbilletes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtbilletes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtbilletes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtbilletes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtbilletes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("LIMITE PERMITIDO");

        jtlimite.setText("0");

        jLabel12.setText("Q");

        jtsuma.setText("0");

        jLabel13.setText("Q");

        jLabel11.setText("TOTAL INGRESADO");

        jLabel14.setText("DIFERENCIA");

        jtdif.setText("0");

        jLabel15.setText("Q");

        jbguardar.setText("GUARDAR");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jButton1.setText("COMPROBAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jbguardar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jbguardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbsalir.setText("SALIR");
        jbsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbsalir)
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbsalir)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbilletes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes1ActionPerformed

    private void jtbilletes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes2ActionPerformed

    private void jtbilletes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes3ActionPerformed

    private void jtbilletes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes4ActionPerformed

    private void jtbilletes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes5ActionPerformed

    private void jtbilletes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes6ActionPerformed

    private void jtbilletes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        limitecajero();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        //AgregarDatosB(billete);
        INICIALIZAR();
        limpiar();            
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jbsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbsalirActionPerformed
        limpiar();
    }//GEN-LAST:event_jbsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbguardar;
    private javax.swing.JButton jbsalir;
    private javax.swing.JTextField jtbilletes1;
    private javax.swing.JTextField jtbilletes2;
    private javax.swing.JTextField jtbilletes3;
    private javax.swing.JTextField jtbilletes4;
    private javax.swing.JTextField jtbilletes5;
    private javax.swing.JTextField jtbilletes6;
    private javax.swing.JTextField jtbilletes7;
    private javax.swing.JTextField jtdif;
    private javax.swing.JTextField jtlimite;
    private javax.swing.JTextField jtsuma;
    // End of variables declaration//GEN-END:variables
}
