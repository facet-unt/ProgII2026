package pedidos.modelos;

import productos.modelos.Producto;

public class ProductoDelPedido {
  private Producto producto;
  private int cantidad;

  // Constructor
  public ProductoDelPedido(Producto producto, int cantidad) {
    this.producto = producto;
    this.cantidad = cantidad;
  }

  // Getters
  public Producto verProducto() {
    return this.producto;
  }

  public int verCantidad() {
    return this.cantidad;
  }

  // Setters
  public void asignarProducto(Producto producto) {
    this.producto = producto;
  }

  public void asignarCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
