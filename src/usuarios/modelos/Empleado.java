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

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    /**
     * metodo heredado de Usuario Muestra la lista de pedidos realizados En
     * Empleado devuelve una lista vacia
     *
     * @return pedidos un ArrayList vacio
     */
    @Override
    public List<Pedido> verPedidos() {
        return GestorPedidos.instanciar().verPedidos();
    }
}
