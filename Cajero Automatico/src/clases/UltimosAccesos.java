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
public class UltimosAccesos {
    private String idUser;
    private String Nombre;
    private String Apellido;
    private String CambioPin;
    private String fecha;

    public UltimosAccesos(String idUser, String Nombre, String Apellido, String CambioPin, String fecha) {
        this.idUser = idUser;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.CambioPin = CambioPin;
        this.fecha = fecha;
    }


    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCambioPin() {
        return CambioPin;
    }

    public void setCambioPin(String CambioPin) {
        this.CambioPin = CambioPin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
