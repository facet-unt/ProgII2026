/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author Peralta
 */
public class Cliente extends Usuario {
    private ArrayList<Pedido> pedidos;

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        if (pedido == null) return;
        if (this.pedidos.contains(pedido)) {
            int indice = this.pedidos.indexOf(pedido);
            this.pedidos.set(indice, pedido);
        } else {
            this.pedidos.add(pedido);
        }
        pedido.asignarCliente(this);
    }

    public void cancelarPedido(Pedido pedido) {
        if (pedido != null) {
            this.pedidos.remove(pedido);
        }
    }

    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    public void asignarPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("Pedidos:" + pedidos);
    }
}