package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;

public class GestorUsuarios implements IGestorUsuarios {
  private GestorUsuarios() {
    usuarios = new ArrayList<>();
  }

  public static GestorUsuarios instanciar() {
    if (gestor == null) {
      gestor = new GestorUsuarios();
    }
    return gestor;
  }

  public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil,
      String clave, String claveRepetida) {
    // Si no se valida con exito se devuelve el mensaje de error
    String validacion = validarUsuario(correo, apellido, nombre, clave, claveRepetida);
    if (!validacion.equals(VALIDACION_EXITO)) {
      return validacion;
    }

    if (perfil == null) {
      return ERROR_PERFIL;
    }

    // Revisar todos los perfiles y si la variable 'Perfil' no existe bajo
    // los campos de la enumeracion, devolver la cadena de error de perfil
    switch (perfil) {
      case CLIENTE:
        usuarios.add(new Cliente(correo, clave, apellido, nombre));
        break;
      case EMPLEADO:
        usuarios.add(new Empleado(correo, clave, apellido, nombre));
        break;
      case ENCARGADO:
        usuarios.add(new Encargado(correo, clave, apellido, nombre));
        break;
      default:
        return ERROR_PERFIL;
    }

    return EXITO;
  }

  public ArrayList<Usuario> verUsuarios() {
    return this.usuarios;
  }

  public ArrayList<Usuario> buscarUsuarios(String apellido) {
    ArrayList<Usuario> resultado = new ArrayList<>();

    for (Usuario u : this.usuarios) {
      if (u.verApellido().toLowerCase().equals(apellido.toLowerCase())) {
        resultado.add(u);
      }
    }

    return resultado;
  }

  // Metodo para ver si existe un usuario en el gestor
  public boolean existeEsteUsuario(Usuario usuario) {
    boolean resultado = false;

    for (Usuario u : this.usuarios) {
      if (usuario.equals(u)) {
        resultado = true;
      }
    }

    return resultado;
  }

  // Metodo para buscar un usuario por correo en el gestor
  public Usuario obtenerUsuario(String correo) {
    Usuario resultado = null;

    for (Usuario u : this.usuarios) {
      if (u.verCorreo().equals(correo)) {
        resultado = u;
      }
    }

    return resultado;
  }

  public String borrarUsuario(Usuario usuario) {
    // Revisar que el argumento no sea nulo
    // o que el usuario no este registrado
    if (usuario == null) {
      return USUARIO_INEXISTENTE;
    }
    int indice = this.usuarios.indexOf(usuario);
    if (indice == -1) {
      return USUARIO_INEXISTENTE;
    }

    // Revisar si tiene pedidos
    if (!usuario.verPedidos().isEmpty()) {
      return ERROR_HAY_PEDIDOS;
    }

    // Ya deberia quedar un usuario valido
    // para eliminacion, entonces se lo saca
    this.usuarios.remove(indice);
    return BORRAR_EXITO;
  }

  private String validarUsuario(
      String correo, String apellido, String nombre, String clave, String claveRepetida) {
    // No se especifica que correo no debe ser cadena vacia pero lo incluyo igual.
    if (correo == null || correo.isBlank() || !correo.contains("@")) {
      return ERROR_CORREO;
    }
    if (apellido == null || apellido.isBlank()) {
      return ERROR_APELLIDO;
    }
    if (nombre == null || nombre.isBlank()) {
      return ERROR_NOMBRE;
    }
    if (clave == null || clave.isBlank()) {
      return ERROR_CLAVES;
    }
    if (claveRepetida == null || claveRepetida.isBlank() || !claveRepetida.equals(clave)) {
      return ERROR_CLAVES;
    }

    // Revisar para que no haya usuarios duplicados
    for (Usuario u : usuarios) {
      if (u.verCorreo().equals(correo)) {
        return USUARIOS_DUPLICADOS;
      }
    }

    return VALIDACION_EXITO;
  }

  private static GestorUsuarios gestor;
  private ArrayList<Usuario> usuarios;
}
