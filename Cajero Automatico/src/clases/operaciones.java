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
public class operaciones {
    
    private int Deposito =0;
    private int Retiro =0;
    private int Saldo =0;
    private String CambPIN ="";
    private String CambTarjeta ="";
    
      public operaciones(int dp, int rt, int sld, String cpin, String ctj) {
    
        this.Deposito=dp;
        this.Retiro = rt;
        this.Saldo = sld;
        this.CambPIN = cpin;
        this.CambTarjeta = ctj;
 
    }
    
    
    

    /**
     * @return the Deposito
     */
    public int getDeposito() {
        return Deposito;
    }

    /**
     * @param Deposito the Deposito to set
     */
    public void setDeposito(int Deposito) {
        this.Deposito = Deposito;
    }

    /**
     * @return the Retiro
     */
    public int getRetiro() {
        return Retiro;
    }

    /**
     * @param Retiro the Retiro to set
     */
    public void setRetiro(int Retiro) {
        this.Retiro = Retiro;
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
     * @return the CambPIN
     */
    public String getCambPIN() {
        return CambPIN;
    }

    /**
     * @param CambPIN the CambPIN to set
     */
    public void setCambPIN(String CambPIN) {
        this.CambPIN = CambPIN;
    }

    /**
     * @return the CambTarjeta
     */
    public String getCambTarjeta() {
        return CambTarjeta;
    }

    /**
     * @param CambTarjeta the CambTarjeta to set
     */
    public void setCambTarjeta(String CambTarjeta) {
        this.CambTarjeta = CambTarjeta;
    }
    
    
    
   
}
