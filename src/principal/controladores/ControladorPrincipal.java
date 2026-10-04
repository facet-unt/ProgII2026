/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
 * this license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package principal.controladores;

import java.util.ArrayList;
import pedidos.modelos.Pedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

/**
 *
 * @author estudiante
 */
public class ControladorPrincipal {
  public static void main(String[] args) {
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Encargado> encargados = new ArrayList<>();
    ArrayList<Empleado> empleados = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<Pedido> listaPedidos = new ArrayList<>();

    Cliente cliente1 = new Cliente("martinvarga@hotmail.com", "1234", "Varga", "Martin");
    Cliente cliente2 = new Cliente("joseluisM@hotmail.com", "4567", "Molina", "Jose Luis");
    Cliente cliente3 = new Cliente("juliGz@hotmail.com", "9096", "Gomez", "Julieta");

    Encargado encargado1 = new Encargado("fernandezjuan@hotmail.com", "3334", "Fernandez", "Juan");
    Encargado encargado2 = new Encargado("martinezK@hotmail.com", "5557", "Martinez", "Kevin");
    Encargado encargado3 = new Encargado("alvaresTomas@hotmail.com", "88854", "Alvares", "Tomas");

    Empleado empleado1 = new Empleado("fuentesmario@hotmail.com", "3334", "Fuentes", "Mario");
    Empleado empleado2 = new Empleado("lopez@hotmail.com", "111111", "Lopez", "Hector");
    Empleado empleado3 = new Empleado("alguileraC@hotmail.com", "2026", "Aguilera", "Cristina");

    Producto hamburguesa =
        new Producto(1234, "Hamburguesa", Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE, 8000f);
    Producto pizza =
        new Producto(5678, "Pizza", Categoria.PLATO_PRINCIPAL, Estado.NO_DISPONIBLE, 12000f);
    Producto papasFritas =
        new Producto(91011, "Papas Fritas", Categoria.ENTRADA, Estado.DISPONIBLE, 5000f);

    Pedido pedido1 = new Pedido(1, cliente1);
    pedido1.agregarProducto(hamburguesa, 2);
    pedido1.agregarProducto(papasFritas, 1);
    pedido1.agregarProducto(hamburguesa, 1);

    Pedido pedido2 = new Pedido(2, cliente2);
    pedido2.agregarProducto(pizza, 1);
    pedido2.agregarProducto(papasFritas, 2);

    Pedido pedido3 = new Pedido(3, cliente3);
    pedido3.agregarProducto(pizza, 2);

    productos.add(hamburguesa);
    productos.add(pizza);
    productos.add(papasFritas);

    clientes.add(cliente1);
    clientes.add(cliente2);
    clientes.add(cliente3);

    encargados.add(encargado1);
    encargados.add(encargado2);
    encargados.add(encargado3);

    empleados.add(empleado1);
    empleados.add(empleado2);
    empleados.add(empleado3);

    listaPedidos.add(pedido1);
    listaPedidos.add(pedido2);
    listaPedidos.add(pedido3);

    cliente1.agregarPedido(pedido1);
    cliente2.agregarPedido(pedido2);
    cliente3.agregarPedido(pedido3);

    System.out.println("------Productos------\n");

    System.out.println("Con toString:");
    System.out.println(hamburguesa.toString());

    System.out.println("Sin toString (método mostrar):");
    for (Producto p : productos) {
      p.mostrar();
    }
    System.out.println("------Clientes------\n");
    for (Cliente c : clientes) {
      c.mostrar();
    }
    System.out.println("------Encargados------\n");
    for (Encargado e : encargados) {
      e.mostrar();
    }
    System.out.println("------Empleados------\n");
    for (Empleado e : empleados) {
      e.mostrar();
    }
    System.out.println("------Pedidos------\n");
    for (Pedido p : listaPedidos) {
      p.mostrar();
      System.out.println();
    }

    System.out.println("Cambiando...\n");

    productos.get(0).asignarPrecio(12000f);
    productos.get(1).asignarEstado(Estado.NO_DISPONIBLE);
    productos.get(2).asignarCodigo(4567);

    clientes.get(2).asignarClave("454647");
    empleados.get(1).verCorreo();
    encargados.get(1).asignarApellido("Falcon");
    encargados.get(0).asignarClave("346789");
    empleados.get(2).asignarClave("0000");

    listaPedidos.get(0).asignarEstado(pedidos.modelos.Estado.PROCESANDO);
    listaPedidos.get(1).quitarProducto(papasFritas, 1);
    listaPedidos.get(1).asignarEstado(pedidos.modelos.Estado.ENTREGADO);
    listaPedidos.get(2).agregarProducto(hamburguesa, 1);

    System.out.println("===Productos después de las modificaciones===");

    for (Producto p : productos) {
      p.mostrar();
    }

    System.out.println("===Clientes después de las modificaciones===");

    for (Cliente c : clientes) {
      c.mostrar();
    }

    System.out.println("===Encargados después de las modificaciones===");

    for (Encargado e : encargados) {
      e.mostrar();
    }

    System.out.println("===Empleados después de las modificaciones===");

    for (Empleado e : empleados) {
      e.mostrar();
    }

    System.out.println("===Pedidos después de las modificaciones===");

    for (Pedido p : listaPedidos) {
      p.mostrar();
      System.out.println();
    }
  }
}
