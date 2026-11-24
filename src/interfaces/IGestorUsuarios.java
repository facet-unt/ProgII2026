/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author estudiante
 */
public interface IGestorUsuarios {
    
    String EXITO = "Usuario creado/modificado con exito";
    String ERROR_CORREO = "El correo del usuario es incorrecto";
    String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    String VALIDACION_EXITO = "Los datos del usuario son correctos";
    String USUARIO_INEXISTENTE = "No existe el usuario especificado";
    String ERROR_ELIMINAR = "El usuario no se pudo eliminar correctamente";
    
    String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    List<Usuario> verUsuarios();
    List<Usuario> buscarUsuarios(String apellido);
    String borrarUsuario(Usuario usuario);
    boolean existeEsteUsuario(Usuario usuario);
    Usuario obtenerUsuario(String correo);
    
}
