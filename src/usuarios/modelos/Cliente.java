 ///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 * 
 *Hereda de la clase Usuario
 * @author estudiante
 */
public class Cliente extends Usuario {

    //Relacion: un cliente tiene muchos pedidos
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    /**
     * Metodo heredado de Usuario 
     * Muestra la lista de pedidos realizados por el Cliente,incluso si la lista esta vacia
     * @return pedidos un Arraylist con los pedidos del Cliente
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }
    
    /**
     * Agrega un pedido a la lista del cliente,verifica que la lista no sea nula,
     * evita que se ingresen objetos duplicados y/o los actualiza
     * @param unPedido El pedido a agregar o actualizar
     */
    public void agregarPedido(Pedido unPedido) {
        // y si isEmpty es false
        if(unPedido != null){
            
            if (!pedidos.contains(unPedido)) {
                pedidos.add(unPedido);
            } else {
                for (int i = 0; i < pedidos.size(); i++) {
                    if (pedidos.get(i).equals(unPedido)) {
                        pedidos.set(i, unPedido);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Cancelar un pedido de la lista,verifica que se este para removerlo
     * @param unPedido El pedido a remover de la lista
     */
    public void cancelarPedido(Pedido unPedido) {
        if (pedidos.contains(unPedido)) {
            pedidos.remove(unPedido);
        }
    }
}
