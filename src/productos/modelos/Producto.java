/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author luis
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

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

    public String verCategoria() {
        return categoria;
    }

    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String verEstado() {
        return estado;
    }

    public void asignarEstado(String estado) {
        this.estado = estado;
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
    public void mostrar() {        
        System.out.println("**********Producto**********");
        System.out.println("Codigo: " + codigo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Categoria: " + categoria);
        System.out.println("Estado: DISPONIBLE(true)/AGOTADO(false) --> " + estado);
        System.out.println("Precio: $" + precio);    
    }
    
//    public void mostrar() {    
//        System.out.printf("\n\tProducto <Codigo %d>: \n||Descripcion: %s\n||Categoria: %s\n||Estado: %s\n||Precio: %.2f\n",codigo ,descripcion,categoria, estado, precio);
//   
//    }
    
    @Override
    public String toString(){
        return "Descripcion del producto " + descripcion;
     
    }
}
