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
    
    public static final String EXITO = "Pedido creado/modificado/cancelado con exito.";
    public static final String ERROR_FECHA = "La fecha del pedido es incorrecta.";
    public static final String ERROR_HORA = "La hora del pedido es incorrecta.";
    public static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos.";
    public static final String ERROR_CLIENTE = "El pedido no tiene un cliente.";
    public static final String ERROR_ESTADO = "El pedido no tiene un estado.";
    public static final String ERROR_CANCELAR = "No se puede cancelar el pedido en este estado.";
    public static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero.";
    public static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado.";
    public static final String VALIDACION_EXITO = "El pedido tiene los datos correctos.";
    
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
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    /**
     * Devuelve true si hay al menos un pedido con el cliente especificado, false en caso contrario.
     * @param cliente Un cliente.
     * @return Un boolean.
     */
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
    public boolean existeEstePedido(Pedido pedido){
        return pedidos.contains(pedido);
    }
    
    /**
     * Obtiene el pedido con el número especificado. Si no hay un pedido con ese número, devuelve null.
     * @param numero El número del pedido.
     * @return Null.
     */
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
