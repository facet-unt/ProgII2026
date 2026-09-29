/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
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
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        
        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 = new Producto(1, "Producto1", 1550.8f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto p2= new Producto(2, "Producto2", 850.8f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        Producto p3 = new Producto(3, "Producto3", 1050.0f, Estado.DISPONIBLE, Categoria.PLATO_PRINCIPAL);
        
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

        for (Empleado e: listaEmpleados){
            e.mostrar();
        }
     }
}
