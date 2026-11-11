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
 * @author ramayo
 */
public class GestorPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    public static final String EXITO="Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA="La fecha del pedido es incorrecta";
    public static final String ERROR_HORA ="La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO="El pedido no tiene productos";
    public static final String ERROR_CLIENTE ="El pedido no tiene un cliente";
    public static final String ERROR_ESTADO ="El pedido no tiene un estado";
    public static final String ERROR_CANCELAR ="No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS="Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE ="No existe el pedido especificado";
    public static final String VALIDACION_EXITO="El pedido tiene los datos correctos";
    
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
    
    public String validarPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha==null)
            return ERROR_FECHA;
        if(hora==null)
            return ERROR_HORA;
        if(cliente==null)
            return ERROR_CLIENTE;
        if(productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        return VALIDACION_EXITO;
    }
    
    /*Crea un nuevo pedido, devolviendo el resultado de la operación.
    Al crearlo, el pedido se agrega al cliente especificado (con el método agregarPedido() definido en la clase Cliente).*/
    public String crearPedido(LocalDate fecha,LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String validacion = validarPedido(fecha, hora, productosDelPedido, cliente);
        if(validacion==VALIDACION_EXITO){
            Pedido p = new Pedido(14 ,fecha, hora, productosDelPedido, cliente);
            cliente.agregarPedido(p);
            listaPedidos.add(p);
            return EXITO;
        }
        else return validacion;
    }
            
    /*Cambia el estado de un pedido: si está en Estado.CREADO lo pasa a Estado.PROCESANDO;
    si está en Estado.PROCESANDO lo pasa a Estado.ENTREGADO. Devuelve el resultado de la operación.*/
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
    public ArrayList<Pedido> verPedidos(){
        return listaPedidos;
    }
            
    //Devuelve true si hay al menos un pedido con el cliente especificado, false en caso contrario.
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p:listaPedidos){
            if(p.verCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
            
    //Devuelve true si hay al menos un pedido con el producto especificado, false en caso contrario.
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: listaPedidos){
            if(p.verListaProductos().contains(producto)){
                return true;
            } 
        }
        return false;
    }
            
    //Devuelve true si existe el pedido especificado, false en caso contrario.
    public boolean existeEstePedido(Pedido pedido){
        return listaPedidos.contains(pedido);
    }
                    
    //Obtiene el pedido con el número especificado. Si no hay un pedido con ese número, devuelve null.
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p:listaPedidos){
            if(p.verNumero()==numero){
                return p;
            }
        }
        return null;
    }
}
