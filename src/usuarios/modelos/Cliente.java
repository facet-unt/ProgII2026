///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
// this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
// template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 * @author barti
 */
public class Cliente extends Usuario {
  // Constructor
  public Cliente(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
    this.pedidos = new ArrayList<>();
  }

  public ArrayList<Pedido> verPedidos() {
    return this.pedidos;
  }

  public void asignarListaPedidos(ArrayList<Pedido> nuevosPedidos) {
    this.pedidos = nuevosPedidos;
  }

  /**
   * Al agregar un pedido, revisar si dicho pedido no es nulo
   * o si el mismo se encuentra dentro de la lista de pedidos.
   * En caso que el pedido a agregar ya este en la lista,
   * reemplazar el pedido que esta en la lista con el nuevo pedido.
   */
  public void agregarPedido(Pedido unPedido) {
    if (unPedido == null) {
      return;
    }

    for (int i = 0; i < this.pedidos.size(); ++i) {
      if (this.pedidos.get(i).equals(unPedido)) {
        this.pedidos.set(i, unPedido);
        return;
      }
    }

    this.pedidos.add(unPedido);
  }

  public void cancelarPedido(Pedido unPedido) {
    this.pedidos.remove(unPedido);
  }

  protected String verTipoUsuario() {
    return "Cliente";
  }

  private ArrayList<Pedido> pedidos;
}
