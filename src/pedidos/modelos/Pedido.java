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

  public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> productos,
      Cliente cliente) {
    this(numero, fechaYHora, cliente, productos, Estado.CREADO);
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

  @Override
  public boolean equals(Object o) {
    // Retornar falso si El objeto es nulo o es de una clase distinta a esta.
    // Retornar verdadero si es este mismo objeto.
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    // Si hasta este punto no se volvio, el objeto es comparable y se
    // lo convierte a la clase a comparar.
    Pedido unPedido = (Pedido) o;
    // Comparacion
    return this.numero == unPedido.numero;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + this.numero;
    return hash;
  }

  public void mostrar() {
    System.out.println("Nro: " + this.numero);
    System.out.println("Fecha: " + verFecha() + "        Hora: " + verHora());
    System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
    System.out.println("Estado: " + this.estado);

    // Se muestra la lista si tiene productos
    if (this.productos != null && !this.productos.isEmpty()) {
      System.out.println("       Producto                Cantidad");
      System.out.println("       ==========================");
      for (ProductoDelPedido item : this.productos) {
        System.out.println("       Producto: " + item.verProducto().verCodigo() + " - "
            + item.verProducto().verDescripcion() + " Precio $:" + item.verProducto().verPrecio()
            + " " + item.verCantidad());
      }
    }
  }
}
