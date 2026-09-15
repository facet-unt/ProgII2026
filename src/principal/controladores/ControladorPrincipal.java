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
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        p1.descripcion = "Hamburguesa";
        p2.descripcion = "Pizza";
        p1.mostrar();
        p2.mostrar();
        
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
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();
        
        
    }
}
