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
 * @author LUCRECIA
 */
public class GestorPedidos {
    ArrayList<Pedido> pedidos = new ArrayList<>();
    public static GestorPedidos gestor;
    private static int numero =0;
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con éxito";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese número";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";
    
    private GestorPedidos(){
        
    }
    
    public static GestorPedidos instanciar(){
        if(gestor == null){
            gestor = new GestorPedidos();
            return gestor;
        }
        System.out.println("gestor de productos ya existe");
        return null;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        
        if(fecha == null)
            return ERROR_FECHA;
        if(hora == null)
            return ERROR_HORA;
        if(cliente == null)
            return ERROR_CLIENTE;
        if(productosDelPedido == null)
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        else if(productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        System.out.println(VALIDACION_EXITO);
        
        numero++;
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        Pedido p = new Pedido(numero, fechaYHora, productosDelPedido, cliente);
        cliente.agregarPedido(p);
        pedidos.add(p);
        return EXITO;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar){
        switch(pedidoAModificar.verEstado()){
            case Estado.CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESADO);
                break;
            case Estado.ENTREGADO:
                System.out.println("El pedido ya ha sido entregado");
                break;
            case Estado.PROCESADO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                break;
            default: return ERROR_ESTADO;
        }
        return EXITO;
    }
    
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: pedidos){
            if(p.verUnCliente().equals(cliente))
                return true;
        }
        return false;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: pedidos){
             for(ProductoDelPedido pdp : p.verProductos()){
                 if(pdp.verUnProducto().equals(producto))
                     return true;
            }
        }
        return false;
    }
    
    public boolean existeEstePedido(Pedido pedido){
        return pedidos.contains(pedido);
    }
    
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero() == numero)
                return p;
        }
        System.out.println(PEDIDO_INEXISTENTE);
        return null;
    }
    
    public String cancelarPedido(Pedido pedido){
        if(pedido.verEstado()!=Estado.CREADO)
            return ERROR_CANCELAR;
        pedidos.remove(pedido);
        return EXITO;
    }
}
