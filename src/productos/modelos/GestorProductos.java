/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.ArrayList;

/**
 *
 * @author ramayo
 */
public class GestorProductos {
    String validacion;
    ArrayList<Producto> lista = new ArrayList<>();
    
    public static final String EXITO = "Producto creado/modificado con éxito";
    public static final String ERROR_CODIGO = "El código del producto es incorrecto";
    public static final String ERROR_DESCRIPCION="La descripción del producto es incorrecta";
    public static final String ERROR_PRECIO = "El precio del producto es incorrecto";
    public static final String ERROR_CATEGORIA = "La categoría del producto es incorrecta";
    public static final String ERROR_ESTADO = "El estado del producto es incorrecto";
    public static final String PRODUCTOS_DUPLICADOS = "Ya existe un producto con ese código";
    public static final String VALIDACION_EXITO = "Los datos del producto son correctos";
    public static final String PRODUCTO_INEXISTENTE = "No existe el producto especificado";
    
    //<editor-fold defaultstate="collapsed" desc="Patrón Singleton">
    private static GestorProductos gestor;
    private GestorProductos() {
    }
    
    public static GestorProductos instanciar() {
        if (gestor == null)
        gestor = new GestorProductos();
        return gestor;
    }
    //</editor-fold>
    
    //Verifica que los datos ingresados sean válidos según enunciado.
    public String validarProducto(int codigo, String descripcion,float precio, Categoria categoria, Estado estado){
        if(codigo>=0){
            return ERROR_CODIGO;
        }
        if(!(descripcion == null || descripcion.trim().isEmpty())){
            return ERROR_DESCRIPCION;
        }
        if(precio>=0){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado==null){
            return ERROR_ESTADO;
        }
        return VALIDACION_EXITO;
    }
    
    //Crea un nuevo producto, devolviendo una cadena con el resultado de la operación.    
    public String crearProducto(int codigo, String descripcion,float precio, Categoria categoria, Estado estado){
        validacion=validarProducto(codigo, descripcion, precio, categoria, estado);
        if (validacion.equals(VALIDACION_EXITO)){
            Producto p = new Producto(codigo, descripcion, precio, categoria, estado);
            (lista).add(p);
            return EXITO;
        }
        else return validacion;
    }

    //Modifica un producto, devolviendo una cadena con el resultado de la operación.
    public String modificarProducto(Producto productoAModificar,int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if(existeEsteProducto(productoAModificar)){
            validacion = validarProducto(codigo, descripcion, precio, categoria, estado);
            if(validacion.equals(VALIDACION_EXITO)){
                int indice = lista.indexOf(productoAModificar);
                Producto p = new Producto(codigo, descripcion, precio, categoria, estado);
                lista.set(indice, p);
            }
        }
        else validacion = PRODUCTO_INEXISTENTE;
        return validacion;
    }
    
    // Devuelve todos los productos.
    public ArrayList<Producto> menu(){
        return lista;
    }
    
    //Busca los productos cuya descripción coincida, total o parcialmente, con la especificada.
    public ArrayList<Producto> buscarProductos(String descripcion){
        ArrayList<Producto> productosPorDescripcion = new ArrayList<>();
        
        if(!(descripcion == null || descripcion.trim().isEmpty()))
            for(Producto p: lista){
                String descripcionMinuscula = p.verDescripcion().toLowerCase();
                if(descripcionMinuscula.contains(descripcion.toLowerCase())){
                    productosPorDescripcion.add(p);
                }
        }
        else 
            System.out.println(ERROR_DESCRIPCION);
        if(productosPorDescripcion.isEmpty()){
            System.out.println(PRODUCTO_INEXISTENTE);
        }
        return productosPorDescripcion;
    }
    
    //Devuelve true si existe el producto especificado, false en caso contrario.
    public boolean existeEsteProducto(Producto producto){
        return lista.contains(producto);
    }
    
    //Devuelve los productos con la categoría especificada.
    public ArrayList<Producto> verProductosPorCategoria(Categoria categoria){
        ArrayList<Producto> productosPorCategoria = new ArrayList<>();
        if(!(categoria ==null)){
            for(Producto p: lista){
                if(p.verCategoria() == categoria){
                    productosPorCategoria.add(p);
                }
            }
        }
        else System.out.println(ERROR_CATEGORIA);
        if(productosPorCategoria.isEmpty()){
            System.out.println(PRODUCTO_INEXISTENTE);
        }
        return productosPorCategoria;
    }
    
    //Obtiene el producto con el código especificado. Si no hay un producto con ese código, devuelve null.
    public Producto obtenerProducto(Integer codigo){
        if(codigo>=0||codigo==null){
            for(Producto p: lista){
                if(p.verCodigo() == codigo){
                    return p;
                }
            }
        }
        else System.out.println(ERROR_CODIGO);
        return null;
    }
}
