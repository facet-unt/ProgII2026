/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import java.util.ArrayList;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 * @author Peralta
 */
public class ControladorPrincipalTP4Seccion2 {
    public static void main(String[] args) {
    /*
    ***************************************************
    ***************************************************
    ***************************************************
    INICIO Segunda parte - herencia
//  */
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        Usuario unCliente1 = new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");        
        Usuario unCliente2 = new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");        
        Usuario unCliente3 = new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
        Usuario unCliente4 = new Cliente("cliente3@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4"); 
        //unCliente4 repetido con unCliente3
        
        if (!usuarios.contains(unCliente1)) { usuarios.add(unCliente1); System.out.println("Se agrego unCliente1: " + unCliente1.verCorreo()); } else { System.out.println("No se agrego unCliente1 por correo duplicado: " + unCliente1.verCorreo()); } //Corregido*
        /*
        *************************************************
        AGREGAR aqui las sentencias para sumar a la lista los 
        unCliente2, unCliente3, unCliente4 mostrando en output el resultado para
        visualizar mejor
        *************************************************
        */
        if (!usuarios.contains(unCliente2)) { usuarios.add(unCliente2); System.out.println("Se agrego unCliente2: " + unCliente2.verCorreo()); } else { System.out.println("No se agrego unCliente2 por correo duplicado: " + unCliente2.verCorreo()); } //Corregido*
        if (!usuarios.contains(unCliente3)) { usuarios.add(unCliente3); System.out.println("Se agrego unCliente3: " + unCliente3.verCorreo()); } else { System.out.println("No se agrego unCliente3 por correo duplicado: " + unCliente3.verCorreo()); } //Corregido*
        if (!usuarios.contains(unCliente4)) {
            usuarios.add(unCliente4);
            System.out.println("Se agrego unCliente4: " + unCliente4.verCorreo()); //Corregido*
        } else {
            System.out.println("No se agrego unCliente4 por correo duplicado: " + unCliente4.verCorreo());
        }
        
        System.out.println();        
                
        Usuario unEmpleado1 = new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");        
        Usuario unEmpleado2 = new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");        
        Usuario unEmpleado3 = new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
        Usuario unEmpleado4 = new Empleado("empleado3@bar.com", "claveEmpleado4", "ApellidoEmpleado4", "NombreEmpleado4");
        //empleado repetido
        
         /*
        *************************************************
        AGREGAR aqui las sentencias para sumar a la lista los 
        Empleados que corresponda mostrando en output el resultado para
        visualizar mejor
        *************************************************
        */
        if (!usuarios.contains(unEmpleado1)) { usuarios.add(unEmpleado1); System.out.println("Se agrego unEmpleado1: " + unEmpleado1.verCorreo()); } else { System.out.println("No se agrego unEmpleado1 por correo duplicado: " + unEmpleado1.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEmpleado2)) { usuarios.add(unEmpleado2); System.out.println("Se agrego unEmpleado2: " + unEmpleado2.verCorreo()); } else { System.out.println("No se agrego unEmpleado2 por correo duplicado: " + unEmpleado2.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEmpleado3)) { usuarios.add(unEmpleado3); System.out.println("Se agrego unEmpleado3: " + unEmpleado3.verCorreo()); } else { System.out.println("No se agrego unEmpleado3 por correo duplicado: " + unEmpleado3.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEmpleado4)) {
            usuarios.add(unEmpleado4);
            System.out.println("Se agrego unEmpleado4: " + unEmpleado4.verCorreo()); //Corregido*
        } else {
            System.out.println("No se agrego unEmpleado4 por correo duplicado: " + unEmpleado4.verCorreo());
        }
       
        System.out.println("Clientes");
        System.out.println("=========");
         /*
        *************************************************
        AGREGAR aqui las sentencias para mostrar UNICAMENTE los
        Usuarios de la lista que son Clientes
        *************************************************
        */
        for (Usuario u : usuarios) {
            if (u instanceof Cliente) {
                u.mostrar();
            }
        }
        
        System.out.println("Empleados");
        System.out.println("=========");
         /*
        *************************************************
        AGREGAR aqui las sentencias para mostrar UNICAMENTE los
        Usuarios de la lista que son Empleados
        *************************************************
        */
        for (Usuario u : usuarios) {
            if (u instanceof Empleado) {
                u.mostrar();
            }
        }
        
        System.out.println();

        Usuario unEncargado1 = new Encargado("encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
        Usuario unEncargado2 = new Encargado("encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
        Usuario unEncargado3 = new Encargado("encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
        Usuario unEncargado4 = new Encargado("encargado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        //encargado repetido mismo correo que otro encargado

        /*
        *************************************************
        AGREGAR aqui las sentencias para sumar a la lista los 
        Encargados del al 4 mostrando en output el resultado para
        visualizar mejor
        *************************************************
        */
        if (!usuarios.contains(unEncargado1)) { usuarios.add(unEncargado1); System.out.println("Se agrego unEncargado1: " + unEncargado1.verCorreo()); } else { System.out.println("No se agrego unEncargado1 por correo duplicado: " + unEncargado1.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEncargado2)) { usuarios.add(unEncargado2); System.out.println("Se agrego unEncargado2: " + unEncargado2.verCorreo()); } else { System.out.println("No se agrego unEncargado2 por correo duplicado: " + unEncargado2.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEncargado3)) { usuarios.add(unEncargado3); System.out.println("Se agrego unEncargado3: " + unEncargado3.verCorreo()); } else { System.out.println("No se agrego unEncargado3 por correo duplicado: " + unEncargado3.verCorreo()); } //Corregido*
        if (!usuarios.contains(unEncargado4)) {
            usuarios.add(unEncargado4);
            System.out.println("Se agrego unEncargado4: " + unEncargado4.verCorreo()); //Corregido*
        } else {
            System.out.println("No se agrego unEncargado4 por correo duplicado: " + unEncargado4.verCorreo());
        }

        System.out.println();   
        
        Usuario unEncargado5 = new Encargado("cliente1@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        //mismo correo que un cliente, no debe agregarse
        /*
        Agregar aquí la sentencia para agregar unEncargado5 a la lista de usuarios,
        siempre que no se repita
        */
        if (!usuarios.contains(unEncargado5)) {
            usuarios.add(unEncargado5);
            System.out.println("Se agrego unEncargado5: " + unEncargado5.verCorreo()); //Corregido*
        } else {
            System.out.println("No se agrego unEncargado5 por repetir correo de cliente: " + unEncargado5.verCorreo());
        }
        
        Usuario unCliente5 = new Encargado("empleado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
        //mismo correo que un empleado, no debe agregarse
        /*
        Agregar aquí la sentencia para agregar unCliente5 a la lista de usuarios,
        siempre que no se repita
        */
        if (!usuarios.contains(unCliente5)) {
            usuarios.add(unCliente5);
            System.out.println("Se agrego unCliente5: " + unCliente5.verCorreo()); //Corregido*
        } else {
            System.out.println("No se agrego unCliente5 por repetir correo de empleado: " + unCliente5.verCorreo());
        }
        
        System.out.println("Todos");
        System.out.println("=====");
        for(Usuario u : usuarios) {
            u.mostrar();
            System.out.println();
        }
        System.out.println();
        /*
    FIN Segunda parte - herencia
    ***************************************************
    ***************************************************
    ***************************************************
    */
    }
}