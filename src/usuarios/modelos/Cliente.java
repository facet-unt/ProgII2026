/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author ramayo
 */
public class Cliente {
 private String correo;
    private String clave;
    private String nombre;
    private String apellido;
    
    
    public Cliente(){
    }
    
    
    public Cliente(String correo, String clave, String nombre, String apellido){
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    public void mostrar(){
        System.out.println("Cliente -> Nombre: " + nombre + "" + apellido + "Correo: " + correo);
    }
}
