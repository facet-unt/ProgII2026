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
    public String correo;
    public  String clave;
    public String apellido;
    public String nombre;
    
    public void mostrar(){
        System.out.printf("\n\tCliente <%s %s>: \n||Correo: %s\n||Clave: %s\n\n", apellido, nombre, correo, clave);
    }
}
