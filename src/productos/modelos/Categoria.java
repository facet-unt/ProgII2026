package productos.modelos;

/**
 *
 * @author barti
 */
public enum Categoria {
  ENTRADA("Entrada"),
  PLATO_PRINCIPAL("Plato principal"),
  POSTRE("Postre");

  private final String descripcion;

  Categoria(String descripcion) {
    this.descripcion = descripcion;
  }

  public String verDescripcion() {
    return descripcion;
  }

  @Override
  public String toString() {
    return this.descripcion;
  }
}
