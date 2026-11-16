/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author luciano
 */
import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

public class GestorPedidos implements IGestorPedidos{

    private static GestorPedidos gestor;
    private ArrayList<Pedido> pedidos;
    private int contadorPedidos;
    //constructor
    private GestorPedidos() {
        this.pedidos = new ArrayList<>();
        this.contadorPedidos=0;
    }
    //instanciar
    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
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
@Override
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String resultado = validarDatos(fecha, hora, productosDelPedido, cliente);
        if (!resultado.equals(VALIDACION_EXITO)) {
            return resultado;
        }
        int nuevoNumero = this.contadorPedidos + 1;
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
 
        Pedido nuevoPedido = new Pedido(nuevoNumero, fechaYHora, productosDelPedido, cliente);

        if (this.pedidos.contains(nuevoPedido)) {
            return PEDIDOS_DUPLICADOS;
        }
        this.contadorPedidos = nuevoNumero;
        this.pedidos.add(nuevoPedido);
        cliente.agregarPedido(nuevoPedido); 

        return EXITO;
    }
@Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (pedidoAModificar == null || !existeEstePedido(pedidoAModificar)) {
            return PEDIDO_INEXISTENTE;
        }
        if (pedidoAModificar.verEstado() == null) {
            return ERROR_ESTADO;
        }

        if (pedidoAModificar.verEstado() == Estado.CREADO) {
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        } else if (pedidoAModificar.verEstado() == Estado.PROCESANDO) {
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        }
        return EXITO;
    }
@Override
    public ArrayList<Pedido> verPedidos() {
        return this.pedidos;
    }

@Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        if (cliente != null) {
            for (Pedido p : this.pedidos) {
                if (p.verCliente() != null && p.verCliente().equals(cliente)) {
                    return true;
                }
            }
        }
        return false;
    }
@Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        if (producto != null) {
            for (Pedido p : this.pedidos) {
                if (p.verPedido() != null) {
                    for (ProductoDelPedido pdp : p.verPedido()) {
                        if (pdp.verProducto() != null && pdp.verProducto().equals(producto)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
@Override
    public boolean existeEstePedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }
        return this.pedidos.contains(pedido);
    }
@Override
    public Pedido obtenerPedido(Integer numero) {
        if (numero != null) {
            for (Pedido p : this.pedidos) {
                if (p.verNumero() == numero) {
                    return p;
                }
            }
        }
        return null;
    }
@Override
    public String cancelarPedido(Pedido pedido) {
        if (pedido == null || !this.pedidos.contains(pedido)) {
            return PEDIDO_INEXISTENTE;
        }
        if (pedido.verEstado() != Estado.CREADO) {
            return ERROR_CANCELAR;
        }
        this.pedidos.remove(pedido);
        if (pedido.verCliente() != null) {
            pedido.verCliente().cancelarPedido(pedido);
        }
        return EXITO;
    }
}
