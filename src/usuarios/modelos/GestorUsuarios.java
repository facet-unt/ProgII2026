/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorUsuarios {
    /**
     * Constantes con sus respectivos mensajes de texto
     */
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    
    /**
     * Lista para guardar los usuarios que se ingresen
     */
    ArrayList<Usuario> listaUsuarios= new ArrayList<>();

    private static GestorUsuarios instancia;
    private GestorUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }
    
    /**
     * Método estático instanciar()
     * @return el objeto unico
     */
    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    public String crearUsuario(String correo,String apellido,String nombre,Perfil perfil,String clave,String claveRepetida){
        if(correo == null || !correo.contains("@"))
            return ERROR_CORREO;
        
        //trim() para que se recorte los espacios de los extremos,por si se ingresa solamente espacios
        if(apellido==null || apellido.trim().isEmpty())
            return ERROR_APELLIDO;
        
        if(nombre==null || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
            
        if(clave==null || clave.trim().isEmpty() || claveRepetida==null || !clave.equals(claveRepetida))
            return ERROR_CLAVES;
  
        //si es distinto de null,ya hay un usuario con ese correo
        if(obtenerUsuario(correo) != null)
            return USUARIOS_DUPLICADOS;
    
        Usuario usuario;
        
        switch(perfil){
            case EMPLEADO -> usuario=new Empleado(correo,apellido,nombre,clave);
            case ENCARGADO -> usuario=new Encargado(correo,apellido,nombre,clave);
            case CLIENTE -> usuario=new Cliente(correo,apellido,nombre,clave);
            default -> {
                return ERROR_PERFIL;
            }
        }
        
        listaUsuarios.add(usuario);
        return EXITO;

    }

    /**
     * @return toda la lista de usuarios  
     */
    public ArrayList<Usuario> verUsuarios(){
        return listaUsuarios;
    }
    
    
    /**
     * metodo para buscar un apellido en una lista de usuarios
     * @param Apellido a buscar
     * @return lista de usuarios que coincidan total o parcialmente con el ingresado
     */
//    public ArrayList<Usuario> buscarUsuarios(String Apellido){
//    
//        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
//        
//        for(Usuario u : listaUsuarios){
//            if(u.verApellido())
//        }
//    }
//    
    /**
     * 
     * @param usuario que se busca
     * @return true si existe el usuario,false en caso contrario
     */
     public boolean existeEsteUsuario(Usuario usuario){
        //
         if(usuario==null){
            return false;
        }
        
        return (obtenerUsuario(usuario.verCorreo()) != null);
    }
   
     /**
      * @param correo utilizado para buscar un usuario
      * @return el usuario en caso de encontrarlo,null en caso contrario
      */
    public Usuario obtenerUsuario(String correo) {
        
        for (Usuario u : listaUsuarios) {
            if (u.verCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        
        return null;
    }
    
}
