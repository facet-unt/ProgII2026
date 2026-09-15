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
    public String estado;
    public String categoria;
    
    public void mostrar() {        
        System.out.println(descripcion);
        System.out.println(precio);
        System.out.println(categoria);
        System.out.println(estado);
        System.out.println(codigo);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + ", categoria=" + categoria + '}';
    }
    
    
}
