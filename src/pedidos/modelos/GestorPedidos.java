/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Usuario
 */
public class GestorPedidos {

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
     * @param cliente para buscar pedidos registrados
     * @return true si se encuentra pedidos con el Clinte,false en caso
     * contrario
     */
    public boolean hayPedidosConEsteCliente(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        return !cliente.verPedidos().isEmpty();
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
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fechaInavlida(fecha)) {
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
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    /**
     * @param producto que se busca en una lista de pedidos
     * @return true si se encuentra el producto en al menos un pedido,false en
     * caso contrario
     */
    public boolean hayPedidosConEsteProducto(Producto producto) {
        if (producto == null) {
            return false;
        }

        //completar con el nombre del arraylist de pedidos
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
     * @param pedido a verificar si existe
     * @return true si se encuentra el pedido en la lista,false en caso
     * contrario
     */
    public boolean existeEstePedido(Pedido pedido) {

        //completar con el nombre del arraylist de pedidos
        return pedidos.contains(pedido);
    }

    /**
     *
     * @param numero del pedido que se desea buscar
     * @return el pedido si se lo encontro,null en caso contrario
     */
    public Pedido obtenerPedido(Integer numero) {
        if (numero == null) {
            return null;
        }

        //completar con el nombre del arraylist de pedidos
        for (Pedido p : pedidos) {
            if (p.verNumero() == numero) {
                return p;
            }
        }
        return null;
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

        return EXITO_CANCELAR;
    }
   

    /**
     * Valida que fecha sea distinto de null. Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param fecha
     * @return
     */
    private boolean fechaInavlida(LocalDate fecha) {
        if (fecha == null) {
            return true;
        }
        return false;
    }

    /**
     * Valida que hora sea distinta de null Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param hora
     * @return
     */
    private boolean horaInvalida(LocalTime hora) {
        if (hora == null) {
            return true;
        }
        return false;
    }

    /**
     * Valida que cliente es distinto de null Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param cliente
     * @return
     */
    private boolean clienteInvalido(Cliente cliente) {
        if (cliente == null) {
            return true;
        }
        return false;
    }

    /**
     * Valida que el pedido tiene productos Si no cumple con la validacion
     * devuelve true, caso contrario false.
     *
     * @param pdp
     * @return
     */
    private boolean productosDelPedidoInvalido(ArrayList<ProductoDelPedido> pdp) {
        if (pdp == null || pdp.isEmpty()) {
            return true;
        }
        return false;
    }
}
