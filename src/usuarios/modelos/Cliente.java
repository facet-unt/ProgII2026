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

    //Relacion: un cliente tiene muchos pedidos
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public void mostrar(){
        System.out.println("Cliente <" + super.verApellido() + " " + super.verNombre() + ">");
        super.mostrar();
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        if (pedidos.isEmpty()) {
        }
        return pedidos;
    }

    public void agregarPedido(Pedido unPedido) {
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

    public void cancelarPedido(Pedido unPedido) {
        if (pedidos.contains(unPedido)) {
            pedidos.remove(unPedido);
        }
    }
}
