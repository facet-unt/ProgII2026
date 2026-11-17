/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import Interfaces.IGestorPedidos;
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
public class GestorPedidos implements IGestorPedidos {
    ArrayList<Pedido> pedidos = new ArrayList<>();
    public static GestorPedidos gestor;
    private static int numero =0;
    
    
    private GestorPedidos(){
        
    }
    
    /**
     * Patrón Singleton.
     * @return Un gestor.
     */
    public static GestorPedidos instanciar(){
        if(gestor == null)
            gestor = new GestorPedidos();
        return gestor;
    }
    
    /**
     * Crea un nuevo pedido, devolviendo el resultado de la operación. Al 
     * crearlo, el pedido se agrega al cliente especificado (con el método 
     * agregarPedido() definido en la clase Cliente).
     * @param fecha La fecha del pedido.
     * @param hora La hora del pedido.
     * @param productosDelPedido ArrayList de los productos del pedido. 
     * @param cliente Un cliente.
     * @return Una cadena de EXITO si se creó correctamente el pedido.
     */
    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String resultadoValidacion = validarDatos(fecha, hora, productosDelPedido, cliente);
         if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        numero++;
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        Pedido p = new Pedido(numero, fechaYHora, productosDelPedido, cliente);
        cliente.agregarPedido(p);
        pedidos.add(p);
        return EXITO;
    }
    
    /**
     * Cambia el estado de un pedido: si está en Estado.CREADO lo pasa a Estado.PROCESANDO; 
     * si está en Estado.PROCESANDO lo pasa a Estado.ENTREGADO. Devuelve el resultado de la operación.
     * @param pedidoAModificar El pedido que hay que modificar.
     * @return Una cadena de EXITO si se modificó correctamente el pedido.
     */
    @Override
    public String cambiarEstado(Pedido pedidoAModificar){
        switch(pedidoAModificar.verEstado()){
            case Estado.CREADO:
                pedidoAModificar.asignarEstado(Estado.PROCESADO);
                break;
            case Estado.ENTREGADO:
                System.out.println("El pedido ya ha sido entregado.");
                break;
            case Estado.PROCESADO:
                pedidoAModificar.asignarEstado(Estado.ENTREGADO);
                break;
            default: return ERROR_ESTADO;
        }
        return EXITO;
    }
    
    /**
     * Devuelve todos los pedidos.
     * @return 
     */
    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    /**
     * Devuelve true si hay al menos un pedido con el cliente especificado, false en caso contrario.
     * @param cliente Un cliente.
     * @return Un boolean.
     */
    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for(Pedido p: pedidos){
            if(p.verUnCliente().equals(cliente))
                return true;
        }
        return false;
    }
    
    /**
     * Devuelve true si hay al menos un pedido con el producto especificado, false en caso contrario.
     * @param producto Un producto.
     * @return Un boolean.
     */
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        for(Pedido p: pedidos){
             for(ProductoDelPedido pdp : p.verProductos()){
                 if(pdp.verUnProducto().equals(producto))
                     return true;
            }
        }
        return false;
    }
    
    /**
     * Devuelve true si existe el pedido especificado, false en caso contrario.
     * @param pedido Un pedido.
     * @return Un boolean.
     */
    @Override
    public boolean existeEstePedido(Pedido pedido){
        return pedidos.contains(pedido);
    }
    
    /**
     * Obtiene el pedido con el número especificado. Si no hay un pedido con ese número, devuelve null.
     * @param numero El número del pedido.
     * @return Null.
     */
    @Override
    public Pedido obtenerPedido(Integer numero){
        for(Pedido p: pedidos){
            if(p.verNumero() == numero)
                return p;
        }
        System.out.println(PEDIDO_INEXISTENTE);
        return null;
    }
    
    /**
     * Recibe un pedido y, si el estado lo permite, lo cancela.
     * @param pedido Un pedido.
     * @return Una cadena de EXITO si se canceló correctamente el pedido.
     */
    @Override
    public String cancelarPedido(Pedido pedido){
        if(pedido.verEstado()!=Estado.CREADO)
            return ERROR_CANCELAR;
        pedidos.remove(pedido);
        pedido.verUnCliente().cancelarPedido(pedido);
        return EXITO;
    }
    
    //Métrodos para hacer los distintos controles
    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if(fecha == null)
            return ERROR_FECHA;
        if(hora == null)
            return ERROR_HORA;
        if(cliente == null)
            return ERROR_CLIENTE;
        if(productosDelPedido == null || productosDelPedido.isEmpty())
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        
        return VALIDACION_EXITO;
    }
    
}
