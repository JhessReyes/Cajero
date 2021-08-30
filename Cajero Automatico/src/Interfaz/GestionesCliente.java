/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Login.idUser;
import clases.TarjetaU;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Reyes
 */
public class GestionesCliente extends javax.swing.JInternalFrame {
   private final JComponent northPane;
   private Border border;
   File Transacciones = new File("transacciones.txt");
   File tarjetas = new File("tarjetas.txt");
   ArrayList<TarjetaU> ListaTarjetas = new ArrayList<>();
   private String IdCliente;
   String saldoU;
   
    /**
     * Creates new form GestionesCliente
     */
    public GestionesCliente() {
        initComponents();
        northPane = ((BasicInternalFrameUI) getUI()).getNorthPane();
        border = getBorder();
        this.setUndecorated(true);
        this.setLocation(140, 55);
        AgregarDatosTJ(tarjetas);
        IdCliente = "";
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    } 
    public void retiro(){
        String retiro;
        saldoU = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();    
        retiro=JOptionPane.showInputDialog(null,"¿Cuanto dinero desea retirar?","RETIRO",0).trim();
        int sal = Integer.valueOf(saldoU)-Integer.valueOf(retiro);
        if(Integer.valueOf(retiro)>Integer.valueOf(saldoU)){
            JOptionPane.showMessageDialog(null,"El saldo no es viable para completar esta transaccion","ERROR",0);
        }else ModificarDatosTJ(ListaTarjetas,tarjetas,Integer.toString(sal));
    }
    

        public void AgregarDatosTJ(File f) {
        String a = "";
        String TipoUser = "";
        ListaTarjetas.clear();
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
                ListaTarjetas.add(new TarjetaU(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5], Usuarios[6]));
                TipoUser = "";
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
    }

    public void ModificarDatosTJ(ArrayList<TarjetaU> t, File f,String saldo) {
        int pos =Integer.valueOf(t.get(Integer.valueOf(idUser)).getIdTarjeta());
        
//        int eg = Integer.valueOf(t.get(pos).getEgresos())+Integer.valueOf(egreso);
//        t.get(pos).setEgresos(Integer.toString(eg));
        t.get(pos).setSaldo(saldo);
        String dato = "";
        for (int i = 0; i < t.size(); i++) {
            dato += t.get(i).getIdTarjeta()+"\t"+
                    t.get(i).getNumTarjeta()+"\t"+
                    t.get(i).getMInicial()+"\t"+
                    t.get(i).getLRetiro()+"\t"+
                    t.get(i).getIngresos()+"\t"+
                    t.get(i).getEgresos()+"\t"+
                    t.get(i).getSaldo()+"\n";
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write("");
            try ( FileWriter FlWr = new FileWriter(f, true)) {
                FlWr.write(dato);
            }
        } catch (IOException e) {
            System.out.println("Error");
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

        jbCambPin = new javax.swing.JButton();
        jbRetiro = new javax.swing.JButton();
        jbSaldo = new javax.swing.JButton();
        jbUltTrans = new javax.swing.JButton();
        jbDeposito = new javax.swing.JButton();

        setVisible(true);

        jbCambPin.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbCambPin.setText("Cambiar Pin");

        jbRetiro.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbRetiro.setText("Retiro");
        jbRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRetiroActionPerformed(evt);
            }
        });

        jbSaldo.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbSaldo.setText("SALDO");

        jbUltTrans.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbUltTrans.setText("ultimas tranSACCIONES");

        jbDeposito.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbDeposito.setText("Depósito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jbDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCambPin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(jbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jbUltTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCambPin, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jbUltTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRetiroActionPerformed
        // TODO add your handling code here:
        retiro();
    }//GEN-LAST:event_jbRetiroActionPerformed
    public void setRootPaneCheckingEnabled(boolean enabled)
    {
        super.setRootPaneCheckingEnabled(enabled);
    }
    
    public void setUndecorated(boolean val)
    {
        setBorder(val ? null : border);

        setRootPaneCheckingEnabled(false);
        ((BasicInternalFrameUI) getUI()).setNorthPane(val ? null : northPane);
        setRootPaneCheckingEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCambPin;
    private javax.swing.JButton jbDeposito;
    private javax.swing.JButton jbRetiro;
    private javax.swing.JButton jbSaldo;
    private javax.swing.JButton jbUltTrans;
    // End of variables declaration//GEN-END:variables
}
