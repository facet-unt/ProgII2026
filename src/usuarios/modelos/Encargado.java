/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author MARYPAZ
 */
public class Encargado {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;
    
     public void mostrar(){
        System.out.println("|Encargado|");
        System.out.println("Correo: "+correo+" Clave: "+clave);
        System.out.println("Apellido: "+apellido+" Nombre: "+nombre);
    }
}
