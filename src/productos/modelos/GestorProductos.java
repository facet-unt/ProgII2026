/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author LUCRECIA
 */
public class GestorProductos {
    ArrayList<Producto> productos =new ArrayList<>();
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
    
    private GestorProductos(){
        
    }
    
    public static GestorProductos instanciar(){
        if (gestor == null){
            gestor = new GestorProductos();
            return gestor;
        }
        System.out.println("gestor de productos ya existe");
        return null;
    }
    
    public String crearProducto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio){
        if(codigo<1){
            return ERROR_CODIGO;
        }
        if(codigoEsRepetido(codigo))
            return PRODUCTOS_DUPLICADOS;
        if(descripcion == null){
            return ERROR_DESCRIPCION;
        }else if(descripcion.isBlank()){
            return ERROR_DESCRIPCION;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
        if(precio <1){
            return ERROR_PRECIO;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(p);
        return EXITO;
    }
    
    private boolean codigoEsRepetido (int codigo){
        for(Producto p: productos){
            if(p.verCodigo() == codigo)
                return true;
        }
        return false;
    }
    
    public String modificarProducto (Producto productoAModificar,int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        if(!productos.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        if(codigo<0){
            return ERROR_CODIGO;
        }
        if(codigoEsRepetido(codigo)){
            return PRODUCTOS_DUPLICADOS;
        }
        if(descripcion.isBlank() || descripcion.isBlank()){
            return ERROR_DESCRIPCION;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
        if(precio <0){
            return ERROR_PRECIO;
        }
        Producto p = new Producto(productoAModificar.verCodigo(), descripcion, categoria, estado, precio);
        productos.set(productos.indexOf(productoAModificar), p);
        
        return VALIDACION_EXITO;
    }
    
    public ArrayList<Producto> menu(){
        return productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> productosCoincidentes= new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion() != null && p.verDescripcion().contains(descripcion))
                productosCoincidentes.add(p);
        }
        return productosCoincidentes;
    }
    
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> productosCoincidentes = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria().equals(categoria))
                productosCoincidentes.add(p);
        }
        return productosCoincidentes;
    }
    
    public Producto obtenerProducto(Integer codigo){
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
    }
    
}
    

