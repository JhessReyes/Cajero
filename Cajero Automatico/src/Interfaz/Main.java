/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import clases.TarjetaU;
import clases.Transacciones;
import clases.usuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhess
 */
public class Main extends javax.swing.JFrame {
    static InicioUsuario init = new InicioUsuario();
    static gestionadmin gest = new gestionadmin();  
    static newusuario nuses = new newusuario();
    static iniciarcajero incj = new iniciarcajero();
    static GestionesCliente gcli = new GestionesCliente();
    static TablaTransacciones tabtran = new TablaTransacciones();
    static agregarlote lote = new agregarlote();
    static modificarTarjeta mt = new modificarTarjeta();
    static modificarLimite ml = new modificarLimite();
    static ControlUsuarios ctrlu = new ControlUsuarios();
    static ConsultaUsuario conus = new ConsultaUsuario();
    
    /**
     * Creates new form Main
     */
        
    public Main() {
       
        initComponents();
        BarraAdmin();
        this.setLocationRelativeTo(this);
        Tiempo.add(init);
        init.setVisible(false);
        Tiempo.add(gest);
        gest.setVisible(false);
        Tiempo.add(nuses);
        nuses.setVisible(false);
        Tiempo.add(incj);
        incj.setVisible(false);
        Tiempo.add(gcli);
        gcli.setVisible(false);
        Tiempo.add(tabtran);
        tabtran.setVisible(false);
        Tiempo.add(lote);
        lote.setVisible(false);
        Tiempo.add(mt);
        mt.setVisible(false);
        Tiempo.add(ml);
        ml.setVisible(false);
        Tiempo.add(ctrlu);
        ctrlu.setVisible(false);
        Tiempo.add(conus);
        conus.setVisible(false);
       // Time ventana = new Time();
//        Tiempo.add(ventana);
//        ventana.show();
       
        //Tiempo.add(ventana);
//        InicioUsuario init = new InicioUsuario();
//        Tiempo.add(init);
//        init.show();
        //ventana.setVisible(true);
//        btnAd.setOpaque(false);
//        btnAd.setBorderPainted(false);
//        btnAd.setContentAreaFilled(false);
//        btnIng.setOpaque(false);
//        btnIng.setBorderPainted(false);
//        btnIng.setContentAreaFilled(false);

    }
        public static void RemoveDatos(JTable tb, DefaultTableModel db){
     int fil = tb.getRowCount();
        if(fil>=0){
            for(int x =fil-1; x>=0;x--){
                db.removeRow(x);
            }
        }
    }
    //metodo agregar ListadeTransacciones
    public static ArrayList<Transacciones> AgregarDatosTrans(ArrayList<Transacciones> ListaTransacciones,File f) {
        String a = "";
        String text = "";
        ListaTransacciones=new ArrayList<>();
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
                        cnt++;
                        text = "";
                    }
                    if (cnt == 4) {
                        Usuarios[cnt] = text;
                    }
                }
                ListaTransacciones.add(new Transacciones(Usuarios[0], Usuarios[1], Usuarios[2], Usuarios[3], Usuarios[4]));
                text = "";
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }
        return ListaTransacciones;
    }
    public static void ModificarDatosTrans(ArrayList<Transacciones> t, File f) {
        String dato = "";
        for (int i = 0; i < t.size(); i++) {
            dato += t.get(i).getIdRegistro()+"\t"+
                    t.get(i).getIdUser()+"\t"+
                    t.get(i).getTipo()+"\t"+
                    t.get(i).getMonto()+"\t"+
                    t.get(i).getFecha()+"\n";
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
    public static ArrayList<usuarios> AgregarDatosU(ArrayList<usuarios> ListaUser,File f) {
        String a = "";
        String TipoUser = "";
        ListaUser = new ArrayList<>();
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
        return ListaUser;
    }
    public static ArrayList<TarjetaU> AgregarDatosTJs(ArrayList<TarjetaU> ListaTarjetas, File f) {
        String a = "";
        String TipoUser = "";
        ListaTarjetas = new ArrayList<>();
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
        return ListaTarjetas;
    }
    public static String autoId(File f){
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
        } catch (Exception ex) {}
        
        return Integer.toString(linea);
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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAd = new javax.swing.JButton();
        Tiempo = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 625));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 625));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CAJERO AUTOMÁTICO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 480, 50));

        jLabel2.setBackground(new java.awt.Color(0, 153, 102));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/banner.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 67));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setFocusable(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/menu_ico.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 60, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/IconsBar/User_male.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 100));

        jLabel6.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ADMIN");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 60, 20));

        jLabel8.setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sergio Santos");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 140, -1));

        jLabel9.setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Copyrigth © - 2021");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 140, 20));

        jLabel10.setFont(new java.awt.Font("Bell MT", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Jhonatan Reyes ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 140, 20));

        jLabel11.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("REPORTE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("INICIO");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel13.setFont(new java.awt.Font("Castellar", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("USUARIOS");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/IconsBar/icons8-survey-23.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 30, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/IconsBar/icons8-home-page-23.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 30, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/IconsBar/icons8-magazine-23.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 30, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 559));
        jPanel2.getAccessibleContext().setAccessibleName("");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/menu_ico_gray.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 60, 50));

        btnAd.setFont(new java.awt.Font("Castellar", 1, 12)); // NOI18N
        btnAd.setText("ADMINISTRACIÓN");
        btnAd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAd.setOpaque(false);
        btnAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdActionPerformed(evt);
            }
        });
        jPanel3.add(btnAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 130, 40));

        Tiempo.setPreferredSize(new java.awt.Dimension(260, 70));

        javax.swing.GroupLayout TiempoLayout = new javax.swing.GroupLayout(Tiempo);
        Tiempo.setLayout(TiempoLayout);
        TiempoLayout.setHorizontalGroup(
            TiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        TiempoLayout.setVerticalGroup(
            TiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel3.add(Tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 790, 550));
        Tiempo.getAccessibleContext().setAccessibleName("");

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1000, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int x = 210;
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        if( x == 210){
            jPanel2.setSize(210,559);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 210; i>= 0 ; i--){
                            //fecha.stop();
                            Thread.sleep(1);
                            jPanel2.setSize(i,559);
                           // if(i==0)fecha.start();
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    } 
                }
            };th.start();
            x=0;
           // fecha.start();
        }

       
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        //init.setVisible(true);
        Login vt = new Login();
        vt.setVisible(true);
        if( x == 0){
            jPanel2.show();
            jPanel2.setSize(x,559);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 0; i<= x ; i++){
                            Thread.sleep(1);
                            jPanel2.setSize(i,559);
                        }
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    } 
                }
            };th.start();
            x=210;            
        }        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btnAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdActionPerformed
        // TODO add your handling code here:
        Login vt = new Login();
        vt.setVisible(true);
    }//GEN-LAST:event_btnAdActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                init.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Tiempo;
    private javax.swing.JButton btnAd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
    
    
    public void BarraAdmin(){
        if( x == 210){
            jPanel2.setSize(210,559);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i = 210; i>= 0 ; i--){
                            //fecha.stop();
                            Thread.sleep(1);
                            jPanel2.setSize(i,559);
                           // if(i==0)fecha.start();
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    } 
                }
            };th.start();
            x=0;
        }
    }
}
