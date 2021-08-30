/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Reyes
 */
public class TarjetaU {

    private String IdTarjeta;
    private String NumTarjeta;
    private String MInicial;
    private String LRetiro;
    private String Ingresos;
    private String Egresos;
    private String Saldo;

    public TarjetaU(String idT,String NumTarjeta, String MInicial, String LRetiro, String Ingresos, String Egresos, String Saldo) {
        this.IdTarjeta = idT;
        this.NumTarjeta = NumTarjeta;
        this.MInicial = MInicial;
        this.LRetiro = LRetiro;
        this.Ingresos = Ingresos;
        this.Egresos = Egresos;
        this.Saldo = Saldo;
    }
    
    
    
    /**
     * @return the IdTarjeta
     */
    public String getIdTarjeta() {
        return IdTarjeta;
    }

    /**
     * @param IdTarjeta the IdTarjeta to set
     */
    public void setIdTarjeta(String IdTarjeta) {
        this.IdTarjeta = IdTarjeta;
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
     * @return the MInicial
     */
    public String getMInicial() {
        return MInicial;
    }

    /**
     * @param MInicial the MInicial to set
     */
    public void setMInicial(String MInicial) {
        this.MInicial = MInicial;
    }

    /**
     * @return the LRetiro
     */
    public String getLRetiro() {
        return LRetiro;
    }

    /**
     * @param LRetiro the LRetiro to set
     */
    public void setLRetiro(String LRetiro) {
        this.LRetiro = LRetiro;
    }

    /**
     * @return the Ingresos
     */
    public String getIngresos() {
        return Ingresos;
    }

    /**
     * @param Ingresos the Ingresos to set
     */
    public void setIngresos(String Ingresos) {
        this.Ingresos = Ingresos;
    }

    /**
     * @return the Egresos
     */
    public String getEgresos() {
        return Egresos;
    }

    /**
     * @param Egresos the Egresos to set
     */
    public void setEgresos(String Egresos) {
        this.Egresos = Egresos;
    }

    /**
     * @return the Saldo
     */
    public String getSaldo() {
        return Saldo;
    }

    /**
     * @param Saldo the Saldo to set
     */
    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }

    

}
