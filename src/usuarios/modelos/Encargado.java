/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


public class Encargado {
    //Atributos
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    //Constructor
    public Encargado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.println("Correo: " + correo + "| Clave: " + clave + "| Apellido: " + apellido + "| Nombre: " + nombre);
    }   
}
