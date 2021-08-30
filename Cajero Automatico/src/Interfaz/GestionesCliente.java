/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Login.idUser;
import static Interfaz.Main.fech;
import static Interfaz.Main.fecha;
import static Interfaz.Main.fechayhora;
import static Interfaz.Main.hora;
import static Interfaz.Main.init;
import static Interfaz.Main.tabtran;
import static Interfaz.TablaTransacciones.jTable;
import static Interfaz.TablaTransacciones.model;
import clases.TarjetaU;
import clases.Transacciones;
import clases.usuarios;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reyes
 */
public class GestionesCliente extends javax.swing.JInternalFrame {
   private final JComponent northPane;
   private Border border;
   File Transacciones = new File("transacciones.txt");
   File tarjetas = new File("tarjetas.txt");
   File usuario = new File("usuarios.txt");

   ArrayList<TarjetaU> ListaTarjetas = new ArrayList<>();   
   ArrayList<usuarios> ListaUser;   
   ArrayList<Transacciones> ListaTransacciones;

   private String IdCliente;
   String saldoU;
   int idTransaccion;
    /**
     * Creates new form GestionesCliente
     */
    public GestionesCliente() {
        initComponents();
        ListaUser= new ArrayList<>();
        northPane = ((BasicInternalFrameUI) getUI()).getNorthPane();
        border = getBorder();
        this.setUndecorated(true);
        this.setLocation(140, 55);
        AgregarDatosTJ(tarjetas);
        IdCliente = "";
        ListaTransacciones= new ArrayList<>();
        AgregarDatosTran(Transacciones);
        autoid(Transacciones);
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String IdCliente) {
        this.IdCliente = IdCliente;
    }
    
        //metodo para autoregistro
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
            idTransaccion= linea;
            //this.jtid.setText(String.valueOf(linea));
        } catch (Exception ex) {
        }
    }
    
        //metodo para realizar retiros de la tarjeta
    public void retiro(){
        AgregarDatosTran(Transacciones);
        String retiro;
        saldoU = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();    
        retiro=JOptionPane.showInputDialog(null,"¿Cuanto dinero desea retirar?","RETIRO",0).trim();
        int sal = Integer.valueOf(saldoU)-Integer.valueOf(retiro);
        if(Integer.valueOf(retiro)>Integer.valueOf(saldoU)){
            JOptionPane.showMessageDialog(null,"El saldo no es viable para completar esta transaccion","ERROR",0);
        }else{
            ModificarDatosTJ(ListaTarjetas,tarjetas,Integer.toString(sal));
            ListaTransacciones.add(new Transacciones(Integer.toString(idTransaccion),idUser,"Retiro",retiro,fecha,hora));
            idTransaccion++;
            ModificarDatosTran(ListaTransacciones,Transacciones);
        }
    }
    
        //metodo para realizar depositos en la tarjeta
    public void deposito(){
        AgregarDatosTJ(tarjetas);
        AgregarDatosTran(Transacciones);
        String deposito;
        saldoU = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();    
        deposito=JOptionPane.showInputDialog(null,"¿Cuanto dinero desea ingresar?","DEPOSITO",0).trim();
        int sal = Integer.valueOf(saldoU)+Integer.valueOf(deposito);
        ModificarDatosTJ(ListaTarjetas,tarjetas, Integer.toString(sal));        
        ListaTransacciones.add(new Transacciones(Integer.toString(idTransaccion),idUser,"Deposito",deposito,fecha,hora));
        idTransaccion++;
        ModificarDatosTran(ListaTransacciones,Transacciones);
    }
    
        //metodo para cambiar pin
    public void cambpin(){
        AgregarDatosU(usuario);
        String nuevopin;
        String pinant;
        //pinant=JOptionPane.showInputDialog(null,"Ingrese su pin anterior","PIN ANTERIOR",2).trim();
        nuevopin=JOptionPane.showInputDialog(null,"Ingrese su nuevo pin","NUEVO PIN",3).trim();
        System.out.println(ListaUser.get(Integer.valueOf(idUser)).getPassword().trim());
        //System.out.println(pinant);
//        if(pinant!=null&&nuevopin!=null){
//                if(pinant.contentEquals(ListaUser.get(Integer.valueOf(idUser)).getPassword())){
                    ModificarDatosU(ListaUser,usuario,nuevopin);            
//                }else JOptionPane.showMessageDialog(null,"Sus datos no coinciden", "ERROR", 0);
//            }
    }
    //metodo para mostrar saldos disponibles
    public void saldos(){
        String Sal = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();
        String retiro = ListaTarjetas.get(Integer.valueOf(idUser)).getLRetiro();
        JOptionPane.showMessageDialog(null, "• Monto máximo de retiro     Q. " + retiro +"\n"+
                                            "• Monto máximo de retiro diario disponible  Q. \n" +
                                            "• Saldo Actual -> Q. "+Sal);
    }
    
        //metodo para mostrar ultimos 5 registros
    public void  tabla(){
       
       RemoveDatos(jTable,model);
        for(Transacciones tb: ListaTransacciones){
            if(tb.getIdUser().contentEquals(idUser)){
            String []info = new String[6];
            info[0] = tb.getIdRegistro();
            info[1] = tb.getTipo();
            info[2] = tb.getMonto();
            info[3] = tb.getFecha();
            info[4] = tb.getHora();
            model.addRow(info);
            }
        }
    }
    public void RemoveDatos(JTable tb, DefaultTableModel db){
     int fil = tb.getRowCount();
        if(fil>=0){
            for(int x =fil-1; x>=0;x--){
                db.removeRow(x);
            }
        }
    }
        //metodo para guardar datos de todas las tarjetas
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
    
        //metodo agregar ListadeTransacciones
    public void AgregarDatosTran(File f) {
        String a = "";
        String text = "";
        ListaTransacciones.clear();
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
                        text += String.valueOf(c);
                    } else {
                        if (cnt == 0) {
                            Usuarios[cnt] = text;
                        }
                        if (cnt == 1) {
                            Usuarios[cnt] = text;
                        }
                        if (cnt == 2) {
                            Usuarios[cnt] = text;
                        }
                        if (cnt == 3) {
                            Usuarios[cnt] = text;
                        }
                        if (cnt == 4) {
                            Usuarios[cnt] = text;
                        }
                        cnt++;
                        text = "";
                    }
                    if (cnt == 5) {
                        Usuarios[cnt] = text;
                    }
                }
                ListaTransacciones.add(new Transacciones(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4], Usuarios[5]));
                text = "";
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
    }
    
        //metodo para modificar saldos de la tarjeta
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
        public void ModificarDatosTran(ArrayList<Transacciones> t, File f) {
        String dato = "";
        for (int i = 0; i < t.size(); i++) {
            dato += t.get(i).getIdRegistro()+"\t"+
                    t.get(i).getIdUser()+"\t"+
                    t.get(i).getTipo()+"\t"+
                    t.get(i).getMonto()+"\t"+
                    t.get(i).getFecha()+"\t"+
                    t.get(i).getHora()+"\n";
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
    
        //metodo para modificar pin tarjeta
    public void ModificarDatosU(ArrayList<usuarios> a, File b, String pinnuevo) {
        String dato = "";
        a.get(Integer.valueOf(idUser)).setPassword(pinnuevo);

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
    
        //metodo par guardar datos de los usuarios
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
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
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
        jButton1 = new javax.swing.JButton();

        setVisible(true);

        jbCambPin.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbCambPin.setText("Cambiar Pin");
        jbCambPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambPinActionPerformed(evt);
            }
        });

        jbRetiro.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbRetiro.setText("Retiro");
        jbRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRetiroActionPerformed(evt);
            }
        });

        jbSaldo.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbSaldo.setText("SALDO");
        jbSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaldoActionPerformed(evt);
            }
        });

        jbUltTrans.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbUltTrans.setText("ultimas tranSACCIONES");
        jbUltTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUltTransActionPerformed(evt);
            }
        });

        jbDeposito.setFont(new java.awt.Font("Castellar", 0, 14)); // NOI18N
        jbDeposito.setText("Depósito");
        jbDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDepositoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jbDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jbCambPin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jbSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(110, 110, 110)
                            .addComponent(jButton1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbUltTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
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
                .addGap(39, 39, 39)
                .addComponent(jbUltTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRetiroActionPerformed
        // TODO add your handling code here:
        retiro();
    }//GEN-LAST:event_jbRetiroActionPerformed

    private void jbDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDepositoActionPerformed
        // TODO add your handling code here:
        deposito();
    }//GEN-LAST:event_jbDepositoActionPerformed

    private void jbCambPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambPinActionPerformed
        // TODO add your handling code here:
        cambpin();
    }//GEN-LAST:event_jbCambPinActionPerformed

    private void jbSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaldoActionPerformed
        // TODO add your handling code here:
        saldos();
    }//GEN-LAST:event_jbSaldoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        init.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbUltTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUltTransActionPerformed
        // TODO add your handling code here:
        tabla();
        tabtran.setVisible(true);
    }//GEN-LAST:event_jbUltTransActionPerformed
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jbCambPin;
    private javax.swing.JButton jbDeposito;
    private javax.swing.JButton jbRetiro;
    private javax.swing.JButton jbSaldo;
    private javax.swing.JButton jbUltTrans;
    // End of variables declaration//GEN-END:variables
}
