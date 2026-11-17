package interfaces;

import java.util.List;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;

public interface IGestorProductos {
  String crearProducto(
      int codigo, String descripcion, float precio, Categoria categoria, Estado estado);

  String modificarProducto(Producto productoAModificar, int codigo, String descripcion,
      float precio, Categoria categoria, Estado estado);

  List<Producto> menu();

  List<Producto> buscarProductos(String descripcion);

  String borrarProducto(Producto producto);

  boolean existeEsteProducto(Producto producto);

  List<Producto> verProductosPorCategoria(Categoria categoria);

  Producto obtenerProducto(Integer codigo);

  static final String EXITO = "Producto creado/modificado con éxito";
  static final String BORRAR_EXITO = "Producto borrado con éxito";
  static final String ERROR_CODIGO = "El código del producto es incorrecto";
  static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";
  static final String ERROR_PRECIO = "El precio del producto es incorrecto";
  static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
  static final String ERROR_ESTADO = "El estado del producto es incorrecto";
  static final String ERROR_EN_PEDIDO = "No se puede borrar el producto porque esta en un pedido";
  static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
  static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
  static final String VALIDACION_EXITO = "Los datos del producto son correctos";
}
