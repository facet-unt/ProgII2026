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
    private float precio;
    
    //Relacion:Un producto tiene una categoria y un estado.
    private Categoria categoria;
    private Estado estado;

    //<editor-fold defaultstate="collapsed" desc="Metodos 'ver/mostrar'">
    public int verCodigo() {
        return codigo;
    }
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    public String verDescripcion() {
        return descripcion;
    }
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public float verPrecio() {
        return precio;
    }
        public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
        
    public Categoria verCategoria() {
        return categoria;
    }
    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    public Estado verEstado() {
        return estado;
    }
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos 'equals' y 'hashCode'">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
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
    //</editor-fold>
    
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar() {        
        System.out.println("Producto "+verCodigo()+" "+verDescripcion());
            System.out.println("Categoria: "+verCategoria()+" Estado: "+verEstado()+" Precio: "+verPrecio());
    }
    
    @Override
    public String toString(){
        return "Producto: " + descripcion;
    }
    
}
