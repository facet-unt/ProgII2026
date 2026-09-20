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
    public float precio;
    public boolean disponible;
    public String categoria;
    
    public void mostrar() {        
        System.out.println(descripcion);
        System.out.println(precio);
        System.out.println(categoria);
        System.out.println(disponible);
        System.out.println(codigo);
    }
    
    
}
