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
    
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar() {    
        System.out.printf("\n\tProducto <Codigo %d>: \n||Descripcion: %s\n||Categoria: %s\n||Estado: %s\n||Precio: %.2f\n",codigo ,descripcion,categoria, estado, precio);
   
    }
    
    @Override
    public String toString(){
        return "Descripcion del producto " + descripcion;
     
    }
    public void asignarDescripcion(String descripcion){
        this.descripcion = descripcion;
    } 
    public float verPrecio(){
        return this.precio;
    }
    public void asignarPrecio(float precio){
        this.precio = precio;
    } 
}

