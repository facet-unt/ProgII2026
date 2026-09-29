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
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", 1550.8f, "Disponible", "Plato Principal");
        Producto p2= new Producto(2, "Producto2", 850.8f, "Disponible", "Plato Principal");
        Producto p3 = new Producto(3, "Producto3", 1050.0f, "No Disponible", "Plato Principal");
        
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        
        System.out.println("PRODUCTOS usando mostrar()");
        for (Producto p: listaProductos)
            p.mostrar();
        
        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        
        ArrayList<Cliente> clientes = new ArrayList <>();
        ArrayList<Encargado> encargados = new ArrayList <>();
        ArrayList<Empleado> empleados = new ArrayList <>();
        ArrayList<Producto> productos = new ArrayList<>();
        
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +  listaProductos.get(2).verPrecio());
        
        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos)
            System.out.println(p);
        System.out.println("#################### ");
        
        System.out.println("#################### ");
        System.out.println("CLIENTES");
        Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");       
        Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        

        for (Cliente e: listaClientes)
           e.mostrar();
        
        System.out.println("#################### ");
        System.out.println("EMPLEADOS");
        Empleado e1 = new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1", "NombreEmpleado1");
        Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2", "NombreEmpleado2");
        Empleado e3 = new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3", "NombreEmpleado3");
               
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);

        for (Empleado e: listaEmpleados)
            e.mostrar();
        }
        
        System.out.println("Cambiando...\n");
        
        productos.get(0).asignarPrecio(12000f);
        productos.get(1).asignarEstado("No disponible");
        productos.get(2).asignarCodigo(4567);
        
        clientes.get(2).asignarClave("454647");
        empleados.get(1).verCorreo();
        encargados.get(1).asignarApellido("Falcon");
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
    }
}
