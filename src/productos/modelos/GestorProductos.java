/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;
import java.util.List;
import interfaces.IGestorProductos;
import pedidos.modelos.GestorPedidos;
import java.util.Collections;
/**
 *
 * @author lourdes
 */
public class GestorProductos implements IGestorProductos {

    private static GestorProductos instancia;
    private List<Producto> productos;
    
    public static final String EXITO = "Producto creado/modificado con éxito";

    public static final String ERROR_CODIGO = "El código del producto es incorrecto";

    public static final String ERROR_DESCRIPCION = "La descripción del producto es incorrecta";

    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";

    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";

    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";

    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";

    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";

    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

    private GestorProductos() {
        productos = new ArrayList<>();
    }

    public static GestorProductos instanciar() {
        if (instancia == null) {
            instancia = new GestorProductos();
        }
        return instancia;
    }

    private boolean validarCodigo(int codigo) {
        return codigo > 0;
    }

    private boolean validarDescripcion(String descripcion) {
        return descripcion != null && !descripcion.isEmpty();
    }

    private boolean validarPrecio(float precio) {
        return precio > 0;
    }

    private boolean validarCategoria(Categoria categoria) {
        return categoria != null;
    }

    private boolean validarEstado(Estado estado) {
        return estado != null;
    }

    public String crearProducto(int codigo, String descripcion,
            float precio, Categoria categoria, Estado estado) {

        if (!validarCodigo(codigo)) {
            return ERROR_CODIGO;
        }

        if (!validarDescripcion(descripcion)) {
            return ERROR_DESCRIPCION;
        }

        if (!validarPrecio(precio)) {
            return ERROR_PRECIO;
        }

        if (!validarCategoria(categoria)) {
            return ERROR_CATEGORIA;
        }

        if (!validarEstado(estado)) {
            return ERROR_ESTADO;
        }
        for (Producto producto : productos) {
            if (producto.verCodigo() == codigo) {
                return PRODUCTOS_DUPLICADOS;
            }
        }
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);

        productos.add(nuevoProducto);

        return EXITO;

    }

   @Override
public List<Producto> menu() {
    List<Producto> productosOrdenados = new ArrayList<>(productos);

    Collections.sort(productosOrdenados, (p1, p2) -> {
        int resultado = p1.verCategoria().compareTo(p2.verCategoria());

        if (resultado == 0) {
            return p1.verDescripcion().compareTo(p2.verDescripcion());
        }

        return resultado;
    });

    return productosOrdenados;
}

    public Producto obtenerProducto(Integer codigo) {
        for (Producto producto : productos) {
            if (producto.verCodigo() == codigo) {
                return producto;
            }
        }
        return null;
    }

   public List<Producto> verProductosPorCategoria(Categoria categoria) {
    List<Producto> productosBuscados = new ArrayList<>();

    for (Producto producto : productos) {
        if (producto.verCategoria().equals(categoria)) {
            productosBuscados.add(producto);
        }
    }

    Collections.sort(productosBuscados,
        (p1, p2) -> p1.verDescripcion().compareTo(p2.verDescripcion())
    );

    return productosBuscados;
}

    public String modificarProducto(Producto productoAModificar, int codigo,
            String descripcion, float precio, Categoria categoria, Estado estado) {

        if (!productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }

        if (!validarDescripcion(descripcion)) {
            return ERROR_DESCRIPCION;
        }

        if (!validarPrecio(precio)) {
            return ERROR_PRECIO;
        }

        if (!validarCategoria(categoria)) {
            return ERROR_CATEGORIA;
        }

        if (!validarEstado(estado)) {
            return ERROR_ESTADO;
        }

        productoAModificar.asignarDescripcion(descripcion);
        productoAModificar.asignarPrecio(precio);
        productoAModificar.asignarCategoria(categoria);
        productoAModificar.asignarEstado(estado);

        return EXITO;
    }

    public List<Producto> buscarProductos(String descripcion) {
    List<Producto> productosBuscados = new ArrayList<>();

    for (Producto producto : productos) {
        if (producto.verDescripcion().contains(descripcion)) {
            productosBuscados.add(producto);
        }
    }

    Collections.sort(productosBuscados, (p1, p2) -> {
        int resultado = p1.verCategoria().compareTo(p2.verCategoria());

        if (resultado == 0) {
            return p1.verDescripcion().compareTo(p2.verDescripcion());
        }

        return resultado;
    });

    return productosBuscados;
}
    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    @Override
    public String borrarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            return PRODUCTO_INEXISTENTE;
        }

        if (GestorPedidos.instanciar().hayPedidosConEsteProducto(producto)) {
            return "No se puede borrar el producto porque tiene pedidos asociados";
        }

        productos.remove(producto);
        return "Producto eliminado con éxito";
    }
}
