/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Arebalo
 */
public class GestorPedidos {
    //Lista para guardar pedidos
    
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    
    //Constantes para errores
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con exito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar un pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
            
    //Singleton
    
    private static GestorPedidos gestor;
    private GestorPedidos(){
    }
    
    public static GestorPedidos instanciar(){
        if(gestor == null){
            gestor = new GestorPedidos();
        }
        return gestor;
    }
   
    //Validador de datos
    
    private String validarDatos(LocalDate fecha,LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido,Cliente cliente){
        if(fecha == null){
            return ERROR_FECHA;
        }
        if(hora == null){
            return ERROR_HORA;
        }
        if(cliente == null){
            return ERROR_CLIENTE;
        }
        if(productosDelPedido == null || productosDelPedido.isEmpty()){
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        return VALIDACION_EXITO;
    }
    
    //Creador de un pedido
    
    public String crearPedido(LocalDate fecha,LocalTime hora,ArrayList<ProductoDelPedido> productosDelPedido,Cliente cliente){
        String validacion = validarDatos(fecha,hora,productosDelPedido,cliente);
        if(!validacion.equals(VALIDACION_EXITO)){
            return validacion;
        }
        int numeroPedido = this.pedidos.size() + 1;
        LocalDateTime fechaYHora = LocalDateTime.of(fecha,hora);
        
        Pedido nuevoPedido = new Pedido(numeroPedido,fechaYHora,productosDelPedido,cliente);
        
        if(this.pedidos.contains(nuevoPedido)){
            return PEDIDOS_DUPLICADOS;
        }
        this.pedidos.add(nuevoPedido);
        cliente.agregarPedido(nuevoPedido);
        return EXITO;
    }
    
    //Cambiar el estado de un pedido
    
    public String cambiarEstado(Pedido pedidoAModificar){
        if(pedidoAModificar == null || !this.pedidos.contains(pedidoAModificar)){
            return PEDIDO_INEXISTENTE;
        }
        Estado estadoActual = pedidoAModificar.verEstado();
        if(estadoActual == null){
            return ERROR_ESTADO;
        }
        if(estadoActual == Estado.CREADO){
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            return EXITO;
        }else if (estadoActual == Estado.PROCESANDO){
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            return EXITO;
        }
        return ERROR_ESTADO;       
    }
    
    //Devolver todos los pedidos
    
    public ArrayList<Pedido> verPedidos(){
        return this.pedidos;
    }
    
    //Verificar si hay un pedido con un cliente
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        if(cliente == null){
            return false;
        }
        for(Pedido p : this.pedidos){
            if(p.verCliente() != null && p.verCliente().equals(cliente)){
                return true;
            }
        }
        return false;
    }
    
    //Verificar si hay un pedido con un producto
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        if(producto == null){
            return false;
        }
        for(Pedido p : this.pedidos){
            if(p.verProductosDelPedido() != null){
                for(ProductoDelPedido pdp : p.verProductosDelPedido()){
                    if(pdp.verProducto() != null && pdp.verProducto().equals(producto)){
                        return true;
                    }
                }
            }
            
        }
        return false;
            
        }
    
    //Verificar si existe un pedido especificado
    
    public boolean existeEstePedido(Pedido pedido){
        if(pedido == null){
            return false;
        }
        return this.pedidos.contains(pedido);
    }
    
    //Obtener un pedido con un numero
    
    public Pedido obtenerPedido(Integer numero){
        if(numero == null){
            return null;
        }
        for (Pedido p : this.pedidos){
            if(p.verNumero() == numero){
                return p;
            }
        }
        return null;
    }
    public String cancelarPedido(Pedido pedidoACancelar){
        if(pedidoACancelar == null || !this.pedidos.contains(pedidoACancelar)){
            return PEDIDO_INEXISTENTE;
        }
        if(pedidoACancelar.verEstado() == Estado.CREADO){
            if(pedidoACancelar.verCliente() != null){
                pedidoACancelar.verCliente().cancelarPedido(pedidoACancelar);
            }
            this.pedidos.remove(pedidoACancelar);
            return EXITO;
        }
        return ERROR_CANCELAR;
    }
}
