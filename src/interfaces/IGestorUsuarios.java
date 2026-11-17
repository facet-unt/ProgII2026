package interfaces;

import java.util.ArrayList;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

public interface IGestorUsuarios {
  String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave,
      String claveRepetida);

  ArrayList<Usuario> verUsuarios();

  ArrayList<Usuario> buscarUsuarios(String apellido);

  String borrarUsuario(Usuario usuario);

  boolean existeEsteUsuario(Usuario usuario);

  Usuario obtenerUsuario(String correo);

  static final String EXITO = "Usuario creado/modificado con éxito";
  static final String BORRAR_EXITO = "Usuario borrado con éxito";
  static final String ERROR_CORREO = "El correo del usuario es incorrecto";
  static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
  static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
  static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
  static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
  static final String ERROR_HAY_PEDIDOS = "No se pudo borrar ya que el usuario aun tiene pedidos";
  static final String USUARIO_INEXISTENTE = "El usuario ingresado no existe";
  static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
  static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
}
