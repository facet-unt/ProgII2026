/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import java.util.List;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
/**
 *
 * @author Home
 */
public class GestorProductos implements IGestorProductos {
    
    private static GestorProductos gestor;
    private List<Producto> productos = new ArrayList<>();
    
    public static GestorProductos instanciar() {
        if (gestor == null){
         gestor = new GestorProductos();   
        }
        return gestor;
    }

    private GestorProductos(){    
    }   
@Override
    public String crearProducto(int codigo, String descripcion,float precio, Categoria categoria, Estado estado){
        if(codigo < 0){
            return ERROR_CODIGO;
        }
        if(descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio < 0){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
      
        Producto producto = new Producto(codigo, descripcion, categoria, estado, precio);
        for(Producto p : productos){
                 if(p.equals(producto)) return PRODUCTOS_DUPLICADOS;
        }
        this.productos.add(producto);
        return EXITO;
    }

@Override
    public String modificarProducto(Producto productoAModificar,int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(codigo < 0){
            return ERROR_CODIGO;
        }
        if(descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio < 0){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
       
        // podria crear un nuevo producto sobrescribiendo el modificado?
        // hay alguna forma de que no modifique todo?
        return EXITO;
    }
    
@Override  
    public List<Producto> menu(){
        return productos;
    }
 @Override   
    public List<Producto> buscarProductos(String descripcion){
        List<Producto> productosBuscados = new ArrayList<>();
        for(Producto p : productos){
            if(p.verDescripcion().equals(descripcion)){
                productosBuscados.add(p);
            }
        }
        return productosBuscados;
    }
 @Override   
    public boolean existeEsteProducto(Producto producto){
        for(Producto p : productos){
            if(p.equals(producto)){
                return true;
            }
        }
        return false;
    }
 @Override   
    public List<Producto> verProductosPorCategoria(Categoria categoria){
        List<Producto> productosBuscados = new ArrayList<>();
        for(Producto p : productos){
            if(p.verCategoria().equals(categoria.toString())){
                productosBuscados.add(p);
            }
        }
        return productosBuscados;
    }
@Override    
    public Producto obtenerProducto(Integer codigo){
        for(Producto p : productos){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;        
    }

public String borrarProducto(Producto producto) {
    if (producto == null || !this.productos.contains(producto)) {
        return PRODUCTO_INEXISTENTE;
    }

    IGestorPedidos gp = GestorPedidos.instanciar();
    if (gp.hayPedidosConEsteProducto(producto)) {
        return ERROR_BORRAR_PRODUCTO;
    }

    this.productos.remove(producto);
    return PRODUCTO_BORRADO;
}
}
        