/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import productos.modelos.Producto;

/**
 *
 * @author Arebalo
 */
public class ProductoDelPedido {
    private Producto producto;
    private int cantidad;

    public Producto verProducto() {
        return producto;
    }

    
    public String verDescripcion() {
        return producto.verDescripcion();
    }

    public int verCodigo() {
        return producto.verCodigo();
    }

    public float verPrecio() {
        return producto.verPrecio();
    }

    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }

    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    public ProductoDelPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
