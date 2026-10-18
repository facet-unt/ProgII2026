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
    private Producto unProducto;
    private int cantidad;
    
    @Override
    public String toString() {
        return "Producto: " + this.verProducto() + " - Cant: " + this.cantidad;
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
    
    
    
    public ProductoDelPedido(Producto unProducto, int cantidad){
        this.unProducto = unProducto;
        this.cantidad = cantidad;
    }
    
    public String verProducto(){
        return unProducto.verDescripcion();
    }
    public int verCodigo(){
        return unProducto.verCodigo();
    }
    public float verPrecio(){
        return unProducto.verPrecio();
    }
    /**
     * @return the cantidad
     */
    public int verCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void mostrar(){
        System.out.println("["+ unProducto.verCodigo() + "] "+unProducto.verDescripcion()+ "    $"+ String.format("%.2f",unProducto.verPrecio()) + "             " +  this.cantidad);
    }
}
