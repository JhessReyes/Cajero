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
public class Transacciones {
    private String IdRegistro;
    private String IdUser;
    private String Tipo;
    private String Monto;
    private String fecha;

    public Transacciones(String IdRegistro, String IdUser, String Tipo, String Monto, String fecha) {
        this.IdRegistro = IdRegistro;
        this.IdUser = IdUser;
        this.Tipo = Tipo;
        this.Monto = Monto;
        this.fecha = fecha;
    }


    public String getIdRegistro() {
        return IdRegistro;
    }

    public void setIdRegistro(String IdRegistro) {
        this.IdRegistro = IdRegistro;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }   
    
}
