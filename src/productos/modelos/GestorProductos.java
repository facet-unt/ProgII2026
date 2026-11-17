/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Arebalo
 */
public class GestorProductos implements IGestorProductos{
    private static GestorProductos gestor;
    
    private ArrayList<Producto> productos = new ArrayList<>();
    
    
    
    private GestorProductos(){
    }
    public static GestorProductos instanciar(){
        if(gestor == null){
            gestor = new GestorProductos();
        }
        return gestor;
    }
    //Metodo para validar datos
    
    private String validarDatos(int codigo, String descripcion, float precio,Categoria categoria,Estado estado){
        if(codigo<=0){
            return ERROR_CODIGO;
        }
        if(descripcion == null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio<=0){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
        return EXITO;
    }
    //Metodo para crear producto
    
    @Override
    public String crearProducto(int codigo,String descripcion,float precio,Categoria categoria,Estado estado){
        String validacion = validarDatos(codigo,descripcion,precio,categoria,estado);
        if(!validacion.equals(EXITO)){
            return validacion;
        }
        Producto nuevoProducto = new Producto(codigo,descripcion.trim(),categoria,estado,precio);
        if(this.productos.contains(nuevoProducto)){
            return PRODUCTOS_DUPLICADOS;
        }
        this.productos.add(nuevoProducto);
        return EXITO;
    }
    
    //Modificar un producto existente si los nuevos datos son validos
    
    @Override
    public String modificarProducto(Producto productoAModificar,int codigo,String descripcion,float precio,Categoria categoria,Estado estado){
        if(productoAModificar == null || !this.productos.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        String validacion = validarDatos(codigo,descripcion,precio,categoria,estado);
        if (!validacion.equals(EXITO)){
            return validacion;
        }
        if(productoAModificar.verCodigo() != codigo){
            Producto aux = new Producto(codigo,descripcion,categoria,estado,precio);
            if (this.productos.contains(aux)){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        productoAModificar.asignarDescripcion(descripcion.trim());
        productoAModificar.asignarPrecio(precio);
        productoAModificar.setCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        return EXITO;
    
    }
         
    //Devolver todos los productos
    
    @Override
    public ArrayList<Producto> menu(){
        return this.productos;
    }
    
    //Buscar productos por descripcion
    
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> resultado = new ArrayList<>();
        if(descripcion == null || descripcion.trim().isEmpty()){
            return resultado;
        }
        String buscado = descripcion.trim().toLowerCase();
        for (Producto p : this.productos){
            if (p.verDescripcion() != null && p.verDescripcion().toLowerCase().contains(buscado)){
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    //Verificar si un producto existe
    
    @Override
    public boolean existeEsteProducto(Producto producto){
        if(producto == null){
            return false;
        }
        return this.productos.contains(producto);
    }
    
    //Devuelve los productos de una categoria
    
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> resultado = new ArrayList<>();
        if(categoria == null){
            return resultado;
        }
        for(Producto p : this.productos){
            if(p.verCategoria() == categoria){
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    //Obtener un producto por su codigo
    
    @Override
    public Producto obtenerProducto(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Producto p : this.productos){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    @Override
public String borrarProducto(Producto producto) {
    if (producto == null || !this.productos.contains(producto)) {
        return PRODUCTO_INEXISTENTE;
    }

    IGestorPedidos gp = GestorPedidos.instanciar();
    if (gp.hayPedidosConEsteProducto(producto)) {
        return ERROR_BORRAR;
    }

    this.productos.remove(producto);
    return EXITO;
}
}
