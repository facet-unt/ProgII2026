/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import interfaces.IGestorProductos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorProductos implements IGestorProductos{
    ArrayList<Producto> prods = new ArrayList <>();
    private static GestorProductos gestor;
    private GestorProductos(){
    }
    public static GestorProductos instanciar(){
        if(gestor == null){
            gestor = new GestorProductos();
        }
        return gestor;
    }
    private String verificarDatos(int codigo, String descripcion, float precio, Categoria categoria, Estado estado){
        if (codigo <= 0){
            return ERROR_CODIGO;
        }
        if (descripcion == null || descripcion.isEmpty()){
            return ERROR_DESCRIPCION;
        }
        if (precio <= 0){
            return ERROR_PRECIO;
        }
        if (categoria == null){
            return ERROR_CATEGORIA;
        }
        if (estado == null){
            return ERROR_ESTADO;
        }
        return EXITO;
    }
    public String crearProducto(int codigo, String descripcion,
    float precio, Categoria categoria, Estado estado){
        String proceso = verificarDatos(codigo, descripcion, precio, categoria, estado);
        if (proceso.equals(EXITO)){
            Producto p = new Producto(codigo, descripcion,categoria, estado, precio);
            if (prods.contains(p)){
                return PRODUCTOS_DUPLICADOS;
            }
            prods.add(p);
            }
        return proceso;
        }
    
    public String modificarProducto(Producto productoAModificar,
    int codigo, String descripcion, float precio, Categoria
    categoria, Estado estado){
        String proceso = verificarDatos(codigo, descripcion, precio, categoria, estado);
        if (!prods.contains(productoAModificar)){
            return PRODUCTO_INEXISTENTE;
        }
        if (proceso.equals(EXITO)){
        int posicion = prods.indexOf(productoAModificar);
        Producto p = new Producto (codigo, descripcion,categoria, estado, precio);
        prods.set(posicion, p);
        proceso = VALIDACION_EXITO;
    }
        return proceso;
    }  
    
    public List<Producto> menu()
    {
        List<Producto> ordenado = new ArrayList <>();
        System.out.println("Ordenados por desc.");
        Comparator<Producto> CatYDescComp = new Comparator<Producto>(){
        @Override
        public int compare(Producto p1, Producto p2) 
        {
            int comparacion = p1.verCategoria().compareTo(p2.verCategoria());
            if (comparacion == 0) {
                return p1.verDescripcion().compareTo(p2.verDescripcion());
            }
            return comparacion;
        }
        };
        ordenado.addAll(prods);
        ordenado.sort(CatYDescComp);
        return ordenado;
    }
    
    public List<Producto> buscarProductos(String descripcion) {
    List<Producto> encontrados = new ArrayList<>();

    for (Producto p : prods) {
        if (p.verDescripcion().contains(descripcion)) {
            encontrados.add(p);
        }
    }
    Comparator<Producto> CatYDescComp = (Producto p1, Producto p2) -> {
        int comparacion = p1.verCategoria().compareTo(p2.verCategoria());
        
        if (comparacion == 0) {
            return p1.verDescripcion().compareTo(p2.verDescripcion());
        }
        
        return comparacion;
    };

    encontrados.sort(CatYDescComp);

    return encontrados;
}
    
    public boolean existeEsteProducto(Producto producto){
        return prods.contains(producto);
}
    public ArrayList<Producto> verProductosPorCategoria(Categoria
    categoria){
        ArrayList<Producto> encontrados = new ArrayList<>();
        for(Producto p: prods){
            if(p.verCategoria()== categoria.toString()){
                encontrados.add(p);
            }
        }
        
            Comparator<Producto> CatYDescComp = (Producto p1, Producto p2) -> {
        int comparacion = p1.verCategoria().compareTo(p2.verCategoria());
        
        if (comparacion == 0) {
            return p1.verDescripcion().compareTo(p2.verDescripcion());
        }
        
        return comparacion;
    };

    encontrados.sort(CatYDescComp);
        return encontrados;
    }
    
    public Producto obtenerProducto(Integer codigo){
        for(Producto p: prods){
            if(p.verCodigo() == codigo){
                return p;
            }
        }
        return null;
    }
    
    public String borrarProducto(Producto producto)
    {
        if(prods.contains(producto))
        {
            prods.remove(producto);
            return EXITO;
        }
        return PRODUCTO_INEXISTENTE;
    }
        
}
