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
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author homep
 */
public class GestorProductos implements IGestorProductos{
    private final List<Producto> productos = new ArrayList<>();
    private final Comparator <Producto> comparadorCatyDescr = (p1,p2) -> {
        int compCategoria = p1.verCategoria().compareTo(p2.verCategoria());
        if (compCategoria != 0){
            return compCategoria;
        }
        
        return p1.verDescripcion().compareToIgnoreCase(p2.verDescripcion());
    };
    
    private final Comparator <Producto> comparadorDescripcion = Comparator.comparing(Producto::verDescripcion,String.CASE_INSENSITIVE_ORDER);
    private final IGestorPedidos gdp = GestorPedidos.instanciar();
    private static final String BASE_DE_DATOS = "./src/media/productos.txt";
    
    //=============================
    //      Singleton
    //=============================
    private static final GestorProductos instancia = new GestorProductos();
    private GestorProductos(){
        obtenerProductosdesdeTXT(productos);
    };
    
    public static GestorProductos instanciar(){
        return instancia;
    }
    
    //==============================
    //          Metodos
    //==============================
    private String corroborarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if (codigo <= 0)
            return ERROR_CODIGO;
        if ((descripcion == null || (descripcion.isBlank() || descripcion.contains(Producto.SEPARADOR))))
            return ERROR_DESCRIPCION;
        if (precio <= 0)
            return ERROR_PRECIO;
        if (categoria == null)
            return ERROR_CATEGORIA;
        if (estado == null)
            return ERROR_ESTADO;
        
        return VALIDACION_EXITO;
    }
    
    @Override
    public String crearProducto(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        String escritura;
        String proceso = corroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (proceso.equals(VALIDACION_EXITO)){
            Producto p = new Producto(codigo, descripcion, categoria, estado, precio);
            if (productos.contains(p)){
                return PRODUCTOS_DUPLICADOS;
            }
            productos.add(p);
            escritura = this.subirProductos();
            if (escritura.equals(ESCRITURA_ERROR)) {
                productos.remove(p);
                return ESCRITURA_ERROR;
            }
            return EXITO;
        }
        return proceso;
    }
    
    @Override
    public String modificarProducto(Producto productoAModificar, int codigo, String descripcion, float precio, Categoria categoria, Estado estado) {
        if (productoAModificar == null || !productos.contains(productoAModificar)) {
            return PRODUCTO_INEXISTENTE;
        }
        String proceso = corroborarDatos(codigo, descripcion, precio, categoria, estado);
        if (!proceso.equals(VALIDACION_EXITO)) {
            return proceso;
        }

        Producto p = productos.get(productos.indexOf(productoAModificar));
        String descAnterior = p.verDescripcion();
        float precioAnterior = p.verPrecio();
        Categoria catAnterior = p.verCategoria();
        Estado estAnterior = p.verEstado();

        p.asignarDescripcion(descripcion);
        p.asignarPrecio(precio);
        p.asignarCategoria(categoria);
        p.asignarEstado(estado);

        if (this.subirProductos().equals(ESCRITURA_ERROR)) {
            p.asignarDescripcion(descAnterior);
            p.asignarPrecio(precioAnterior);
            p.asignarCategoria(catAnterior);
            p.asignarEstado(estAnterior);
            return ESCRITURA_ERROR;
        }
        return EXITO;
    }
    
    @Override
    public List<Producto> menu() {
        List<Producto> resultado = new ArrayList<>(productos);
        Collections.sort(resultado, comparadorCatyDescr);
        return resultado;
    }
    
    @Override
    public List<Producto> buscarProductos(String descripcion){
        List<Producto> pdp = new ArrayList<>();
        if (descripcion == null) {
            return pdp;
        }
        for (Producto p : productos){
            if ((p.verDescripcion() != null  && p.verDescripcion().toLowerCase().contains(descripcion.toLowerCase())))
                pdp.add(p);
        }
        Collections.sort(pdp, comparadorCatyDescr);
        return pdp;
    }
    
    @Override
    public boolean existeEsteProducto(Producto producto){
        return productos.contains(producto);
    }
    
    @Override
    public List<Producto> verProductosPorCategoria(Categoria categoria){
        List<Producto> pdp = new ArrayList<>();
        if (categoria == null) {
            return pdp;
        }
        for (Producto p : productos){
            if (p.verCategoria() == categoria)
                pdp.add(p);
        }
        Collections.sort(pdp,comparadorDescripcion);
        return pdp;
    }
    
    @Override
    public Producto obtenerProducto(Integer codigo){
        for (Producto p: productos){
            if (codigo != null && p.verCodigo() == codigo){      
                return p;
            }
        }
        return null;
    }
    
   
    @Override
    public String borrarProducto(Producto producto){
        if (producto == null || !this.productos.contains(producto)){
            return PRODUCTO_INEXISTENTE;
        
        }else if(this.gdp.hayPedidosConEsteProducto(producto))
            return ERROR_PROD_EN_PED;        
        this.productos.remove(producto);
        if(this.subirProductos().equals(ESCRITURA_ERROR)){
            this.productos.add(producto);
            return ESCRITURA_ERROR;
        }
        return EXITO_BORRAR;
    }
    
    public List<Producto> obtenerProductosdesdeTXT(List<Producto> prods){
        File f = new File (BASE_DE_DATOS);
        if (f.exists()) {
            prods.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (!linea.isBlank()) {
                        Producto p = Producto.desconcatenar(linea);
                        if (p != null) {
                            prods.add(p);
                        }
                    }
                }
                System.out.println(LECTURA_OK);
            }catch (IOException ex){
            System.out.println(LECTURA_ERROR);
            }
        }else{
            try{
                File dir = new File("./src/media");
                if (!dir.exists()) {
                    dir.mkdir();
                }
                f.createNewFile();
                System.out.println(CREACION_OK);
            } catch (IOException ex) {
                System.out.println(CREACION_ERROR);
            }
        }
        return prods;
        
    }
    
    
    public String subirProductos(){
        File f = new File (BASE_DE_DATOS);
        try (BufferedWriter bw = new BufferedWriter (new FileWriter(f))){
           for (Producto p : productos) {
            bw.write(p.concatenar());
            bw.newLine();
            }
            return ESCRITURA_OK;
        } catch (IOException ex) {
            return ESCRITURA_ERROR;
    }
    }
   
}