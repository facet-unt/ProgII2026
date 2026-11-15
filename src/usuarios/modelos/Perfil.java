package usuarios.modelos;

public enum Perfil {
  CLIENTE("Cliente"),
  EMPLEADO("Empleado"),
  ENCARGADO("Encargado");

  private final String descripcion;

  Perfil(String descripcion) {
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
