/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author LUCRECIA
 */
public class GestorProductos implements IGestorProductos {
    File archivo = new File ("Productos.txt");
    ArrayList<Producto> productos =new ArrayList<>();
    private static GestorProductos gestor;
    private final int MAX_COLUMNA = 6;
    private final int MAX_FILA = 50;
 
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
        this.leerArchivo();
        String resultadoValidacion = validarDatos(codigo, descripcion, categoria, estado, precio, null);
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.add(p);
        this.escribirArchivo();
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
        this.leerArchivo();
        if(!productos.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        
        String resultadoValidacion = validarDatos(codigo, descripcion, categoria, estado, precio, productoAModificar);
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
        productos.set(productos.indexOf(productoAModificar), p);
        this.escribirArchivo();
        return VALIDACION_EXITO;
    }
    
    /**
     * Devuelve todos los productos.
     * @return 
     */
    @Override
    public ArrayList<Producto> menu(){
        this.leerArchivo();
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
        this.leerArchivo();
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
        this.leerArchivo();
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
        this.leerArchivo();
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
        this.leerArchivo();
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
        this.leerArchivo();
        if (producto == null || !productos.contains(producto)) {
        return PRODUCTO_INEXISTENTE; 
        }
        
        IGestorPedidos gp = GestorPedidos.instanciar();
        if(gp.hayPedidosConEsteProducto(producto))
            return ERROR_BORRAR;
        productos.remove(producto);
        this.escribirArchivo();
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
        this.leerArchivo();
        for(Producto p: productos){
            //Si el código coincide y no es el producto que estamos editando, está duplicado
            if(p.verCodigo() == codigo && !p.equals(productoAExcluir))
                return true;
        }
        return false;
    }
    
    void escribirArchivo(){
        try(BufferedWriter bw =new BufferedWriter (new FileWriter(archivo))){
            for(Producto pro : productos){
                bw.write(pro.verCodigo() + ";" + pro.verDescripcion() + ";" + pro.verCategoria() + ";" + pro.verEstado() + ";" + pro.verPrecio());
                bw.newLine();
            }   
            }
            catch(IOException ex){
                System.out.println(ex);
            }
    }
    
    void leerArchivo(){
        //limpiamos la coleccion
        if(productos !=null) productos.clear();
        String [][] componentes = new String[MAX_FILA][MAX_COLUMNA];
        
        String linea;  //linea que sera leida por nuestro bufferedReader
        Producto p;  //se usa para llenar la coleccion productos
        int contador = 0 ; //nos ayuda a contar la cantidad de productos en nuestro archivo
        Categoria categoria = null;   //lo usaremos para convertir un String en una clase enum
        Estado estado = null;  //lo usaremos para convertir un String en una clase enum
        
        try (BufferedReader br=new BufferedReader(new FileReader(archivo))) {
            
            //leemos el archivo linea por linea
            while((linea = br.readLine()) != null) {
                componentes[contador] = linea.split(";", -1);  //linea se separa en Substrings diferenciados por ; y se añade cada uno en una fila de un arreglo de strings
                contador ++;  //contador nos indica en qué fila estamos
            }
            
            //ahora recorremos nuestro arreglo de Strings componentes
            for (int i = 0; i < contador; i++) {
                //como el arreglo tiene Strings, tenemos que asignar un enum con su respectivo valor
                switch (componentes[i][2]) {
                    case "Entrada": 
                        categoria = Categoria.ENTRADA; 
                        break;
                    case "Plato principal": 
                        categoria = Categoria.PLATO_PRINCIPAL; 
                        break;
                    case "Postre": 
                        categoria = Categoria.POSTRE; 
                        break;
                }
                switch (componentes[i][3]) {
                    case "Disponible": 
                        estado = Estado.DISPONIBLE; 
                        break;
                    case "No disponible": 
                        estado = Estado.NO_DISPONIBLE; 
                        break;
                }
                //usamos los valores de la fila i para ponerlos en un producto p que despues añadiremos a la coleccion productos
                p= new Producto(Integer.parseInt(componentes[i][0]) , componentes[i][1], categoria, estado, Float.parseFloat(componentes[i][4]));
                productos.add(p);
            }
            
            }
            catch(IOException ex) {
            System.out.println(ex);
            }
    }
    
}
    

