/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.util.Objects;
import productos.modelos.Producto;

/**
 *Representa los detalles de un pedido con respecto a la cantidad y el producto
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

    public Producto verProducto() {
        return unProducto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.unProducto);
        return hash;
    }
    
    /**
     * compara un objeto con otro para verificar su igualdad segun el producto.
     * @param obj a comparar con el producto
     * @return true si ambos objetos son de la misma clase y tienen el mismo producto,si no devuelve false
     */
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

    /**
     * @return String en formato solicitado
     */
    @Override
    public String toString() {
        return "Producto: " + unProducto.verDescripcion() + " - Cant: " + cantidad;
    }

    /**
     * muestra por pantalla los productos de la lista con el formato correcto
     */
    public void mostrarPDP() {
        System.out.println("[" + unProducto.verCodigo() + "] " + unProducto.verDescripcion() + "\t\t$" + unProducto.verPrecio() + "\t\t\t" + cantidad);
    }

}
