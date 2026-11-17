/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author luciano
 */
import java.util.List;
import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

public interface IGestorProductos {

    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto debe ser mayor a cero";
    public static final String ERROR_DESCRIPCION = "La descripción del producto no puede ser nula ni vacía";
    public static final String ERROR_PRECIO = "El precio del producto debe ser mayor a cero";
    public static final String ERROR_CATEGORIA = "La categoría del producto no puede ser nula";
    public static final String ERROR_ESTADO = "El estado del producto no puede ser nulo";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "No existe el producto especificado";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    public static final String PRODUCTO_BORRADO = "Producto borrado con éxito";
    public static final String ERROR_BORRAR_PRODUCTO = "No se puede borrar el producto porque tiene pedidos asociados";
    
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado);
    public List<Producto> menu();
    public List<Producto> buscarProductos(String descripcion);
    public String borrarProducto(Producto producto);
    public boolean existeEsteProducto(Producto producto);
    public List<Producto> verProductosPorCategoria(Categoria categoria);
    public Producto obtenerProducto(Integer codigo);
}

  