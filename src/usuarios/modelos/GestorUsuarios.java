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
 * @author ramayo
 */
public class GestorUsuarios implements IGestorUsuarios{
    private static final ArrayList<Usuario> listaUsuario = new ArrayList<>();
    private String validacion;
    
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
        if(correo==null || !(correo.contains("@")))
            return ERROR_CORREO;
        if(apellido==null || apellido.trim().isEmpty())
            return ERROR_APELLIDO;
        if(nombre==null || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if(perfil!=Perfil.CLIENTE&&perfil!=Perfil.EMPLEADO&&perfil!=Perfil.ENCARGADO)
            return ERROR_PERFIL;
        if(clave==null || clave.trim().isEmpty()||claveRepetida==null||clave.trim().isEmpty()||!(claveRepetida.equals(clave)))
            return ERROR_CLAVES;
        for(Usuario u:listaUsuario){
            if(u.verCorreo().equals(correo)){
                return USUARIOS_DUPLICADOS;
            }
        }
        return VALIDACION_EXITO;
    }       
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        validacion= validarUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);
        if(validacion.equals(VALIDACION_EXITO)){
            switch(perfil){
                case EMPLEADO:
                    Usuario e = new Empleado(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(e))){
                        GestorUsuarios.listaUsuario.add(e);}
                case ENCARGADO:
                    Usuario ec = new Encargado(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(ec))){
                        GestorUsuarios.listaUsuario.add(ec);}
                default:
                    Usuario c = new Cliente(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(c))){
                        GestorUsuarios.listaUsuario.add(c);}
            }
            return EXITO;
        }
        else return validacion;
    }
    
    public ArrayList<Usuario> verUsuarios(){
        return GestorUsuarios.listaUsuario;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuarioBuscado = new ArrayList<>();
        if(!(apellido==null||apellido.isEmpty())){
            for(Usuario u:listaUsuario){
                String apellidoMinuscula = u.verApellido().toLowerCase();
                if(apellidoMinuscula.contains(apellido.toLowerCase()))
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
                if(u.verCorreo().equals(correo)){
                    return u;
                }
            }
        }
        else
            System.out.println(ERROR_CORREO);
        return null; 
    }

    public String borrarUsuario(Usuario usuario) {
        if(listaUsuario.contains(usuario)){
            if(usuario.verPedidos().isEmpty()){
                listaUsuario.remove(usuario);
                return EXITO;
            }
            else return ERROR_USUARIO_CON_PEDIDO;
        }
        else return ERROR_USUARIO;
    }
        
}

