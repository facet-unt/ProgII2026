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

    /**
     * Variable estática privada para guardar la única instancia
     */
    private static GestorUsuarios instancia;

    /**
     * Constructor privado para evitar que hagan 'new GestorUsuarios()' desde afuera
     */
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
        
        if(perfil==null)
            return ERROR_PERFIL;
            
        if(clave==null || clave.trim().isEmpty())    
            if(claveRepetida==null || !clave.equals(claveRepetida))
                return ERROR_CLAVES;
        
        //FALTA USUARIO DUPLICADO
        if()
    
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
    public ArrayList<Usuario> buscarUsuarios(String Apellido){
    
        ArrayList<Usuario> usuariosEncontrados = new ArrayList<>();
        
        for(Usuario u : listaUsuarios){
            if(u.verApellido())
        }
    }
    
   
    
    
    
    
}
