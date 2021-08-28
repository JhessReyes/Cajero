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
public class usuarios {

    private String idUsuario = "";
    private String Nombre = "";
    private String Apellido = "";
    private String Password = "";
    private String NumTarjeta = "";
    private String TipoUsuario = "";

    public usuarios(String id, String nombre, String apellido, String password, String tarjeta, String Tusuario) {
    
        this.idUsuario=id;
        this.Nombre=nombre;
        this.Apellido=apellido;
        this.Password=password;
        this.NumTarjeta = tarjeta;
        this.TipoUsuario = Tusuario;
    
    
   
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
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
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
     * @return the TipoUsuario
     */
    public String getTipoUsuario() {
        return TipoUsuario;
    }

    /**
     * @param TipoUsuario the TipoUsuario to set
     */
    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

}
