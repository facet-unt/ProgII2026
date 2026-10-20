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
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Usuario;
//import usuarios.modelos.Usuario;


/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP4Seccion3 {
     public static void main(String[] args) {
     
         /*
         ***************************************************
         ***************************************************
         ***************************************************
         INICIO Tercera parte - herencia
         **************************************************
         */
         
         ArrayList<Usuario> usuarios = new ArrayList<>();
         ArrayList<Producto> listaProductos = new ArrayList<>();
         ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
         Usuario unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
         Usuario unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
         Usuario unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
         Usuario unCliente4 = new Cliente("cliente3@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4"); 
         //cliente repetido
        
         if (!usuarios.contains(unCliente1))
            usuarios.add(unCliente1);
         if (!usuarios.contains(unCliente2))
            usuarios.add(unCliente2);
         if (!usuarios.contains(unCliente3))
            usuarios.add(unCliente3);
         if (!usuarios.contains(unCliente4)){             
            usuarios.add(unCliente4);}
         else
             System.out.println("No se puede agregar el cliente4");
         
         /*
         Completar con el agregado de clientes
         */
                        
         Usuario unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
         Usuario unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
         Usuario unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
         Usuario unEmpleado4 = new Empleado("empleado3@bar.com", "claveEmpleado4", "ApellidoEmpleado4", "NombreEmpleado4");
         //empleado repetido
        
         if (!usuarios.contains(unEmpleado1))
            usuarios.add(unEmpleado1);
         if(!usuarios.contains(unEmpleado2))
            usuarios.add(unEmpleado2);
         if(!usuarios.contains(unEmpleado3))
            usuarios.add(unEmpleado3);
         if(!usuarios.contains(unEmpleado4))
             usuarios.add(unEmpleado4);
         else
             System.out.println("No se puede agregar el unEmpleado4");
         
         /*
         Completar con el agregado de Empleados
         */
        
         Usuario unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
         Usuario unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
         Usuario unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
         Usuario unEncargado4 = new Encargado("encargado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
         //encargado repetido

         if(!usuarios.contains(unEncargado1))
             usuarios.add(unEncargado1);
         if(!usuarios.contains(unEncargado2))
             usuarios.add(unEncargado2);
         if(!usuarios.contains(unEncargado3))
             usuarios.add(unEncargado3);
         if(!usuarios.contains(unEncargado4))
             usuarios.add(unEncargado4);
         else
             System.out.println("No se puede agregar el Encargado4");
        
         /*
        Completar con el agregado de Encargados
         */

         
        System.out.println("Lista de Usuarios");
        System.out.println("==========");
        System.out.println("Datos del Cliente");
        for(Usuario u : usuarios){
            if(u instanceof Cliente){
                u.mostrar();
                System.out.println();
            }
        }
         
        System.out.println("Datos del Empleado");
        for(Usuario u2 : usuarios){
            if(u2 instanceof Empleado){
                u2.mostrar();
                System.out.println();
            }
        } 
         
        System.out.println("Datos del Encargado");        
        for(Usuario u3 : usuarios){
            if(u3 instanceof Encargado){
                u3.mostrar();
                System.out.println();
            }
        }
        
        Producto unProducto1 = new Producto(1, "Producto1", 1.0f, Estado.DISPONIBLE, Categoria.ENTRADA);        
        Producto unProducto2 = new Producto(2, "Producto2", 2.0f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto unProducto3 = new Producto(3, "Producto3", 3.0f, Estado.DISPONIBLE, Categoria.POSTRE);
        Producto unProducto4 = new Producto(3, "Producto4", 4.0f, Estado.DISPONIBLE, Categoria.POSTRE);
        //producto repetido
        
        if(!listaProductos.contains(unProducto1))
            listaProductos.add(unProducto1);
        if(!listaProductos.contains(unProducto2))
            listaProductos.add(unProducto2);
        if(!listaProductos.contains(unProducto3))
            listaProductos.add(unProducto3);
        if(!listaProductos.contains(unProducto4))
            listaProductos.add(unProducto4);
        
         ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
         ProductoDelPedido pdp1 = new ProductoDelPedido(1, listaProductos.get(0));
         ProductoDelPedido pdp2 = new ProductoDelPedido(2, listaProductos.get(1));        
         if (!listapdp1.contains(pdp1))
            listapdp1.add(pdp1);
         if (!listapdp1.contains(pdp2))
            listapdp1.add(pdp2);
         Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), EstadoPedido.PROCESANDO, (Cliente)usuarios.get(0), listapdp1);        
        
         ArrayList<ProductoDelPedido> productosDelPedido2 = new ArrayList<>();
         ProductoDelPedido pdp3 = new ProductoDelPedido(10, listaProductos.get(2));
         ProductoDelPedido pdp4 = new ProductoDelPedido(20, listaProductos.get(0));
         ProductoDelPedido pdp5 = new ProductoDelPedido(30, listaProductos.get(2));
         //producto repetido        
         if (!productosDelPedido2.contains(pdp3))
            productosDelPedido2.add(pdp3);
         if (!productosDelPedido2.contains(pdp4))
            productosDelPedido2.add(pdp4);
         if (!productosDelPedido2.contains(pdp5))
            productosDelPedido2.add(pdp5);
         Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), EstadoPedido.CREADO, (Cliente)usuarios.get(1), productosDelPedido2);        
        
         ArrayList<ProductoDelPedido> productosDelPedido3 = new ArrayList<>();
         ProductoDelPedido pdp6 = new ProductoDelPedido(100, listaProductos.get(1));
         ProductoDelPedido pdp7 = new ProductoDelPedido(200, listaProductos.get(2));
         if (!productosDelPedido3.contains(pdp6))
            productosDelPedido3.add(pdp6);
         if (!productosDelPedido3.contains(pdp7))
            productosDelPedido3.add(pdp7);
         Pedido unPedido3 = new Pedido(2, LocalDateTime.now(), EstadoPedido.ENTREGADO, (Cliente)usuarios.get(2), productosDelPedido3);        
         //pedido repetido

         if(!listaPedidos.contains(unPedido1))
            listaPedidos.add(unPedido1);
         if(!listaPedidos.contains(unPedido2))
            listaPedidos.add(unPedido2);
         if(!listaPedidos.contains(unPedido3))
            listaPedidos.add(unPedido3);
        
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
    
        
         //CAST : Cliente unCliente = (Cliente)usuarios.get(0); 
         //Ejemplo para cast
         /*
         FIN Tercera parte - herencia
         ***************************************************
         ***************************************************
         ***************************************************
         */
    }
  }
