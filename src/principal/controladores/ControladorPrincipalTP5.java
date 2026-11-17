/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import interfaces.IGestorPedidos;
import interfaces.IGestorProductos;
import interfaces.IGestorUsuarios;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Categoria;
import productos.modelos.Estado;
import productos.modelos.GestorProductos;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author Mariana
 */
public class ControladorPrincipalTP5 {
  public static void main(String[] args) {
    IGestorProductos gp = GestorProductos.instanciar();
    IGestorUsuarios gu = GestorUsuarios.instanciar();
    IGestorPedidos gPed = GestorPedidos.instanciar();

    System.out.println("#####PRODUCTOS#####");
    /*CREAR PRODUCTO*/
    System.out.println(
        gp.crearProducto(1, "Producto1", 1.0f, Categoria.ENTRADA, Estado.DISPONIBLE));
    System.out.println(
        gp.crearProducto(2, "Producto2", 2.0f, Categoria.PLATO_PRINCIPAL, Estado.DISPONIBLE));
    System.out.println(gp.crearProducto(3, "Plato3", 3.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    System.out.println(gp.crearProducto(3, "Producto4", 4.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    // producto repetido, mismo codigo
    System.out.println(gp.crearProducto(0, "Producto4", 4.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    // código inválido vale 0
    System.out.println(gp.crearProducto(4, null, 4.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    // sin descripción -- nula
    System.out.println(gp.crearProducto(4, "", 4.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    // descripción inválida  -- cadena vacia
    System.out.println(gp.crearProducto(4, "Producto4", 0.0f, Categoria.POSTRE, Estado.DISPONIBLE));
    // precio inválido  -- precio en 0
    System.out.println(gp.crearProducto(4, "Producto4", 4.0f, null, Estado.DISPONIBLE));
    // sin categoría
    System.out.println(gp.crearProducto(4, "Producto4", 4.0f, Categoria.POSTRE, null));
    // sin estado

    /*RECUPERAR LOS PRODUCTOS CON EL METODO MENU*/
    System.out.println("######## PRODUCTOS CON MENU ########");
    System.out.println("Productos");
    System.out.println("=========");
    for (Producto p : gp.menu()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println("######## PRODUCTOS POR CODIGO ########");
    /*OBTENER UN PRODUCTO MEDIANTE EL CODIGO*/
    Producto unProducto1 = gp.obtenerProducto(1);
    Producto unProducto2 = gp.obtenerProducto(2);

    System.out.println("######## PRODUCTOS DE UNA CATEGORIA ########");
    /*SUBCONJUNTO DE PRODUCTOS DE UNA CATEGORIA*/
    ArrayList<Producto> productosBuscados =
        (ArrayList) gp.verProductosPorCategoria(Categoria.POSTRE);
    System.out.println("Productos filtrados por categoría");
    System.out.println("===================");
    for (Producto p : productosBuscados) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println("######## PRODUCTOS POR DESCRIPCION ########");
    /*BUSCAR PRODUCTO POR DESCRIPCION*/
    productosBuscados = (ArrayList) gp.buscarProductos("Prod");
    System.out.println("Productos buscados por descripcion");
    System.out.println("==================");
    for (Producto p : productosBuscados) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println(gp.modificarProducto(
        unProducto1, 100, "Producto11", 10.0f, Categoria.PLATO_PRINCIPAL, Estado.NO_DISPONIBLE));
    // se le cambia la descripción, precio, categoría y estado
    // el código, por más que se lo pasa, no se modifica
    productosBuscados = (ArrayList) gp.buscarProductos("Producto11");
    System.out.println("Productos buscados");
    System.out.println("==================");
    for (Producto p : productosBuscados) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println(gp.modificarProducto(
        unProducto1, 100, "", 10.0f, Categoria.PLATO_PRINCIPAL, Estado.NO_DISPONIBLE));
    //
    System.out.println("#####USUARIOS#####");

    System.out.println(gu.crearUsuario("cliente1@bar.com", "ApellidoCliente1", "NombreCliente1",
        Perfil.CLIENTE, "claveCliente1", "claveCliente1"));
    System.out.println(gu.crearUsuario("cliente2@bar.com", "ApellidoCliente2", "NombreCliente2",
        Perfil.CLIENTE, "claveCliente2", "claveCliente2"));
    System.out.println(gu.crearUsuario("cliente3@bar.com", "ApellidoCliente3", "NombreCliente3",
        Perfil.CLIENTE, "claveCliente3", "claveCliente3"));
    System.out.println(gu.crearUsuario("cliente3@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, "claveCliente4", "claveCliente4"));
    // cliente duplicado
    System.out.println(gu.crearUsuario(null, "ApellidoCliente4", "NombreCliente4", Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // sin correo
    System.out.println(gu.crearUsuario("", "ApellidoCliente4", "NombreCliente4", Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // correo inválido
    System.out.println(gu.crearUsuario("cliente4@bar.com", null, "NombreCliente4", Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // sin apellido
    System.out.println(gu.crearUsuario("cliente4@bar.com", "", "NombreCliente4", Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // apellido inválido
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", null, Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // sin nombre
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "", Perfil.CLIENTE,
        "claveCliente4", "claveCliente4"));
    // nombre inválido
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        null, "claveCliente4", "claveCliente4"));
    // sin perfil
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, null, "claveCliente4"));
    // sin clave
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, "", "claveCliente4"));
    // clave inválida
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, "claveCliente4", null));
    // sin repetir la clave
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, "claveCliente4", ""));
    // clave repetida inválida
    System.out.println(gu.crearUsuario("cliente4@bar.com", "ApellidoCliente4", "NombreCliente4",
        Perfil.CLIENTE, "claveCliente4", "claveCliente44"));
    // sin coincidir las claves

    System.out.println("Clientes");
    System.out.println("========");
    for (Usuario u : gu.verUsuarios()) {
      if (u instanceof Cliente) {
        u.mostrar();
        System.out.println();
      }
    }
    System.out.println();

    System.out.println(gu.crearUsuario("empleado1@bar.com", "ApellidoEmpleado1", "NombreEmpleado1",
        Perfil.EMPLEADO, "claveEmpleado1", "claveEmpleado1"));
    System.out.println(gu.crearUsuario("empleado2@bar.com", "ApellidoEmpleado2", "NombreEmpleado2",
        Perfil.EMPLEADO, "claveEmpleado2", "claveEmpleado2"));
    System.out.println(gu.crearUsuario("empleado3@bar.com", "ApellidoEmpleado3", "NombreEmpleado3",
        Perfil.EMPLEADO, "claveEmpleado3", "claveEmpleado3"));
    System.out.println(gu.crearUsuario("empleado3@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado4"));
    // empleado duplicado
    System.out.println(gu.crearUsuario(null, "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado4"));
    // sin correo
    System.out.println(gu.crearUsuario("", "ApellidoEmpleado4", "NombreEmpleado4", Perfil.EMPLEADO,
        "claveEmpleado4", "claveEmpleado4"));
    // correo inválido
    System.out.println(gu.crearUsuario("empleado4@bar.com", null, "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado4"));
    // sin apellido
    System.out.println(gu.crearUsuario("empleado4@bar.com", "", "NombreEmpleado4", Perfil.EMPLEADO,
        "claveEmpleado4", "claveEmpleado4"));
    // apellido inválido
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", null,
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado4"));
    // sin nombre
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "",
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado4"));
    // nombre inválido
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        null, "claveEmpleado4", "claveEmpleado4"));
    // sin perfil
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, null, "claveEmpleado4"));
    // sin clave
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "", "claveEmpleado4"));
    // clave sin especificar
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", null));
    // sin repetir clave
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", ""));
    // clave repetida inválida
    System.out.println(gu.crearUsuario("empleado4@bar.com", "ApellidoEmpleado4", "NombreEmpleado4",
        Perfil.EMPLEADO, "claveEmpleado4", "claveEmpleado44"));
    // sin coincidir las claves

    System.out.println("Empleados");
    System.out.println("=========");
    for (Usuario u : gu.verUsuarios()) {
      if (u instanceof Empleado) {
        u.mostrar();
        System.out.println();
      }
    }
    System.out.println();

    System.out.println(gu.crearUsuario("encargado1@bar.com", "ApellidoEncargado1",
        "NombreEncargado1", Perfil.ENCARGADO, "claveEncargado1", "claveEncargado1"));
    System.out.println(gu.crearUsuario("encargado2@bar.com", "ApellidoEncargado2",
        "NombreEncargado2", Perfil.ENCARGADO, "claveEncargado2", "claveEncargado2"));
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado3",
        "NombreEncargado3", Perfil.ENCARGADO, "claveEncargado3", "claveEncargado3"));
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // encargado duplicado
    System.out.println(gu.crearUsuario(null, "ApellidoEncargado4", "NombreEncargado4",
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // sin correo
    System.out.println(gu.crearUsuario("", "ApellidoEncargado4", "NombreEncargado4",
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // correo inválido
    System.out.println(gu.crearUsuario("encargado3@bar.com", null, "NombreEncargado4",
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // sin apellido
    System.out.println(gu.crearUsuario("encargado3@bar.com", "", "NombreEncargado4",
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // apellido inválido
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4", null,
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // sin nombre
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4", "",
        Perfil.ENCARGADO, "claveEncargado4", "claveEncargado4"));
    // nombre inválido
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", null, "claveEncargado4", "claveEncargado4"));
    // sin perfil
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, null, "claveEncargado4"));
    // sin clave
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, "", "claveEncargado4"));
    // clave sin especificar
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, "claveEncargado4", null));
    // sin repetir clave
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, "claveEncargado4", ""));
    // clave repetida inválida
    System.out.println(gu.crearUsuario("encargado3@bar.com", "ApellidoEncargado4",
        "NombreEncargado4", Perfil.ENCARGADO, "claveEncargado4", "claveEncargado44"));
    // sin coincidir las claves

    System.out.println("Encargados");
    System.out.println("==========");
    for (Usuario u : gu.verUsuarios()) {
      if (u instanceof Encargado) {
        u.mostrar();
        System.out.println();
      }
    }
    System.out.println();

    System.out.println("Menu");
    System.out.println("=========");
    for (Producto p : gp.menu()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println("Obtener usuarios y productos");
    System.out.println("=========");
    Usuario unCliente1 = gu.obtenerUsuario("cliente1@bar.com");
    Producto prod1 = gp.obtenerProducto(1);
    Producto prod2 = gp.obtenerProducto(2);

    System.out.println("=========");
    System.out.println("Crear pedidos");
    ArrayList<ProductoDelPedido> productosDelPedido1 = new ArrayList<>();
    ProductoDelPedido pdp1 = new ProductoDelPedido(unProducto1, 1);
    ProductoDelPedido pdp2 = new ProductoDelPedido(unProducto2, 2);
    LocalDateTime fechaYHora = LocalDateTime.now();
    LocalDate fecha = fechaYHora.toLocalDate();
    LocalTime hora = fechaYHora.toLocalTime();
    if (!productosDelPedido1.contains(pdp1))
      productosDelPedido1.add(pdp1);
    if (!productosDelPedido1.contains(pdp2))
      productosDelPedido1.add(pdp2);
    System.out.println(gPed.crearPedido(fecha, hora, productosDelPedido1, (Cliente) unCliente1));

    Usuario unCliente2 = gu.obtenerUsuario("cliente2@bar.com");
    ArrayList<ProductoDelPedido> productosDelPedido2 = new ArrayList<>();
    ProductoDelPedido pdp3 = new ProductoDelPedido(unProducto1, 10);
    ProductoDelPedido pdp4 = new ProductoDelPedido(unProducto2, 20);
    ProductoDelPedido pdp5 = new ProductoDelPedido(unProducto1, 30);
    // producto repetido
    if (!productosDelPedido2.contains(pdp3))
      productosDelPedido2.add(pdp3);
    if (!productosDelPedido2.contains(pdp4))
      productosDelPedido2.add(pdp4);
    if (!productosDelPedido2.contains(pdp5))
      productosDelPedido2.add(pdp5);
    System.out.println(gPed.crearPedido(fecha, hora, productosDelPedido2, (Cliente) unCliente2));

    System.out.println(gPed.crearPedido(null, hora, productosDelPedido2, (Cliente) unCliente1));
    // sin fecha
    System.out.println(gPed.crearPedido(fecha, null, productosDelPedido2, (Cliente) unCliente1));
    // sin hora
    ArrayList<ProductoDelPedido> productosDelPedido3 = new ArrayList<>();
    System.out.println(gPed.crearPedido(fecha, hora, null, (Cliente) unCliente1));
    // sin productos
    System.out.println(gPed.crearPedido(fecha, hora, productosDelPedido3, (Cliente) unCliente1));
    // sin productos
    System.out.println(gPed.crearPedido(fecha, hora, productosDelPedido2, null));
    //        //sin cliente
    System.out.println("=======");
    System.out.println("Pedidos");
    for (Pedido p : gPed.verPedidos()) {
      p.mostrar();
    }
    System.out.println("=======");

    System.out.println("Hay pedidos con un producto");
    Producto prod = gp.obtenerProducto(2);
    System.out.println(gPed.hayPedidosConEsteProducto(prod));
    System.out.println("=======");

    System.out.println("Hay pedidos con un cliente");
    Usuario unCliente3 = gu.obtenerUsuario("cliente3@bar.com");
    System.out.println(gPed.hayPedidosConEsteCliente((Cliente) unCliente3));
    System.out.println("=======");

    System.out.println("Hay pedidos con un cliente");
    System.out.println(gPed.hayPedidosConEsteCliente((Cliente) unCliente1));
    System.out.println("=======");

    System.out.println("Obtener el pedido y agregarle al cliente 1");
    Pedido unPedido1 = gPed.obtenerPedido(1);
    ((Cliente) unCliente1).agregarPedido(unPedido1);

    ((Cliente) unCliente1).agregarPedido(unPedido1);
    // pedido repetido
    System.out.println("=======");
    System.out.println("Pedidos de " + unCliente1.verApellido() + ", " + unCliente1.verNombre());
    for (Pedido p : unCliente1.verPedidos()) {
      p.mostrar();
    }
    System.out.println();

    Usuario unEmpleado3 = gu.obtenerUsuario("empleado3@bar.com");
    System.out.println("Todos los pedidos (consultados por un empleado)");
    for (Pedido p : unEmpleado3.verPedidos()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    Usuario unEncargado3 = gu.obtenerUsuario("encargado3@bar.com");
    System.out.println("Todos los pedidos (consultados por un encargado)");
    for (Pedido p : unEncargado3.verPedidos()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println("Cancelar el pedido de unCliente1");
    ((Cliente) unCliente1).cancelarPedido(unPedido1);
    System.out.println("Pedidos de " + unCliente1.verApellido() + ", " + unCliente1.verNombre());
    for (Pedido p : unCliente1.verPedidos()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println("Ver si existe un usuario");
    System.out.println(gu.existeEsteUsuario(unCliente1));
    Usuario unCliente10 =
        new Cliente("cliente10@bar.com", "claveCliente10", "ApellidoCliente10", "NombreCliente10");
    // usuario inexistente
    System.out.println("Ver si existe un usuario");
    System.out.println(gu.existeEsteUsuario(unCliente10));

    System.out.println("Usuarios");
    System.out.println("========");
    for (Usuario u : gu.verUsuarios()) {
      u.mostrar();
      System.out.println();
    }
    System.out.println();

    ArrayList<Usuario> usuariosBuscados = (ArrayList) gu.buscarUsuarios("ApellidoCliente");
    System.out.println("Usuarios filtrados");
    System.out.println("==================");
    for (Usuario u : usuariosBuscados) {
      u.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println(gPed.existeEstePedido(unPedido1));
    Pedido unPedido10 = gPed.obtenerPedido(10);
    // pedido inexistente
    System.out.println(gPed.existeEstePedido(unPedido10));

    Pedido unPedido2 = gPed.obtenerPedido(2);
    System.out.println(gPed.cambiarEstado(unPedido2));

    System.out.println("Pedidos");
    System.out.println("=======");
    for (Pedido p : gPed.verPedidos()) {
      p.mostrar();
      System.out.println();
    }
    System.out.println();

    System.out.println(gPed.cancelarPedido(unPedido2));
    // no se puede por el estado del pedido
    System.out.println(gPed.cancelarPedido(unPedido1));
    //        //sí se puede

    System.out.println("\n\nPedidos");
    System.out.println("=======");
    for (Pedido p : gPed.verPedidos()) {
      p.mostrar();
    }
    System.out.println();

    // =========================================================================
    // Pruebas de borrarProducto, borrarUsuario y cancelarPedido
    // =========================================================================
    probarBorrarProducto(gp, gPed);
    probarBorrarUsuario(gu, gPed);
    probarCancelarPedido(gPed, gu, gp);
  }

  /**
   * Verifica el funcionamiento de borrarProducto(Producto producto):
   * -Borrar producto nulo (invalido -> PRODUCTO_INEXISTENTE)
   * -Borrar producto que no existe en el gestor (invalido -> PRODUCTO_INEXISTENTE)
   * -Borrar producto que tiene pedidos asociados (invalido -> ERROR_EN_PEDIDO)
   * -Borrar producto que NO tiene pedidos asociados (valido -> BORRAR_EXITO)
   */
  public static void probarBorrarProducto(IGestorProductos gp, IGestorPedidos gPed) {
    System.out.println("\n##################################################");
    System.out.println("PRUEBA: borrarProducto(Producto producto)");
    System.out.println("##################################################");

    // Producto nulo
    System.out.println("Intentar borrar producto nulo:");
    System.out.println("Resultado: " + gp.borrarProducto(null));

    // Producto no registrado en el gestor
    System.out.println("\nIntentar borrar producto no registrado:");
    Producto prodInexistente =
        new Producto(999, "Producto Fantasma", Categoria.POSTRE, Estado.DISPONIBLE, 100.0f);
    System.out.println("Resultado: " + gp.borrarProducto(prodInexistente));

    // Producto con pedidos asociados (el producto 2 está en el pedido 2)
    System.out.println("\nIntentar borrar producto con pedidos asociados:");
    Producto prodConPedido = gp.obtenerProducto(2);
    System.out.println("Producto a borrar: Código " + prodConPedido.verCodigo() + " - "
        + prodConPedido.verDescripcion());
    System.out.println(
        "¿Hay pedidos con este producto?: " + gPed.hayPedidosConEsteProducto(prodConPedido));
    System.out.println("Resultado: " + gp.borrarProducto(prodConPedido));
    System.out.println("¿Sigue existiendo en el gestor?: " + gp.existeEsteProducto(prodConPedido));

    // Producto sin pedidos (creamos uno nuevo que no esté en ningún pedido)
    System.out.println("\nBorrar producto sin pedidos asociados:");
    gp.crearProducto(50, "Producto Sin Pedidos", 150.0f, Categoria.ENTRADA, Estado.DISPONIBLE);
    Producto prodSinPedido = gp.obtenerProducto(50);
    System.out.println("Producto a borrar: Código " + prodSinPedido.verCodigo() + " - "
        + prodSinPedido.verDescripcion());
    System.out.println(
        "¿Hay pedidos con este producto?: " + gPed.hayPedidosConEsteProducto(prodSinPedido));
    System.out.println("Resultado: " + gp.borrarProducto(prodSinPedido));
    System.out.println("¿Sigue existiendo en el gestor?: " + gp.existeEsteProducto(prodSinPedido));
  }

  /**
   * Verifica el funcionamiento de borrarUsuario(Usuario usuario):
   * -Borrar usuario nulo (invalido -> USUARIO_INEXISTENTE)
   * -Borrar usuario que no existe en el gestor (invalido -> USUARIO_INEXISTENTE)
   * -Borrar usuario que tiene pedidos asociados (invalido -> ERROR_HAY_PEDIDOS)
   * -Borrar usuario que NO tiene pedidos asociados (valido -> BORRAR_EXITO)
   */
  public static void probarBorrarUsuario(IGestorUsuarios gu, IGestorPedidos gPed) {
    System.out.println("\n##################################################");
    System.out.println("PRUEBA: borrarUsuario(Usuario usuario)");
    System.out.println("##################################################");

    // Usuario nulo
    System.out.println("Intentar borrar usuario nulo:");
    System.out.println("Resultado: " + gu.borrarUsuario(null));

    // Usuario no registrado en el gestor
    System.out.println("\nIntentar borrar usuario no registrado:");
    Usuario userInexistente = new Cliente("fantasma@bar.com", "123", "Fantasma", "Casper");
    System.out.println("Resultado: " + gu.borrarUsuario(userInexistente));

    // Usuario con pedidos asociados (cliente2 tiene pedidos)
    System.out.println("\nIntentar borrar usuario que tiene pedidos asociados:");
    Usuario userConPedidos = gu.obtenerUsuario("cliente2@bar.com");
    System.out.println("Usuario a borrar: " + userConPedidos.verCorreo());
    System.out.println("¿Tiene pedidos?: " + !userConPedidos.verPedidos().isEmpty());
    System.out.println("Resultado: " + gu.borrarUsuario(userConPedidos));
    System.out.println("¿Sigue existiendo en el gestor?: " + gu.existeEsteUsuario(userConPedidos));

    // Usuario sin pedidos (creamos uno nuevo que no tenga pedidos)
    System.out.println("\nBorrar usuario sin pedidos asociados:");
    gu.crearUsuario("borrarme@bar.com", "Perez", "Juan", Perfil.CLIENTE, "clave123", "clave123");
    Usuario userSinPedidos = gu.obtenerUsuario("borrarme@bar.com");
    System.out.println("Usuario a borrar: " + userSinPedidos.verCorreo());
    System.out.println("¿Tiene pedidos?: " + !userSinPedidos.verPedidos().isEmpty());
    System.out.println("Resultado: " + gu.borrarUsuario(userSinPedidos));
    System.out.println("¿Sigue existiendo en el gestor?: " + gu.existeEsteUsuario(userSinPedidos));
  }

  /**
   * Verifica el funcionamiento de cancelarPedido(Pedido pedido):
   * -Cancelar pedido nulo (invalido -> PEDIDO_INEXISTENTE)
   * -Cancelar pedido inexistente (invalido -> PEDIDO_INEXISTENTE)
   * -Cancelar pedido en estado PROCESANDO/ENTREGADO (invalido -> ERROR_CANCELAR)
   * -Cancelar pedido en estado CREADO (valido -> EXITO, y se borra de cliente y gestor)
   */
  public static void probarCancelarPedido(
      IGestorPedidos gPed, IGestorUsuarios gu, IGestorProductos gp) {
    System.out.println("\n##################################################");
    System.out.println("PRUEBA: cancelarPedido(Pedido pedido)");
    System.out.println("##################################################");

    // Pedido nulo
    System.out.println("Intentar cancelar pedido nulo:");
    System.out.println("Resultado: " + gPed.cancelarPedido(null));

    // Pedido inexistente
    System.out.println("\nIntentar cancelar pedido no registrado:");
    Pedido pedInexistente = new Pedido(999, (Cliente) gu.obtenerUsuario("cliente1@bar.com"));
    System.out.println("Resultado: " + gPed.cancelarPedido(pedInexistente));

    // Pedido en estado PROCESANDO (pedido 2 está en PROCESANDO)
    System.out.println("\nIntentar cancelar pedido en estado distinto a CREADO:");
    Pedido pedProcesando = gPed.obtenerPedido(2);
    if (pedProcesando != null) {
      System.out.println("Pedido #" + pedProcesando.verNumero()
          + " - Estado actual: " + pedProcesando.verEstado());
      System.out.println("Resultado: " + gPed.cancelarPedido(pedProcesando));
      System.out.println(
          "¿Sigue existiendo en el gestor?: " + gPed.existeEstePedido(pedProcesando));
    }

    // Cancelar pedido en estado CREADO
    System.out.println("\nCancelar pedido en estado CREADO:");
    Usuario clientePrueba = gu.obtenerUsuario("cliente3@bar.com");
    Producto prodPrueba = gp.obtenerProducto(3);
    ArrayList<ProductoDelPedido> listaPdp = new ArrayList<>();
    listaPdp.add(new ProductoDelPedido(prodPrueba, 2));

    LocalDate hoy = LocalDate.now();
    LocalTime ahora = LocalTime.now();
    gPed.crearPedido(hoy, ahora, listaPdp, (Cliente) clientePrueba);

    // Obtener el último pedido creado
    ArrayList<Pedido> listaPedidos = (ArrayList) gPed.verPedidos();
    Pedido pedACancelar = listaPedidos.get(listaPedidos.size() - 1);
    System.out.println(
        "Pedido creado: #" + pedACancelar.verNumero() + " para " + clientePrueba.verCorreo());
    System.out.println("Estado del pedido: " + pedACancelar.verEstado());
    System.out.println("¿El cliente tiene el pedido en su lista?: "
        + ((Cliente) clientePrueba).verPedidos().contains(pedACancelar));
    System.out.println("¿El gestor tiene el pedido?: " + gPed.existeEstePedido(pedACancelar));

    System.out.println("Resultado de cancelarPedido(): " + gPed.cancelarPedido(pedACancelar));
    System.out.println("¿Sigue en GestorPedidos?: " + gPed.existeEstePedido(pedACancelar));
    System.out.println("¿Sigue en la lista del Cliente?: "
        + ((Cliente) clientePrueba).verPedidos().contains(pedACancelar));
  }
}
