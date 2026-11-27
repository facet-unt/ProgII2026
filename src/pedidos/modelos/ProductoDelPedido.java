/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.Locale;
import java.util.Objects;
import productos.modelos.Producto;

/**
 *
 * @author Arebalo
 * @author Peralta
 */
public class ProductoDelPedido {
    private Producto producto;
    private int cantidad;
    
//=================================================================================
//                              Constructor
//=================================================================================    
    public ProductoDelPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto verProducto() {
        return producto;
    }

    public int verCantidad() {
        return cantidad;
    }

    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String verDescripcion() {
        if (producto != null && producto.verDescripcion() != null) {
            return producto.verDescripcion();
        }
        return "-";
    }

    public int verCodigo() {
        return(producto != null) ? producto.verCodigo() : 0;
    }

    public float verPrecio() {
        return(producto != null) ? producto.verPrecio() : 0.0f;
    }

    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }


    public void mostrar() {
        if (producto != null) {
            String desc = (producto.verDescripcion() != null) ? producto.verDescripcion() : "-";
            String precioFormateado = String.format(Locale.US, "$%.2f", producto.verPrecio());
            System.out.println("Producto: [" + producto.verCodigo() + "] " + desc + " - Precio: " + precioFormateado + " - Cantidad: " + cantidad);
        }else{
            System.out.println("Producto: - Cantidad: " +cantidad);
        }
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.producto);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDelPedido other = (ProductoDelPedido) obj;
        return Objects.equals(this.producto, other.producto);
    }


    @Override
    public String toString() {
        if (producto != null) {
            String desc = (producto.verDescripcion() != null) ? producto.verDescripcion() : "-";
            String precioFormateado = String.format(Locale.US, "$%.2f", producto.verPrecio());
            return "[" + producto.verCodigo() + "] " + desc + " " + precioFormateado + " (" + cantidad + ")";
        }
        return "- (" + cantidad + ")";
    }
}
