/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import static Interfaz.Main.AgregarDatosTJs;
import static Interfaz.Main.AgregarDatosTrans;
import static Interfaz.Main.AgregarDatosU;
import static Interfaz.Main.RemoveDatos;
import static Interfaz.Main.gest;
import clases.TarjetaU;
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
public class ConsultaUsuario extends javax.swing.JInternalFrame {
    ArrayList<TarjetaU> ListaTarjeta;
    ArrayList<usuarios> ListaUsuarios;
    ArrayList<Transacciones> ListaTran;
    ArrayList<UltimosAccesos> UltimosUsuarios = new ArrayList<>();

    DefaultTableModel model2;
    File tar = new File("tarjetas.txt");
    File us = new File("usuarios.txt");
    File tr = new File("transacciones.txt");

    /**
     * Creates new form ConsultaUsuario
     */
    public ConsultaUsuario() {
        initComponents();
        this.ListaTarjeta = AgregarDatosTJs(ListaTarjeta,tar);
        this.ListaUsuarios = AgregarDatosU(ListaUsuarios,us);
        this.ListaTran = AgregarDatosTrans(ListaTran,tr);
        
        model2 = new DefaultTableModel();
        model2.addColumn("Retiro Disponible");
        model2.addColumn("Total Retiros");
        model2.addColumn("Saldo Actual");
        model2.addColumn("Ultimo Acceso");
        jTUser.setDragEnabled(false);
        jTUser.setFont(new Font("Nirmala UI",3,14));
        jTUser.setForeground(Color.black);
        jTUser.setBackground(new Color(0,255,120));
        this.jTUser.setModel(model2);
    }
    
    public void Consulta(){
        RemoveDatos(this.jTUser,model2);
        String []info = new String[5];
        int result = 0;
        String ult="";
        int con=0;
        for (int i = 0; i < ListaTran.size(); i++) {
            if(ListaTran.get(i).getTipo().contentEquals("Retiro")){
                result += Integer.valueOf(ListaTran.get(i).getMonto());
            }
            if(con==0){
               if(ListaTran.get(i).getTipo().contentEquals("Login")){
                   if(ListaTran.get(i).getIdUser().contentEquals(Integer.toString(consultIdU()))){
                       info[3] = ListaTran.get(i).getFecha();
                   }
               } 
            }
        }
        
        int RetiroDispo = Integer.valueOf(ListaTarjeta.get(consultIdU()).getLRetiro())-result;

            info[0] = Integer.toString(RetiroDispo);
            info[1] = Integer.toString(result);
            info[2] = ListaTarjeta.get(consultIdU()).getSaldo();
            model2.addRow(info);
        UltimosUsuarios.clear();
    }
    
    public void UltimoA(){
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
    }
    
    public int consultIdU(){
        int id=0;
        for (int i = 0; i < ListaTarjeta.size(); i++) {
            if(jTarjeta.getText().trim().contentEquals(ListaTarjeta.get(i).getNumTarjeta())){
                String ids = ListaTarjeta.get(i).getIdTarjeta();
                id=Integer.valueOf(ids);
                break;
            }            
        }
        return id;
    }
    
    public void salir(){
        this.jTarjeta.setText("");
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
        jTUser = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTarjeta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jTUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTUser);

        jLabel2.setText("INGRESE EL NUMERO DE TARJETA DEL USUARIO A CONSULTAR");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setText("No. TARJETA DEL USUARIO");

        jButton1.setText("CONSULTAR");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.ListaTarjeta = AgregarDatosTJs(ListaTarjeta,tar);
        this.ListaUsuarios = AgregarDatosU(ListaUsuarios,us);
        this.ListaTran = AgregarDatosTrans(ListaTran,tr);
        Consulta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        salir();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTUser;
    private javax.swing.JTextField jTarjeta;
    // End of variables declaration//GEN-END:variables
}
