/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author tobias150
 */
public class GestorUsuarios implements IGestorUsuarios{
    //Atributos de la clase
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios gestor;
    
    //Constructor privado de la clase
    private GestorUsuarios(){        
    }
    
    //Metodo para poder crear una unica instancia de la clase
    public static GestorUsuarios instanciar(){
        if(gestor == null){
            gestor = new GestorUsuarios();
        }
        return gestor;
    }
    
    //Metodo que devuelve todos los usuarios creados
    public ArrayList<Usuario> verUsuarios(){
        Collections.sort(usuarios);
        return usuarios;
    }
    
    //Metodo que busca si existe el usuario creado
    public boolean existeEsteUsuario(Usuario usuario){
        if(this.usuarios.contains(usuario)){
            return true;
        }
        return false;
    }
    
    //Devuelve un usuario con el correo especificado, si no existe, devuelve null
    public Usuario obtenerUsuario(String correo){
        for(Usuario u : usuarios){
            if(u.verCorreo().equals(correo))
                return u;
        }
        
        return null;
    }

    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        String resultado = this.validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        
        if(!resultado.equals(VALIDACION_EXITO)){
            return resultado;
        }
        
        Usuario u = null;
        switch(perfil){
            case CLIENTE:
                u = new Cliente(correo, clave, apellido, nombre);
                break;
            case EMPLEADO:
                u = new Empleado(correo, clave, apellido, nombre);
                break;
            case ENCARGADO:
                u = new Encargado(correo, clave, apellido, nombre);              
                break;
        }
        
        if(!this.existeEsteUsuario(u)){
            usuarios.add(u);
        }
        return EXITO;
    }

    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido) {
        ArrayList<Usuario> buscados = new ArrayList<>();
        
        for(int i = 0; i < usuarios.size(); i++){
            Usuario us = usuarios.get(i);
            if(us.verApellido().equals(apellido)){
                buscados.add(us);
            }
        }
        
        Collections.sort(buscados);
        return buscados;
    }

    @Override
    public String borrarUsuario(Usuario usuario) {
        if(this.usuarios.contains(usuario)){
            usuarios.remove(usuario);
            return IGestorUsuarios.USUARIO_BORRADO;
        }
        
        return IGestorUsuarios.USUARIO_INEXISTENTE;
    }
    
    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
           if(correo == null || correo.isEmpty() || !correo.contains("@"))
               return ERROR_CORREO;
           if(nombre == null || nombre.isEmpty())
               return ERROR_NOMBRE;
           if(apellido == null || apellido.isEmpty())
               return ERROR_APELLIDO;          
           if(clave == null || claveRepetida == null || clave.isEmpty() || claveRepetida.isEmpty() || !clave.equals(claveRepetida))
               return ERROR_CLAVES;
           if(perfil == null)
               return ERROR_PERFIL;
           
           return VALIDACION_EXITO;
       }
}
