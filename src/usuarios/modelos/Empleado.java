/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author foxeen
 */
public class Empleado {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;

    public Empleado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.printf("\n\tEmpleado <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido, nombre, correo, clave);
    }
    
    public void asignarNombre(String nombre){
        this.nombre = nombre;
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
