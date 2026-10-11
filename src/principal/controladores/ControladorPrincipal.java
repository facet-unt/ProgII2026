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
import usuarios.modelos. *;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        
        
        ArrayList<Cliente> clientes = new ArrayList <>();
        ArrayList<Encargado> encargados = new ArrayList <>();
        ArrayList<Empleado> empleados = new ArrayList <>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos=new ArrayList<>();
        ArrayList<ProductoDelPedido> productosp1=new ArrayList<>();
        ArrayList<ProductoDelPedido> productosp2=new ArrayList<>();
        ArrayList<ProductoDelPedido> productosp3=new ArrayList<>();
        
        Cliente cliente1 = new Cliente("martinvarga@hotmail.com","1234","Varga","Martin");
        Cliente cliente2 = new Cliente("joseluisM@hotmail.com","4567","Molina","Jose Luis");
        Cliente cliente3 = new Cliente("juliGz@hotmail.com","9096","Gomez","Julieta");
         
        Encargado encargado1 = new Encargado("fernandezjuan@hotmail.com","3334","Fernandez","Juan");
        Encargado encargado2 = new Encargado("martinezK@hotmail.com","5557","Martinez","Kevin");
        Encargado encargado3 = new Encargado("alvaresTomas@hotmail.com","88854","Alvares","Tomas");
         
        Empleado empleado1 = new Empleado("fuentesmario@hotmail.com","3334","Fuentes","Mario");
        Empleado empleado2 = new Empleado("lopez@hotmail.com","111111","Lopez","Hector");
        Empleado empleado3 = new Empleado("alguileraC@hotmail.com","2026","Aguilera","Cristina");
      
        
        Producto hamburguesa = new Producto(1,"Hamburguesa", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE,8000f);
        Producto pizza = new Producto(2,"Pizza", Categoria.PLATO_PRINCIPAL ,Estado.NO_DISPONIBLE,12000f);
        Producto papasFritas = new Producto(3,"Papas Fritas", Categoria.ENTRADA,Estado.DISPONIBLE,5000f);
        
        Pedido pedido1=new Pedido(1,LocalDateTime.now());
        Pedido pedido2=new Pedido(2,LocalDateTime.now());
        Pedido pedido3=new Pedido(3,LocalDateTime.now());
        
        productos.add(hamburguesa);
        productos.add(pizza);
        productos.add(papasFritas);
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        encargados.add(encargado1);
        encargados.add(encargado2);
        encargados.add(encargado3);
        
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        
        System.out.println("####################");
        System.out.println("PRODUCTOS");
        
        System.out.println("PRODUCTOS con mostrar");
        for (Producto p: productos ){
            p.mostrar();
        }
        
        System.out.println("PRODUCTOS con toString()");
        System.out.println(hamburguesa.toString());
        
        System.out.println("\nMODIFICANDO PRODUCTOS...");
        productos.get(0).asignarPrecio(12000f);
        productos.get(1).asignarEstado(Estado.NO_DISPONIBLE);
        productos.get(2).asignarCodigo(6);
        
        System.out.println("PRODUCTOS DESPUES DE LAS MODIFICACIONES...");
        for (Producto p: productos ){
            p.mostrar();
        }
        
        System.out.println("####################");
      
        System.out.println("CLIENTES");
        for (Cliente c: clientes ){
            c.mostrar();
        }
        
        System.out.println("MODIFICANDO CLIENTES...");
        clientes.get(2).asignarClave("454647");
        
        System.out.println("CLIENTES DESPUES DE LAS MODIFICACIONES...");
        for (Cliente c: clientes ){
            c.mostrar();
        }
        
        System.out.println("####################");
        
        System.out.println("ENCARGADOS");
        for (Encargado e: encargados ){
            e.mostrar();
        }
        System.out.println("MODIFICANDO ENCARGADOS...");
        encargados.get(1).asignarApellido("Falcon");
        encargados.get(0).asignarClave("346789");
        
        System.out.println("ENCARGADOS DESPUES DE LAS MODIFICACIONES...");
        for (Encargado e: encargados ){
            e.mostrar();
        }
        
        System.out.println("####################");
        
        System.out.println("EMPLEADOS");
        for (Empleado e: empleados ){
            e.mostrar();
        }
        System.out.println("MODIFICANDO EMPLEADOS...");
        empleados.get(1).verCorreo();
        empleados.get(2).asignarClave("0000");
      
        System.out.println("EMPLEADOS DESPUES DE LAS MODIFICACIONES...");
        for (Empleado e: empleados ){
            e.mostrar();
        }
        
        System.out.println("####################");
        System.out.println("PEDIDOS");
       
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        
        pedido1.setUnCliente(cliente1);
        pedido2.setUnCliente(cliente2);
        pedido3.setUnCliente(cliente3);
        
        ProductoDelPedido prodp1=new ProductoDelPedido(3);
        prodp1.asignarUnProducto(papasFritas);
        
        ProductoDelPedido prodp2=new ProductoDelPedido(5);
        prodp2.asignarUnProducto(hamburguesa);
        
        productosp1.add(prodp1);
        productosp1.add(prodp2);
        
        ProductoDelPedido prodp3=new ProductoDelPedido(4);
        prodp3.asignarUnProducto(hamburguesa);
        ProductoDelPedido prodp4=new ProductoDelPedido(4);
        prodp4.asignarUnProducto(pizza);
        
        productosp2.add(prodp3);
        productosp2.add(prodp4);
        
        ProductoDelPedido prodp5=new ProductoDelPedido(1);
        prodp5.asignarUnProducto(papasFritas);
        ProductoDelPedido prodp6=new ProductoDelPedido(2);
        prodp6.asignarUnProducto(hamburguesa);
        
        productosp3.add(prodp5);
        productosp3.add(prodp6);
        
        pedido1.setProductos(productosp1);
        pedido2.setProductos(productosp2);
        pedido3.setProductos(productosp3);
        
        for(Pedido p:pedidos){
            p.mostrar();
        }
        
    }
}
