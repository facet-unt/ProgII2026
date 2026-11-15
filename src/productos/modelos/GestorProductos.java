/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorProductos {

    ArrayList<Producto> productos = new ArrayList<>();

    //Variable de clase privada
    private static GestorProductos gestor;
    
    public static final String EXITO = "Producto creado/modificado con exito";
    public static final String ERROR_CODIGO = "El codigo del producto es incorrecto";
    public static final String ERROR_DESCRIPCION = "La descripcion del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoria del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";

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
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
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
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (codigoInvalido(codigo)) {
            return ERROR_CODIGO;
        }else productoAModificar.asignarCodigo(codigo);

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
    public ArrayList<Producto> menu() {
        return productos;
    }

    /**
     * Busca los productos cuya descripcion coincida, total o parcialmente, con
     * la especificada
     *
     * @param descripcion
     * @return
     */
    public ArrayList<Producto> buscarProductos(String descripcion) {
        ArrayList<Producto> productosPorDescricpcion = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verDescripcion().contains(descripcion)) {
                productosPorDescricpcion.add(p);
            }
        }
        return productosPorDescricpcion;
    }

    /**
     * Devuelve true si existe el producto especificado, false en caso contrario
     *
     * @param producto
     * @return
     */
    public boolean existeEsteProducto(Producto producto) {
        return productos.contains(producto);
    }

    /**
     * Devuelve los productos con la categoria especificada
     *
     * @param categoria
     * @return
     */
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria) {
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        for (Producto p : productos) {
            if (p.verCategoria() == categoria) {
                productosPorCategoria.add(p);
            }
        }
        return productosPorCategoria;
    }

    /**
     * Obtiene el producto con el codigo especificado. Si no hay un producto con
     * ese codigo, devuelve null
     *
     * @param codigo
     * @return
     */
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
