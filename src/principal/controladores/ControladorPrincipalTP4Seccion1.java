///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package principal.controladores;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import pedidos.modelos.Pedido;
//import pedidos.modelos.ProductoDelPedido;
//import productos.modelos.Categoria;
//import productos.modelos.Estado;
//import productos.modelos.Producto;
//import usuarios.modelos.Cliente;
//
///**
// *
// * @author Mariana
// */
//public class ControladorPrincipalTP4Seccion1 {
//    public static void main(String[] args) {
//        /*
//        ***************************************************
//        INICIO Primera parte - comparación de objetos
//        ***************************************************
//        */
//        ArrayList<Producto> listaProductos = new ArrayList<>();
//        ArrayList<Pedido> listaPedidos = new ArrayList<>();
//        ArrayList<Cliente> listaClientes = new ArrayList<>();
//        
//        
//        System.out.println("#################### ");
//        System.out.println("PRODUCTOS");
//        Producto p1 = new  Producto(1, "Producto 1", Categoria.ENTRADA ,Estado.DISPONIBLE, 200.0f);        
//        Producto p2 = new  Producto(2, "Producto 2", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 1950.0f);        
//        Producto p3 = new  Producto(3, "Producto 3",Categoria.POSTRE, Estado.NO_DISPONIBLE, 580.0f);        
//        Producto p4 = new  Producto(4, "Producto 4",Categoria.POSTRE, Estado.NO_DISPONIBLE, 580.0f);        
//        Producto p5 = new  Producto(3, "Producto 5",Categoria.POSTRE, Estado.NO_DISPONIBLE, 7580.0f);         
//        //no debe agregar a p5
//        
//             
//        /***************************************************
//         * AGREGAR aqui las sentencias para completar el llenado de 
//         * la lista de productos
//        ***************************************************/
//             
//        /***************************************************
//         * AGREGAR aqui las sentencias para mostrar la lista
//         * de productos, deberían listarse 4
//        ***************************************************/
//           
//        
//        System.out.println("\n#################### ");
//        System.out.println("CLIENTES");
//        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
//        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
//        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
//        
//        listaClientes.add(cliente1);
//        listaClientes.add(cliente2);
//        listaClientes.add(cliente3);
//        /*
//        Clientes, se crean 3 para crear los pedidos
//        */
//        for (Cliente e: listaClientes)
//            e.mostrar();
//                
//        System.out.println("#################### ");
//        System.out.println("PEDIDOS");
//        ArrayList<ProductoDelPedido> listapdp1 = new ArrayList<>();
//        ProductoDelPedido pdp1 = new ProductoDelPedido(listaProductos.get(0), 1);
//        ProductoDelPedido pdp2 = new ProductoDelPedido(listaProductos.get(1), 2);        
//        ProductoDelPedido pdp3 = new ProductoDelPedido(listaProductos.get(1), 8);
//        if (!listapdp1.contains(pdp1)){
//            System.out.println("Se agregará al pedido:" + pdp1);
//            listapdp1.add(pdp1);
//        }
//        if (!listapdp1.contains(pdp2)){
//            listapdp1.add(pdp2);
//            System.out.println("Se agregará al pedido:" + pdp2);
//        }
//        if (!listapdp1.contains(pdp3)){
//            listapdp1.add(pdp3);
//            System.out.println("Se agregará al pedido:" + pdp3);
//        }
//        Pedido unPedido1 = new Pedido(1, LocalDateTime.now(), listapdp1, cliente1);        
//        
//        ArrayList<ProductoDelPedido> productosDelPedido2 = new ArrayList<>();
//        ProductoDelPedido pdp4 = new ProductoDelPedido(listaProductos.get(2), 10);
//        ProductoDelPedido pdp5 = new ProductoDelPedido(listaProductos.get(0), 20);
//        ProductoDelPedido pdp6 = new ProductoDelPedido(listaProductos.get(2), 30);
//        //producto repetido        
//        if (!productosDelPedido2.contains(pdp4))
//            productosDelPedido2.add(pdp4);
//        if (!productosDelPedido2.contains(pdp5))
//            productosDelPedido2.add(pdp5);
//        if (!productosDelPedido2.contains(pdp6))
//            productosDelPedido2.add(pdp6);
//        Pedido unPedido2 = new Pedido(2, LocalDateTime.now(), productosDelPedido2, cliente2);        
//        
//        ArrayList<ProductoDelPedido> productosDelPedido3 = new ArrayList<>();
//        ProductoDelPedido pdp7 = new ProductoDelPedido(listaProductos.get(1), 100);
//        ProductoDelPedido pdp8 = new ProductoDelPedido(listaProductos.get(2), 200);
//        if (!productosDelPedido3.contains(pdp7))
//            productosDelPedido3.add(pdp7);
//        if (!productosDelPedido3.contains(pdp8))
//            productosDelPedido3.add(pdp8);
//        Pedido unPedido3 = new Pedido(2, LocalDateTime.now(), productosDelPedido3, cliente3);        
//        //pedido repetido no debe agregarse a la lista
//
//        if(!listaPedidos.contains(unPedido1))
//            listaPedidos.add(unPedido1);
//        //***********************************************
//        //AGREGAR aqui la sentencia para agregar pedidos a la lista sin que se repitan
//        //*************************************************
//        
//        System.out.println("\n\nLos pedidos son: ");
//        System.out.println("=======");
//        /*
//        *************************************************
//        AGREGAR aqui la sentencia para mostrar la lista de pedidos
//        *************************************************
//        */
//         
//        System.out.println();        
//    
//    /*
//    *************************************************
//     FIN Primera parte - comparación de objetos
//    ***************************************************
//    */
//      }
//  }