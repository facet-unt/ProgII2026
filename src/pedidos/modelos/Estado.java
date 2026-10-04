package pedidos.modelos;

/**
 *
 * @author barti
 */
public enum Estado {
  CREADO("Creado"),
  PROCESANDO("Procesando"),
  ENTREGADO("Entregado");

  private final String descripcion;

  Estado(String descripcion) {
    this.descripcion = descripcion;
  }

  public String verDescripcion() {
    return this.descripcion;
  }

  @Override
  public String toString() {
    return this.descripcion;
  }
}
