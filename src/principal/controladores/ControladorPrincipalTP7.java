/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author luis
 */
public class ControladorPrincipalTP7 {
    public static void main(String[] args) {
        IGestorProductos gp = GestorProductos.instanciar();
        IGestorUsuarios gu = GestorUsuarios.instanciar();
    
        //<editor-fold defaultstate="collapsed" desc="Creación de productos">
        //Ejecutar una única vez y comprobar que se guarden en el archivo los productos
        //Luego comentar todo este bloque para probar las otras secciones
        System.out.println(gp.crearProducto(1, "Producto1", Categoria.ENTRADA, Estado.DISPONIBLE, 1.0f));
        System.out.println(gp.crearProducto(2, "Pizza2", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 2.0f));
        System.out.println(gp.crearProducto(3, "Producto3", Categoria.POSTRE, Estado.DISPONIBLE, 3.0f));
        System.out.println(gp.crearProducto(4, "Producto4", Categoria.POSTRE, Estado.DISPONIBLE, 4.0f));
        System.out.println(gp.crearProducto(5, "Producto5", Categoria.ENTRADA, Estado.DISPONIBLE, 4.0f));
        System.out.println(gp.crearProducto(6, "Pizza6", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 4.0f));
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Listado ordenado por categoría y descripción">
        List<Producto> productos = gp.menu();
//        for(Producto p : productos)
//            p.mostrar();
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Listado ordenado alfabéticamente por descripción">
        productos = gp.verProductosPorCategoria(Categoria.ENTRADA);
//        System.out.println("Cantidad de productos tipo " + Categoria.ENTRADA + ": " + productos.size()); //2
//        for(Producto p : productos)
//            p.mostrar();        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Verificación de la existencia de un producto">
//        System.out.println(gp.existeEsteProducto(gp.obtenerProducto(6))); //true
//        System.out.println(gp.existeEsteProducto(gp.obtenerProducto(10))); //false
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Búsqueda de productos total o parcialmente por su descripción">
        productos = gp.buscarProductos("Producto1");
//        System.out.println("Cantidad de productos: " + productos.size()); //1
//        for(Producto p : productos)
//            p.mostrar();
        
        productos = gp.buscarProductos("Producto");
//        System.out.println("Cantidad de productos: " + productos.size()); //4
//        for(Producto p : productos)
//            p.mostrar();
        
//        productos = gp.buscarProductos("Coca"); //debe devolver una lista vacía
//        System.out.println("Cantidad de productos: " + productos.size()); //0
//        for(Producto p : productos)
//            p.mostrar();
        //</editor-fold>        
        
        //<editor-fold defaultstate="collapsed" desc="Modificación de productos">
        Producto p1 = gp.obtenerProducto(1);
//        System.out.println("Antes de cambiar los valores");
//        p1.mostrar();
//        System.out.println(gp.modificarProducto(p1, 1, "Producto10", 10.0f, Categoria.PLATO_PRINCIPAL, Estado.NO_DISPONIBLE));
        p1 = gp.obtenerProducto(1);
//        System.out.println("Después de cambiar los valores");               
//        p1.mostrar(); //nuevos valores
        
        p1 = gp.obtenerProducto(10);
//        System.out.println(gp.modificarProducto(p1, 1, "Producto10", 10.0f, Categoria.PLATO_PRINCIPAL, Estado.NO_DISPONIBLE));        

        //</editor-fold>                
        
        //<editor-fold defaultstate="collapsed" desc="Borrado de productos:">
//        Producto p6 = gp.obtenerProducto(6);
//        System.out.println(gp.borrarProducto(p6)); //sí se puede borrar
////        productos = gp.menu();
////        System.out.println("Cantidad de productos luego de borrar uno: " + productos.size());
////        for(Producto p : productos)
////            p.mostrar();
//        
//        System.out.println(gu.crearUsuario("correo5.cliente@bar.com", "ApeCli5", "NomCli5", Perfil.CLIENTE, "123456", "123456"));
//        Usuario u = gu.obtenerUsuario("correo5.cliente@bar.com");
//        Cliente cliente = (Cliente)gu.obtenerUsuario("correo5.cliente@bar.com");
//        Producto p2 = gp.obtenerProducto(2);
//        Pedido pe1 = new Pedido(1, 
//            LocalDateTime.now(),             
//            new ArrayList<>(List.of(new ProductoDelPedido(p1, 1), new ProductoDelPedido(p2, 2))), 
//            cliente
//        );
//        System.out.println(gp.borrarProducto(p2)); //no se debe poder borrar este producto
//        
//        productos = gp.menu();
//        System.out.println("Cantidad de productos: " + productos.size()); //5
        //</editor-fold>                
        
    }
}
