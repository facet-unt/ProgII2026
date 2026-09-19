/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

public class Producto {
    //Atributos
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    //Constructor
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar(){
        System.out.println("Codigo: " + codigo + "| Descripcion: " + descripcion + "| Categoria: " + categoria + "| Estado: " + estado + "| Precio: " + precio);
    }
@Override
    public String toString() {
        return this.descripcion;
    }
}
