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
    
    public void mostrar(){
        System.out.printf("\n\tEmpleado <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido, nombre, correo, clave);
    }
    
}
