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
    private Categoria categoria;
    private EstadoProducto estado;
    private float precio;

    public int verCodigo() {
        return codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public Categoria verCategoria() {
        return categoria;
    }

    public EstadoProducto verEstado() {
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

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
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
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    }

    

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    public Producto(int codigo, String descripcion,Categoria categoria, EstadoProducto estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    
    
    public void mostrar() {        
        System.out.println("Producto: " + descripcion + " |Codigo: " + codigo );
        System.out.println("Estado: " + estado + " | Precio: " + precio);
        System.out.println("Categoria: " + categoria +"\n");
    }
    
    @Override
    public String toString(){
        return  "[1]" + descripcion + "\t" +     precio;
    }
    
}
