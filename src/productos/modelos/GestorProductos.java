/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class GestorProductos {
       //Declaracion de variables
       private ArrayList<Producto> productos = new ArrayList<>();
       private static GestorProductos gestor;
       
       //Constructor privado de la clase
       private GestorProductos(){
           
       }
       
       //Metodo estatico para crear una sola instancia de la clase
       public static GestorProductos instanciar(){
           if(gestor == null){
               GestorProductos gestor = new GestorProductos();
           }
           return gestor;
       }
       
       //Devuelve todos los productos guardados
       public ArrayList<Producto> menu(){
           return productos;
       }
       
       //Busca si es que el producto a buscar esta guardado en el menu
       public boolean existeEsteProducto(Producto producto){
           if(this.productos.contains(producto)){
               return true;
           }
           else{
               return false;
           }
       }
       
       //Busca el producto con el codigo asignado, si no esta devuelve null
       public Producto obtenerProducto(Integer codigo){
           
       }
}
