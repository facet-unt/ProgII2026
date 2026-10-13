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

  public boolean equals(Object o) {
    // Retornar falso si: El objecto es nulo, es este mismo
    // objecto o es de una clase distinta a esta.
    if (o == null) {
      return false;
    }
    if (o == this) {
      return false;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    // Si hasta este punto no se volvio, el objeto es correcto y se
    // lo convierte a la clase a comparar.
    ProductoDelPedido unPdp = (ProductoDelPedido) o;
    // Comparacion
    return this.producto.equals(unPdp.producto);
  }

  public int hashCode() {
    return this.producto.hashCode();
  }

  @Override
  public String toString() {
    return "Producto: " + producto.verDescripcion() + " | Cant: " + cantidad;
  }
}
