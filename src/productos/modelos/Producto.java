/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
 * this license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package productos.modelos;

/**
 *
 * @author luis
 */
public class Producto {
    public Producto(int codigo, String descripcion, String categoria, String estado,
                    float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println(descripcion);
        System.out.println(precio);
        System.out.println(categoria);
        System.out.println(estado);
        System.out.println(codigo);
    }

    // Getters
    public int verCodigo() { return this.codigo; }
    public String verDescripcion() { return this.descripcion; }
    public String verCategoria() { return this.categoria; }
    public String verEstado() { return this.estado; }
    public float verPrecio() { return this.precio; }

    // Setters
    public void asignarCodigo(int nuevoCodigo) { this.codigo = nuevoCodigo; }
    public void asignarDescripcion(String nuevaDescripcion) {
        this.descripcion = nuevaDescripcion;
    }
    public void asignarCategoria(String nuevaCategoria) {
        this.categoria = nuevaCategoria;
    }
    public void asignarEstado(String nuevoEstado) { this.estado = nuevoEstado; }
    public void asignarPrecio(float nuevoPrecio) { this.precio = nuevoPrecio; }

    @Override public String toString() { return this.descripcion; }

    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
}
