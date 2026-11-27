/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
/**
 *
 * @author lourdes
 */
public interface IGestorPedidos {
    String EXITO = "Pedido creado/modificado con éxito";
String ERROR_FECHA = "La fecha del pedido es incorrecta";
String ERROR_HORA = "La hora del pedido es incorrecta";
String ERROR_PRODUCTOS_DEL_PEDIDO = "Los productos del pedido son incorrectos";
String ERROR_CLIENTE = "El cliente del pedido es incorrecto";
String ERROR_ESTADO = "El estado del pedido es incorrecto";
String ERROR_CANCELAR = "No se puede cancelar el pedido";
String PEDIDOS_DUPLICADOS = "Ya existe el pedido";
String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
String VALIDACION_EXITO = "Los datos del pedido son correctos";

    public String crearPedido(LocalDate fecha, LocalTime hora,
        List<ProductoDelPedido> productosDelPedido, Cliente cliente);

    public String cambiarEstado(Pedido pedidoAModificar);

    public List<Pedido> verPedidos();

    public boolean hayPedidosConEsteCliente(Cliente cliente);

    public boolean hayPedidosConEsteProducto(Producto producto);

    public String cancelarPedido(Pedido pedido);

    public boolean existeEstePedido(Pedido pedido);

    public Pedido obtenerPedido(Integer numero);
}

