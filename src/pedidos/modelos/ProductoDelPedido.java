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
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.unProducto);
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
        return "Producto: "+unProducto.verDescripcion()+" - Cant: " + cantidad;
    }
    
    public void mostrarPDP(){
        System.out.println("[" + unProducto.verCodigo() + "] " + unProducto.verDescripcion() + "\t\t\t\t" + cantidad);
    }
    
}
