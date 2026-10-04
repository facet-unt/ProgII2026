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
public class Cliente {
  // Constructor
  public Cliente(String correo, String clave, String apellido, String nombre) {
    this.correo = correo;
    this.clave = clave;
    this.nombre = nombre;
    this.apellido = apellido;
    this.pedidos = new ArrayList<>();
  }

  // Getters
  public String verCorreo() {
    return this.correo;
  }
  public String verClave() {
    return this.clave;
  }
  public String verApellido() {
    return this.apellido;
  }
  public String verNombre() {
    return this.nombre;
  }

  public ArrayList<Pedido> verListaPedidos() {
    return this.pedidos;
  }

  // Setters
  public void asignarCorreo(String nuevoCorreo) {
    this.correo = nuevoCorreo;
  }
  public void asignarClave(String nuevaClave) {
    this.clave = nuevaClave;
  }
  public void asignarApellido(String nuevoApellido) {
    this.apellido = nuevoApellido;
  }
  public void asignarNombre(String nuevoNombre) {
    this.nombre = nuevoNombre;
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

  public void mostrar() {
    System.out.printf("\nCliente %s, %s: \nCorreo: %s\nClave: %s\nTotal Pedidos: %d\n", apellido,
        nombre, correo, clave, pedidos.size());
  }

  private String correo;
  private String clave;
  private String apellido;
  private String nombre;
  private ArrayList<Pedido> pedidos;
}
