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
    public boolean estado;
    public float precio;
    
    public void mostrar() {
        System.out.println("Codigo: "+codigo);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Categoria: "+categoria);
        System.out.println("Estado: "+estado);
        System.out.println("Precio: "+precio+"\n");
    }
    
    public String toString(){
        return "Descripcion: "+descripcion;
    }
    
}
