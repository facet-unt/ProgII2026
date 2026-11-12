/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import interfaces.IGestorPedidos;
import java.time.LocalDate;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String cambiarEstado(Pedido pedidoAModificar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
    
}
