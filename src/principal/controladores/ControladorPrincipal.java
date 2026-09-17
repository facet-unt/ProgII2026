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
        
        
        ArrayList<Cliente> clientes = new ArrayList ();
        ArrayList<Encargado> encargados = new ArrayList ();
        ArrayList<Empleado> empleados = new ArrayList ();
        ArrayList<Producto> productos = new ArrayList ();
        
         Cliente cliente1 = new Cliente();
         Cliente cliente2 = new Cliente();
         Cliente cliente3 = new Cliente();
         
         Encargado encargado1 = new Encargado();
         Encargado encargado2 = new Encargado();
         Encargado encargado3 = new Encargado();
         
         Empleado empleado1 = new Empleado();
         Empleado empleado2 = new Empleado();
         Empleado empleado3 = new Empleado();
        
        
        Producto hamburguesa = new Producto();
        Producto pizza = new Producto();
        Producto papasFritas = new Producto();
        
        hamburguesa.descripcion = "Hamburguesa";
        pizza.descripcion = "Pizza";
        papasFritas.descripcion = "Papas Fritas";
        hamburguesa.precio = 7000f;
        
        cliente1.apellido = "Varga";
        cliente2.apellido = "Molina";
        cliente3.apellido = "Gomez";
        
        encargado1.apellido ="Fernandez";
        encargado2.apellido ="Martinez";
        encargado3.apellido ="Alvares";
        
        empleado1.apellido ="Fuentes";
        empleado2.apellido ="Lopez";
        empleado3.apellido ="Aguilera";
        
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
        
        
        System.out.println("------productos------\n");
        for (Producto p: productos ){
            p.mostrar();
        }
        System.out.println("------clientes------\n");
        for (Cliente c: clientes ){
            c.mostrar();
        }
        System.out.println("------encargados------\n");
        for (Encargado e: encargados ){
            e.mostrar();
        }
        System.out.println("------empleados------\n");
        for (Empleado e: empleados ){
            e.mostrar();
        }
        
        System.out.println("cambiando precio de hamburguesa\n");
        
        productos.get(0).precio=8000f;
        
        for (Producto p: productos ){
            p.mostrar();
        }
        
    }
}
