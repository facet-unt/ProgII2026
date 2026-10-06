/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.EstadoPedido;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos. *;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<ProductoDelPedido> listaProductosPedidos1 = new ArrayList<>();
        ArrayList<ProductoDelPedido> listaProductosPedidos2 = new ArrayList<>();
        ArrayList<ProductoDelPedido> listaProductosPedidos3 = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        
        Producto p1 = new Producto(1, "Producto1", 1550.8f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto p2= new Producto(2, "Producto2", 850.8f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto p3 = new Producto(3, "Producto3", 1050.0f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        System.out.println("PRODUCTOS con mostrar()");
        
        for (Producto p: listaProductos){
            p.mostrar();
            System.out.println();
        }        

        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos){
            System.out.println(p);
        }
        
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        
        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);        
        
        for (Cliente e: listaClientes){
           e.mostrar();
           System.out.println();
        }
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS");
        
        Empleado e1 = new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3 = new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
               
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);

        for (Empleado e: listaEmpleados){
            e.mostrar();
            System.out.println();
        }
        
        System.out.println("#################### ");
        System.out.println("ENCARGADOS");
        
        Encargado unEncargado1 = new Encargado("encargado1@gmail.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@gmail.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@gmail.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        
        listaEncargados.add(unEncargado1);
        listaEncargados.add(unEncargado2);
        listaEncargados.add(unEncargado3);

        for(Encargado enc : listaEncargados){
            enc.mostrar();
            System.out.println();
        }
        
        System.out.println("#################### ");
        System.out.println("PEDIDOS"); 
        
        ProductoDelPedido productoPedido1 = new ProductoDelPedido(2, p1);
        ProductoDelPedido productoPedido2 = new ProductoDelPedido(4, p2);
        ProductoDelPedido productoPedido3 = new ProductoDelPedido(3, p3);
        
        listaProductosPedidos1.add(productoPedido1);
        listaProductosPedidos1.add(productoPedido2);
        listaProductosPedidos2.add(productoPedido3);
        listaProductosPedidos2.add(productoPedido1);
        listaProductosPedidos3.add(productoPedido2);
        listaProductosPedidos3.add(productoPedido1);
        
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), EstadoPedido.ENTREGADO, cliente1, listaProductosPedidos1);
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), EstadoPedido.CREADO, cliente2, listaProductosPedidos2);
        Pedido unPedido3 = new Pedido(3, LocalDateTime.now(), EstadoPedido.PROCESANDO, cliente3, listaProductosPedidos3);
        
        listaPedidos.add(unPedido1);
        listaPedidos.add(unPedido2);
        listaPedidos.add(unPedido3);     
        
        for(Pedido pd : listaPedidos){
            pd.mostrar();
        }
     }
}
