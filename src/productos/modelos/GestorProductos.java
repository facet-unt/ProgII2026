package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.GestorPedidos;

public class GestorProductos implements IGestorProductos {
  private GestorProductos() {
    productos = new ArrayList<>();
  };

  public static GestorProductos instanciar() {
    if (gestor == null) {
      gestor = new GestorProductos();
    }
    return gestor;
  }

  public String crearProducto(
      int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
    String validacion = validarProducto(codigo, descripcion, precio, categoria, estado);
    if (!validacion.equals(VALIDACION_EXITO)) {
      return validacion;
    }

    productos.add(new Producto(codigo, descripcion, categoria, estado, precio));

    return EXITO;
  }

  public String modificarProducto(Producto productoAModificar, int codigo, String descripcion,
      float precio, Categoria categoria, Estado estado) {
    if (productoAModificar == null) {
      return PRODUCTO_INEXISTENTE;
    }
    String validacion = validarProducto(codigo, descripcion, precio, categoria, estado);
    if (!validacion.equals(VALIDACION_EXITO)) {
      return validacion;
    }

    int indice = this.productos.indexOf(productoAModificar);
    // indexOf devuelve -1 si no encuentra lo solicitado
    if (indice == -1) {
      return PRODUCTO_INEXISTENTE;
    }

    this.productos.get(indice).asignarCategoria(categoria);
    this.productos.get(indice).asignarCodigo(codigo);
    this.productos.get(indice).asignarDescripcion(descripcion);
    this.productos.get(indice).asignarEstado(estado);
    this.productos.get(indice).asignarPrecio(precio);

    return EXITO;
  }

  public ArrayList<Producto> menu() {
    return this.productos;
  }

  // Devuelve un arrayList con los productos que encajen con la descripcion dada.
  // Devuelve un arrayList vacio si no encuentra nada
  public ArrayList<Producto> buscarProductos(String descripcion) {
    ArrayList<Producto> resultado = new ArrayList<>();

    for (Producto p : this.productos) {
      if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())) {
        resultado.add(p);
      }
    }

    return resultado;
  }

  public boolean existeEsteProducto(Producto producto) {
    boolean resultado = false;

    if (this.productos.contains(producto)) {
      resultado = true;
    }

    return resultado;
  }

  public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
    ArrayList<Producto> resultado = new ArrayList<>();
    for (Producto p : productos) {
      if (p.verCategoria().equals(categoria)) {
        resultado.add(p);
      }
    }
    return resultado;
  }

  public Producto obtenerProducto(Integer codigo) {
    if (codigo == null) {
      return null;
    }

    Producto resultado = null;

    for (Producto p : productos) {
      if (Objects.equals(codigo, p.verCodigo())) {
        resultado = p;
      }
    }

    return resultado;
  }

  public String borrarProducto(Producto producto) {
    // Revisar primero que el producto no es nulo
    // y que se encuentre en el gestor
    if (producto == null) {
      return PRODUCTO_INEXISTENTE;
    }
    int indice = this.productos.indexOf(producto);
    if (indice == -1) {
      return PRODUCTO_INEXISTENTE;
    }

    // Si no es nulo y esta en el gestor, revisar
    // que no este en ningun pedido
    if (GestorPedidos.instanciar().hayPedidosConEsteProducto(producto)) {
      return ERROR_EN_PEDIDO;
    }

    // A esta altura se cumplen todos los requisitos de
    // validez para borrar, entonces borro
    this.productos.remove(producto);
    return BORRAR_EXITO;
  }

  // Revisa que:
  // -El codigo sea positivo
  // -La descripcion no sea nula o cadena vacia
  // -El precio es positivo
  // -El estado no sea nulo
  // -La categoria no sea nula
  private String validarProducto(
      int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
    if (codigo <= 0) {
      return ERROR_CODIGO;
    }
    if (descripcion == null || descripcion.isBlank()) {
      return ERROR_DESCRIPCION;
    }
    if (precio <= 0) {
      return ERROR_PRECIO;
    }
    if (categoria == null) {
      return ERROR_CATEGORIA;
    }
    if (estado == null) {
      return ERROR_ESTADO;
    }

    for (Producto p : productos) {
      if (p.verCodigo() == codigo) {
        return PRODUCTOS_DUPLICADOS;
      }
    }

    return VALIDACION_EXITO;
  }

  private ArrayList<Producto> productos;
  private static GestorProductos gestor;
}
