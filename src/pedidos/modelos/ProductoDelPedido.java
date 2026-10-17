/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.Objects;
import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public class ProductoDelPedido {
    private int cantidad;
    private Producto unProducto;

    public ProductoDelPedido(Producto unProducto, int cantidad) {
        this.cantidad = cantidad;
        this.unProducto = unProducto;
    }

    public int verCantidad() {
        return cantidad;
    }
    
    public void asginarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto verUnProducto() {
        return unProducto;
    }

    public void asignarUnProducto(Producto unProducto) {
        this.unProducto = unProducto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.unProducto);
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
        return Objects.equals(this.unProducto, other.unProducto);
    }

    @Override
    public String toString() {
        return unProducto.verDescripcion() + "- Cantidad: " + cantidad;
    }
    
}
