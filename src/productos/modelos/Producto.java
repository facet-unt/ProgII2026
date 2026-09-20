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
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    
    public void mostrar() {    
        System.out.printf("\n\tProducto <Codigo %d>: \n||Descripcion: %s\n||Categoria: %s\n||Estado: %s\n||Precio: %.2f\n",codigo ,descripcion,categoria, estado, precio);
   
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
