package productos.modelos;

/**
 *
 * @author barti
 */
public enum Estado {
  DISPONIBLE("Disponible"),
  NO_DISPONIBLE("No disponible");

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
