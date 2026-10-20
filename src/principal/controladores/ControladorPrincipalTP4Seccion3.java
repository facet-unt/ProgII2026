/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP4Seccion3 {
    public static void main(String[] args) {
     
    /*
    ***************************************************
    INICIO Tercera parte - herencia
    ***************************************************
    */
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
        Usuario unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Usuario unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Usuario unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        Usuario unCliente4 = new Cliente("cliente3@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4"); 
        //cliente repetido
        
        if (!listaUsuarios.contains(unCliente1))
            listaUsuarios.add(unCliente1);  
        else System.out.println("No se puede agregar el cliente1");
        if (!listaUsuarios.contains(unCliente2))
            listaUsuarios.add(unCliente2);
        else System.out.println("No se puede agregar el cliente2");
        if (!listaUsuarios.contains(unCliente3))
            listaUsuarios.add(unCliente3);
        else System.out.println("No se puede agregar el cliente3");
        if (!listaUsuarios.contains(unCliente4))
            listaUsuarios.add(unCliente4);
        else System.out.println("No se puede agregar el cliente4");
                        
        Usuario unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
        Usuario unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
        Usuario unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
        Usuario unEmpleado4 = new Empleado("empleado3@bar.com", "claveEmpleado4", "ApellidoEmpleado4", "NombreEmpleado4");
        //empleado repetido
        
        if (!listaUsuarios.contains(unEmpleado1))
            listaUsuarios.add(unEmpleado1);
        else System.out.println("No se puede agregar el empleado1");
        if (!listaUsuarios.contains(unEmpleado2))
            listaUsuarios.add(unEmpleado2);
        else System.out.println("No se puede agregar el empleado2");
        if (!listaUsuarios.contains(unEmpleado3))
            listaUsuarios.add(unEmpleado3);
        else System.out.println("No se puede agregar el empleado3");
        if (!listaUsuarios.contains(unEmpleado4))
            listaUsuarios.add(unEmpleado4);
        else System.out.println("No se puede agregar el empleado4");
        
        Usuario unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Usuario unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Usuario unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        Usuario unEncargado4 = new Encargado("encargado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        //encargado repetido
        
        if (!listaUsuarios.contains(unEncargado1))
            listaUsuarios.add(unEncargado1);
        else System.out.println("No se puede agregar el encargado1");
        if (!listaUsuarios.contains(unEncargado2))
            listaUsuarios.add(unEncargado2);
        else System.out.println("No se puede agregar el encargado2");
        if (!listaUsuarios.contains(unEncargado3))
            listaUsuarios.add(unEncargado3);
        else System.out.println("No se puede agregar el encargado3");
        if (!listaUsuarios.contains(unEncargado4))
            listaUsuarios.add(unEncargado4);
        else System.out.println("No se puede agregar el encargado4");

        Producto unProducto1 = new Producto(1, "Producto1", Categoria.ENTRADA, Estado.DISPONIBLE, 1.0f);        
        Producto unProducto2 = new Producto(2, "Producto2", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 2.0f);
        Producto unProducto3 = new Producto(3, "Producto3", Categoria.POSTRE, Estado.DISPONIBLE, 3.0f);
        Producto unProducto4 = new Producto(3, "Producto4", Categoria.POSTRE, Estado.DISPONIBLE, 4.0f);
        //producto repetido
        
        if (!listaProductos.contains(unProducto1))
            listaProductos.add(unProducto1);
        if (!listaProductos.contains(unProducto2))
            listaProductos.add(unProducto2);
        if (!listaProductos.contains(unProducto3))
            listaProductos.add(unProducto3);
        if (!listaProductos.contains(unProducto4))
            listaProductos.add(unProducto4);
        
        ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
        ProductoDelPedido pdp1 = new ProductoDelPedido(listaProductos.get(0), 1);
        ProductoDelPedido pdp2 = new ProductoDelPedido(listaProductos.get(1), 2);        
        if (!listapdp1.contains(pdp1))
            listapdp1.add(pdp1);
        if (!listapdp1.contains(pdp2))
            listapdp1.add(pdp2);
        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), listapdp1, (Cliente) listaUsuarios.get(0));        
        
        ArrayList<ProductoDelPedido> productosDelPedido2 = new ArrayList<>();
        ProductoDelPedido pdp3 = new ProductoDelPedido(listaProductos.get(2), 10);
        ProductoDelPedido pdp4 = new ProductoDelPedido(listaProductos.get(0), 20);
        ProductoDelPedido pdp5 = new ProductoDelPedido(listaProductos.get(2), 30);
        //producto repetido        
        if (!productosDelPedido2.contains(pdp3))
            productosDelPedido2.add(pdp3);
        if (!productosDelPedido2.contains(pdp4))
            productosDelPedido2.add(pdp4);
        if (!productosDelPedido2.contains(pdp5))
            productosDelPedido2.add(pdp5);
        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), productosDelPedido2, (Cliente) listaUsuarios.get(1));        
        
        ArrayList<ProductoDelPedido> productosDelPedido3 = new ArrayList<>();
        ProductoDelPedido pdp6 = new ProductoDelPedido(listaProductos.get(1), 100);
        ProductoDelPedido pdp7 = new ProductoDelPedido(listaProductos.get(2), 200);
        if (!productosDelPedido3.contains(pdp6))
            productosDelPedido3.add(pdp6);
        if (!productosDelPedido3.contains(pdp7))
            productosDelPedido3.add(pdp7);
        Pedido unPedido3 = new Pedido(2, LocalDateTime.now(), productosDelPedido3, (Cliente) listaUsuarios.get(2));        
        //pedido repetido

        if(!listaPedidos.contains(unPedido1))
            listaPedidos.add(unPedido1);
        if(!listaPedidos.contains(unPedido2))
            listaPedidos.add(unPedido2);
        if(!listaPedidos.contains(unPedido3))
            listaPedidos.add(unPedido3);
        
        System.out.println("Lista de usuarios");
        System.out.println("=======");
        for (Usuario u : listaUsuarios){
            u.mostrar();
            System.out.println();
        }
        
        System.out.println("Pedidos");
        System.out.println("=======");
        for(Pedido p : listaPedidos) {
            p.mostrar();
            System.out.println();
        }
        
        ((Cliente)unCliente1).agregarPedido(unPedido1);
        ((Cliente)unCliente1).agregarPedido(unPedido1);
        //pedido repetido
        
        System.out.println("Pedidos de " + unCliente1.verApellido() + ", " + unCliente1.verNombre());
        for(Pedido p : unCliente1.verPedidos()) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
        
        ((Cliente)unCliente1).cancelarPedido(unPedido1);
        System.out.println("Pedidos de " + unCliente1.verApellido() + ", " + unCliente1.verNombre());
        for(Pedido p : unCliente1.verPedidos()) {
            p.mostrar();
            System.out.println();
        }
        System.out.println();
    
    /*
    FIN Tercera parte - herencia
    ***************************************************
    */
    }
}