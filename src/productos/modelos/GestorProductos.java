/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author homep
 */
public class GestorProductos implements IGestorProductos{
    private static final List<Producto> productos = new ArrayList<>();
    private final Comparator <Producto> comparadorCatyDescr = (p1,p2) -> {
        int compCategoria = p1.verCategoria().compareTo(p2.verCategoria());
        if (compCategoria != 0){
            return compCategoria;
        }
        
        return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
    };
    
    private final Comparator <Producto> comparadorDescripcion = Comparator.comparing(Producto::verDescripcion,String.CASE_INSENSITIVE_ORDER);
    private final IGestorPedidos gdp = GestorPedidos.instanciar();
    private final String BASE_DE_DATOS = "../media/productos.txt";
    
    //=============================
    //      Singletone
    //=============================
    private static final GestorProductos instancia = new GestorProductos();
    private GestorProductos(){};
    
    public static GestorProductos instanciar(){
        return instancia;
    }
    
    //==============================
    //          Metodos
    //==============================
    private String CorroborarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if (codigo <= 0)
            return ERROR_CODIGO;
        if (descripcion == null || descripcion.isEmpty())
            return ERROR_DESCRIPCION;
        if (precio <= 0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        return EXITO;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        String proceso = CorroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (proceso.equals(EXITO)){
            Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
            if (productos.contains(p))
                return "Producto Repetido ingresado";
            productos.add(p);
        }
        return proceso;
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        
        String proceso = CorroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (!productos.contains(productoAModificar))
            return ERROR_NO_ESTA;
        if (proceso.equals(EXITO)){
            Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
            productos.set(productos.indexOf(productoAModificar), p);
        }
        return proceso;
    }
    
    @Override
    public List<Producto> menu(){
        Collections.sort(productos,comparadorCatyDescr);
        return productos;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion){
        List<Producto> pdp = new ArrayList<>();
        for (Producto p : productos){
            if (p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase()))
                pdp.add(p);
        }
        if (pdp.isEmpty())
            return null;
        Collections.sort(pdp,comparadorCatyDescr);
        return pdp;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria){
        List<Producto> pdp = new ArrayList<>();
        for (Producto p : productos){
            if (p.verCategoria() == categoria)
                pdp.add(p);
        }
        if (pdp.isEmpty())
            return null;
        Collections.sort(pdp,comparadorDescripcion);
        return pdp;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo){
        for (Producto p: productos){
            if (p.verCodigo() == codigo){      
                return p;
            }
        }
        return null;
    }
    @Override
    public String borrarProducto(Producto producto){
        if (!this.productos.contains(producto)){
            return ERROR_NO_ESTA;
        
        }else if(this.gdp.hayPedidosConEsteProducto(producto))
            return "No es puede borrar este producto ya que se encuentra en un pedido";
        
        else{
            this.productos.remove(producto);
            this.subirProductos();
            return EXITO_BORRAR;
        }
    }
    
    public String subirProductos(){
        
        File f = new File (this.BASE_DE_DATOS);
        try (BufferedWriter bw = new BufferedWriter (new FileWriter(f))){
            for (Producto p : this.productos){
                bw.write(Producto.concatenar(p));
                bw.newLine();
            }
            bw.flush();
            
        } catch (IOException ex) {
            System.getLogger(GestorProductos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return EXITO;
       
    }
}