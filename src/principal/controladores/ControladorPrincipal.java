/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import productos.modelos.*;
import usuarios.modelos.*;

/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        ArrayList<Encargado> listaEncargado = new ArrayList<>();
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        ArrayList<Producto> listaProducto = new ArrayList<>();
        
        //Instanciar y agregar los Clientes a su correspondiente arraylist
        listaCliente.add(new Cliente());
        listaCliente.add(new Cliente());
        listaCliente.add(new Cliente());
        
        //Instanciar y agregar los Encargados a su correspondiente arraylist
        listaEncargado.add(new Encargado());
        listaEncargado.add(new Encargado());
        listaEncargado.add(new Encargado());
        
        //Instanciar y agregar los Empleados a su correspondiente arraylist
        listaEmpleado.add(new Empleado());
        listaEmpleado.add(new Empleado());
        listaEmpleado.add(new Empleado());
        
        //Instanciar y agregar los Productos a su correspondiente arraylist
        listaProducto.add(new Producto());
        listaProducto.add(new Producto());
        listaProducto.add(new Producto());
        
        //Presentacion de los Elementos de cada ArrayList
        System.out.printf("\t\tClientes\t\t");                   
        for(Cliente unCliente : listaCliente){
            unCliente.mostrar();                   
        }
        
        System.out.printf("\t\tEmpleados\t\t");           
        for(Empleado unEmpleado : listaEmpleado){
            unEmpleado.mostrar();                  
        }
        
        System.out.printf("\t\tEncargados\t\t");           
        for(Encargado unEncargado : listaEncargado){
            unEncargado.mostrar();                   
        }
        
        System.out.printf("\t\tProductos\t\t\n");           
        for(Producto unProducto : listaProducto){
            unProducto.mostrar();                
        }
        
        //Modificaciones de las varibles de instancias de cada uno de los objetos
        
        for(int i=0 ; i<listaCliente.size();){
            Cliente unCliente = listaCliente.get(i);
            i++;
            unCliente.apellido="Apellido "+i;
            unCliente.clave ="Clave "+i;
            unCliente.correo ="Correo "+i;
            unCliente.nombre ="Nombre "+i;
        }
        
        for(int i=0 ; i<listaEmpleado.size();){
            Empleado unEmpleado = listaEmpleado.get(i);
            i++;
            unEmpleado.apellido="Apellido "+i;
            unEmpleado.clave ="Clave "+i;
            unEmpleado.correo ="Correo "+i;
            unEmpleado.nombre ="Nombre "+i;
        }
        
        for(int i=0 ; i<listaEncargado.size();){
            Encargado unEncargado = listaEncargado.get(i);
            i++;
            unEncargado.apellido="Apellido "+i;
            unEncargado.clave ="Clave "+i;
            unEncargado.correo ="Correo "+i;
            unEncargado.nombre ="Nombre "+i;
        }
        for(int i=0; i<listaProducto.size();){
            Producto unProducto = listaProducto.get(i);
            float flotante = 0.0f;
            i++;
            flotante++;
           
            unProducto.categoria = "categoria "+ i;
            unProducto.codigo = i;
            unProducto.descripcion = "descripcion " + i;
            unProducto.estado = "estado " + i;
            unProducto.precio = flotante;
        }
        
        //Presentacion de los Elementos de cada ArrayList
        System.out.printf("\n\t\tClientes\t\t");                   
        for(Cliente unCliente : listaCliente){
            unCliente.mostrar();                   
        }
        
        System.out.printf("\n\t\tEmpleados\t\t");           
        for(Empleado unEmpleado : listaEmpleado){
            unEmpleado.mostrar();                  
        }
        
        System.out.printf("\n\t\tEncargados\t\t");           
        for(Encargado unEncargado : listaEncargado){
            unEncargado.mostrar();                   
        }
        
        System.out.printf("\n\t\tProductos\t\t\n");           
        for(Producto unProducto : listaProducto){
            unProducto.mostrar();
        }
    }
}
