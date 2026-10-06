/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
import productos.modelos.Producto;
import usuarios.modelos.Encargado;
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
        Pedido pedidos;
        
        
        Cliente cliente1 = new Cliente("martinvarga@hotmail.com","1234","Varga","Martin");
        Cliente cliente2 = new Cliente("joseluisM@hotmail.com","4567","Molina","Jose Luis");
        Cliente cliente3 = new Cliente("juliGz@hotmail.com","9096","Gomez","Julieta");
         
        Encargado encargado1 = new Encargado("fernandezjuan@hotmail.com","3334","Fernandez","Juan");
        Encargado encargado2 = new Encargado("martinezK@hotmail.com","5557","Martinez","Kevin");
        Encargado encargado3 = new Encargado("alvaresTomas@hotmail.com","88854","Alvares","Tomas");
         
        Empleado empleado1 = new Empleado("fuentesmario@hotmail.com","3334","Fuentes","Mario");
        Empleado empleado2 = new Empleado("lopez@hotmail.com","111111","Lopez","Hector");
        Empleado empleado3 = new Empleado("alguileraC@hotmail.com","2026","Aguilera","Cristina");
      

        Producto hamburguesa = new Producto(1234,"Hamburguesa","Comida","Disponible",8000f);
        Producto pizza = new Producto(5678,"Pizza","Comida","No disponible",12000f);
        Producto papasFritas = new Producto(91011,"Papas Fritas","Comida","Disponible",5000f);
        
        
        productos.add(hamburguesa);
        productos.add(pizza);
        productos.add(papasFritas);
        
        pedidos = new Pedido(1, cliente1);
        pedidos.asignarProductoDelPedido(19, pizza);
        pedidos.asignarProductoDelPedido(20, hamburguesa);
        pedidos.asignarProductoDelPedido(120, papasFritas);
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        encargados.add(encargado1);
        encargados.add(encargado2);
        encargados.add(encargado3);
        
        empleados.add(empleado1);
        empleados.add(empleado2);
        empleados.add(empleado3);
        
        
        pedidos.mostrar();
        
//        System.out.println("------Productos------\n");
//        
//        System.out.println("Con toString:");
//        System.out.println(hamburguesa.toString());
//        
//        System.out.println("Sin toString (metodo mostrar):");
//        for (Producto p: productos ){
//            p.mostrar();
//        }
//        System.out.println("------Clientes------\n");
//        for (Cliente c: clientes ){
//            c.mostrar();
//        }
//        System.out.println("------Encargados------\n");
//        for (Encargado e: encargados ){
//            e.mostrar();
//        }
//        System.out.println("------Empleados------\n");
//        for (Empleado e: empleados ){
//            e.mostrar();
//        }
//        
//        System.out.println("Cambiando...\n");
//        
//        productos.get(0).asignarPrecio(12000f);
//        productos.get(1).asignarEstado("No disponible");
//        productos.get(2).asignarCodigo(4567);
//        
//        clientes.get(2).asignarClave("454647");
//        empleados.get(1).verCorreo();
//        encargados.get(1).asignarApellido("Falcon");
//        encargados.get(0).asignarClave("346789");
//        empleados.get(2).asignarClave("0000");
//        
//        System.out.println("===Productos despues de las modificaciones===");
//        
//        for (Producto p: productos ){
//            p.mostrar();
//        }
//        
//        System.out.println("===Clientes despues de las modificaciones===");
//        
//        for (Cliente c: clientes ){
//            c.mostrar();
//        }
//        
//        System.out.println("===Encargados despues de las modificaciones===");
//        
//        for (Encargado e: encargados ){
//            e.mostrar();
//        }
//        
//        System.out.println("===Empleados despues de las modificaciones===");
//        
//        for (Empleado e: empleados ){
//            e.mostrar();
//        }
////

    }
}
