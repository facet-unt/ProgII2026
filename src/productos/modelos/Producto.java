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
        System.out.println("|Producto|");
        System.out.println("Codigo: "+codigo+" Descripcion: "+descripcion+" Categoria: "+categoria);
        System.out.println("Estado: "+estado+" Precio: "+precio);
    }
    
    
}
