/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import static interfaces.IGestorPedidos.ERROR_CLIENTE;
import static interfaces.IGestorPedidos.ERROR_FECHA;
import static interfaces.IGestorPedidos.ERROR_HORA;
import static interfaces.IGestorPedidos.ERROR_PRODUCTOS_DEL_PEDIDO;
import static interfaces.IGestorPedidos.PEDIDO_INEXISTENTE;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Usuario
 */
public class GestorPedidos implements IGestorPedidos{

    ArrayList<Pedido> pedidos = new ArrayList<>();

    private static GestorPedidos gestor;
    private int numeroSgte = 1;

    private GestorPedidos() {
        pedidos = new ArrayList<>();
    }
    
    public static GestorPedidos instanciar() {
        if (gestor == null) {
            gestor = new GestorPedidos();
        }
        return gestor;
    }

    /**
     * Crea un nuevo pedido, devolviendo el resultado de la operación. Al
     * crearlo, el pedido se agrega al cliente especificado (con el método
     * agregarPedido() definido en la clase Cliente).
     *
     * @param fecha
     * @param hora
     * @param productosDelPedido
     * @param cliente
     * @return
     */
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fechaInvalida(fecha)) {
            return ERROR_FECHA;
        }

        if (horaInvalida(hora)) {
            return ERROR_HORA;
        }

        if (productosDelPedidoInvalido(productosDelPedido)) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }

        if (clienteInvalido(cliente)) {
            return ERROR_CLIENTE;
        }

        Pedido nuevoPedido = new Pedido(fecha, hora, productosDelPedido, cliente);
        nuevoPedido.asignarNumero(numeroSgte);
        numeroSgte++;
        pedidos.add(nuevoPedido);
        cliente.agregarPedido(nuevoPedido);
        return EXITO;
    }

    /**
     * Cambia el estado de un pedido: si está en Estado.CREADO lo pasa a
     * Estado.PROCESANDO; si está en Estado.PROCESANDO lo pasa a
     * Estado.ENTREGADO. Devuelve el resultado de la operación.
     *
     * @param pedidoAModificar
     * @return
     */
    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (pedidoAModificar == null) {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        Estado opc = pedidoAModificar.verEstado();
        if (opc == null) {
            return ERROR_ESTADO;
        }
        switch (opc) {
            case CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                break;
            case PROCESANDO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                break;
            default:
        }
        return EXITO;
    }

    /**
     * Devuelve todos los pedidos
     *
     * @return
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    /**
     * @param cliente para buscar pedidos registrados
     * @return true si se encuentra pedidos con el Clinte,false en caso
     * contrario
     */
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        if (cliente == null) {
            return false;
        }
        return !cliente.verPedidos().isEmpty();
    }
    
    /**
     * @param producto que se busca en una lista de pedidos
     * @return true si se encuentra el producto en al menos un pedido,false en
     * caso contrario
     */
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        if (producto == null) {
            return false;
        }

        for (Pedido p : pedidos) {
            for (ProductoDelPedido pdp : p.productosDelPedido) {
                if (pdp.verProducto().equals(producto)) {
                    return true;
                }
            }
        }
        return false;
    }

     /**
     * 
     * @param pedido que,lueqo de validar que no sea nulo o no este en la lista,se quiere cancelar
     * @return un mensaje de exito de que se pudo cancelar,en caso contrario un mensaje de pedido inexistente
     */
    @Override
    public String cancelarPedido(Pedido pedido){
        
        if (pedido == null || !(existeEstePedido(pedido))) {
         return PEDIDO_INEXISTENTE;
        }

        if (!clienteInvalido(pedido.verUnCliente())) { 
            pedido.verUnCliente().cancelarPedido(pedido);
        }

        this.pedidos.remove(pedido);

        return EXITO;
    }
    
    /**
     * @param pedido a verificar si existe
     * @return true si se encuentra el pedido en la lista,false en caso
     * contrario
     */
    @Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

    /**
     *
     * @param numero del pedido que se desea buscar
     * @return el pedido si se lo encontro,null en caso contrario
     */
    @Override
    public Pedido obtenerPedido(Integer numero) {
        if (numero == null) {
            return null;
        }

        for (Pedido p : pedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }
        return null;
    }

    /**
     * Valida que fecha sea distinto de null. Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param fecha
     * @return
     */
    private boolean fechaInvalida(LocalDate fecha) {
        return fecha == null;
    }

    /**
     * Valida que hora sea distinta de null Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param hora
     * @return
     */
    private boolean horaInvalida(LocalTime hora) {
        return hora == null;
    }

    /**
     * Valida que cliente es distinto de null Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param cliente
     * @return
     */
    private boolean clienteInvalido(Cliente cliente) {
        return cliente == null;
    }

    /**
     * Valida que el pedido tiene productos Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param pdp
     * @return
     */
    private boolean productosDelPedidoInvalido(List<ProductoDelPedido> pdp) {
        return pdp == null || pdp.isEmpty();
    }
}
