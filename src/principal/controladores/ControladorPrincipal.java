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
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        

        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        

        for (Cliente e: clientes)
           e.mostrar();
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS");
        Empleado e1 = new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3 = new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
               
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);

        for (Empleado e: empleados)
            e.mostrar();
        
        //Realizar algunas modificaciones a algunos de los objetos antes creados
        e1.asignarApellido("APELLIDOEmpleado11");
        empleados.get(1).asignarNombre("NOMBREEMPLEADO11");
        
        for (Empleado e: empleados)
            e.mostrar();
        
        System.out.println("#################### ");
        System.out.println("ENCARGADOS");
        Encargado unEncargado1 = new Encargado("encargado1@mail.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Encargado unEncargado2 = new Encargado("encargado2@mail.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Encargado unEncargado3 = new Encargado("encargado3@mail.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        
        encargados.add(unEncargado1);
        encargados.add(unEncargado2);
        encargados.add(unEncargado3);
        
        for (Encargado e: encargados)
            e.mostrar();
    }
}
