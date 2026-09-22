/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
 * this license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package principal.controladores;

import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Encargado> listaEncargados = new ArrayList<>();
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        ArrayList<Producto> listaProductos = new ArrayList<>();

        System.out.println("#################### ");
        System.out.println("PRODUCTOS");
        Producto p1 =
            new Producto(1, "Producto1", "Plato Principal", "Disponible", 1550.8f);
        Producto p2 = new Producto(2, "Producto2", "Postre", "Disponible", 850.8f);
        Producto p3 =
            new Producto(3, "Producto3", "Plato Principal", "No Disponible", 1050.0f);

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);

        System.out.println("PRODUCTOS usando mostrar()");
        for (Producto p: listaProductos) p.mostrar();

        listaProductos.get(2).asignarDescripcion("Producto 3");
        System.out.println("\nEl precio del producto es :" +
                           listaProductos.get(2).verPrecio());
        listaProductos.get(2).asignarPrecio(1898.98f);
        System.out.println("El nuevo precio del producto es :" +
                           listaProductos.get(2).verPrecio());

        System.out.println("\nPRODUCTOS usando toString()");
        for (Producto p: listaProductos) System.out.println(p);
        System.out.println("#################### ");

        // System.out.println("#################### ");
        // System.out.println("CLIENTES");
        // Cliente cliente1 = new Cliente("cliente1@bar.com", "claveCliente1",
        //                                "ApellidoCliente1", "NombreCliente1");
        // Cliente cliente2 = new Cliente("cliente2@bar.com", "claveCliente2",
        //                                "ApellidoCliente2", "NombreCliente2");
        // Cliente cliente3 = new Cliente("cliente3@bar.com", "claveCliente3",
        //                                "ApellidoCliente3", "NombreCliente3");

        // listaClientes.add(cliente1);
        // listaClientes.add(cliente2);
        // listaClientes.add(cliente3);

        // for (Cliente e: listaClientes) e.mostrar();

        // System.out.println("#################### ");
        // System.out.println("EMPLEADOS");
        // Empleado e1 = new Empleado("empleado1@mail.com", "123", "ApellidoEmpleado1",
        //                            "NombreEmpleado1");
        // Empleado e2 = new Empleado("empleado2@mail.com", "123", "ApellidoEmpleado2",
        //                            "NombreEmpleado2");
        // Empleado e3 = new Empleado("empleado3@mail.com", "123", "ApellidoEmpleado3",
        //                            "NombreEmpleado3");

        // listaEmpleados.add(e1);
        // listaEmpleados.add(e2);
        // listaEmpleados.add(e3);

        // for (Empleado e: listaEmpleados) e.mostrar();

        // // Realizar algunas modificaciones a algunos de los objetos antes creados
        // e1.asignarApellido("APELLIDOEmpleado11");
        // listaEmpleados.get(1).asignarNombre("NOMBREEMPLEADO11");

        // for (Empleado e: listaEmpleados) e.mostrar();

        // System.out.println("#################### ");
        // System.out.println("ENCARGADOS");
        // Encargado unEncargado1 = new Encargado("encargado1@mail.com",
        // "claveEncargado1",
        //                                        "ApellidoEncargado1",
        //                                        "NombreEncargado1");
        // Encargado unEncargado2 = new Encargado("encargado2@mail.com",
        // "claveEncargado2",
        //                                        "ApellidoEncargado2",
        //                                        "NombreEncargado2");
        // Encargado unEncargado3 = new Encargado("encargado3@mail.com",
        // "claveEncargado3",
        //                                        "ApellidoEncargado3",
        //                                        "NombreEncargado3");

        // listaEncargados.add(unEncargado1);
        // listaEncargados.add(unEncargado2);
        // listaEncargados.add(unEncargado3);

        // for (Encargado e: listaEncargados) e.mostrar();
    }
}
