/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.AgregarDatosTrans;
import static Interfaz.Main.AgregarDatosU;
import static Interfaz.Main.Conexion;
import static Interfaz.Main.RemoveDatos;
import static Interfaz.Main.gest;
import clases.Transacciones;
import clases.UltimosAccesos;
import clases.usuarios;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reyes
 */
public class ControlUsuarios extends javax.swing.JInternalFrame {
    ArrayList<Transacciones> ListaTran;
    ArrayList<usuarios> ListaUsuarios = new ArrayList<>();;
    ArrayList<UltimosAccesos> UltimosUsuarios = new ArrayList<>();
    ArrayList<String> idUsuarios = new ArrayList<>();
    File Transacciones = new File("transacciones.txt");
    File Usuarios = new File("usuarios.txt");

    static DefaultTableModel model1; 
    
    /**
     * Creates new form ControlUsuarios
     */
    public ControlUsuarios() {
        initComponents();
        this.ListaUsuarios = AgregarDatosU(ListaUsuarios,Usuarios);
        this.ListaTran = AgregarDatosTrans(ListaTran,Transacciones);
//        totalRet.setText(TotalRetiros());
//        totalDep.setText(TotalDepositos());
        TOTALES();
        model1 = new DefaultTableModel();
        model1.addColumn("Nombre");
        model1.addColumn("Apellido");
        model1.addColumn("Cambio de Pin");        
        model1.addColumn("Fecha");
        jControlU.setDragEnabled(false);
        jControlU.setFont(new Font("Nirmala UI",3,14));
        jControlU.setForeground(Color.black);
        jControlU.setBackground(new Color(0,255,120));
       // TablaClientes();
        this.jControlU.setModel(model1);
       
    }
    public void usuarios(){
        for (int i = 0; i < ListaUsuarios.size(); i++) {
            idUsuarios.add(ListaUsuarios.get(i).getIdUsuario());
        }
    }
    public void TablaClientes(){
        int pos=0;
        for (int i = ListaTran.size()-1; i > -1;  i--) {
            if(ListaTran.get(i).getTipo().contentEquals("Login")){
                String id=ListaTran.get(i).getIdUser();
                pos=Integer.valueOf(id);
                UltimosUsuarios.add(new UltimosAccesos(id,ListaUsuarios.get(pos).getNombre(),
                        ListaUsuarios.get(pos).getApellido(),"",ListaTran.get(i).getFecha()));
            }
        }

        for (int i = ListaTran.size()-1; i > -1;  i--) {
            if(ListaTran.get(i).getTipo().contentEquals("CambioPin")){
                for (int j = ListaUsuarios.size()-1; j > -1; j--) {
                        if(ListaTran.get(i).getMonto().contentEquals(ListaUsuarios.get(j).getNumTarjeta())){
                                for (int k = UltimosUsuarios.size()-1; k > -1; k--) {
                                    if(UltimosUsuarios.get(k).getIdUser().contentEquals(ListaUsuarios.get(j).getIdUsuario())){
                                       // System.out.println(UltimosUsuarios.get(k).getIdUser());
                                        UltimosUsuarios.get(k).setCambioPin("Si");
                                    }
                                }
                        }
                    }
                }
        }

        for (int k = UltimosUsuarios.size()-1; k > -1; k--) {
                    if(UltimosUsuarios.get(k).getCambioPin().contentEquals("")){
                            UltimosUsuarios.get(k).setCambioPin("No");
                    }
        }
        
//        int cnt = 0;
//        for (int l = UltimosUsuarios.size()-1; l > -1; l--) {
//            if(cnt<UltimosUsuarios.size()){
//            if(UltimosUsuarios.get(cnt).getIdUser().contentEquals(UltimosUsuarios.get(l).getIdUser())){
//                UltimosUsuarios.remove(l);
//                cnt++;
//            }
//            }
//        }
        InsertarTablaporCambiopin();
    }
    
    public void InsertarTablaporCambiopin(){
        RemoveDatos(jControlU,model1);
        for(UltimosAccesos tb: UltimosUsuarios){
            if(tb.getCambioPin().contentEquals("Si")){
            String []info = new String[5];
            info[0] = tb.getNombre();
            info[1] = tb.getApellido();
            info[2] = tb.getCambioPin();
            info[3] = tb.getFecha();
            model1.addRow(info);
            }
            if(tb.getCambioPin().contentEquals("No")){
            String []info = new String[5];
            info[0] = tb.getNombre();
            info[1] = tb.getApellido();
            info[2] = tb.getCambioPin();
            info[3] = tb.getFecha();
            model1.addRow(info);    
            }
        }
            ListaTran.clear();
            ListaUsuarios.clear();
            UltimosUsuarios.clear();
    }
    
    public String TotalDepositos(){
        //this.ListaTran = AgregarDatosTran(ListaTran,Transacciones);
        String r;
        int result = 0;
        for (int i = 0; i < ListaTran.size(); i++) {
            if(ListaTran.get(i).getTipo().contentEquals("Deposito")){
                result += Integer.valueOf(ListaTran.get(i).getMonto());
            }            
        }
        r = Integer.toString(result);
        return  r;
    }
    public String TotalRetiros(){
        
        String r;
        int result = 0;
        for (int i = 0; i < ListaTran.size(); i++) {
            if(ListaTran.get(i).getTipo().contentEquals("Retiro")){
                result += Integer.valueOf(ListaTran.get(i).getMonto());
            }            
        }
        r = Integer.toString(result);
        return  r;
    }
    
   public void TOTALES(){
       PreparedStatement Declaracion;
        ResultSet result;
        try{
            Declaracion= Conexion.prepareStatement("EXEC CONTROL_USUARIOS");
            result = Declaracion.executeQuery();
            while(result.next()){
                totalRet.setText(result.getString("TOTAL DEPOSITOS"));
                totalDep.setText(result.getString("TOTAL RETIROS"));
            }
        }catch(Exception e) {System.out.println(e);}
   }
   
   public void cambiaron(){
       RemoveDatos(jControlU,model1);
       PreparedStatement Declaracion;
        ResultSet result;
        try{
            Declaracion= Conexion.prepareStatement("EXEC CAMBIARON_PIN");
            result = Declaracion.executeQuery();
            while(result.next()){
                String[] info = new String[5];
                info[0] = result.getString("NOMBRES");
                info[1] = result.getString("APELLIDOS");
                info[2] = result.getString("CAMBIO DE PIN");
                info[3] = result.getString("FECHA_HORA");
                model1.addRow(info);
            }
        }catch(Exception e) {System.out.println(e);}
   }
   
   public void Nocambiaron(){
       RemoveDatos(jControlU,model1);
       PreparedStatement Declaracion;
        ResultSet result;
        try{
            Declaracion= Conexion.prepareStatement("EXEC NO_CAMBIARON_PIN");
            result = Declaracion.executeQuery();
            while(result.next()){
                String[] info = new String[5];
                info[0] = result.getString("NOMBRES");
                info[1] = result.getString("APELLIDOS");
                info[2] = result.getString("CAMBIO DE PIN");
                info[3] = result.getString("FECHA_HORA");
                model1.addRow(info);
            }
        }catch(Exception e) {System.out.println(e);}
   }
    public void salir(){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jControlU = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalRet = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalDep = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);

        jControlU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jControlU);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("Total retirado por los usuarios  Q.");

        totalRet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalRet.setText("0.00");

        jLabel2.setText("Total depositado por los usuarios  Q.");

        totalDep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalDep.setText("0.00");

        jButton1.setText("ACTUALIZAR DATOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CAMBIARON PIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("NO CAMBIARON");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalRet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalDep, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalRet))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalDep))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.ListaUsuarios = AgregarDatosU(ListaUsuarios,Usuarios);
        this.ListaTran = AgregarDatosTrans(ListaTran,Transacciones);
        totalRet.setText(TotalRetiros());
        totalDep.setText(TotalDepositos());
        TOTALES();
        //TablaClientes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cambiaron();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Nocambiaron();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JTable jControlU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalDep;
    private javax.swing.JLabel totalRet;
    // End of variables declaration//GEN-END:variables
}
