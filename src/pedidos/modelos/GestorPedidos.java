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
    //      Singletone
    //=====================
    private static final GestorPedidos instancia = new GestorPedidos();
    private GestorPedidos(){}
    
    public static GestorPedidos instanciar(){
        return instancia;
    }
    
    //=================
    //      Metodos
    //=================
    
    private String corroborarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if (fecha == null)
            return ERROR_FECHA;
        if (hora == null)
            return ERROR_HORA;
        if (productosDelPedido == null)
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        if (cliente == null)
            return ERROR_CLIENTE;
        
        return VALIDACION_EXITO;
    }
    
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String proceso = corroborarDatos(fecha, hora, (ArrayList<ProductoDelPedido>) productosDelPedido, cliente);
        
        
        if (proceso.equals(VALIDACION_EXITO)){
            LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
            cantidadDePedidos++;
            Pedido p = new Pedido(cantidadDePedidos, fechaYHora, (ArrayList<ProductoDelPedido>) productosDelPedido, cliente);
            GestorPedidos.pedidos.add(p);
            cliente.agregarPedido(p);
        }
        return proceso;
    }
    
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        switch (pedidoAModificar.verEstado()){
            case Estado.CREADO -> pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            case Estado.PROCESANDO -> pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            default -> {
                return ERROR_ESTADO;
            }
        }
        return VALIDACION_EXITO;
    }
    
    @Override
    public List<Pedido> verPedidos(){
        Collections.sort(GestorPedidos.pedidos,comparadorNumAsc);
        return GestorPedidos.pedidos;
    }
    
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for (Pedido p : pedidos){
            if (p.verCliente().equals(cliente))
                return true;
        }
        return false;
    }
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for (Pedido p : pedidos){
            for (ProductoDelPedido pdp : p.verProductoDelPedido()){
                if (pdp.verProducto().equals(producto))
                    return true;
            }
        }
        return false;
    }
    

    @Override
    public boolean existeEstePedido(Pedido pedido){
        for (Pedido p : pedidos){
            if (p.equals(pedido))
                return true;
        }
        return false;
    }
    
    @Override
    public Pedido obtenerPedido(Integer numero){
        for (Pedido p: pedidos){
            if (p.verNumero() == numero)
                return p;
        }
        return null;
    }

    @Override
    public String cancelarPedido(Pedido unPedido2) {
        for (Pedido p: pedidos){
            if (p.equals(unPedido2)){
                p.verCliente().cancelarPedido(unPedido2);
                return EXITO;
            }
        }
        return PEDIDO_INEXISTENTE;
    }
}
