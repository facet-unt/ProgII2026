/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

/**
 *
 * @author Usuario
 */
public interface IGestorProductos {
    String EXITO = "Producto creado/modificado/eliminado con exito";
    String ERROR_CODIGO = "El codigo del producto es incorrecto";
    String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta";
    String ERROR_PRECIO = "El precio del producto es incorrecto";
    String ERROR_CATEGORIA = "La categoria del producto es incorrecta";
    String ERROR_ESTADO = "El estado del producto es incorrecto";
    String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese codigo";
    String VALIDACION_EXITO = "Los datos del producto son correctos";
    String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    String ERROR_ELIMINAR = "El producto no se pudo eliminar correctamente";
   
    String crearProducto(int codigo, String descripcion, float precio, Categoria categoria,Estado estado);
    String modificarProducto(Producto productoAModificar, int codigo, String descripcion, 
    float precio, Categoria categoria, Estado estado); 
    List<Producto> menu(); 
    List<Producto> buscarProductos(String descripcion); 
    String borrarProducto(Producto producto); 
    boolean existeEsteProducto(Producto producto); 
    List<Producto> verProductosPorCategoria(Categoria categoria); 
    Producto obtenerProducto(Integer codigo); 
}
