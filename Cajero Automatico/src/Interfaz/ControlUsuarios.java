/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.AgregarDatosTrans;
import static Interfaz.Main.AgregarDatosU;
import static Interfaz.Main.RemoveDatos;
import clases.Transacciones;
import clases.UltimosAccesos;
import clases.usuarios;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
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
        totalRet.setText(TotalRetiros());
        totalDep.setText(TotalDepositos());
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jControlU = new javax.swing.JTable();
        totalRet = new javax.swing.JLabel();
        totalDep = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setText("Total retirado por los usuarios  Q.");

        jLabel2.setText("Total depositado por los usuarios  Q.");

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

        totalRet.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalRet.setText("0.00");

        totalDep.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalDep.setText("0.00");

        jButton1.setText("ACTUALIZAR DATOS");
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
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalRet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalDep, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalRet))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalDep))
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.ListaUsuarios = AgregarDatosU(ListaUsuarios,Usuarios);
        this.ListaTran = AgregarDatosTrans(ListaTran,Transacciones);
        totalRet.setText(TotalRetiros());
        totalDep.setText(TotalDepositos());
        TablaClientes();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JTable jControlU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalDep;
    private javax.swing.JLabel totalRet;
    // End of variables declaration//GEN-END:variables
}
