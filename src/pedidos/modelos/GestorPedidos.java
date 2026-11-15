package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class GestorPedidos {
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

    for (Pedido p : this.pedidos) {
      if (p.equals(pedido) && Objects.equals(p.verEstado(), Estado.CREADO)) {
        p.verCliente().cancelarPedido(p);
        pedidos.remove(p);
        return EXITO;
      } else {
        return ERROR_CANCELAR;
      }
    }

    return PEDIDO_INEXISTENTE;
  }

  public String existeEstePedido(Pedido pedido) {
    if (pedido == null) {
      return PEDIDO_INEXISTENTE;
    }

    if (this.pedidos.contains(pedido)) {
      return PEDIDO_EXISTE;
    }

    return PEDIDO_INEXISTENTE;
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

  private static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
  private static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
  private static final String ERROR_HORA = "La hora del pedido es incorrecta";
  private static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
  private static final String ERROR_CLIENTE = "El cliente ingresado es invalido";
  private static final String ERROR_ESTADO = "El pedido no tiene un estado valido";
  private static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
  private static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
  private static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
  private static final String PEDIDO_EXISTE = "Si existe el pedido solicitado";
  private static GestorPedidos gestor;
  private static int numerosDePedidos = 1;
  private ArrayList<Pedido> pedidos;
}
