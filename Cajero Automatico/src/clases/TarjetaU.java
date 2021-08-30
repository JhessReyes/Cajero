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
    private int IdTarjeta;
    private String NumTarjeta;
    private String MInicial;
    private String LRetiro;
    private Ingreso Ingresos;
    private Retiro Egresos;
    private String Saldo;

    public TarjetaU(String NumTarjeta, String MInicial, String LRetiro, Ingreso Ingresos, Retiro Egresos, String Saldo) {
        this.NumTarjeta = NumTarjeta;
        this.MInicial = MInicial;
        this.LRetiro = LRetiro;
        this.Ingresos = Ingresos;
        this.Egresos = Egresos;
        this.Saldo = Saldo;
    }

    public String getNumTarjeta() {
        return NumTarjeta;
    }

    public void setNumTarjeta(String NumTarjeta) {
        this.NumTarjeta = NumTarjeta;
    }

    public String getMInicial() {
        return MInicial;
    }

    public void setMInicial(String MInicial) {
        this.MInicial = MInicial;
    }

    public String getLRetiro() {
        return LRetiro;
    }

    public void setLRetiro(String LRetiro) {
        this.LRetiro = LRetiro;
    }

    public Ingreso getIngresos() {
        return Ingresos;
    }

    public void setIngresos(Ingreso Ingresos) {
        this.Ingresos = Ingresos;
    }

    public Retiro getEgresos() {
        return Egresos;
    }

    public void setEgresos(Retiro Egresos) {
        this.Egresos = Egresos;
    }

    public String getSaldo() {
        return Saldo;
    }

    public void setSaldo(String Saldo) {
        this.Saldo = Saldo;
    }
    
}
