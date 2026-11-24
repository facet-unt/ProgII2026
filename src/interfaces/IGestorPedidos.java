/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Usuario
 */
public interface IGestorPedidos {

    String EXITO = "Pedido creado/modificado/cancelado con exito";
    String ERROR_FECHA = "La fecha del pedido es incorrecta";
    String ERROR_HORA = "La hora del pedido es incorrecta";
    String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    String ERROR_CLIENTE = "El pedido no tiene un cliente";
    String ERROR_ESTADO = "El pedido no tiene un estado";
    String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    String VALIDACION_EXITO = "El pedido tiene datos correctos";
    
    String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente);
    String cambiarEstado(Pedido pedidoAModificar);
    List<Pedido> verPedidos();
    boolean hayPedidosConEsteCliente(Cliente cliente);
    boolean hayPedidosConEsteProducto(Producto producto);
    String cancelarPedido(Pedido pedido);
    boolean existeEstePedido(Pedido pedido);
    Pedido obtenerPedido(Integer numero);
}
