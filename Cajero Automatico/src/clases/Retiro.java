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
public class Retiro {
    private String IdUser;
    private String Monto;
    private String fecha;
    private String hora;
    private String Motivo;

    public Retiro(String IdUser, String Monto, String fecha, String hora, String Motivo) {
        this.IdUser = IdUser;
        this.Monto = Monto;
        this.fecha = fecha;
        this.hora = hora;
        this.Motivo = Motivo;
    }
    

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getIdUser() {
        return IdUser;
    }

    public void setIdUser(String IdUser) {
        this.IdUser = IdUser;
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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
