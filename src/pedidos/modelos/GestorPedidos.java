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
import java.util.Comparator;
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Usuario;

/**
 *
 * @author Arebalo
 */
public class GestorPedidos implements IGestorPedidos{
    //Lista para guardar pedidos
    
    private List<Pedido> pedidos = new ArrayList<>();
    
            
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
    
    private String validarDatos(LocalDate fecha,LocalTime hora,List<ProductoDelPedido> productosDelPedido,Cliente cliente){
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
    private int generarNumeroPedido(){
        int max=0;
        for(Pedido p : this.pedidos){
            if(p.verNumero() > max){
                max =p.verNumero();
            }
        }
        return max + 1;
    }
    
    //Creador de un pedido
    
    @Override
    public String crearPedido(LocalDate fecha,LocalTime hora,List<ProductoDelPedido> productosDelPedido,Cliente cliente){
        String validacion = validarDatos(fecha,hora,productosDelPedido,cliente);
        if(!validacion.equals(VALIDACION_EXITO)){
            return validacion;
        }
        int numeroPedido = generarNumeroPedido();
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
    
    @Override
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
    
    @Override
    public List<Pedido> verPedidos(){
        this.pedidos.sort(Comparator.comparingInt(Pedido::verNumero));
        return this.pedidos;
    }
    
    //Verificar si hay un pedido con un cliente
    
    @Override
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
    
    @Override
    public boolean hayPedidosConEsteProducto(Producto producto){
        if(producto == null){
            return false;
        }
        //recorrer pedidos registrados en el gestor
        for (Pedido p : this.pedidos) {
            for (ProductoDelPedido pdp : p.verProductosDelPedido()) {
                if(pdp.verProducto().equals(producto)){
                    return true;
                }
            }
            
        }
        for (Usuario u : GestorUsuarios.instanciar().verUsuarios()) {
            if (u instanceof Cliente) {
                Cliente c = (Cliente) u;
                for (Pedido p : c.verPedidos()) {
                    for(ProductoDelPedido pdp : p.verProductosDelPedido()){
                        if(pdp.verProducto().equals(producto)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
            
        }
    
    //Verificar si existe un pedido especificado
    
    @Override
    public boolean existeEstePedido(Pedido pedido){
        if(pedido == null){
            return false;
        }
        return this.pedidos.contains(pedido);
    }
    
    //Obtener un pedido con un numero
    
    @Override
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
    @Override
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
