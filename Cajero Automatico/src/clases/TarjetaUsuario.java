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
    
    
    
    private String NumTarjeta = "";
    private String idUsuario = "";
    private String Nombre = "";
    private String Apellido = "";
    private int Saldo = 0;
    private String Fecha_Deposito = "";
    private String Fecha_Retiro = "";
    private int Limite = 0;
    
    
    public TarjetaUsuario(String ntj, String iduses, String nomb, String apell, int sald, String fd, String fr, int lim) {
        this.NumTarjeta = ntj;
        this.idUsuario=iduses;
        this.Nombre = nomb;
        this.Apellido = apell;
        this.Saldo = sald;
        this.Fecha_Deposito = fd;
        this.Fecha_Retiro = fr;
        this.Limite = lim;
        
 
    }

    /**
     * @return the NumTarjeta
     */
    public String getNumTarjeta() {
        return NumTarjeta;
    }

    /**
     * @param NumTarjeta the NumTarjeta to set
     */
    public void setNumTarjeta(String NumTarjeta) {
        this.NumTarjeta = NumTarjeta;
    }

    /**
     * @return the idUsuario
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(String idUsuario) {
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
