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
    private String nombre;
    private int codigo;
    private String descripcion;
    private float precio;
    
    //Relacion:Un producto tiene una categoria y un estado.
    private Categoria categoria;
    private Estado estado;

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
        
    public Estado verDisponible() {
        return estado;
    }
    public void asignarDisponible(Estado estado) {
        this.estado = estado;
    }
    
    public void asignarNombre(String nombre){
        this.nombre=nombre;
    }
    public String verNombre(){
        return nombre;
    }

    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = Categoria.POSTRE;  //valor por defecto
        this.estado = Estado.NODISPONIBLE;  //valor por defecto
        this.precio = precio;
        this.nombre = "ProductoExample";
    }
    
    public void mostrar() {        
        System.out.println("Nombre: "+nombre +" |Descripcion: " +descripcion +"\n");
        System.out.println("|Estado: "+estado +" | Precio: " +precio+ "\n");
        System.out.println("Codigo: "+codigo+"| Categoria: "+categoria);
    }
    
    @Override
    public String toString(){
        return "Producto: " + descripcion;
    }
    
}
