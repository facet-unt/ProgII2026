/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.Objects;

/**
 *
 * @author Arebalo
 */
public abstract class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

        public Usuario(String correo, String clave, String apellido, String nombre) {
            this.correo = correo;
            this.clave = clave;
            this.apellido = apellido;
            this.nombre = nombre;
        }

    
    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    

    public String verCorreo() {
        return correo;
    }

    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }
    public void mostrar(){
        System.out.println("Cliente " + apellido + " " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("Clave: " + clave);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        
        if (!(obj instanceof Usuario)) return false;
        
        Usuario otro = (Usuario) obj;
        return Objects.equals(this.correo, otro.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo);
    }
   
}
