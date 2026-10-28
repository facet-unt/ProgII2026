 ///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * Hereda de la clase Usuario
 * @author estudiante
 */
public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    /**
     * metodo heredado de Usuario 
     * Muestra la lista de pedidos realizados
     * En Encargado devuelve una lista vacia
     * @return pedidos un ArrayList vacio
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        return new ArrayList<Pedido>();
    }
}
