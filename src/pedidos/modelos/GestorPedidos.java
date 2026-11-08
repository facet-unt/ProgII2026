/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

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
    
    
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
       
        if(cliente==null)
            return false;
        
        return !cliente.verPedidos().isEmpty(); 
    }
    
    
}
