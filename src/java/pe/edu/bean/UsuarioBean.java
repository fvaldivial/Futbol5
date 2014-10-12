

package pe.edu.bean;

import java.io.Serializable;


public class UsuarioBean implements Serializable{
    
    private String dni;
    private String email;
    private String nombre;
    private String telefono;
    private String usuario;
    private String direccion;
    private String[] partidos;

    public UsuarioBean(){}
    
    public UsuarioBean(String dni, String email, String nombre, String telefono, String usuario, String direccion, String[] partidos) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.partidos = partidos;
        this.usuario = usuario;
        this.direccion = direccion;
        
    }
    
    public UsuarioBean(String dni, String email, String nombre, String telefono) {
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String[] getPartidos() {
        return partidos;
    }

    public void setPartidos(String[] partidos) {
        this.partidos = partidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
}
