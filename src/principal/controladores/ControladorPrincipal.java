/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos. *;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        
        
//        ArrayList<Cliente> clientes = new ArrayList ();
//        ArrayList<Encargado> encargados = new ArrayList ();
//        ArrayList<Empleado> empleados = new ArrayList ();
        ArrayList<Producto> productos = new ArrayList ();
        
//         Cliente cliente1 = new Cliente();
//         Cliente cliente2 = new Cliente();
//         Cliente cliente3 = new Cliente();
//         
//         Encargado encargado1 = new Encargado();
//         Encargado encargado2 = new Encargado();
//         Encargado encargado3 = new Encargado();
//         
//         Empleado empleado1 = new Empleado();
//         Empleado empleado2 = new Empleado();
//         Empleado empleado3 = new Empleado();
//        
        
        Producto hamburguesa = new Producto(1234,"Hamburguesa","Comida","Disponible",8000f);
        Producto pizza = new Producto(5678,"Pizza","Comida","No disponible",12000f);
        Producto papasFritas = new Producto(91011,"Papas Fritas","Comida","Disponible",5000f);
        
        
//        cliente1.apellido = "Varga";
//        cliente2.apellido = "Molina";
//        cliente3.apellido = "Gomez";
//        
//        encargado1.apellido ="Fernandez";
//        encargado2.apellido ="Martinez";
//        encargado3.apellido ="Alvares";
//        
//        empleado1.apellido ="Fuentes";
//        empleado2.apellido ="Lopez";
//        empleado3.apellido ="Aguilera";
//        
        productos.add(hamburguesa);
        productos.add(pizza);
        productos.add(papasFritas);
        
//        clientes.add(cliente1);
//        clientes.add(cliente2);
//        clientes.add(cliente3);
//        
//        encargados.add(encargado1);
//        encargados.add(encargado2);
//        encargados.add(encargado3);
//        
//        empleados.add(empleado1);
//        empleados.add(empleado2);
//        empleados.add(empleado3);
        
        
        System.out.println("------Productos------\n");
        for (Producto p: productos ){
            p.mostrar();
        }
//        System.out.println("------clientes------\n");
//        for (Cliente c: clientes ){
//            c.mostrar();
//        }
//        System.out.println("------encargados------\n");
//        for (Encargado e: encargados ){
//            e.mostrar();
//        }
//        System.out.println("------empleados------\n");
//        for (Empleado e: empleados ){
//            e.mostrar();
//        }
        
        System.out.println("Cambiando...\n");
//        
        productos.get(0).asignarPrecio(12000f);
        productos.get(1).asignarEstado("No disponible");
        productos.get(2).asignarCodigo(4567);
//        
        for (Producto p: productos ){
            p.mostrar();
        }
        
    }
}
