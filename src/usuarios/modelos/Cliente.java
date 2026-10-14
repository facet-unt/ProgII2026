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

  public ArrayList<Pedido> verListaPedidos() {
    return this.pedidos;
  }

  public void asignarListaPedidos(ArrayList<Pedido> nuevosPedidos) {
    this.pedidos = nuevosPedidos;
  }

  public void agregarPedido(Pedido unPedido) {
    if (unPedido != null) {
      this.pedidos.add(unPedido);
    }
  }

  public void quitarPedido(Pedido unPedido) {
    this.pedidos.remove(unPedido);
  }

  protected String verTipoUsuario() {
    return "Cliente";
  }

  private ArrayList<Pedido> pedidos;
}
