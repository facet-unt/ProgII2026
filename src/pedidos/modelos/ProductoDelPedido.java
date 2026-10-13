/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import productos.modelos.Producto;

/**
 *
 * @author Cubanox
 */
public class ProductoDelPedido {
    private Producto unProducto;
    private int cantidad;
    
    public ProductoDelPedido(int cantidad){
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
}
