/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.*;
import productos.modelos.Producto;


/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
          ArrayList<Cliente> listaClientes = new ArrayList<>();
          ArrayList<Empleado> listaEmpleados = new ArrayList<>();
          ArrayList<Encargado> listaEnacargados = new ArrayList<>();
          ArrayList<Producto> listaProductos = new ArrayList<>();
          
          //Instanciamos objetos
          Cliente cliente1 = new Cliente();
          Cliente cliente2 = new Cliente();
          Cliente cliente3 = new Cliente();
          
          Empleado empleado1 = new Empleado();
          Empleado empleado2 = new Empleado();
          Empleado empleado3 = new Empleado();
          
          Encargado encargado1 = new Encargado();
          Encargado encargado2 = new Encargado();
          Encargado encargado3 = new Encargado();
          
          Producto producto1 = new Producto();
          Producto producto2 = new Producto();
          Producto producto3 = new Producto();
          
          //Los agregamos a sus respectivas colecciones
          listaEnacargados.add(encargado1);
          listaEnacargados.add(encargado2);
          listaEnacargados.add(encargado3);
          
          listaClientes.add(cliente1);
          listaClientes.add(cliente2);
          listaClientes.add(cliente3);
          
          listaEmpleados.add(empleado1);
          listaEmpleados.add(empleado2);
          listaEmpleados.add(empleado3);
          
          listaProductos.add(producto1);
          listaProductos.add(producto2);
          listaProductos.add(producto3);
          
          //Recorremos los arrayList
//          for (Cliente unCliente : listaClientes) {
//            unCliente.mostrar();
//        }
//          
//        for (Empleado unEmpleado : listaEmpleados) {
//            unEmpleado.mostrar();
//        }
//        
//        for (Encargado unEncargado : listaEnacargados) {
//            unEncargado.mostrar();
//        }
//          
//        for (Producto unProducto : listaProductos) {
//            unProducto.mostrar();
//        }
        
        //Modificamos algunos objetos
        producto1.codigo = 1;
        producto1.descripcion = "Arroz integral";
        producto1.estado = false;
        producto1.precio = 1400;
        
        //Recorremos los arrayList
          for (Cliente unCliente : listaClientes) {
            unCliente.mostrar();
        }
          
        for (Empleado unEmpleado : listaEmpleados) {
            unEmpleado.mostrar();
        }
        
        for (Encargado unEncargado : listaEnacargados) {
            unEncargado.mostrar();
        }
          
        for (Producto unProducto : listaProductos) {
            unProducto.mostrar();
        }
    }
}
