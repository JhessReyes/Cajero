/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.gest;
import clases.TarjetaU;
import clases.cajero;
import clases.usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        if(dif <=var2){
            JOptionPane.showMessageDialog(null, "CONFIGURACION ACEPTADA, PUEDE GUARDAR");
            this.jbguardar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUEDE GUARDAR ESTA CONFIGURACION");
        }
        
    }
    
    public void limpiar(){
        this.jtbilletes1.setText("");
        this.jtbilletes2.setText("");
        this.jtbilletes3.setText("");
        this.jtbilletes4.setText("");
        this.jtbilletes5.setText("");
        this.jtbilletes6.setText("");
        this.jtbilletes7.setText("");
        this.jtlimite.setText("10000");
        this.jtsuma.setText("");
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtbilletes1 = new javax.swing.JTextField();
        jtbilletes2 = new javax.swing.JTextField();
        jtbilletes3 = new javax.swing.JTextField();
        jtbilletes4 = new javax.swing.JTextField();
        jtbilletes5 = new javax.swing.JTextField();
        jtbilletes6 = new javax.swing.JTextField();
        jtbilletes7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtlimite = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtsuma = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbguardar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtdif = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jLabel1.setText("INGRESE LA CANTIDAD DE DINERO DEL DIA");

        jLabel2.setText("INGRESE LA CANTIDAD DE BILLETES");

        jLabel3.setText("Q1");

        jLabel4.setText("Q5");

        jLabel5.setText("Q10");

        jLabel6.setText("Q20");

        jLabel7.setText("Q50");

        jLabel8.setText("Q100");

        jLabel9.setText("Q200");

        jtbilletes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes1ActionPerformed(evt);
            }
        });

        jtbilletes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes2ActionPerformed(evt);
            }
        });

        jtbilletes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes3ActionPerformed(evt);
            }
        });

        jtbilletes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes4ActionPerformed(evt);
            }
        });

        jtbilletes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes5ActionPerformed(evt);
            }
        });

        jtbilletes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes6ActionPerformed(evt);
            }
        });

        jtbilletes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes7ActionPerformed(evt);
            }
        });

        jLabel10.setText("LIMITE PERMITIDO");

        jLabel11.setText("TOTAL INGRESADO");

        jButton1.setText("COMPROBAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbguardar.setText("GUARDAR");
        jbguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbguardarActionPerformed(evt);
            }
        });

        jLabel12.setText("Q");

        jLabel13.setText("Q");

        jLabel14.setText("DIFERENCIA");

        jLabel15.setText("Q");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(2, 2, 2)
                        .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtbilletes1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jbguardar)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtbilletes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jtbilletes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jtbilletes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtbilletes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtbilletes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jbguardar))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtbilletes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
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
                AgregarDatosB(billete);
                limpiar();            
    }//GEN-LAST:event_jbguardarActionPerformed


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
    private javax.swing.JButton jbguardar;
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
