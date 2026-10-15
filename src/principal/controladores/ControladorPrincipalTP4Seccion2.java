/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 license
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
 */
public class ControladorPrincipalTP4Seccion2 {
  public static void main(String[] args) {
    /*
     ***************************************************
     ***************************************************
     ***************************************************
     * INICIO Segunda parte - herencia
     * //
     */
    ArrayList<Usuario> usuarios = new ArrayList<>();
    Usuario unCliente1 =
        new Cliente("cliente1@bar.com", "claveCliente1", "ApellidoCliente1", "NombreCliente1");
    Usuario unCliente2 =
        new Cliente("cliente2@bar.com", "claveCliente2", "ApellidoCliente2", "NombreCliente2");
    Usuario unCliente3 =
        new Cliente("cliente3@bar.com", "claveCliente3", "ApellidoCliente3", "NombreCliente3");
    Usuario unCliente4 =
        new Cliente("cliente3@bar.com", "claveCliente4", "ApellidoCliente4", "NombreCliente4");
    // unCliente4 repetido con unCliente3
    if (!usuarios.contains(unCliente1)) {
      usuarios.add(unCliente1);
    }

    // Para el agregado de nuevos clientes se usa un arreglo
    // temporal y anonimo que contiene a todos los clientes nuevos
    for (Usuario cl : new Usuario[] {unCliente2, unCliente3, unCliente4}) {
      if (!usuarios.contains(cl)) {
        usuarios.add(cl);
        System.out.println("Se agregó el cliente: " + cl.verCorreo());
      } else {
        System.out.println("No se pudo agregar (correo repetido): " + cl.verCorreo());
      }
    }

    System.out.println();
    Usuario unEmpleado1 =
        new Empleado("empleado1@bar.com", "claveEmpleado1", "ApellidoEmpleado1", "NombreEmpleado1");
    Usuario unEmpleado2 =
        new Empleado("empleado2@bar.com", "claveEmpleado2", "ApellidoEmpleado2", "NombreEmpleado2");
    Usuario unEmpleado3 =
        new Empleado("empleado3@bar.com", "claveEmpleado3", "ApellidoEmpleado3", "NombreEmpleado3");
    Usuario unEmpleado4 =
        new Empleado("empleado3@bar.com", "claveEmpleado4", "ApellidoEmpleado4", "NombreEmpleado4");
    // empleado repetido

    // Para agregar los empleados se usa un arreglo temporal
    // y anonimo que contiene a todos los empleados nuevos
    for (Usuario emp : new Usuario[] {unEmpleado1, unEmpleado2, unEmpleado3, unEmpleado4}) {
      if (!usuarios.contains(emp)) {
        usuarios.add(emp);
        System.out.println("Se agregó el empleado: " + emp.verCorreo());
      } else {
        System.out.println("No se pudo agregar (correo repetido): " + emp.verCorreo());
      }
    }

    System.out.println();
    System.out.println("Clientes");
    System.out.println("=========");

    // Para mostrar un tipo de usuario especifico, se itera
    // sobre todos los usuarios con ese tipo usando instanceof
    for (Usuario u : usuarios) {
      if (u instanceof Cliente) {
        u.mostrar();
      }
    }

    System.out.println();
    System.out.println("Empleados");
    System.out.println("=========");

    for (Usuario u : usuarios) {
      if (u instanceof Empleado) {
        u.mostrar();
      }
    }

    System.out.println();
    Usuario unEncargado1 = new Encargado(
        "encargado1@bar.com", "claveEncargado1", "ApellidoEncargado1", "NombreEncargado1");
    Usuario unEncargado2 = new Encargado(
        "encargado2@bar.com", "claveEncargado2", "ApellidoEncargado2", "NombreEncargado2");
    Usuario unEncargado3 = new Encargado(
        "encargado3@bar.com", "claveEncargado3", "ApellidoEncargado3", "NombreEncargado3");
    Usuario unEncargado4 = new Encargado(
        "encargado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
    // encargado repetido mismo correo que otro encargado

    // Igual a las ultimas dos veces
    for (Usuario enc : new Usuario[] {unEncargado1, unEncargado2, unEncargado3, unEncargado4}) {
      if (!usuarios.contains(enc)) {
        usuarios.add(enc);
        System.out.println("Se agregó el encargado: " + enc.verCorreo());
      } else {
        System.out.println("No se pudo agregar (correo repetido): " + enc.verCorreo());
      }
    }

    System.out.println();
    Usuario unEncargado5 = new Encargado(
        "cliente1@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
    // mismo correo que un cliente, no debe agregarse
    /*
     * Agregar aquí la sentencia para agregar unEncargado5 a la lista de usuarios,
     * siempre que no se repita
     */
    // Se deja todo el codigo de revision para ver que las clases usuario y
    // encargado funcionan de forma correcta
    if (!usuarios.contains(unEncargado5)) {
      usuarios.add(unEncargado5);
      System.out.println("Se agregó el encargado: " + unEncargado5.verCorreo());
    } else {
      System.out.println("No se pudo agregar unEncargado5: correo repetido con un cliente ("
          + unEncargado5.verCorreo() + ")");
    }

    Usuario unCliente5 = new Encargado(
        "empleado3@bar.com", "claveEncargado4", "ApellidoEncargado4", "NombreEncargado4");
    // mismo correo que un empleado, no debe agregarse
    /*
     * Agregar aquí la sentencia para agregar unCliente5 a la lista de usuarios,
     * siempre que no se repita
     */
    if (!usuarios.contains(unCliente5)) {
      usuarios.add(unCliente5);
      System.out.println("Se agregó el usuario: " + unCliente5.verCorreo());
    } else {
      System.out.println("No se pudo agregar unCliente5: correo repetido con un empleado ("
          + unCliente5.verCorreo() + ")");
    }

    System.out.println("Todos");
    System.out.println("=====");
    for (Usuario u : usuarios) {
      u.mostrar();
      System.out.println();
    }
    System.out.println();
    /*
     * FIN Segunda parte - herencia
     ***************************************************
     ***************************************************
     ***************************************************
     */
  }
}
