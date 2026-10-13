/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public abstract class Usuario {
     private String correo;
     private String clave;
     private String apellido;
     private String nombre;
     
     public void mostrar(){
        System.out.println("Cliente <" + this.apellido + " " + this.nombre + ">");
        System.out.println("Correo : " + this.correo);
        System.out.println("Clave : " + this.clave);
     }
     
     public Usuario(String correo, String clave, String apellido, String nombre){
         this.apellido = apellido;
         this.clave = clave;
         this.nombre = nombre;
         this.correo = correo;
     }
     
     
}
