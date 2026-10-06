/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.ArrayList;
import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public class ProductoDelPedido {
    private int cantidad;
    //private Pedido unPedido;

    ArrayList<Producto> productos = new ArrayList<>();

     
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private static final System.Logger LOG = System.getLogger(ProductoDelPedido.class.getName());

    public ProductoDelPedido(int cantidad) {
        this.cantidad = cantidad;
    }
    
     
}
