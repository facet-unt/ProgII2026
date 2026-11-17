package usuarios.modelos;

import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 * @author barti
 */
public class Empleado extends Usuario {
  // Constructor
  public Empleado(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
  }

  public List<Pedido> verPedidos() {
    return GestorPedidos.instanciar().verPedidos();
  }

  protected String verTipoUsuario() {
    return "Empleado";
  }
}
