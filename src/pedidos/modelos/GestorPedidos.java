/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import interfaces.IGestorPedidos;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author lourdes
 */
public class GestorPedidos implements IGestorPedidos {

    private static GestorPedidos instancia;
   private List<Pedido> pedidos;

    public static final String EXITO = "Pedido creado/modificado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "Los productos del pedido son incorrectos";
    public static final String ERROR_CLIENTE = "El cliente del pedido es incorrecto";
    public static final String ERROR_ESTADO = "El estado del pedido es incorrecto";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe el pedido";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "Los datos del pedido son correctos";

    private GestorPedidos() {
        pedidos = new ArrayList<>();
    }

    public static GestorPedidos instanciar() {
        if (instancia == null) {
            instancia = new GestorPedidos();
        }
        return instancia;
    }

    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora,
        List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null) {
            return ERROR_FECHA;
        }
        if (hora == null) {
            return ERROR_HORA;
        }
        if (productosDelPedido == null || productosDelPedido.isEmpty()) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        if (cliente == null) {
            return ERROR_CLIENTE;
        }
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        int numero = pedidos.size() + 1;

        Pedido nuevoPedido = new Pedido(numero, fechaYHora, productosDelPedido, cliente);
        pedidos.add(nuevoPedido);
        cliente.agregarPedido(nuevoPedido);
        return EXITO;
    }

    @Override
public List<Pedido> verPedidos() {
    List<Pedido> pedidosOrdenados = new ArrayList<>(pedidos);

    Collections.sort(pedidosOrdenados,
        (p1, p2) -> p1.verNumero() - p2.verNumero()
    );

    return pedidosOrdenados;
}

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

    @Override
    public Pedido obtenerPedido(Integer numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.verNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for (Pedido pedido : pedidos) {
            if (pedido.verCliente().equals(cliente)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for (Pedido pedido : pedidos) {
            for (ProductoDelPedido pdp : pedido.verProductoDelPedido()) {
                if (pdp.verProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (!existeEstePedido(pedidoAModificar)) {
            return PEDIDO_INEXISTENTE;
        }

        if (pedidoAModificar.verEstado() == Estado.CREADO) {
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        } else if (pedidoAModificar.verEstado() == Estado.PROCESANDO) {
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        } else {
            return ERROR_ESTADO;
        }

        return EXITO;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if (!existeEstePedido(pedido)) {
            return PEDIDO_INEXISTENTE;
        }

        if (pedido.verEstado() != Estado.CREADO) {
            return ERROR_CANCELAR;
        }

        pedidos.remove(pedido);
        pedido.verCliente().cancelarPedido(pedido);

        return EXITO;
    }
}
