package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public interface IGestorPedidos {
  String crearPedido(
      LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente);

  String cambiarEstado(Pedido pedidoAModificar);

  List<Pedido> verPedidos();

  boolean hayPedidosConEsteCliente(Cliente cliente);

  boolean hayPedidosConEsteProducto(Producto producto);

  String cancelarPedido(Pedido pedido);

  boolean existeEstePedido(Pedido pedido);

  Pedido obtenerPedido(Integer numero);

  static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
  static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
  static final String ERROR_HORA = "La hora del pedido es incorrecta";
  static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
  static final String ERROR_CLIENTE = "El cliente ingresado es invalido";
  static final String ERROR_ESTADO = "El pedido no tiene un estado valido";
  static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
  static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
  static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
  static final String PEDIDO_EXISTE = "Si existe el pedido solicitado";
}
