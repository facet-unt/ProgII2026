/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;
import productos.modelos.Producto;

/**
 *
 * @author lourdes
 */
public class ProductoDelPedido {
    

    private int cantidad;
    private Producto producto;

    public ProductoDelPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }

        if (!(objeto instanceof ProductoDelPedido)) {
            return false;
        }

        ProductoDelPedido otro = (ProductoDelPedido) objeto;

        return producto.equals(otro.producto);
    }

    @Override
    public int hashCode() {
        return producto.hashCode();
    }

    @Override
    public String toString() {
        return producto.toString() + " Cantidad: " + cantidad;
    }
    
}


