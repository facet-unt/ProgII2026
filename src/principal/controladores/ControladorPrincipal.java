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
    
    /*Creación del ArrayList 'listaProductos', inicializar 3 objetos de clase 'Producto'
    y presentación por pantalla de los mismos*/
        ArrayList<Producto> listaProductos= new ArrayList<>();
        Producto Producto1 = new Producto();
        Producto Producto2 = new Producto();
        Producto Producto3 = new Producto();
        
        listaProductos.add(Producto1);
        listaProductos.add(Producto2);
        listaProductos.add(Producto3);
        
        System.out.println("Productos: ");
        for(Producto unProducto: listaProductos){
            unProducto.mostrar();
        }
        
    /*Creación del ArrayList 'listaClientes', inicializar 3 objetos de clase 'Cliente'
    y presentación por pantalla de los mismos*/
        ArrayList<Cliente> listaClientes= new ArrayList<>();
        Cliente Cliente1 = new Cliente();
        Cliente Cliente2 = new Cliente();
        Cliente Cliente3 = new Cliente();
        
        listaClientes.add(Cliente1);
        listaClientes.add(Cliente2);
        listaClientes.add(Cliente3);
        
        System.out.println("Clientes: ");
        for(Cliente unCliente: listaClientes){
            unCliente.mostrar();
        }
        
    /*Creación del ArrayList 'listaEmpleados', inicializar 3 objetos de clase 'Empleados'
    y presentación por pantalla de los mismos*/
        ArrayList<Empleado> listaEmpleados= new ArrayList<>();
        Empleado Empleado1 = new Empleado();
        Empleado Empleado2 = new Empleado();
        Empleado Empleado3 = new Empleado();
        
        listaEmpleados.add(Empleado1);
        listaEmpleados.add(Empleado2);
        listaEmpleados.add(Empleado3);
        
        System.out.println("Empleados: ");
        for(Empleado unEmpleado: listaEmpleados){
            unEmpleado.mostrar();
        }
        
    /*Creación del ArrayList 'listaEncargados', inicializar 3 objetos de clase 'Encargados'
    y presentación por pantalla de los mismos*/
        ArrayList<Encargado> listaEncargados= new ArrayList<>();
        Encargado Encargado1 = new Encargado();
        Encargado Encargado3 = new Encargado();
        Encargado Encargado2 = new Encargado();
        
        listaEncargados.add(Encargado1);
        listaEncargados.add(Encargado2);
        listaEncargados.add(Encargado3);
        
        System.out.println("Encargados: ");
        for(Encargado unEncargado: listaEncargados){
            unEncargado.mostrar();
        }
        
    /*Se modifican los objetos de las clases 'Cliente', 'Empleado', 'Encargado'
    y 'Producto' para darles valores específicos y luego se muestran en pantalla*/
        for (int i=0;i<listaClientes.size();i++){
            listaClientes.get(i).nombre="nombre de cliente "+(i+1);
            listaClientes.get(i).apellido="apellido de cliente ";
            listaClientes.get(i).correo="correo del cliente "+(i+1);
            listaClientes.get(i).clave="clave del cliente "+(i+1);
            listaClientes.get(i).mostrar();
        }
        for (int i=0;i<listaEmpleados.size();i++){
            listaEmpleados.get(i).nombre="nombre de empleado "+(i+1);
            listaEmpleados.get(i).apellido="apellido de empleado ";
            listaEmpleados.get(i).correo="correo del empleado "+(i+1);
            listaEmpleados.get(i).clave="clave del empleado "+(i+1);
            listaEmpleados.get(i).mostrar();
        }
        for (int i=0;i<listaEncargados.size();i++){
            listaEncargados.get(i).nombre="nombre de encargado "+(i+1);
            listaEncargados.get(i).apellido="apellido de encargado ";
            listaEncargados.get(i).correo="correo del encargado "+(i+1);
            listaEncargados.get(i).clave="clave del encargado "+(i+1);
            listaEncargados.get(i).mostrar();
        }
        for(int i = 0;i<listaProductos.size();i++){
            listaProductos.get(i).codigo = (i+1);
            listaProductos.get(i).descripcion = "descripcion"+(i+1);
            listaProductos.get(i).categoria = "Categoria"+(i+1);
            listaProductos.get(i).estado = true;
            listaProductos.get(i).precio = (i+1);
            listaProductos.get(i).mostrar();
        }
    }
}
