package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author barti
 */
public class Pedido {
  private int numero;
  private LocalDateTime fechaYHora;
  private ArrayList<ProductoDelPedido> productos;
  private Cliente cliente;
  private Estado estado;

  private static final String PATRON_FECHA = "dd/MM/yyyy";
  private static final String PATRON_HORA = "HH:mm";
  private String fechaACadena(LocalDateTime fechaHora) {
    return fechaHora.format(DateTimeFormatter.ofPattern(PATRON_FECHA));
  }
  private String horaACadena(LocalDateTime fechaHora) {
    return fechaHora.format(DateTimeFormatter.ofPattern(PATRON_HORA));
  }

  // Constructor completo
  public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente,
      ArrayList<ProductoDelPedido> productos, Estado estado) {
    this.numero = numero;
    this.fechaYHora = fechaYHora;
    this.cliente = cliente;
    this.productos = (productos != null) ? productos : new ArrayList<>();
    this.estado = estado;
  }

  // Constructor que asigna fecha y hora actual con estado inicial CREADO
  public Pedido(int numero, Cliente cliente, ArrayList<ProductoDelPedido> productos) {
    this(numero, LocalDateTime.now(), cliente, productos, Estado.CREADO);
  }

  // Constructor para manejar el caso en que el pedido se crea sin productos inicialmente
  public Pedido(int numero, Cliente cliente) {
    this(numero, LocalDateTime.now(), cliente, new ArrayList<>(), Estado.CREADO);
  }

  // Getters
  public int verNumero() {
    return this.numero;
  }

  public String verFecha() {
    return fechaACadena(this.fechaYHora);
  }

  public String verHora() {
    return horaACadena(this.fechaYHora);
  }

  public LocalDate verSoloFecha() {
    return this.fechaYHora.toLocalDate();
  }

  public LocalTime verSoloHora() {
    return this.fechaYHora.toLocalTime();
  }

  public Cliente verCliente() {
    return this.cliente;
  }

  public ArrayList<ProductoDelPedido> verProductos() {
    return this.productos;
  }

  public Estado verEstado() {
    return this.estado;
  }

  // Setters
  public void asignarNumero(int nuevoNumero) {
    this.numero = nuevoNumero;
  }

  public void asignarFechaYHora(LocalDateTime nuevaFechaYHora) {
    this.fechaYHora = nuevaFechaYHora;
  }

  public void asignarCliente(Cliente nuevoCliente) {
    this.cliente = nuevoCliente;
  }

  public void asignarListaDeProductos(ArrayList<ProductoDelPedido> nuevosProductos) {
    this.productos = nuevosProductos;
  }

  public void asignarEstado(Estado nuevoEstado) {
    this.estado = nuevoEstado;
  }

  public void agregarProducto(Producto p, int cantidad) {
    if (p == null || cantidad <= 0) {
      return;
    }

    for (ProductoDelPedido item : this.productos) {
      // Comparar por codigo
      if (item.verProducto().verCodigo() == p.verCodigo()) {
        // Acumular la cantidad si ya estaba
        item.asignarCantidad(item.verCantidad() + cantidad);
        return; // Finalizar porque no hace falta agregar mas
      }
    }

    // Si ningun codigo es comparable(nuevo producto), simplemente se lo agrega con su cantidad
    this.productos.add(new ProductoDelPedido(p, cantidad));
  }

  public void quitarProducto(Producto p, int cantidad) {
    if (p == null || cantidad <= 0) {
      return;
    }

    for (ProductoDelPedido item : this.productos) {
      // Comparar codigos
      if (item.verProducto().verCodigo() == p.verCodigo()) {
        int restante = item.verCantidad() - cantidad;
        if (restante > 0) {
          // Si ya estaba se disminuye la canitdad
          item.asignarCantidad(restante);
        } else {
          // Si es 0 (o de alguna forma es menor que 0) eliminarlo
          this.productos.remove(item);
        }
        return;
      }
    }
  }

  public void mostrar() {
    System.out.println("Nro: " + this.numero);
    System.out.println("Fecha: " + verFecha() + "\tHora: " + verHora());

    System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());

    System.out.println("Estado: " + this.estado);

    // Se muestra la lista si tiene productos
    if (this.productos != null && !this.productos.isEmpty()) {
      System.out.println("Producto                Cantidad"); // 16 espacios
      System.out.println("================================");
      for (ProductoDelPedido item : this.productos) {
        System.out.println(
            item.verProducto().verDescripcion() + "                " + item.verCantidad());
      }
    }
  }
}
