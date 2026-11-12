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
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author tobias150
 */
public class GestorPedidos implements IGestorPedidos{
    ArrayList<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos gestor;
    private static int contadorPedidos = 1;
    
    //Patron Singleton
    private GestorPedidos(){        
    }
    
    public static GestorPedidos instanciar(){
        if(gestor == null)
            gestor = new GestorPedidos();
        
        return gestor;
    }

    @Override
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        String respuesta = this.validarDatos(fecha, hora, productosDelPedido, cliente);
        
        if(!respuesta.equals(VALIDACION_EXITO)){
            return respuesta;
        }
        
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        Pedido unPedido = new Pedido(contadorPedidos, fechaYHora, productosDelPedido, cliente);
        contadorPedidos++;
        
        if(this.existeEstePedido(unPedido)){
            return PEDIDOS_DUPLICADOS;
        }
        
       pedidos.add(unPedido);
       
       return EXITO;
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        EstadoPedido estado = pedidoAModificar.verEstado();
        
        switch(estado){
            case CREADO:
                pedidoAModificar.asignarEstado(EstadoPedido.PROCESANDO);
                break;
            case PROCESANDO:
                pedidoAModificar.asignarEstado(EstadoPedido.ENTREGADO);
                break;
            default:
                return ERROR_ESTADO;
        }
        
        return VALIDACION_EXITO;
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    @Override
    public boolean hayPedidosConEsteCliente(Cliente cliente) {
        for(Pedido p : pedidos){
            if(p.verCliente().equals(cliente))
                return true;
        }
        
        return false;
    }

    @Override
    public boolean hayPedidosConEsteProducto(Producto producto) {
        for(Pedido p : pedidos){
            for(ProductoDelPedido pdp : p.verListaPedidos()){
                if(pdp.verProducto().equals(producto)){
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public String cancelarPedido(Pedido pedido) {
        if(this.pedidos.contains(pedido)){
            pedidos.remove(pedido);
            return PEDIDO_BORRADO;
        }
        
        return PEDIDO_INEXISTENTE;
    }

    @Override
    public boolean existeEstePedido(Pedido pedido) {
        return pedidos.contains(pedido);
    }

    @Override
    public Pedido obtenerPedido(Integer numero) {
        for(Pedido pd : pedidos){
            if(pd.verNumero() == numero)
                return pd;
        }
        
        return null;
    }
    
    private String validarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
           if(fecha == null)
               return ERROR_FECHA;
           if(hora == null)
               return ERROR_HORA;
           if(productosDelPedido == null)
               return ERROR_PRODUCTOS_DEL_PEDIDO;
           if(cliente == null)
               return ERROR_CLIENTE;
           
           return VALIDACION_EXITO;
    }
}
