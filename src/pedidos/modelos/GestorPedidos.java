package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class GestorPedidos implements IGestorPedidos {
  private GestorPedidos() {
    pedidos = new ArrayList<>();
  }

  public static GestorPedidos instanciar() {
    if (gestor == null) {
      gestor = new GestorPedidos();
    }
    return gestor;
  }

  public String crearPedido(LocalDate fecha, LocalTime hora,
      ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
    String validacion = validarPedido(fecha, hora, cliente, productosDelPedido);
    if (!validacion.equals(VALIDACION_EXITO)) {
      return validacion;
    }

    // Pasar el localDate y el LocalTime a LocalDateTime, pues es lo que usa el constructor
    LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
    Pedido nuevoPedido = new Pedido(numerosDePedidos++, fechaYHora, productosDelPedido, cliente);
    cliente.agregarPedido(nuevoPedido);
    pedidos.add(nuevoPedido);

    return EXITO;
  }

  public String cambiarEstado(Pedido pedidoAModificar) {
    if (pedidoAModificar == null) {
      return PEDIDO_INEXISTENTE;
    }

    int indice = this.pedidos.indexOf(pedidoAModificar);
    if (indice == -1) {
      return PEDIDO_INEXISTENTE;
    }

    Pedido pedido = this.pedidos.get(indice);

    if (pedido.verEstado().equals(Estado.CREADO)) {
      pedido.asignarEstado(Estado.PROCESANDO);
      return EXITO;
    } else if (pedido.verEstado().equals(Estado.PROCESANDO)) {
      pedido.asignarEstado(Estado.ENTREGADO);
      return EXITO;
    }

    return ERROR_ESTADO;
  }

  public ArrayList<Pedido> verPedidos() {
    return this.pedidos;
  }

  public boolean hayPedidosConEsteCliente(Cliente cliente) {
    if (cliente == null) {
      return false;
    }

    for (Pedido p : this.pedidos) {
      if (p.verCliente().equals(cliente)) {
        return true;
      }
    }

    return false;
  }

  public boolean hayPedidosConEsteProducto(Producto producto) {
    if (producto == null) {
      return false;
    }

    for (Pedido p : this.pedidos) {
      for (ProductoDelPedido pdp : p.verProductos()) {
        if (pdp.verProducto().equals(producto)) {
          return true;
        }
      }
    }

    return false;
  }

  public Pedido obtenerPedido(Integer numero) {
    if (numero == null) {
      return null;
    }

    Pedido resultado = null;

    for (Pedido p : this.pedidos) {
      if (Objects.equals(numero, p.verNumero())) {
        resultado = p;
        break;
      }
    }

    return resultado;
  }

  public String cancelarPedido(Pedido pedido) {
    if (pedido == null) {
      return PEDIDO_INEXISTENTE;
    }
    int indice = this.pedidos.indexOf(pedido);
    if (indice == -1) {
      return PEDIDO_INEXISTENTE;
    }

    Pedido p = this.pedidos.get(indice);
    if (p.verEstado() != Estado.CREADO) {
      return ERROR_CANCELAR;
    }

    this.pedidos.remove(indice);
    if (p.verCliente() != null) {
      p.verCliente().cancelarPedido(p);
    }

    return EXITO;
  }

  public boolean existeEstePedido(Pedido pedido) {
    if (pedido == null) {
      return false;
    }

    if (!this.pedidos.contains(pedido)) {
      return false;
    }

    return true;
  }

  private String validarPedido(LocalDate fecha, LocalTime hora, Cliente cliente,
      ArrayList<ProductoDelPedido> productosDelPedido) {
    if (fecha == null) {
      return ERROR_FECHA;
    }
    if (hora == null) {
      return ERROR_HORA;
    }
    if (cliente == null) {
      return ERROR_CLIENTE;
    }
    if (productosDelPedido == null || productosDelPedido.isEmpty()) {
      return ERROR_PRODUCTOS_DEL_PEDIDO;
    }

    return VALIDACION_EXITO;
  }

  private static GestorPedidos gestor;
  private static int numerosDePedidos = 1;
  private ArrayList<Pedido> pedidos;
}
