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
public class cajero {

    private String b1 = "";
    private String b5 = "";
    private String b10 = "";
    private String b20 = "";
    private String b50 = "";
    private String b100 = "";
    private String b200 = "";
    private String total = "";
    private String limite = "";

    public cajero(String q1, String q5, String q10, String q20, String q50, String q100, String q200, String tt, String lim) {
        this.b1 = q1;
        this.b5 = q5;
        this.b10 = q10;
        this.b20 = q20;
        this.b50 = q50;
        this.b100 = q100;
        this.b200 = q200;
        this.total = tt;
        this.limite = lim;
    }
    
   
    /**
     * @return the b1
     */
    public String getB1() {
        return b1;
    }

    /**
     * @param b1 the b1 to set
     */
    public void setB1(String b1) {
        this.b1 = b1;
    }

    /**
     * @return the b5
     */
    public String getB5() {
        return b5;
    }

    /**
     * @param b5 the b5 to set
     */
    public void setB5(String b5) {
        this.b5 = b5;
    }

    /**
     * @return the b10
     */
    public String getB10() {
        return b10;
    }

    /**
     * @param b10 the b10 to set
     */
    public void setB10(String b10) {
        this.b10 = b10;
    }

    /**
     * @return the b20
     */
    public String getB20() {
        return b20;
    }

    /**
     * @param b20 the b20 to set
     */
    public void setB20(String b20) {
        this.b20 = b20;
    }

    /**
     * @return the b50
     */
    public String getB50() {
        return b50;
    }

    /**
     * @param b50 the b50 to set
     */
    public void setB50(String b50) {
        this.b50 = b50;
    }

    /**
     * @return the b100
     */
    public String getB100() {
        return b100;
    }

    /**
     * @param b100 the b100 to set
     */
    public void setB100(String b100) {
        this.b100 = b100;
    }

    /**
     * @return the b200
     */
    public String getB200() {
        return b200;
    }

    /**
     * @param b200 the b200 to set
     */
    public void setB200(String b200) {
        this.b200 = b200;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the saldo
     */
    public String getSaldo() {
        return limite;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(String saldo) {
        this.limite = saldo;
    }

    

}
