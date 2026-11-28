/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author foxeen
 */
public class GestorPedidos implements IGestorPedidos{
    private static final List<Pedido> pedidos = new ArrayList<>();
    private static int cantidadDePedidos = 0;
    private final Comparator<Pedido> comparadorNumAsc = Comparator.comparing(Pedido::verNumero);
    

    //=====================
    //      Singleton
    //=====================
    private static final GestorPedidos instancia = new GestorPedidos();
    private GestorPedidos(){}
    
    public static GestorPedidos instanciar(){
        return instancia;
    }
    
    //=================
    //      Metodos
    //=================
    
    private String corroborarDatos(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        if (fecha == null)
            return ERROR_FECHA;
        if (hora == null)
            return ERROR_HORA;
        if (productosDelPedido == null || productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        if (cliente == null)
            return ERROR_CLIENTE;
        
        return VALIDACION_EXITO;
    }
    
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String proceso = corroborarDatos(fecha, hora, productosDelPedido, cliente);
    
        if (proceso.equals(VALIDACION_EXITO)) {
            LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
            cantidadDePedidos++;
            Pedido p = new Pedido(cantidadDePedidos, fechaYHora, productosDelPedido, cliente);
            GestorPedidos.pedidos.add(p);
            cliente.agregarPedido(p);
            return EXITO;
        }
        return proceso;
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        if (pedidoAModificar == null || !pedidos.contains(pedidoAModificar)) {
            return PEDIDO_INEXISTENTE;
        }
        if (pedidoAModificar.verEstado() == null) {
            return ERROR_ESTADO;
        }
        switch (pedidoAModificar.verEstado()) {
            case Estado.CREADO ->
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            case Estado.PROCESANDO ->
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            default -> {
                return ERROR_ESTADO;
            }
        }
        return EXITO;
    }
    
    @Override
    public List<Pedido> verPedidos(){
        Collections.sort(GestorPedidos.pedidos,comparadorNumAsc);
        return GestorPedidos.pedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        for (Pedido p : pedidos) {
            if (cliente.equals(p.verCliente())){
            return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        if (producto == null){
            return false;
        }
        for (Pedido p : pedidos){
            for (ProductoDelPedido pdp : p.verProductoDelPedido()){
                if (producto.equals(pdp.verProducto()))
                    return true;
            }
        }
        return false;
    }
    

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        if (numero == null) {
            return null;
        }
        for (Pedido p: pedidos){
            if (p.verNumero() == numero)
                return p;
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if (pedido == null || !pedidos.contains(pedido)) {
            return PEDIDO_INEXISTENTE;
        }
        Pedido p = pedidos.get(pedidos.indexOf(pedido));
        if (p.verEstado() != Estado.CREADO) {
            return ERROR_CANCELAR;
        }
        if (p.verCliente() != null) {
            p.verCliente().cancelarPedido(p);
        }
        pedidos.remove(p);
        
        return EXITO;
    }
}
