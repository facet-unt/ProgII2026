/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Arebalo
 */
public class GestorProductos implements IGestorProductos{
    //Constantes para el archivo y separador
    private static final String NOMBRE_ARCHIVO = "productos.txt";
    private static final String SEPARADOR = ";";
    private static GestorProductos gestor;
    
    private ArrayList<Producto> productos = new ArrayList<>();
    
    
    //Singleton
    private GestorProductos(){
    }
    public static GestorProductos instanciar(){
        if(gestor == null){
            gestor = new GestorProductos();
        }
        return gestor;
    }
    
    //=================================
    //Metodos auxiliares de archivo
    //=================================
    
    private String leerArchivo(){
        File archivo = new File(NOMBRE_ARCHIVO);
        if(!archivo.exists()){
            try{
                if(archivo.createNewFile()){
                    return CREACION_OK;
                }
            }catch(IOException e){
                return CREACION_ERROR;
            }
        }
        
    
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            while((linea = br.readLine()) != null){
                if(!linea.trim().isEmpty()){
                    String[] datos = linea.split(SEPARADOR);
                    if(datos.length == 5){
                        int codigo = Integer.parseInt(datos[0].trim());
                        String descripcion = datos[1].trim();
                        float precio = Float.parseFloat(datos[2].trim());
                        Categoria categoria = Categoria.valueOf(datos[4].trim());
                        Estado estado = Estado.valueOf(datos[4].trim());
                
                        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
                        if(!this.productos.contains(p)){
                            this.productos.add(p);
                        }
                    }
                }
            }
            return LECTURA_OK;
        } catch(IOException | IllegalArgumentException e){
            return LECTURA_ERROR;
        }
    }
    //Metodo para validar datos
    
    private String validarDatos(int codigo, String descripcion, float precio,Categoria categoria,Estado estado){
        if(codigo<=0){
            return ERROR_CODIGO;
        }
        if(descripcion == null || descripcion.trim().isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if(precio<=0){
            return ERROR_PRECIO;
        }
        if(categoria == null){
            return ERROR_CATEGORIA;
        }
        if(estado == null){
            return ERROR_ESTADO;
        }
        return EXITO;
    }
    //Metodo para crear producto
    
    @Override
    public String crearProducto(int codigo,String descripcion,float precio,Categoria categoria,Estado estado){
        String validacion = validarDatos(codigo,descripcion,precio,categoria,estado);
        if(!validacion.equals(EXITO)){
            return validacion;
        }
        Producto nuevoProducto = new Producto(codigo,descripcion.trim(),categoria,estado,precio);
        if(this.productos.contains(nuevoProducto)){
            return PRODUCTOS_DUPLICADOS;
        }
        this.productos.add(nuevoProducto);
        return EXITO;
    }
    
    //Modificar un producto existente si los nuevos datos son validos
    
    @Override
    public String modificarProducto(Producto productoAModificar,int codigo,String descripcion,float precio,Categoria categoria,Estado estado){
        if(productoAModificar == null || !this.productos.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        String validacion = validarDatos(codigo,descripcion,precio,categoria,estado);
        if (!validacion.equals(EXITO)){
            return validacion;
        }
        if(productoAModificar.verCodigo() != codigo){
            Producto aux = new Producto(codigo,descripcion,categoria,estado,precio);
            if (this.productos.contains(aux)){
                return PRODUCTOS_DUPLICADOS;
            }
        }
        productoAModificar.asignarDescripcion(descripcion.trim());
        productoAModificar.asignarPrecio(precio);
        productoAModificar.setCategoria(categoria);
        productoAModificar.asignarEstado(estado);
        return EXITO;
    
    }
         
    //Devolver todos los productos
    
    @Override
    public List<Producto> menu(){
        this.productos.sort(Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion, String.CASE_INSENSITIVE_ORDER));
        return this.productos;
    }
    
    //Buscar productos por descripcion
    
    @Override
    public List<Producto> buscarProductos(String descripcion){
        List<Producto> resultado = new ArrayList<>();
        if(descripcion == null || descripcion.trim().isEmpty()){
            return resultado;
        }
        String buscado = descripcion.trim().toLowerCase();
        for (Producto p : this.productos){
            if (p.verDescripcion() != null && p.verDescripcion().toLowerCase().contains(buscado)){
                resultado.add(p);
            }
        }
        resultado.sort(Comparator.comparing(Producto::verCategoria).thenComparing(Producto::verDescripcion, String.CASE_INSENSITIVE_ORDER));
        return resultado;
    }
    
    //Verificar si un producto existe
    
    @Override
    public boolean existeEsteProducto(Producto producto){
        if(producto == null){
            return false;
        }
        return this.productos.contains(producto);
    }
    
    //Devuelve los productos de una categoria
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria){
        List<Producto> resultado = new ArrayList<>();
        if(categoria == null){
            return resultado;
        }
        for(Producto p : this.productos){
            if(p.verCategoria() == categoria){
                resultado.add(p);
            }
        }
        resultado.sort(Comparator.comparing(Producto::verDescripcion, String.CASE_INSENSITIVE_ORDER));
        return resultado;
    }
    
    //Obtener un producto por su codigo
    
    @Override
    public Producto obtenerProducto(Integer codigo){
        if(codigo == null){
            return null;
        }
        for (Producto p : this.productos){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    @Override
public String borrarProducto(Producto producto) {
    if (producto == null || !this.productos.contains(producto)) {
        return PRODUCTO_INEXISTENTE;
    }

    IGestorPedidos gp = GestorPedidos.instanciar();
    if (gp.hayPedidosConEsteProducto(producto)) {
        return ERROR_BORRAR;
    }

    this.productos.remove(producto);
    return EXITO;
}

    Comparator<Producto> compCategoriaYDescripcion = (p1,p2) -> {
        int cmpCat = p1.verCategoria().compareTo(p2.verCategoria());
        if(cmpCat != 0){
            return cmpCat;
        }
        return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
    };
}
