/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.gest;
import clases.cajero;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class agregarlote extends javax.swing.JInternalFrame {

    /**
     * Creates new form agregarlote
     */
    File billete = new File("billetes.txt");

    public agregarlote() {
        initComponents();
        this.jtlimite.setText(String.valueOf(30000));
        this.jbguardar.setVisible(false);

    }

    cajero DatosB;
    ArrayList<cajero> ListaBillete = new ArrayList<>();
    ArrayList<cajero> db = new ArrayList();

    public cajero GuardarBill() {
        DatosB = new cajero(jtbilletes1.getText(), jtbilletes2.getText(), jtbilletes3.getText(),
                jtbilletes4.getText(), jtbilletes5.getText(), jtbilletes6.getText(), jtbilletes7.getText(),
                jtlimite.getText(), jtsuma.getText()
        );
        return DatosB;
    }

    public void agregarbilete(ArrayList<cajero> ag, File f) {
        ag.indexOf(GuardarBill());
        int b1 = Integer.valueOf(ListaBillete.get(0).getB1() + this.jtbilletes1.getText());
        System.out.print(b1);
        ListaBillete.get(ag.indexOf(GuardarBill()));

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

                int b1 = Integer.valueOf(ListaBillete.get(0).getB1());
                int b5 = Integer.valueOf(ListaBillete.get(0).getB5());
                int b10 = Integer.valueOf(ListaBillete.get(0).getB10());
                int b20 = Integer.valueOf(ListaBillete.get(0).getB20());
                int b50 = Integer.valueOf(ListaBillete.get(0).getB50());
                int b100 = Integer.valueOf(ListaBillete.get(0).getB100());
                int b200 = Integer.valueOf(ListaBillete.get(0).getB200());
                int btt = Integer.valueOf(ListaBillete.get(0).getTotal());
                int bsl = Integer.valueOf(ListaBillete.get(0).getSaldo());

                b1 = b1 + (Integer.valueOf(this.jtbilletes1.getText()));
                b5 = b5 + (Integer.valueOf(this.jtbilletes2.getText()));
                b10 = b10 + (Integer.valueOf(this.jtbilletes3.getText()));
                b20 = b20 + (Integer.valueOf(this.jtbilletes4.getText()));
                b50 = b50 + (Integer.valueOf(this.jtbilletes5.getText()));
                b100 = b100 + (Integer.valueOf(this.jtbilletes6.getText()));
                b200 = b200 + (Integer.valueOf(this.jtbilletes7.getText()));
                btt = Integer.valueOf(this.jtlimite.getText());
                bsl = (b1 * 1) + (b5 * 5) + (b10 * 10) + (b20 * 20) + (b50 * 50) + (b100 * 100) + (b200 * 200);
                
                //LIMPIAR TXT Y DEJAR UNICAMENTE EL SALDO ACTUAN CON EL NUMERO 
                //ACTUAL DE BILLETES
                limpiartxt(f);
                ListaBillete.clear();


                ListaBillete.add(new cajero(String.valueOf(b1), String.valueOf(b5), String.valueOf(b10), String.valueOf(b20), String.valueOf(b50), String.valueOf(b100), String.valueOf(b200), String.valueOf(btt), String.valueOf(bsl)));
                JOptionPane.showMessageDialog(null, "EL SALDO ACTUAL DEL CAJERO ES DE: " + bsl);
            }
            //ListaBillete.add(GuardarBill());

            //agregarbilete( ListaBillete,billete);
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
        int b1, b2, b3, b4, b5, b6, b7, sum, var2, dif;
        b1 = Integer.valueOf(jtbilletes1.getText());
        b2 = Integer.valueOf(jtbilletes2.getText());
        b3 = Integer.valueOf(jtbilletes3.getText());
        b4 = Integer.valueOf(jtbilletes4.getText());
        b5 = Integer.valueOf(jtbilletes5.getText());
        b6 = Integer.valueOf(jtbilletes6.getText());
        b7 = Integer.valueOf(jtbilletes7.getText());
        var2 = 30000;
        sum = (b1 * 1) + (b2 * 5) + (b3 * 10) + (b4 * 20) + (b5 * 50) + (b6 * 100) + (b7 * 200);
        dif = var2 - sum;
        this.jtsuma.setText(String.valueOf(sum));
        this.jtdif.setText(String.valueOf(dif));
        if (dif <= var2) {
            JOptionPane.showMessageDialog(null, "CONFIGURACION ACEPTADA, PUEDE GUARDAR");
            this.jbguardar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE GUARDAR ESTA CONFIGURACION");
        }
    }

    public void limpiar() {
        this.jtbilletes1.setText("0");
        this.jtbilletes2.setText("0");
        this.jtbilletes3.setText("0");
        this.jtbilletes4.setText("0");
        this.jtbilletes5.setText("0");
        this.jtbilletes6.setText("0");
        this.jtbilletes7.setText("0");
        this.jtlimite.setText("30000");
        this.jtsuma.setText("");
        this.jtdif.setText("");
        this.setVisible(false);
        gest.setVisible(true);

    }

    public void limpiartxt(File f) {

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("");
        } catch (IOException ex) {
            Logger.getLogger(iniciarcajero.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtbilletes7 = new javax.swing.JTextField();
        jtbilletes6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbguardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jtbilletes5 = new javax.swing.JTextField();
        jtbilletes4 = new javax.swing.JTextField();
        jtbilletes3 = new javax.swing.JTextField();
        jtbilletes1 = new javax.swing.JTextField();
        jtbilletes2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtlimite = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtsuma = new javax.swing.JTextField();
        jtdif = new javax.swing.JTextField();
        jtsalir = new javax.swing.JButton();

        jLabel1.setText("INGRESE EL NUEVO LOTE DE DINERO PARA LA CAJA");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("INGRESE LA CANTIDAD DE BILLETES");

        jLabel3.setText("Q1");

        jLabel4.setText("Q5");

        jLabel5.setText("Q10");

        jLabel6.setText("Q20");

        jLabel7.setText("Q50");

        jLabel8.setText("Q100");

        jLabel9.setText("Q200");

        jtbilletes7.setText("0");
        jtbilletes7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes7ActionPerformed(evt);
            }
        });

        jtbilletes6.setText("0");
        jtbilletes6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes6ActionPerformed(evt);
            }
        });

        jLabel15.setText("Q");

        jLabel13.setText("Q");

        jLabel12.setText("Q");

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

        jLabel16.setText("DIFERENCIA");

        jtbilletes5.setText("0");
        jtbilletes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes5ActionPerformed(evt);
            }
        });

        jtbilletes4.setText("0");
        jtbilletes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes4ActionPerformed(evt);
            }
        });

        jtbilletes3.setText("0");
        jtbilletes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes3ActionPerformed(evt);
            }
        });

        jtbilletes1.setText("0");
        jtbilletes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes1ActionPerformed(evt);
            }
        });

        jtbilletes2.setText("0");
        jtbilletes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbilletes2ActionPerformed(evt);
            }
        });

        jLabel10.setText("LIMITE PERMITIDO");

        jtlimite.setText("0");

        jLabel11.setText("TOTAL INGRESADO");

        jtsuma.setText("0");

        jtdif.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtbilletes6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16))
                    .addComponent(jButton1))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbguardar))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(jtbilletes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jtlimite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtsuma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtdif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtbilletes4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtbilletes5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jbguardar))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtbilletes6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtbilletes7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jtsalir.setText("SALIR");
        jtsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtsalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtsalir))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbilletes7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes7ActionPerformed

    private void jtbilletes6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes6ActionPerformed

    private void jtbilletes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes5ActionPerformed

    private void jtbilletes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes4ActionPerformed

    private void jtbilletes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes3ActionPerformed

    private void jtbilletes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes1ActionPerformed

    private void jtbilletes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbilletes2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbilletes2ActionPerformed

    private void jbguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbguardarActionPerformed
        AgregarDatosB(billete);
        limpiar();
    }//GEN-LAST:event_jbguardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        limitecajero();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtsalirActionPerformed
        limpiar();
    }//GEN-LAST:event_jtsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JButton jtsalir;
    private javax.swing.JTextField jtsuma;
    // End of variables declaration//GEN-END:variables
}
