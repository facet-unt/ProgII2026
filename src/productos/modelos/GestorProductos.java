/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import static interfaces.IGestorProductos.ERROR_CATEGORIA;
import static interfaces.IGestorProductos.ERROR_CODIGO;
import static interfaces.IGestorProductos.ERROR_DESCRIPCION;
import static interfaces.IGestorProductos.ERROR_ESTADO;
import static interfaces.IGestorProductos.ERROR_PRECIO;
import static interfaces.IGestorProductos.EXITO;
import static interfaces.IGestorProductos.PRODUCTOS_DUPLICADOS;
import static interfaces.IGestorProductos.PRODUCTO_INEXISTENTE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Usuario
 */
public class GestorProductos implements IGestorProductos{

    List<Producto> productos = new ArrayList<>();

    //Variable de clase privada
    private static GestorProductos gestor;
    
    //Contructor privado
    private GestorProductos() {
        productos = new ArrayList<>();
    }

    //Metodo de clase publico
    public static GestorProductos instanciar() {
        if (gestor == null) {
            gestor = new GestorProductos();
        }
        return gestor;
    }

    /**
     * Crea un nuevo producto, devolviendo una cadena con el resultado de la
     * operacion
     *
     * @param codigo
     * @param descripcion
     * @param precio
     * @param categoria
     * @param estado
     * @return
     */
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return PRODUCTOS_DUPLICADOS;
            }
        }
        
        if (codigoInvalido(codigo)) {
            return ERROR_CODIGO;
        }

        if (desripcionInvalida(descripcion)) {
            return ERROR_DESCRIPCION;
        }

        if (precioInvalido(precio)) {
            return ERROR_PRECIO;
        }

        if (categoriaInvalida(categoria)) {
            return ERROR_CATEGORIA;
        }

        if (estadoInavlido(estado)) {
            return ERROR_ESTADO;
        }
        Producto nuevoProducto = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(nuevoProducto);
        return EXITO;
    }

    /**
     * Modifica un producto, devolviendo una cadena con el resultado de la
     * operacion.
     *
     * @param productoAModificar
     * @param codigo
     * @param descripcion
     * @param precio
     * @param categoria
     * @param estado
     * @return
     */ 
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (!productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        
        if (codigoInvalido(codigo)) {
            return ERROR_CODIGO;
        }

        if (desripcionInvalida(descripcion)) {
            return ERROR_DESCRIPCION;
        } else productoAModificar.asignarDescripcion(descripcion);

        if (precioInvalido(precio)) {
            return ERROR_PRECIO;
        } else productoAModificar.asignarPrecio(precio);

        if (categoriaInvalida(categoria)) {
            return ERROR_CATEGORIA;
        }else productoAModificar.asignarCategoria(categoria);

        if (estadoInavlido(estado)) {
            return ERROR_ESTADO;
        }else productoAModificar.asignarEstado(estado);
        
        return EXITO;
    }

    /**
     * Devuelve todos los productos
     * @return
     */
    @Override
    public List<Producto> menu() {
        Collections.sort(productos);
        return productos;
    }

    /**
     * Busca los productos cuya descripcion coincida, total o parcialmente, con
     * la especificada
     *
     * @param descripcion
     * @return
     */
    @Override
    public List<Producto> buscarProductos(String descripcion) {
        List<Producto> productosPorDescripcion = new ArrayList<>();
        
        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                productosPorDescripcion.add(p);
            }
        }
        
        Collections.sort(productosPorDescripcion);
        
        return productosPorDescripcion;
    }

    /**
     * Borra un producto siempre y cuando no haya pedidos con el mismo. Devuelve una cadena con el resultado de la operación.
     * @param producto
     * @return 
     */
    @Override
    public String borrarProducto(Producto producto){
        if (producto == null || !productos.contains(producto)) {
            return PRODUCTO_INEXISTENTE;
        }
        if (GestorPedidos.instanciar().hayPedidosConEsteProducto(producto)) {
            return ERROR_ELIMINAR; 
        }
        productos.remove(producto);
        return EXITO;
    }
    
    /**
     * Devuelve true si existe el producto especificado, false en caso contrario
     *
     * @param producto
     * @return
     */
    @Override
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    /**
     * Devuelve los productos con la categoria especificada
     *
     * @param categoria
     * @return
     */
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria) {
        List<Producto> productosPorCategoria = new ArrayList<>();
        
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                productosPorCategoria.add(p);
            }
        }
        
        Collections.sort(productosPorCategoria);

        return productosPorCategoria;
    }

    /**
     * Obtiene el producto con el codigo especificado. Si no hay un producto con
     * ese codigo, devuelve null
     *
     * @param codigo
     * @return
     */
    @Override
    public Producto obtenerProducto(Integer codigo) {
        for (Producto p : productos) {
            if (p.verCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    /**
     * Valida que el codigo sea un entero positivo. 
     * Si el codigo no cumple con la validacion devuelve true, caso contrario false.
     * @param codigo
     * @return 
     */
    private boolean codigoInvalido(int codigo) {
        if (codigo <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Valida que la descripción no sea una cadena vacia o null.
     * Si el String no cumple con la validacion devuelve true, caso contrario false.
     * @param descripcion
     * @return 
     */
    private boolean desripcionInvalida(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Valida que el precio sea mayor que 0.
     * Si el precio no cumple con la validacion devuelve true, caso contrario false.
     * @param precio
     * @return 
     */
    private boolean precioInvalido(float precio) {
        if (precio <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Valida que categoria no es null.
     * Si la categoria no cumple con la validacion devuelve true, caso contrario false.
     * @param categoria
     * @return 
     */
    private boolean categoriaInvalida(Categoria categoria) {
        if (categoria == null) {
            return true;
        }
        return false;
    }

    /**
     * Valida que estado no es null.
     * Si el estado no cumple con la validacion devuelve true, caso contrario false.
     * @param estado
     * @return 
     */
    private boolean estadoInavlido(Estado estado) {
        if (estado == null) {
            return true;
        }
        return false;
    }
}
