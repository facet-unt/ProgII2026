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
       //Declaracion de variables o atributos
       private ArrayList<Producto> productos = new ArrayList<>();
       private static GestorProductos gestor;
       public static final String EXITO = "Producto creado/modificado con éxito";
       public static final String ERROR_CODIGO = "El código del producto es incorrecto";
       public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
       public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
       public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
       public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
       public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
       public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
       public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
       
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
           
           productoAModificar.asignarCodigo(codigo);
           productoAModificar.asignarDescripcion(descripcion);
           productoAModificar.asignarCategoria(categoria);
           productoAModificar.asignarPrecio(precio);
           productoAModificar.asignarEstado(estado);
           
           Producto p2 = this.obtenerProducto(codigo);
           
           if(productoAModificar.equals(p2)){
               return PRODUCTOS_DUPLICADOS;
           }
           
           return EXITO;
       }
       
       
       
       private String validarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
           if(codigo < 0)
               return ERROR_CODIGO;
           if(descripcion.isEmpty() || descripcion == null)
               return ERROR_DESCRIPCION;
           if(precio < 0.0)
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
               if(pd.verCodigo() == codigo){
                   return pd;
               }
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
           
           for(int i = 0; i < productos.size(); i++){             
               Producto pd = productos.get(i);
               
               if(pd.verDescripcion().equals(descripcion)){
                   
                   listaProductos.add(pd);                   
               }                   
           }
           
           return listaProductos;
       }
       
       
}

