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
    
    public static final String EXITO = "Producto creado/modificado con exito.";
    public static final String ERROR_CODIGO = "El codigo del producto es incorrecto.";
    public static final String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta.";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto.";
    public static final String ERROR_CATEGORIA = "La categoria del producto es incorrecta.";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto.";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese codigo.";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos.";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado.";
    
    private GestorProductos(){
        
    }
    
    /**
     * Patrón Singleton.
     * @return El gestor.
     */
    
    public static GestorProductos instanciar(){
        if (gestor == null)
            gestor = new GestorProductos();
        return gestor;
    }
    
    /**
     * Crea un nuevo producto, devolviendo una cadena con el resultado de la operación.
     * @param codigo El código del producto.
     * @param descripcion La descripción del producto.
     * @param categoria La categoría del producto.
     * @param estado El estado del producto.
     * @param precio El precio del producto.
     * @return Una cadena de EXITO si se creó correctamente el producto.
     */
    public String crearProducto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio){
        String resultadoValidacion = validarDatos(codigo, descripcion, categoria, estado, precio, null);
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(p);
        return EXITO;
    }
    
    /**
     * Modifica el producto, devolviendo una cadena con el resultado de la operación.
     * @param productoAModificar Producto que se quiere modificar.
     * @param codigo El código del producto.
     * @param descripcion La descripción del producto.
     * @param precio El precio del producto.
     * @param categoria La categoría del producto.
     * @param estado El estado del producto.
     * @return Una cadena de VALIDACION_EXITO si se modificó correctamente el producto.
     */
    public String modificarProducto (Producto productoAModificar,int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        if(!productos.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        
        String resultadoValidacion = validarDatos(codigo, descripcion, categoria, estado, precio, productoAModificar);
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.set(productos.indexOf(productoAModificar), p);
        
        return VALIDACION_EXITO;
    }
    
    /**
     * Devuelve todos los productos.
     * @return 
     */
    public ArrayList<Producto> menu(){
        return productos;
    }
    
    /**
     * Busca los productos cuya descripción coincida, total o parcialmente, con la especificada.
     * @param descripcion La descripción del producto.
     * @return Un ArrayList de productos coincidentes.
     */
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> productosCoincidentes= new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion() != null && p.verDescripcion().contains(descripcion))
                productosCoincidentes.add(p);
        }
        return productosCoincidentes;
    }
    
    /**
     * Devuelve true si existe el producto especificado, false en caso contrario.
     * @param producto Un producto.
     * @return Un boolean.
     */
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    /**
     * Devuelve los productos con la categoría especifiacada.
     * @param categoria La categoría del producto.
     * @return Un ArrayList de productos.
     */
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> productosCoincidentes = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria().equals(categoria))
                productosCoincidentes.add(p);
        }
        return productosCoincidentes;
    }
    
    /**
     * Obtiene el producto con el código especificado. Si no hay un producto con ese código, devuelve null.
     * @param codigo El código del producto.
     * @return Null.
     */
    public Producto obtenerProducto(Integer codigo){
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
    }
    
    //Métodos para hacer los distintos controles
    private String validarDatos(int codigo, String descripcion, Categoria categoria, Estado estado, float precio, Producto productoAExcluir){
        if(codigo<1)
            return ERROR_CODIGO;
        
        if(codigoEsRepetido(codigo, productoAExcluir))
            return PRODUCTOS_DUPLICADOS;
        if(descripcion == null || descripcion.isBlank())
            return ERROR_DESCRIPCION;
        
        if(categoria == null)
            return ERROR_CATEGORIA;
        
        if(estado == null)
            return ERROR_ESTADO;
        
        if(precio <1)
            return ERROR_PRECIO;
        
        return VALIDACION_EXITO;
    }
    
    private boolean codigoEsRepetido (int codigo, Producto productoAExcluir){
        for(Producto p: productos){
            //Si el código coincide y no es el producto que estamos editando, está duplicado
            if(p.verCodigo() == codigo && !p.equals(productoAExcluir))
                return true;
        }
        return false;
    }
    
    
}
    

