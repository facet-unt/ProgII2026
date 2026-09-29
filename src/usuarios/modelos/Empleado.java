/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author ramayo
 */
public class Empleado {
    private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    
    public void mostrar(){
      System.out.println("Empleado -> Nombre: " + nombre + " " + apellido + "\nClave: " + clave + "\nCorreo: " + correo + "\n");
    }
    
    public void asignarCorreo(String correo){
        this.correo=correo;
    }
    public void asignarClave(String clave){
        this.clave=clave;
    }
    public void asignarNombre(String nombre){
        this.nombre=nombre;
    }
    public void asignarApellido(String apellido){
        this.apellido=apellido;
    }
    
    public String verCorreo(){
        return correo;
    }
    public String verClave(){
        return clave;
    }
    public String verNombre(){
        return nombre;
    }
    public String verApellido(){
        return apellido;
    }
    
    public Empleado(String correo, String clave, String nombre, String apellido){
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
