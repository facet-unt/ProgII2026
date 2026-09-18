/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Usuario
 */
public class Encargado {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public void mostrar(){
        System.out.println("**********ENCARGADO**********");
        System.out.println("|Apellido: "+apellido+"Nombre: "+nombre+"|");
        System.out.println("|Correo: "+correo+" | Clave: "+clave+"|");
    }
}
