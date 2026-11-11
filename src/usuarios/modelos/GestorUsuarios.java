/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ramayo
 */
public class GestorUsuarios{
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private String validacion;
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos de usuario son correctos";

    //<editor-fold defaultstate="collapsed" desc="Patrón Singleton">
    private static GestorUsuarios gestor;
    private GestorUsuarios() {
    }
    
    public static GestorUsuarios instanciar() {
        if (gestor == null)
        gestor = new GestorUsuarios();
        return gestor;
    }
    //</editor-fold>
    
    private String validarUsuario(String correo, String apellido, String nombre,Perfil perfil, String clave, String claveRepetida){
        if(correo==null && !(correo.contains("@")))
            return ERROR_CORREO;
        if(apellido==null || apellido.trim().isEmpty())
            return ERROR_APELLIDO;
        if(nombre==null || apellido.trim().isEmpty())
            return ERROR_NOMBRE;
        if(perfil.name()!="ENCARGADO"||perfil.name()!="CLIENTE"||perfil.name()!="EMPLEADO")
            return ERROR_PERFIL;
        if(clave==null || clave.trim().isEmpty())
            return ERROR_CLAVES;
        if(claveRepetida==null||clave.trim().isEmpty()||claveRepetida!=clave)
            return ERROR_CLAVES;
        
        return VALIDACION_EXITO;
    }       
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        validacion= validarUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);
        if(validacion==VALIDACION_EXITO){
            switch(perfil){
                case EMPLEADO:
                    Usuario e = new Empleado(correo, apellido, nombre, clave);
                    listaUsuario.add(e);
                case ENCARGADO:
                    Usuario ec = new Encargado(correo, apellido, nombre, clave);
                    listaUsuario.add(ec);
                default:
                    Usuario c = new Cliente(correo, apellido, nombre, clave);
                    listaUsuario.add(c);
            }
            return EXITO;
        }
        else return validacion;
    }
    
    public ArrayList<Usuario> verUsuarios(){
        return listaUsuario;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuarioBuscado = new ArrayList<>();
        if(!(apellido==null||apellido.isEmpty())){
            for(Usuario u:listaUsuario){
                String apellidoLowCase = u.verApellido().toLowerCase();
                if(apellidoLowCase.contains(apellido.toLowerCase()))
                    usuarioBuscado.add(u);
            }
            Collections.sort(usuarioBuscado);
            if(usuarioBuscado.isEmpty())
                System.out.println("Usuario no encontrado");
        }
        else{
            System.out.println(ERROR_APELLIDO);
        }
        return usuarioBuscado;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        return listaUsuario.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String correo){
        if(correo!=null && (correo.contains("@"))){
            for(Usuario u:listaUsuario){
                if(u.verCorreo().equals(correo))
                    return u;
            }
        }
        else
            System.out.println(ERROR_CORREO);
        return null; 
    }
    
    
}

