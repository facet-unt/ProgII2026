/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import pedidos.modelos.Pedido;

/**
 *
 * @author Usuario
 */
public interface IGestorPedidos {
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con exito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene datos correctos";

    
    
    
    
    public String cancelarPedido(Pedido pedido); 
    public boolean existeEstePedido(Pedido pedido); 
    public Pedido obtenerPedido(Integer numero); 
}
