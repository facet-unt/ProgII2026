/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto unProducto1 = new Producto(1, "Pizza", 45.23f, "Disponible", "Plato Principal");
        Producto unProducto2 = new Producto(2, "Milanesa", 49.13f, "Disponible", "Plato Principal");
        Producto unProducto3 = new Producto(3, "Hamburguesa", 10.67f, "Disponible", "Plato Principal");
               
        Cliente unCliente1 = new Cliente();
        Cliente unCliente2 = new Cliente();
        Cliente unCliente3 = new Cliente();
        
        Empleado unEmpleado1 = new Empleado();
        Empleado unEmpleado2 = new Empleado();
        Empleado unEmpleado3 = new Empleado();
        
        Encargado unEncargado1 = new Encargado();
        Encargado unEncargado2 = new Encargado();
        Encargado unEncargado3 = new Encargado();
        
        unCliente1.apellido = "Mora";
        unCliente1.nombre = "Manuel Raul";
        unCliente1.correo = "manuelmora@gmail.com";
        unCliente1.clave = "1234";
        
        unCliente2.apellido = "Lucero";
        unCliente2.nombre = "Romina";
        unCliente2.correo = "luceroromi@gmail.com";
        unCliente2.clave = "5678";
        
        unCliente3.apellido = "Galindez";
        unCliente3.nombre = "Mauro";
        unCliente3.correo = "maurigalindez@gmail.com";
        unCliente3.clave = "9102";
        
        unEmpleado1.apellido = "Castanio";
        unEmpleado1.nombre = "Kevin";
        unEmpleado1.correo = "castanio@gmail.com";
        unEmpleado1.clave = "1234";
        
        unEmpleado2.apellido = "Castillo";
        unEmpleado2.nombre = "Maria";
        unEmpleado2.correo = "castillo@gmail.com";
        unEmpleado2.clave = "5678";
        
        unEmpleado3.apellido = "Quiroga";
        unEmpleado3.nombre = "Josefina";
        unEmpleado3.correo = "josefina@gmail.com";
        unEmpleado3.clave = "9012";

        unEncargado1.apellido = "Montenegro";
        unEncargado1.nombre = "Cristian";
        unEncargado1.correo = "cris@gmail.com";
        unEncargado1.clave = "1234";
        
        unEncargado2.apellido = "Montenegro";
        unEncargado2.nombre = "Cristian";
        unEncargado2.correo = "cris@gmail.com";
        unEncargado2.clave = "1234";
        
        unEncargado3.apellido = "Montenegro";
        unEncargado3.nombre = "Cristian";
        unEncargado3.correo = "cris@gmail.com";
        unEncargado3.clave = "1234";
        
        ArrayList<Cliente> listaclientes = new ArrayList<>();
        ArrayList<Empleado> listaempleados = new ArrayList<>();
        ArrayList<Encargado> listaencargados = new ArrayList<>();
        ArrayList<Producto> listaproductos = new ArrayList<>();
        
        listaclientes.add(unCliente3);
        listaclientes.add(unCliente2);
        listaclientes.add(unCliente1);

        listaempleados.add(unEmpleado1);
        listaempleados.add(unEmpleado2);
        listaempleados.add(unEmpleado3);
        
        listaencargados.add(unEncargado1);
        listaencargados.add(unEncargado2);
        listaencargados.add(unEncargado3);
        
        listaproductos.add(unProducto1);
        listaproductos.add(unProducto2);
        listaproductos.add(unProducto3);
        
        System.out.println("---------- CLIENTES ----------");
        
        for(Cliente unCliente : listaclientes){
            unCliente.mostrar();
            System.out.println();
        }
        
        System.out.println("---------- EMPLEADOS ---------");
        
        for(Empleado unEmpleado : listaempleados){
            unEmpleado.mostrar();
            System.out.println();
        }
        
        System.out.println("---------- ENCARGADOS ---------");

        for(Encargado unEncargado : listaencargados){
            unEncargado.mostrar();
            System.out.println();
        }
        
        System.out.println("---------- PRODUCTOS ----------");
        
        for(Producto unProducto : listaproductos){
            unProducto.mostrar();
            System.out.println();
        }
        
        listaproductos.get(0).asignarPrecio(126.45f);
        
        listaproductos.get(1).asignarEstado("No Disponible");
        
        listaproductos.get(2).asignarCategoria("Entrada");
        
        System.out.println("---------- LISTA ACTUALIZADA DE PRODUCTOS ----------");
        
        for(Producto producto : listaproductos){
            producto.mostrar();
            System.out.println();
        }
    }
    
}
