
package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author foxeen
 */
public interface IGestorPedidos {
    public static final String EXITO = "Pedido creado/moidificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CAMCELAR = "No se puede cancelar un pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente);
    public String cambiarEstado(Pedido pedidoAModificar);
    public ArrayList<Pedido> verPedidos();
    public boolean hayPedidosConEsteCliente(Cliente cliente);
    public boolean hayPedidosConEsteProducto(Producto producto);
    public String cancelarPedido(Pedido pedido);
    public boolean existeEstePedido(Pedido pedido);
    public Pedido obtenerPedido(Integer numero);
}
