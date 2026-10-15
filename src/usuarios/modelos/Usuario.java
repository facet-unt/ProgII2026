package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

public abstract class Usuario {
  // Constructor
  public Usuario(String correo, String clave, String apellido, String nombre) {
    this.correo = correo;
    this.clave = clave;
    this.nombre = nombre;
    this.apellido = apellido;
  }

  // Getters
  public String verCorreo() {
    return this.correo;
  }

  public String verClave() {
    return this.clave;
  }

  public String verApellido() {
    return this.apellido;
  }

  public String verNombre() {
    return this.nombre;
  }

  // Setters
  public void asignarCorreo(String nuevoCorreo) {
    this.correo = nuevoCorreo;
  }

  public void asignarClave(String nuevaClave) {
    this.clave = nuevaClave;
  }

  public void asignarApellido(String nuevoApellido) {
    this.apellido = nuevoApellido;
  }

  public void asignarNombre(String nuevoNombre) {
    this.nombre = nuevoNombre;
  }

  /**
   * Es mejor implementar los metodos equals() y hashCode() en esta superclase,
   * ya que asi se evita la duplicacion de codigo y se permite, por ejemplo,
   * que un cliente y un empleado sean la misma persona, resolviendo asi el
   * problema indicado en el A tener en cuenta:
   * "Un cliente no puede tener el mismo correo que otro cliente, empleado o
   * encargado. Lo mismo vale para empleados y encargados."
   * Ademas, para evitar comparaciones y revisiones manuales de
   * correos nulos utilize la clase Objects.
   * https://docs.oracle.com/javase/8/docs/api/java/util/Objects.html
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Usuario)) {
      return false;
    }

    Usuario otro = (Usuario) o;
    return Objects.equals(this.correo, otro.correo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.correo);
  }

  public void mostrar() {
    System.out.println("\n" + verTipoUsuario() + " <" + verApellido() + " " + verNombre() + ">");
    System.out.println("Correo: " + verCorreo());
    System.out.println("Clave: " + verClave());
    mostrarEspecificos();
  }

  public abstract ArrayList<Pedido> verPedidos();

  /**
   * Metodo utilizado para que el metodo mostrar() sea generico.
   * Cada clase hija de la superclase Usuario debe implementarla
   * y simplemente devuelve el nombre de la misma como String.
   */
  protected abstract String verTipoUsuario();

  /**
   * Metodo para el caso en que se deba mostrar algo mas que solo
   * nombre, apellido, correo y clave a la hora de mostrar un usuario.
   * En caso que una clase hija requiera de esto, se debe
   * redefinir el metodo segun las necesidades de dicha clase.
   */
  protected void mostrarEspecificos() {}

  private String correo;
  private String clave;
  private String apellido;
  private String nombre;
  /**
   * Pese a que todo usuario puede "ver" su lista de pedidos, solo el
   * cliente tiene una lista de pedidos real, ya que los empleados y
   * encargados no pueden realizar pedidos. Por este motivo, deje la
   * implementacion del ArrayList de Pedido solo para Cliente.
   */
}
