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
    
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    
    private GestorUsuarios(){
        
    }
    
    public static GestorUsuarios instanciar(){
        if (gestor == null){
            gestor = new GestorUsuarios();
            return gestor;
        }
        System.out.println("gestor de productos ya existe");
        return null;
    }
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        
        if(correo == null)
            return ERROR_CORREO;
        if (!correo.contains("@"))
            return ERROR_CORREO;
        if(esCorreoRepetido(correo)){
            return USUARIOS_DUPLICADOS;
        }
        
        if(apellido == null)
            return ERROR_APELLIDO;
        if (apellido.isBlank())
            return ERROR_APELLIDO;
        
        if(nombre == null)
            return ERROR_NOMBRE;
        if (nombre.isBlank())
            return ERROR_NOMBRE;
        
        if(clave == null)
            return ERROR_CLAVES;
        if (clave.isBlank())
            return ERROR_CLAVES;
        
        if(claveRepetida == null)
            return ERROR_CLAVES;
        if (claveRepetida.isBlank() || !clave.equals(claveRepetida))
            return ERROR_CLAVES;
        
        if(perfil == null)
            return ERROR_PERFIL;
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
    
    private boolean esCorreoRepetido(String correo){
        if(usuarios.isEmpty())
            return false;
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo))
        return true;
        }
        return false;
    }

    
    public ArrayList<Usuario> verUsuarios(){
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> productosCoincidentes= new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.verApellido() != null && u.verApellido().contains(apellido)){
                productosCoincidentes.add(u);
            }
        }
        return productosCoincidentes;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String correo){
        for(Usuario u: usuarios){
            if(u.verCorreo().equals(correo))
                return u;
        }
        return null;
    }
}
