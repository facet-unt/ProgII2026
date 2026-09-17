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
       ArrayList<Cliente>client=new ArrayList<>();
       ArrayList<Empleado>emp=new ArrayList<>();
       ArrayList<Encargado>enc=new ArrayList<>();
       ArrayList<Producto>product=new ArrayList<>();
       
       Cliente unCliente1= new Cliente();
       Cliente unCliente2= new Cliente();
       Cliente unCliente3= new Cliente();
       
       Empleado unEmpleado1= new Empleado();
       Empleado unEmpleado2= new Empleado();
       Empleado unEmpleado3= new Empleado();
       
       Producto unProducto1= new Producto();
       Producto unProducto2= new Producto();
       Producto unProducto3= new Producto();
       
       Encargado unEncargado1= new Encargado();
       Encargado unEncargado2= new Encargado();
       Encargado unEncargado3= new Encargado();
       
      client.add(unCliente1); 
      client.add(unCliente2); 
      client.add(unCliente3);
      
      emp.add(unEmpleado1);
      emp.add(unEmpleado2);
      emp.add(unEmpleado3);
      
      enc.add(unEncargado1);
      enc.add(unEncargado2);
      enc.add(unEncargado3);
      
      product.add(unProducto1);
      product.add(unProducto2);
      product.add(unProducto3);
      
      System.out.println("=======================");
      for (Producto unProducto:product){
          unProducto.mostrar();
      }
      System.out.println("=======================");
      for (Cliente unCliente:client){
          unCliente.mostrar();
      }
      System.out.println("=======================");
      for (Empleado unEmpleado:emp){
          unEmpleado.mostrar();
      }
      System.out.println("=======================");
      for (Encargado unEncargado:enc){
          unEncargado.mostrar();
      }
      System.out.println("=======================");
      System.out.println("Modificaciones");
      unProducto1.descripcion="Hamburguesa doble";
      unCliente2.apellido="Juarez";
      unEmpleado3.clave="1234";
      
      System.out.println("=======================");
      for (Producto unProducto:product){
          unProducto.mostrar();
      }
      System.out.println("=======================");
      for (Cliente unCliente:client){
          unCliente.mostrar();
      }
      System.out.println("=======================");
      for (Empleado unEmpleado:emp){
          unEmpleado.mostrar();
      }
      System.out.println("=======================");
      for (Encargado unEncargado:enc){
          unEncargado.mostrar();
      }
      
    }
    
}
