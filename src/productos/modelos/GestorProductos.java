/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author homep
 */
public class GestorProductos {
    private static final ArrayList<Producto> productos = new ArrayList<>();
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String ERROR_NO_ESTA = "El producto indicado no se encuentra instanciado";
    
    //=============================
    //      Singletone
    //=============================
    private static final GestorProductos instancia = new GestorProductos();
    private GestorProductos(){};
    
    public static GestorProductos instanciar(){
        return instancia;
    }
    
    //==============================
    //          Metodos
    //==============================
    private String CorroborarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if (codigo <= 0)
            return ERROR_CODIGO;
        if (descripcion == null || descripcion.isEmpty())
            return ERROR_DESCRIPCION;
        if (precio <= 0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        return EXITO;
    }
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        String proceso = CorroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (proceso.equals(EXITO)){
            Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
            if (productos.contains(p))
                return "Producto Repetido ingresado";
            productos.add(p);
        }
        return proceso;
    }
    
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        String proceso = CorroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (!productos.contains(productoAModificar))
            return ERROR_NO_ESTA;
        if (proceso.equals(EXITO)){
            Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
            productos.set(productos.indexOf(productoAModificar), p);
        }
        return proceso;
    }
    
    public ArrayList<Producto> menu(){
        return productos;
    }
    
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> pdp = new ArrayList<>();
        for (Producto p : productos){
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                pdp.add(p);
        }
        if (pdp.isEmpty())
            return null;
        return pdp;
    }
    
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> pdp = new ArrayList<>();
        for (Producto p : productos){
            if (p.verCategoria() == categoria)
                pdp.add(p);
        }
        if (pdp.isEmpty())
            return null;
        return pdp;
    }
    
    public Producto obtenerProducto(Integer codigo){
        for (Producto p: productos){
            if (p.verCodigo() == codigo.intValue()){       
                return p;
            }
        }
        return null;
    }
        
}
