/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import static Interfaz.Login.idUser;
import static Interfaz.Main.AgregarDatosTJs;
import static Interfaz.Main.ModificarDatosTrans;
import static Interfaz.Main.AgregarDatosTrans;
import static Interfaz.Main.autoId;
import static Interfaz.Main.depcli;
import static Interfaz.Main.init;
import static Interfaz.Time.*;
import static Interfaz.Main.tabtran;
import static Interfaz.TablaTransacciones.jTable;
import static Interfaz.TablaTransacciones.model;
import clases.TarjetaU;
import clases.Transacciones;
import clases.cajero;
import clases.usuarios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reyes
 */
public class GestionesClientes extends javax.swing.JInternalFrame {

    private final JComponent northPane;
    private Border border;
    File Transacciones = new File("transacciones.txt");
    File tarjetas = new File("tarjetas.txt");
    File usuario = new File("usuarios.txt");
    File billete = new File("billetes.txt");

    ArrayList<TarjetaU> ListaTarjetas = new ArrayList<>();
    ArrayList<usuarios> ListaUser;
    ArrayList<Transacciones> ListaTransacciones;
    ArrayList<cajero> ListaBillete = new ArrayList<>();

    private String IdCliente;
    String saldoU;
    int idTransaccion;
    String RetiroDisp;

    /**
     * Creates new form GestionesCliente
     */
    public GestionesClientes() {
        initComponents();
        ListaUser = new ArrayList<>();
        northPane = ((BasicInternalFrameUI) getUI()).getNorthPane();
        border = getBorder();
        this.setUndecorated(true);
        this.setLocation(140, 55);
        AgregarDatosTJ(tarjetas);
        IdCliente = "";
        ListaTransacciones = new ArrayList<>();
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
            idTransaccion = linea;
            //this.jtid.setText(String.valueOf(linea));
        } catch (Exception ex) {
        }
    }

    //metodo para realizar retiros de la tarjeta
    public void retiro() {
        limiteDiario();
        AgregarDatosTran(Transacciones);  
        String retiro;
        saldoU = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();
        retiro = JOptionPane.showInputDialog(null, "¿Cuanto dinero desea retirar?", "RETIRO", 0).trim();
        if (Integer.valueOf(retiro) <= Integer.valueOf(RetiroDisp)) {
            int sal = Integer.valueOf(saldoU) - Integer.valueOf(retiro);
            if (Integer.valueOf(retiro) > Integer.valueOf(saldoU)) {
                JOptionPane.showMessageDialog(null, "El saldo no es viable para completar esta transaccion", "ERROR", 0);
            } else {
                AgregarDatosB(billete,retiro);
                ModificarDatosTJ(ListaTarjetas, tarjetas, Integer.toString(sal));
                ListaTransacciones.add(new Transacciones(Integer.toString(idTransaccion), idUser, "Retiro", retiro, FeYHo.getText()));
                idTransaccion++;
                ModificarDatosTran(ListaTransacciones, Transacciones);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se le permiten más retiros por hoy", "ERROR", 0);
        }

    }
    //METODO PARA RESTAR LOS BILLETES DEL RETIRO

    public void AgregarDatosB(File f, String retiro) {
        String a = "";
        String TipoUser = "";
        String ret = retiro;
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
                int b2 = Integer.valueOf(ListaBillete.get(0).getB5());
                int b3 = Integer.valueOf(ListaBillete.get(0).getB10());
                int b4 = Integer.valueOf(ListaBillete.get(0).getB20());
                int b5 = Integer.valueOf(ListaBillete.get(0).getB50());
                int b6 = Integer.valueOf(ListaBillete.get(0).getB100());
                int b7 = Integer.valueOf(ListaBillete.get(0).getB200());
                int btt = Integer.valueOf(ListaBillete.get(0).getTotal());
                int bsl = Integer.valueOf(ListaBillete.get(0).getSaldo());
                
                int ax1,ax2,ax3,ax4,ax5,ax6,ax7;
                ax1=b1; ax2=b2; ax3=b3; ax4=b4; ax5=b5; ax6=b6; ax7=b7;
                
                int rt = Integer.valueOf(ret);
                int disp = Integer.valueOf(ret);

                if(ax7>0){ ax7-=B7(rt); rt-=200*B7(rt);}
                if(ax6>0){ ax6-=B6(rt); rt-=100*B6(rt);}
                if(ax5>0){ ax5-=B5(rt); rt-=50*B5(rt);}
                if(ax4>0){ ax4-=B4(rt); rt-=20*B4(rt);}
                if(ax3>0){ ax3-=B3(rt); rt-=10*B3(rt);}
                if(ax2>0){ ax2-=B2(rt); rt-=5*B2(rt);}
                if(ax1>0){ ax1-=B1(rt); rt-=1*B1(rt);}
                
                if(rt!=0) JOptionPane.showMessageDialog(null, "NO HAY SALDO/BILLETES SUFICIENTES PARA EL RETIRO EN EL CAJERO: ");else{
                    int rts =Integer.valueOf(ret);
                    if(b7>0){ b7-=B7(rts); rt-=200*B7(rts);}
                    if(b6>0){ b6-=B6(rts); rt-=100*B6(rts);}
                    if(b5>0){ b5-=B5(rts); rt-=50*B5(rts);}
                    if(b4>0){ b4-=B4(rts); rt-=20*B4(rts);}
                    if(b3>0){ b3-=B3(rts); rt-=10*B3(rts);}
                    if(b2>0){ b2-=B2(rts); rt-=5*B2(rts);}
                    if(b1>0){ b1-=B1(rts); rt-=1*B1(rts);}
                    bsl-=rts;                    
                }
                //for(int i=1;i<=7;i++){
//                    rt=rt%b1;
//                    System.out.print(rt);
                //}
                
                
                //LIMPIAR TXT Y DEJAR UNICAMENTE EL SALDO ACTUAN CON EL NUMERO 
                //ACTUAL DE BILLETES
                limpiartxt(f);
                ListaBillete.clear();
                ListaBillete.add(new cajero(String.valueOf(b1), String.valueOf(b2), String.valueOf(b3), String.valueOf(b4), String.valueOf(b5), String.valueOf(b6), String.valueOf(b7), String.valueOf(btt), String.valueOf(bsl)));
                JOptionPane.showMessageDialog(null, "BILLETES DISPONIBLES\n"+
                        "Q1->"+b1+"\n"+"Q5->"+b2+"\n"+"Q10->"+b3+"\n"+"Q20->"+b4+"\n"+"Q50->"+b5+"\n"+"Q100->"+b6+"\n"+"Q200->"+b7+"\n"
                        + "EL SALDO ACTUAL DEL CAJERO ES DE: " + bsl);
            }
            //ListaBillete.add(GuardarBill());

            //agregarbilete( ListaBillete,billete);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No se Encontro el Archivo", "ERROR", 2);
        }

        ModificarDatosB(ListaBillete, billete);

    }
    
    public int B7(int retiro){
        int cantidad =0;
        if(retiro>=200){
            retiro-=200;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    
    public int B6(int retiro){
        int cantidad =0;
        if(retiro>=100){
            retiro-=100;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    
    public int B5(int retiro){
        int cantidad =0;
        if(retiro>=50){
            retiro-=50;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    public int B4(int retiro){
        int cantidad =0;
        if(retiro>=20){
            retiro-=20;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    public int B3(int retiro){
        int cantidad =0;
        if(retiro>=10){
            retiro-=10;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    public int B2(int retiro){
        int cantidad =0;
        if(retiro>=5){
            retiro-=5;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
    }
    public int B1(int retiro){
        int cantidad =0;
        if(retiro>=1){
            retiro-=1;
            cantidad++;
            B7(retiro);
        }
        return cantidad;
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
    // METODO PARA BORRAR LOS DATONS ANTERIORES EN EL TXT BILLETES
    //PARA DEJAR UNICAMENTE LOS DATOS ACTUALES

    public void limpiartxt(File f) {

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(f));
            bw.write("");
        } catch (IOException ex) {
            Logger.getLogger(iniciarcajero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //metodo para realizar depositos en la tarjeta
//    public void deposito() {
//        DepositoCliente dp = new DepositoCliente();
//        AgregarDatosTJ(tarjetas);
//        AgregarDatosTran(Transacciones);
////        String deposito;
//        saldoU = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();
//        //deposito = JOptionPane.showInputDialog(null, "¿Cuanto dinero desea ingresar?", "DEPOSITO", 0).trim();
//        int sal = Integer.valueOf(saldoU) + Integer.valueOf(dp.getDepo());
//        ModificarDatosTJ(ListaTarjetas, tarjetas, Integer.toString(sal));
//        ListaTransacciones.add(new Transacciones(Integer.toString(idTransaccion), idUser, "Deposito", dp.getDepo(), FeYHo.getText()));
//        idTransaccion++;
//        ModificarDatosTran(ListaTransacciones, Transacciones);
//    }

    //metodo para cambiar pin
    public void cambpin() {
        AgregarDatosU(usuario);
        String nuevopin;
        String pinant;
        //pinant=JOptionPane.showInputDialog(null,"Ingrese su pin anterior","PIN ANTERIOR",2).trim();
        nuevopin = JOptionPane.showInputDialog(null, "Ingrese su nuevo pin", "NUEVO PIN", 3).trim();
        System.out.println(ListaUser.get(Integer.valueOf(idUser)).getPassword().trim());
        //System.out.println(pinant);
//        if(pinant!=null&&nuevopin!=null){
//                if(pinant.contentEquals(ListaUser.get(Integer.valueOf(idUser)).getPassword())){
        ModificarDatosU(ListaUser, usuario, nuevopin);
        ListaTransacciones.add(new Transacciones(Integer.toString(idTransaccion), idUser, "CambioPin", ListaUser.get(Integer.valueOf(idUser)).getNumTarjeta(), FeYHo.getText()));
        idTransaccion++;
        ModificarDatosTran(ListaTransacciones, Transacciones);
// 
//                }else JOptionPane.showMessageDialog(null,"Sus datos no coinciden", "ERROR", 0);
//            }
    }

    //metodo para mostrar saldos disponibles
    public void saldos() {
        limiteDiario();
        String Sal = ListaTarjetas.get(Integer.valueOf(idUser)).getSaldo();
        String retiro = ListaTarjetas.get(Integer.valueOf(idUser)).getLRetiro();
        JOptionPane.showMessageDialog(null, "• Monto máximo de retiro     Q. " + retiro + "\n"
                + "• Monto máximo de retiro diario disponible  Q. " + RetiroDisp + "\n"
                + "• Saldo Actual   Q. " + Sal + "\n"
                + "• Total Retirado hoy  Q. " + limiteDiario());
    }

    public String limiteDiario() {
        int result = 0;
        for (int i = 0; i < ListaTransacciones.size(); i++) {
            if (ListaTransacciones.get(i).getTipo().contentEquals("Retiro")) {
                result += Integer.valueOf(ListaTransacciones.get(i).getMonto());
            }
        }

        int RetiroDispo = Integer.valueOf(ListaTarjetas.get(Integer.valueOf(idUser)).getLRetiro()) - result;
        RetiroDisp = Integer.toString(RetiroDispo);
        String tot = Integer.toString(result);
        return tot;
    }

    //metodo para mostrar ultimos 5 registros
    public void tabla() {
        RemoveDatos(jTable, model);
        int cnt = 0;
        for (int i = ListaTransacciones.size() - 1; i > -1; i--) {
            if (cnt < 5) {
                if (ListaTransacciones.get(i).getIdUser().contentEquals(idUser)) {
                    if (ListaTransacciones.get(i).getTipo().contentEquals("Retiro")
                            || ListaTransacciones.get(i).getTipo().contentEquals("Deposito")) {
                        String[] info = new String[5];
                        info[0] = ListaTransacciones.get(i).getIdRegistro();
                        info[1] = ListaTransacciones.get(i).getTipo();
                        info[2] = ListaTransacciones.get(i).getMonto();
                        info[3] = ListaTransacciones.get(i).getFecha();
                        model.addRow(info);
                        cnt++;
                    }
                }
            }

        }
//        for(Transacciones tb: ListaTransacciones){
//            if(tb.getIdUser().contentEquals(idUser)){
//                if(tb.getTipo().contentEquals("Retiro")||tb.getTipo().contentEquals("Deposito")){
//                    String []info = new String[5];
//                    info[0] = tb.getIdRegistro();
//                    info[1] = tb.getTipo();
//                    info[2] = tb.getMonto();
//                    info[3] = tb.getFecha();
//                    model.addRow(info);                    
//                }
//            }
//        }
    }

    public void RemoveDatos(JTable tb, DefaultTableModel db) {
        int fil = tb.getRowCount();
        if (fil >= 0) {
            for (int x = fil - 1; x >= 0; x--) {
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
    }

    //metodo para modificar saldos de la tarjeta
    public void ModificarDatosTJ(ArrayList<TarjetaU> t, File f, String saldo) {
        int pos = Integer.valueOf(t.get(Integer.valueOf(idUser)).getIdTarjeta());

//        int eg = Integer.valueOf(t.get(pos).getEgresos())+Integer.valueOf(egreso);
//        t.get(pos).setEgresos(Integer.toString(eg));
        t.get(pos).setSaldo(saldo);
        String dato = "";
        for (int i = 0; i < t.size(); i++) {
            dato += t.get(i).getIdTarjeta() + "\t"
                    + t.get(i).getNumTarjeta() + "\t"
                    + t.get(i).getMInicial() + "\t"
                    + t.get(i).getLRetiro() + "\t"
                    + t.get(i).getIngresos() + "\t"
                    + t.get(i).getEgresos() + "\t"
                    + t.get(i).getSaldo() + "\n";
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
            dato += t.get(i).getIdRegistro() + "\t"
                    + t.get(i).getIdUser() + "\t"
                    + t.get(i).getTipo() + "\t"
                    + t.get(i).getMonto() + "\t"
                    + t.get(i).getFecha() + "\n";
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbCambPin.setBackground(new java.awt.Color(0, 153, 153));
        jbCambPin.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbCambPin.setForeground(new java.awt.Color(255, 255, 255));
        jbCambPin.setText("Cambiar Pin");
        jbCambPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCambPinActionPerformed(evt);
            }
        });
        getContentPane().add(jbCambPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, 86));

        jbRetiro.setBackground(new java.awt.Color(0, 153, 153));
        jbRetiro.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbRetiro.setForeground(new java.awt.Color(255, 255, 255));
        jbRetiro.setText("Retiro");
        jbRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRetiroActionPerformed(evt);
            }
        });
        getContentPane().add(jbRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 86));

        jbSaldo.setBackground(new java.awt.Color(0, 153, 153));
        jbSaldo.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbSaldo.setForeground(new java.awt.Color(255, 255, 255));
        jbSaldo.setText("SALDO");
        jbSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaldoActionPerformed(evt);
            }
        });
        getContentPane().add(jbSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 150, 86));

        jbUltTrans.setBackground(new java.awt.Color(0, 153, 153));
        jbUltTrans.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbUltTrans.setForeground(new java.awt.Color(255, 255, 255));
        jbUltTrans.setText("ultimas 5 tranSACCIONES");
        jbUltTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUltTransActionPerformed(evt);
            }
        });
        getContentPane().add(jbUltTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 283, 86));

        jbDeposito.setBackground(new java.awt.Color(0, 153, 153));
        jbDeposito.setFont(new java.awt.Font("Castellar", 1, 14)); // NOI18N
        jbDeposito.setForeground(new java.awt.Color(255, 255, 255));
        jbDeposito.setText("Depósito");
        jbDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDepositoActionPerformed(evt);
            }
        });
        getContentPane().add(jbDeposito, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 150, 86));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar Sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRetiroActionPerformed
        // TODO add your handling code here:
        retiro();
    }//GEN-LAST:event_jbRetiroActionPerformed

    private void jbDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDepositoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        //jtlimite.setText(ListaTarjetas.get(Integer.valueOf(idUser)).getLRetiro());
        depcli.setVisible(true);
        deposito();
    }//GEN-LAST:event_jbDepositoActionPerformed

    private void jbCambPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCambPinActionPerformed
        // TODO add your handling code here:
        cambpin();
    }//GEN-LAST:event_jbCambPinActionPerformed

    private void jbSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaldoActionPerformed
        // TODO add your handling code here:
        //this.ListaTarjetas = AgregarDatosTJs(ListaTarjetas, tarjetas);
        saldos();
    }//GEN-LAST:event_jbSaldoActionPerformed

    ArrayList<Transacciones> ListaTran;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.ListaTran = AgregarDatosTrans(ListaTran, Transacciones);
        ListaTran.add(new Transacciones(autoId(Transacciones), idUser, "Login", "0", FeYHo.getText()));
        ModificarDatosTrans(ListaTran, Transacciones);
        this.setVisible(false);
        init.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbUltTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUltTransActionPerformed
        // TODO add your handling code here:
        tabla();
        tabtran.setVisible(true);
    }//GEN-LAST:event_jbUltTransActionPerformed
    public void setRootPaneCheckingEnabled(boolean enabled) {
        super.setRootPaneCheckingEnabled(enabled);
    }

    public void setUndecorated(boolean val) {
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
