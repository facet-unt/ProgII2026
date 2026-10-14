package usuarios.modelos;

/**
 * @author barti
 */
public class Empleado extends Usuario {
  // Constructor
  public Empleado(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
  }

  protected String verTipoUsuario() {
    return "Empleado";
  }
}
