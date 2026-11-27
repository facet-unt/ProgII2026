///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;


import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {

    


    //====================================
    //      Metodos de Empleado
    //====================================
   @Override
public List<Pedido> verPedidos() {
    return GestorPedidos.instanciar().verPedidos();
}
       
    //====================================
    //      Constructor de Empleado
    //====================================
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    


}