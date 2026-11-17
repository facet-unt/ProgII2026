///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
// this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
// template
// */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 * @author barti
 */
public class Encargado extends Usuario {
  // Constructor
  public Encargado(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
  }

  public List<Pedido> verPedidos() {
    return GestorPedidos.instanciar().verPedidos();
  }

  protected String verTipoUsuario() {
    return "Encargado";
  }
}
