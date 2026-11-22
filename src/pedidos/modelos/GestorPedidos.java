/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author ramayo
 */
public class GestorPedidos implements IGestorPedidos{
    private static List<Pedido> listaPedidos = new ArrayList<>();
    private static int cantidadPedidos=1;
    
    //<editor-fold defaultstate="collapsed" desc="Patrón Singleton">
    private static GestorPedidos gestor;
    private GestorPedidos() {
    }
    
    public static GestorPedidos instanciar() {
        if (gestor == null)
        gestor = new GestorPedidos();
        return gestor;
    }
    //</editor-fold>    
    
    public String validarPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha==null)
            return ERROR_FECHA;
        if(hora==null)
            return ERROR_HORA;
        if(cliente==null)
            return ERROR_CLIENTE;
        if(productosDelPedido==null||productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        return VALIDACION_EXITO;
    }
    
    /*Crea un nuevo pedido, devolviendo el resultado de la operación.
    Al crearlo, el pedido se agrega al cliente especificado (con el método agregarPedido() definido en la clase Cliente).*/
    @Override
    public String crearPedido(LocalDate fecha,LocalTime hora, List<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = validarPedido(fecha, hora, productosDelPedido, cliente);
        if(validacion.equals(VALIDACION_EXITO)){
            Pedido p = new Pedido(cantidadPedidos ,fecha, hora, productosDelPedido, cliente);
            if(!(listaPedidos.contains(p))){
                cantidadPedidos++;
                cliente.agregarPedido(p);
                GestorPedidos.listaPedidos.add(p);
                return EXITO;
            }
            else return PEDIDOS_DUPLICADOS;
        }
        else return validacion;
    }
            
    /*Cambia el estado de un pedido: si está en Estado.CREADO lo pasa a Estado.PROCESANDO;
    si está en Estado.PROCESANDO lo pasa a Estado.ENTREGADO. Devuelve el resultado de la operación.*/
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar!=null){
            if(pedidoAModificar.verEstado()== Estado.CREADO){
                pedidoAModificar.asignarEstado(Estado.PROCESANDO);
                return EXITO;
            }
            else if(pedidoAModificar.verEstado()==Estado.PROCESANDO){
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                return EXITO;
            }
            else return "Error al cambiar de estado";
        }
        return PEDIDO_INEXISTENTE;
    }

    //Devuelve todos los pedidos.
    @Override
    public List<Pedido> verPedidos(){
        Collections.sort(GestorPedidos.listaPedidos);
        return GestorPedidos.listaPedidos;
    }
            
    //Devuelve true si hay al menos un pedido con el cliente especificado, false en caso contrario.
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p:listaPedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
            
    //Devuelve true si hay al menos un pedido con el producto especificado, false en caso contrario.
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: listaPedidos){
            for(ProductoDelPedido pdp:p.verListaProductos())
                if(pdp.verProducto().equals(producto)){
                return true;
            } 
        }
        return false;
    }
            
    //Devuelve true si existe el pedido especificado, false en caso contrario.
    @Override
    public boolean existeEstePedido(Pedido pedido){
        return listaPedidos.contains(pedido);
    }
                    
    //Obtiene el pedido con el número especificado. Si no hay un pedido con ese número, devuelve null.
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p:listaPedidos){
            if(p.verNumero()==numero){
                return p;
            }
        }
        return null;
    }
    
    @Override
    public String cancelarPedido(Pedido unPedido){
        if(unPedido.verEstado()==Estado.CREADO){
            for(Pedido p:listaPedidos){
                if(p.equals(unPedido)){
                    p.verCliente().cancelarPedido(unPedido);
                    return EXITO;
                }
            }
            return PEDIDO_INEXISTENTE;
        }
        else return ERROR_CANCELAR;
    }
    
}
