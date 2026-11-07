/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author LUCRECIA
 */
public class GestorUsuarios {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    public static GestorUsuarios gestor;
    
    public static final String EXITO = "Usuario creado/modificado con exito.";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto.";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto.";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto.";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas.";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto.";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo.";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos.";
    
    private GestorUsuarios(){
        
    }
    
    /**
     * Patrón Singleton.
     * @return El gestor.
     */
    
    public static GestorUsuarios instanciar(){
        if (gestor == null)
            gestor = new GestorUsuarios();
        return gestor;
    }
    
    /**
     * Crea un nuevo usuario, devolviendo una cadena con el resultado de la operación.
     * @param correo El correo del usuario.
     * @param apellido El apellido del usuario.
     * @param nombre El nombre del usuario.
     * @param perfil El perfil del usuario.
     * @param clave La clave del usuario.
     * @param claveRepetida Clave repetida.
     * @return Una cadena de EXITO si se creó correctamente el usuario.
     */
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        
        String resultadoValidacion = validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida );
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }
        switch(perfil){
            case Perfil.CLIENTE:
                Cliente c = new Cliente(correo, clave, apellido, nombre);
                usuarios.add(c);
                break;
            case Perfil.ENCARGADO:
                Encargado en = new Encargado(correo, clave, apellido, nombre);
                usuarios.add(en);
                break;
            case Perfil.EMPLEADO:
                Empleado em = new Empleado(correo, clave, apellido, nombre);
                usuarios.add(em);
                break;
            default: return ERROR_PERFIL;
        }
        return EXITO;
    }
    
    /**
     * Devuelve todos los usuarios.
     * @return 
     */
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    
    /**
     * Busca los usuarios cuyo apellido coincida, total o parcialmente, con el especificado.
     * @param apellido El apellido del usuario.
     * @return Un ArrayList de usuarios coincidentes.
     */
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuariosCoincidentes= new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido() != null && u.verApellido().contains(apellido)){
                usuariosCoincidentes.add(u);
            }
        }
        return usuariosCoincidentes;
    }
    
    /**
     * Devuelve true si existe el usuario especificado, false en caso contrario.
     * @param usuario Un usuario.
     * @return Un boolean.
     */
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    /**
     * Obtiene el usuario con el correo especificado. Si no hay un usuario con ese correo, devuelve null.
     * @param correo El correo del usuario.
     * @return Null.
     */
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo))
                return u;
        }
        return null;
    }
    
    //Métodos para hacer los distintos controles
    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if(correo == null ||!correo.contains("@") )
            return ERROR_CORREO;
      
        if(esCorreoRepetido(correo))
            return USUARIOS_DUPLICADOS;
        
        if(apellido == null || apellido.isBlank())
            return ERROR_APELLIDO;
        
        if(nombre == null||nombre.isBlank())
            return ERROR_NOMBRE;
        
        if(clave == null || clave.isBlank())
            return ERROR_CLAVES;
        
        if(claveRepetida == null)
            return ERROR_CLAVES;
        if (claveRepetida.isBlank() || !clave.equals(claveRepetida))
            return ERROR_CLAVES;
        
        if(perfil == null)
            return ERROR_PERFIL;
        
        return VALIDACION_EXITO;
    }    
      private boolean esCorreoRepetido(String correo){
        if(usuarios.isEmpty())
            return false;
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo))
        return true;
        }
        return false;
    }

}
