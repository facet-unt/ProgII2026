/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.Collections;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author LUCRECIA
 */
public class GestorProductos implements IGestorProductos {
    ArrayList<Producto> productos =new ArrayList<>();
    private static GestorProductos gestor; 
 
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
    @Override
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
    @Override
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
    @Override
    public ArrayList<Producto> menu(){
        Collections.sort(productos);
        return productos;
    }
    
    /**
     * Busca los productos cuya descripción coincida, total o parcialmente, con la especificada.
     * @param descripcion La descripción del producto.
     * @return Un ArrayList de productos coincidentes.
     */
    @Override
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> productosCoincidentes= new ArrayList<>();
        for(Producto p: productos){
            if(p.verDescripcion() != null && p.verDescripcion().contains(descripcion))
                productosCoincidentes.add(p);
        }
        Collections.sort(productosCoincidentes);
        return productosCoincidentes;
    }
    
    /**
     * Devuelve true si existe el producto especificado, false en caso contrario.
     * @param producto Un producto.
     * @return Un boolean.
     */
    @Override
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    /**
     * Devuelve los productos con la categoría especifiacada.
     * @param categoria La categoría del producto.
     * @return Un ArrayList de productos.
     */
    @Override
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> productosCoincidentes = new ArrayList<>();
        for(Producto p: productos){
            if(p.verCategoria().equals(categoria))
                productosCoincidentes.add(p);
        }
        Collections.sort(productosCoincidentes);
        return productosCoincidentes;
    }
    
    /**
     * Obtiene el producto con el código especificado. Si no hay un producto con ese código, devuelve null.
     * @param codigo El código del producto.
     * @return Null.
     */
    @Override
    public Producto obtenerProducto(Integer codigo){
        for(Producto p: productos){
            if(p.verCodigo()==codigo)
                return p;
        }
        return null;
    }
    
    /**
     * Borra un producto siempre y cuando no haya pedidos con el mismo.
     * @param producto Un producto.
     * @return Cadena con el resultado de la operación.
     */
    @Override
    public String borrarProducto(Producto producto){
        if (producto == null || !productos.contains(producto)) {
        return PRODUCTO_INEXISTENTE; 
        }
        
        IGestorPedidos gp = GestorPedidos.instanciar();
        if(gp.hayPedidosConEsteProducto(producto))
            return ERROR_BORRAR;
        productos.remove(producto);
        return EXITO_BORRAR;
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
    

