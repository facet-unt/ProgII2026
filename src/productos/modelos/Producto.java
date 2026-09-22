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
    public int codigo;
    public String descripcion;
    public String categoria;
    public String estado;
    public float precio;
    
    public void mostrar() {        
        System.out.println("producto: "+descripcion +" codigo: " +codigo );
        System.out.println("estado: "+estado +" | precio: " +precio+ "\n");
    }
    
    @Override
    public String toString(){
        return "Producto:" + descripcion;
    }
    
}
