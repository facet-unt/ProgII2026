/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.printf("\n\tCliente <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido, nombre, correo, clave);
    }
    public void asignarNombre(String nombre){
        this.nombre = nombre;
    }
    public void asignarApellido(String apellido){
        this.apellido = apellido;
    }
    public String mostrarNombre(){
        return this.nombre;
    }
    public String mostrarApellido(){
        return this.apellido;
    }
    public void asignarClave(String clave){
        this.clave = clave;
    }
    public String mostrarClave(){
        return this.clave;
    }
    public void asignarCorreo(String correo){
        this.correo = correo;
    }
    public String mostrarCorreo(){
        return this.correo;
    }
}
