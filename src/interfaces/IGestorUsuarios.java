/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.ArrayList;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author tobias150
 */
public interface IGestorUsuarios {
    //Metodos y atributos 
    public abstract String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida);
    
    public abstract ArrayList<Usuario> verUsuarios();
    
    public abstract ArrayList<Usuario> buscarUsuarios(String apellido);
    
    public abstract String borrarUsuario(Usuario usuario);
    
    public abstract boolean existeEsteUsuario(Usuario usuario);
    
    public abstract Usuario obtenerUsuario(String correo);
       
    public static final String EXITO = "Usuario creado/modificado con éxito";
       
    public static final String ERROR_CORREO = "El código del usuario es incorrecto";
       
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecta";
       
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
       
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
       
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
       
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuarios con ese código";
       
    public static final String VALIDACION_EXITO = "Los datos del usuarios son correctos";   

    public static final String USUARIO_BORRADO = "El usuario fue eliminado correctamente";
    
    public static final String USUARIO_INEXISTENTE = "El usuario especificado no existe";
}

