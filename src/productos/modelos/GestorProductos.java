/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class GestorProductos implements IGestorProductos{
       //Declaracion de variables o atributos
       private ArrayList<Producto> productos = new ArrayList<>();
       private static GestorProductos gestor;

       //Constructor privado de la clase
       private GestorProductos(){
           
       }
       
       //Metodo estatico para crear una sola instancia de la clase
       public static GestorProductos instanciar(){
           if(gestor == null){
               gestor = new GestorProductos();
           }
           return gestor;
       }
       
       public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
           String validacionDatos = this.validarDatos(codigo, descripcion, precio, categoria, estado);
           
           if(!validacionDatos.equals(VALIDACION_EXITO)){
               return validacionDatos;
           }
           
           Producto unProducto = new Producto(codigo, descripcion, categoria, estado, precio);
           
           if(this.existeEsteProducto(unProducto)){
               return "El Producto ya existe";
           }
           this.productos.add(unProducto);
           
           return EXITO;
       }
       
       public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
           if(this.existeEsteProducto(productoAModificar)){
               return PRODUCTO_INEXISTENTE;
           }
           
           productoAModificar.asignarDescripcion(descripcion);
           productoAModificar.asignarCategoria(categoria);
           productoAModificar.asignarPrecio(precio);
           productoAModificar.asignarEstado(estado);          
           
           productos.add(productoAModificar);
           return EXITO;
       }
       
       
       
       private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
           if(codigo <= 0)
               return ERROR_CODIGO;
           if(descripcion == null || descripcion.isEmpty())
               return ERROR_DESCRIPCION;
           if(precio <= 0.0)
               return ERROR_PRECIO;
           if(categoria == null)
               return ERROR_CATEGORIA;
           if(estado == null)
               return ERROR_ESTADO;
           
           return VALIDACION_EXITO;
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
           for(Producto pd : productos){
               if(pd.verCodigo() == codigo)
                   return pd;              
           }
           return null;
       }
       
       //Metodo que busca productos que coincidan con la categoria buscada, que luego 
       //los guarda en un arraylist que sera devuelto
       public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
           ArrayList<Producto> lista = new ArrayList<>();
           
           for(int i = 0; i < productos.size(); i++){
               
               Producto p = productos.get(i);
               
               if(p.verCategoria().equals(categoria)){
                   lista.add(p);
               }
           }
           
           return lista;
       }
       
       public ArrayList<Producto> buscarProductos(String descripcion){
           ArrayList<Producto> listaProductos = new ArrayList<>();
           
           for(Producto pd : productos){
               if(pd.verDescripcion().toLowerCase().equals(descripcion.toLowerCase()))
                   listaProductos.add(pd);
           }
           
           return listaProductos;
       }

    @Override
    public String borrarProducto(Producto producto) {
        if(productos.contains(producto)){
            productos.remove(producto);
            return EXITO_AL_BORRAR;
        }
        
        return PRODUCTO_INEXISTENTE;
    }
       
       
}

