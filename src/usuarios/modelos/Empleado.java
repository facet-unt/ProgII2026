/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado {
    String correo;
    String clave;
    String apellido;
    String nombre;
    public void mostrar(){
        System.out.println("Empleado:"+apellido + ", "+nombre);
        System.out.println("Correo:"+correo + " | clave:  "+clave);
    }
}
