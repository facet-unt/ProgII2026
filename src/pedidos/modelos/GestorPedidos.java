/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Usuario
 */
public class GestorPedidos {
    
    
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene datos correctos";
    
    //temp
    ArrayList<Pedido> pedidos = new ArrayList<>();
    
    /**
     * @param cliente para buscar pedidos registrados
     * @return true si se encuentra pedidos con el Clinte,false en caso contrario
     */
    public boolean hayPedidosConEsteCliente(Cliente cliente){
       
        if(cliente==null)
            return false;
        
        return !cliente.verPedidos().isEmpty(); 
    }
    
    
    /**
     * @param producto que se busca en una lista de pedidos
     * @return true si se encuentra el producto en al menos un pedido,false en caso contrario
     */
    public boolean hayPedidosConEsteProducto(Producto producto){
        if(producto==null)
            return false;

        //completar con el nombre del arraylist de pedidos
        for(Pedido p : pedidos){
            for(ProductoDelPedido pdp : p.productosDelPedido){
                if(pdp.verProducto().equals(pdp)){
                   return true; 
                }
            }
        }
        return false;
    }
    
    /**
     * @param pedido a verificar si existe
     * @return true si se encuentra el pedido en la lista,false en caso contrario
     */
    public boolean existeEstePedido(Pedido pedido){
       
        //completar con el nombre del arraylist de pedidos

        return pedidos.contains(pedido);
    }
 
    /**
     * 
     * @param numero del pedido que se desea buscar
     * @return el pedido si se lo encontro,null en caso contrario
     */
    public Pedido obtenerPedido(Integer numero){
        if(numero==null)
            return null;
    
    //completar con el nombre del arraylist de pedidos
        for(Pedido p : pedidos){
            if(p.verNumero()== numero){
                return p;
            }
        }
        return null;
    }
}
