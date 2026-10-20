/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

public class Cliente extends Usuario {

    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    @Override
    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }

    // Si el pedido no está en la lista lo agrega; si ya está, lo reemplaza.
    public void agregarPedido(Pedido pedido) {
        if (pedido != null) {
            int index = this.pedidos.indexOf(pedido);
            if (index != -1) {
                this.pedidos.set(index, pedido);
            } else {
                this.pedidos.add(pedido); 
            }
        }
    }
    public void cancelarPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    @Override
    public void mostrar() {
        System.out.println("DATOS DEL CLIENTE");
        super.mostrar();
    }
}
    

