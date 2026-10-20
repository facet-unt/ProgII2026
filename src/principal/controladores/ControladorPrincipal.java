/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
import pedidos.modelos.EstadoPedido;
import productos.modelos.Categoria;
import productos.modelos.EstadoProducto;
import productos.modelos.Producto;
import usuarios.modelos.*;

/**
 *
 * @author Arebalo
 * @author Peralta
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        
        
        ArrayList<Cliente> clientes = new ArrayList <>();
        ArrayList<Encargado> encargados = new ArrayList <>();
        ArrayList<Empleado> empleados = new ArrayList <>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        Cliente cliente1 = new Cliente("martinvarga@hotmail.com","1234","Varga","Martin");
        Cliente cliente2 = new Cliente("joseluisM@hotmail.com","4567","Molina","Jose Luis");
        Cliente cliente3 = new Cliente("juliGz@hotmail.com","9096","Gomez","Julieta");
         
        Encargado encargado1 = new Encargado("fernandezjuan@hotmail.com","3334","Fernandez","Juan");
        Encargado encargado2 = new Encargado("martinezK@hotmail.com","5557","Martinez","Kevin");
        Encargado encargado3 = new Encargado("alvaresTomas@hotmail.com","88854","Alvares","Tomas");
         
        Empleado empleado1 = new Empleado("fuentesmario@hotmail.com","3334","Fuentes","Mario");
        Empleado empleado2 = new Empleado("lopez@hotmail.com","111111","Lopez","Hector");
        Empleado empleado3 = new Empleado("alguileraC@hotmail.com","2026","Aguilera","Cristina");
      
        
        Producto hamburguesa = new Producto(1234,"Hamburguesa",Categoria.PLATO_PRINCIPAL,EstadoProducto.DISPONIBLE,8000f);
        Producto pizza = new Producto(5678,"Pizza",Categoria.PLATO_PRINCIPAL,EstadoProducto.DISPONIBLE,12000f);
        Producto papasFritas = new Producto(91011,"Papas Fritas",Categoria.ENTRADA,EstadoProducto.DISPONIBLE,5000f);
        
        
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
        
        
        System.out.println("------Productos------\n");
        
        System.out.println("Con toString:");
        System.out.println(hamburguesa);
        
        System.out.println("Sin toString (metodo mostrar):");
        for (Producto p: productos ){
            p.mostrar();
        }
        System.out.println("------Clientes------\n");
        for (Cliente c: clientes ){
            c.mostrar();
        }
        System.out.println("------Encargados------\n");
        for (Encargado e: encargados ){
            e.mostrar();
        }
        System.out.println("------Empleados------\n");
        for (Empleado e: empleados ){
            e.mostrar();
        }
        
        System.out.println("Cambiando...\n");
        
        productos.get(0).asignarPrecio(12000f);
//        productos.get(1).asignarEstado("No disponible");
        productos.get(2).asignarCodigo(4567);
        
        clientes.get(2).asignarClave("454647");
        empleados.get(1).verCorreo();
        encargados.get(1).setApellido("Falcon");
        encargados.get(0).asignarClave("346789");
        empleados.get(2).asignarClave("0000");
        
        System.out.println("===Productos despues de las modificaciones===");
        
        for (Producto p: productos ){
            p.mostrar();
        }
        
        System.out.println("===Clientes despues de las modificaciones===");
        
        for (Cliente c: clientes ){
            c.mostrar();
        }
        
        System.out.println("===Encargados despues de las modificaciones===");
        
        for (Encargado e: encargados ){
            e.mostrar();
        }
        
        System.out.println("===Empleados despues de las modificaciones===");
        
        for (Empleado e: empleados ){
            e.mostrar();
            
        }
        Pedido p1 = new Pedido(1,LocalDateTime.of(2026, 9, 27, 9, 41),EstadoPedido.CREADO,cliente1);
        Pedido p2 = new Pedido(2,LocalDateTime.now(),EstadoPedido.CREADO,cliente2);
        
        p1.agregarProducto(pizza, 3);
        p1.agregarProducto(hamburguesa, 1);
        
        pedidos.add(p1);
        pedidos.add(p2);
        
        p1.mostrar();
        p2.mostrar();
    }
}