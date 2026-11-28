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
import java.util.List;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author leand
 */
public class GestorPedidos implements IGestorPedidos 
{
    List<Pedido> pedidos = new ArrayList<>();
    private static GestorPedidos gestorP;
    private static int numero=0;
    
    public static GestorPedidos instanciar()
    {
        if (gestorP == null) 
        {
           gestorP = new GestorPedidos(); 
        }
        return gestorP;
    }
    
    private String verificarDatosPedidos(LocalDate fecha, LocalTime hora, Cliente cliente, List<ProductoDelPedido> pdp)
    {
        if ( fecha == null) 
        {
            return ERROR_FECHA;   
        }
        if (hora == null ) 
        {
            return ERROR_HORA;   
        }
        if (cliente == null) 
        {
            return ERROR_CLIENTE;   
        }
        if (pdp == null || pdp.isEmpty()) 
        {
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        }
        return VALIDACION_EXITO;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, List<ProductoDelPedido> pdp, Cliente cliente)
    {
        String verificacion = verificarDatosPedidos(fecha, hora, cliente, pdp);
        if (verificacion.equals(VALIDACION_EXITO)) 
        {
            Pedido p = new Pedido(numero, LocalDateTime.of(fecha, hora), pdp, cliente);
            if (pedidos.contains(p)) 
            {
                return PEDIDOS_DUPLICADOS;
            }
            else
            {
                pedidos.add(p);
                numero+=1;
                cliente.agregarPedido(p);
                return EXITO;
            }
        }
        
        return verificacion;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar)
    {
        if (pedidoAModificar == null) 
        {
            return ERROR_ESTADO;
        }
        if (pedidoAModificar.verEstado().equals(Estado.CREADO)) 
        {
            pedidoAModificar.asignarEstado(Estado.PROCESANDO);
        }
        if(pedidoAModificar.verEstado().equals(Estado.PROCESANDO))
        {
            pedidoAModificar.asignarEstado(Estado.ENTREGADO);
        }
        return EXITO;
    }
    
    public List<Pedido> verPedidos()
    {
        List<Pedido> orden = new ArrayList<>(pedidos);
        
        orden.sort((p1,p2)->
        Integer.compare(p1.verNumero(), p2.verNumero())
        );
        return orden;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente)
    {
        for(Pedido p: pedidos){
           if(p.verCliente().equals(cliente)){
               return true;
           } 
    }
        return false;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto)
    {
        for (Pedido p : pedidos) 
        {
            if (p.verProductoDelPedido().contains(producto)) 
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean existeEstePedido(Pedido pedido)
    {
        return pedidos.contains(pedido);
    }
    
    public Pedido obtenerPedido(Integer numero)
    {
        for (Pedido p : pedidos) 
        {
            if (p.verNumero() == numero) 
            {
                return p;
            }
        }
        return null;
    }
    
    public String cancelarPedido(Pedido pedido)
    {
        if (pedidos.contains(pedido)) 
        {
            for (Pedido p : pedidos) 
            {
                if (p.equals(pedido)) 
                {
                    p.verCliente().cancelarPedido(pedido);
                    return EXITO;
                }
            }
        }
        return PEDIDO_INEXISTENTE;
    }
}
