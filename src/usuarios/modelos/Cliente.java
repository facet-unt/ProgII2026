///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario {
    
    //Relacion:Un cliente tiene muchos pedidos:
    private ArrayList<Pedido> listaPedidos;

    public Cliente(String correo, String clave, String apellido, String nombre, ArrayList<Pedido> pedido) {
        super(correo, clave, apellido, nombre);
        this.listaPedidos = new ArrayList<>();
    }  
    
    @Override
    public ArrayList<Pedido> verPedidos() {
        return this.listaPedidos;
    }

    public void asignarPedidos(ArrayList<Pedido> pedidos) {
        this.listaPedidos = pedidos;
    }

    // Si ya existe lo reemplaza, si no está lo agrega
    public void agregarPedido(Pedido pedido) {
        if (this.listaPedidos.contains(pedido)) {
            int indice = this.listaPedidos.indexOf(pedido);
            this.listaPedidos.set(indice, pedido);
        } else {
            this.listaPedidos.add(pedido);
        }
    }

    // Cancela (elimina) el pedido de la lista
    public void cancelarPedido(Pedido pedido) {
        this.listaPedidos.remove(pedido);
    }

    
}
