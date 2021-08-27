/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author ASUS
 */
public class TarjetaUsuario {

    private int NumTarjeta = 0;
    private int idUsuario = 0;
    private String Nombre = "Admin1";
    private String Apellido = "Admin1";
    private int Saldo=0;
    private String Fecha_Deposito="0";
    private String Fecha_Retiro ="0";
    private int Limite=0;
    
    
    
    /**
     * @return the NumTarjeta
     */
    public int getNumTarjeta() {
        return NumTarjeta;
    }

    /**
     * @param NumTarjeta the NumTarjeta to set
     */
    public void setNumTarjeta(int NumTarjeta) {
        this.NumTarjeta = NumTarjeta;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Apellido
     */
    public String getApellido() {
        return Apellido;
    }

    /**
     * @param Apellido the Apellido to set
     */
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    /**
     * @return the Saldo
     */
    public int getSaldo() {
        return Saldo;
    }

    /**
     * @param Saldo the Saldo to set
     */
    public void setSaldo(int Saldo) {
        this.Saldo = Saldo;
    }

    /**
     * @return the Fecha_Deposito
     */
    public String getFecha_Deposito() {
        return Fecha_Deposito;
    }

    /**
     * @param Fecha_Deposito the Fecha_Deposito to set
     */
    public void setFecha_Deposito(String Fecha_Deposito) {
        this.Fecha_Deposito = Fecha_Deposito;
    }

    /**
     * @return the Fecha_Retiro
     */
    public String getFecha_Retiro() {
        return Fecha_Retiro;
    }

    /**
     * @param Fecha_Retiro the Fecha_Retiro to set
     */
    public void setFecha_Retiro(String Fecha_Retiro) {
        this.Fecha_Retiro = Fecha_Retiro;
    }

    /**
     * @return the Limite
     */
    public int getLimite() {
        return Limite;
    }

    /**
     * @param Limite the Limite to set
     */
    public void setLimite(int Limite) {
        this.Limite = Limite;
    }

    
}
