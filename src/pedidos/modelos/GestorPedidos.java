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
 * @author homep
 */
public class GestorPedidos {
    private static final ArrayList<Pedido> pedidos = new ArrayList<>();
    private static int cantidadDePedidos = 0;
    private static final String EXITO = "Pedido creado/moidificado/cancelado con éxito";
    private static final String ERROR_FECHA = "La fecha del pedido es incorrecta";
    private static final String ERROR_HORA = "La hora del pedido es incorrecta";
    private static final String ERROR_PRODUCTOS_DEL_PEDIDO = "El pedido no tiene productos";
    private static final String ERROR_CLIENTE = "El pedido no tiene cliente";
    private static final String ERROR_ESTADO = "El pedido no tiene un estado";
    private static final String ERROR_CAMCELAR = "No se puede cancelar un pedido en este estado";
    private static final String PEDIDOS_DUPLICADOS = "Ya existe un pedido con ese numero";
    private static final String PEDIDO_INEXISTENTE = "No existe el pedido especificado";
    private static final String VALIDACION_EXITO = "El pedido tiene los datos correctos";

    //=====================
    //      Singletone
    //=====================
    private static final GestorPedidos instancia = new GestorPedidos();
    private GestorPedidos(){}
    
    public static GestorPedidos instanciar(){
        return instancia;
    }
    
    //=================
    //      Metodos
    //=================
    
    private String corroborarDatos(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        if (fecha == null)
            return ERROR_FECHA;
        if (hora == null)
            return ERROR_HORA;
        if (productosDelPedido == null)
            return ERROR_PRODUCTOS_DEL_PEDIDO;
        if (cliente == null)
            return ERROR_CLIENTE;
        return VALIDACION_EXITO;
    }
    
    public String crearPedido(LocalDate fecha, LocalTime hora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente cliente){
        String proceso = corroborarDatos(fecha, hora, productosDelPedido, cliente);
        
        LocalDateTime fechaYHora = LocalDateTime.of(fecha, hora);
        if (proceso.equals(VALIDACION_EXITO)){
            cantidadDePedidos++;
            Pedido p = new Pedido(cantidadDePedidos, fechaYHora, productosDelPedido, cliente);
            GestorPedidos.pedidos.add(p);
            cliente.agregarPedido(p);
        }
        return VALIDACION_EXITO;
    }
    
    public String cambiarEstado(Pedido pedidoAModificar){
        switch (pedidoAModificar.verEstado()){
            case Estado.CREADO -> pedidoAModificar.asignarEstado(Estado.PROCESANDO);
            case Estado.PROCESANDO -> pedidoAModificar.asignarEstado(Estado.ENTREGADO);
            default -> {
                return ERROR_ESTADO;
            }
        }
        return VALIDACION_EXITO;
    }
    
    public ArrayList<Pedido> verPedidos(){
        return GestorPedidos.pedidos;
    }
    
    public boolean hayPedidosConEsteCliente(Cliente cliente){
        for (Pedido p : pedidos){
            if (p.verCliente().equals(cliente))
                return true;
        }
        return false;
    }
    
    public boolean hayPedidosConEsteProducto(Producto producto){
        for (Pedido p : pedidos){
            for (ProductoDelPedido pdp : p.verProductoDelPedido()){
                if (pdp.verProducto().equals(producto))
                    return true;
            }
        }
        return false;
    }
    
    public boolean existeEstePedido(Pedido pedido){
        for (Pedido p : pedidos){
            if (p.equals(pedido))
                return true;
        }
        return false;
    }
    
    public Pedido obtenerPedido(Integer numero){
        for (Pedido p: pedidos){
            if (p.verNumero() == numero)
                return p;
        }
        return null;
    }

    public String cancelarPedido(Pedido unPedido2) {
        for (Pedido p: pedidos){
            if (p.equals(unPedido2)){
                p.verCliente().cancelarPedido(unPedido2);
                return EXITO;
            }
        }
        return PEDIDO_INEXISTENTE;
    }
}
