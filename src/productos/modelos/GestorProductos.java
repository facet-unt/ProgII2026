/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author Arebalo
 */
public class GestorProductos {
    private static GestorProductos gestor;
    
    private ArrayList<Producto> productos = new ArrayList<>();
    
    public static final String EXITO = "Producto creado/modificado con exito";
    public static final String ERROR_CODIGO = "El codigo del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoria del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese codigo";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
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
        productoAModificar.asignarCodigo(codigo);
        productoAModificar.asignarDescripcion(descripcion.trim());
        productoAModificar.asignarPrecio(precio);
        productoAModificar.setCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        return EXITO;
    
    }
         
    //Devolver todos los productos
    
    public ArrayList<Producto> menu(){
        return this.productos;
    }
    
    //Buscar productos por descripcion
    
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
    
    public boolean extisteEsteProducto(Producto producto){
        if(producto == null){
            return false;
        }
        return this.productos.contains(producto);
    }
    
    //Devuelve los productos de una categoria
    
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
}
