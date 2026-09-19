/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import productos.modelos.Producto;


public class ControladorPrincipal {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList <Empleado> empleados = new ArrayList<>();
        ArrayList <Encargado> encargados = new ArrayList<>();
        ArrayList <Producto> productos = new ArrayList<>();
        //Agregado de clientes
        Cliente c1= new Cliente("Correo 1","Clave 1","Apellido 1", "Nombre 1");
        Cliente c2= new Cliente("Correo 2","Clave 2","Apellido 2", "Nombre 2");
        Cliente c3= new Cliente("Correo 3","Clave 3","Apellido 3", "Nombre 3");
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        //Agregado de Empleados
        Empleado e1=new Empleado("Correo 1","Clave 1","Apellido 1", "Nombre 1");
        Empleado e2=new Empleado("Correo 2","Clave 2","Apellido 2", "Nombre 2");
        Empleado e3=new Empleado("Correo 3","Clave 3","Apellido 3", "Nombre 3");
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        //Agregado Encargados
        Encargado en1=new Encargado("Correo 1","Clave 1","Apellido 1", "Nombre 1");
        Encargado en2=new Encargado("Correo 2","Clave 2","Apellido 2", "Nombre 2");
        Encargado en3=new Encargado("Correo 3","Clave 3","Apellido 3", "Nombre 3");
        encargados.add(en1);
        encargados.add(en2);
        encargados.add(en3);
        //Agregado de productos
        Producto p1=new Producto(1,"Descripcion1","Categoria1","Estado1",1);
        Producto p2=new Producto(2,"Descripcion2","Categoria2","Estado2",2);
        Producto p3=new Producto(3,"Descripcion3","Categoria3","Estado3",3);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        System.out.println("CLIENTES");
        //Muestra de Clientes
        for(Cliente c: clientes){
            c.mostrar();
        }
        System.out.println("EMPLEADOS");
        //Muestra de Empleados
        for(Empleado e:empleados){
            e.mostrar();
        }
        System.out.println("ENCARGADOS");
        //Muestra de Encargados
        for(Encargado en: encargados){
            en.mostrar();
        }
        System.out.println("PRODUCTOS");
        //Muestra de Productos
        for(Producto p: productos){
            p.mostrar();
        }
    for(int i=0; i<clientes.size();i++){
        Cliente c=clientes.get(i);
        int num=i+2;
        c.correo= "Correo"+num;
        c.clave="Clave"+num;
        c.apellido="Apellido"+num;
        c.nombre="Nombre"+num;
        
    }
    for(int i=0;i<empleados.size();i++){
        Empleado e=empleados.get(i);
        int num=i+2;
        e.correo= "Correo"+num;
        e.clave="Clave"+num;
        e.apellido="Apellido"+num;
        e.nombre="Nombre"+num;
        
    }
    for(int i=0; i<encargados.size();i++){
        Encargado en=encargados.get(i);
        int num=i+2;
        en.correo= "Correo"+num;
        en.clave="Clave"+num;
        en.apellido="Apellido"+num;
        en.nombre="Nombre"+num;
    }
    for(int i=0;i<productos.size();i++){
        Producto p=productos.get(i);
        int num=i+2;
        p.codigo=num;
        p.descripcion="Descripcion"+num;
        p.categoria="Categoria"+num;
        p.estado="Estado"+num;
        p.precio=num;
    }
    System.out.println("CLIENTES MODIFICADOS");
    for(Cliente c:clientes){
        c.mostrar();
    }
    System.out.println("EMPLEADOS MODIFICADOS");
    for(Empleado e:empleados){
        e.mostrar();
    }
    System.out.println("ENCARGADOS MODIFICADOS");
    for(Encargado en:encargados){
        en.mostrar();
    }
    System.out.println("PRODUCTOS MODIFICADOS");
    for(Producto p:productos){
        p.mostrar();
    }
    }
}
