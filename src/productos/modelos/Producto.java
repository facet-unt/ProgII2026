/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;

    public int verCodigo() {
        return codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public String verCategoria() {
        return categoria;
    }

    public String verEstado() {
        return estado;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    
    
    public void mostrar() {        
        System.out.println("Producto: "+descripcion +" Codigo: " +codigo );
        System.out.println("Estado: "+estado +" | Precio: " +precio+ "\n");
    }
    
    @Override
    public String toString(){
        return "Producto:" + descripcion;
    }
    
}
