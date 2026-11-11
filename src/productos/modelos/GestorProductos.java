/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author Home
 */
public class GestorProductos {
    
    public static final String EXITO =  "El producto fue creado con exito" ;
    public static final String EXITO_MOD =  "El producto correctamente modificado" ;
    public static final String ERROR = "El producto no pudo crearse correctamente, causa de error: " ;
    private static GestorProductos gestor;
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public static GestorProductos instanciar() {
        if (gestor == null){
         gestor = new GestorProductos();   
        }
        return gestor;
    }

    private GestorProductos(){    
    }   

    public String crearProducto(int codigo, String descripcion,float precio, Categoria categoria, Estado estado){
        if(codigo < 0){
            return( ERROR + "Codigo invalido");
        }
        if(descripcion == null || descripcion.isEmpty()){
            return( ERROR + "Descripcion invalida");
        }
        if(precio < 0){
            return( ERROR + "Precio invalido");
        }
        if(categoria == null){
            return( ERROR + "Categoria nula");
        }
        if(estado == null){
            return( ERROR + "Estado nula");
        }
        if(categoria == null){
            return( ERROR + "Categoria nula");
        }
        Producto producto = new Producto(codigo, descripcion, categoria, estado, precio);
        for(Producto p : productos){
                 if(p.equals(producto)) return( ERROR + "Producto duplicado");
        }
        return EXITO;
    }


    public String modificarProducto(Producto productoAModificar,int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo < 0){
            return( ERROR + "Codigo invalido");
        }
        if(descripcion == null || descripcion.isEmpty()){
            return( ERROR + "Descripcion invalida");
        }
        if(precio < 0){
            return( ERROR + "Precio invalido");
        }
        if(categoria == null){
            return( ERROR + "Categoria nula");
        }
        if(estado == null){
            return( ERROR + "Estado nula");
        }
        if(categoria == null){
            return( ERROR + "Categoria nula");
        }
        // podria crear un nuevo producto sobrescribiendo el modificado?
        // hay alguna forma de que no modifique todo?
        return EXITO_MOD;
    }
    
    
    public ArrayList<Producto> menu(){
        return productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> productosBuscados = new ArrayList<>();
        for(Producto p : productos){
            if(p.verDescripcion().equals(descripcion)){
                productosBuscados.add(p);
            }
        }
        return productosBuscados;
    }
    
    public boolean existeEsteProducto(Producto producto){
        for(Producto p : productos){
            if(p.equals(producto)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> productosBuscados = new ArrayList<>();
        for(Producto p : productos){
            if(p.verCategoria().equals(categoria.toString())){
                productosBuscados.add(p);
            }
        }
        return productosBuscados;
    }
    
    public Producto obtenerProducto(Integer codigo){
        for(Producto p : productos){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;        
    }


}
        
