/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public class ProductoDelPedido {
    private int cantidad;
    //Relacion con Producto
    private Producto unProducto;

    public ProductoDelPedido(Producto unProducto, int cantidad) {
        this.unProducto = unProducto;
        this.cantidad = cantidad;
    }
    
    public int verCantidad() {
        return cantidad;
    }

    public Producto verProducto(){
        return unProducto;
    }

    @Override
    public String toString() {
        return unProducto.toString() + cantidad;
    }
    
    
}
