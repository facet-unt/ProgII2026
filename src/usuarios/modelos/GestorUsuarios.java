/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leand
 */
public class GestorUsuarios implements IGestorUsuarios 
{
    List<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios gestorU;
    private GestorUsuarios(){   
    }
    
    public static GestorUsuarios instanciar()
    {
        if(gestorU == null)
        {
            gestorU = new GestorUsuarios();
        }
        return gestorU;
    }
    
    private String verificarDatosUsuarios(String correo, String apellido,String nombre,Perfil perfil ,String clave, String claveRepetida){
        if (correo == null || !correo.contains("@")) 
        {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.isEmpty()) 
        {
            return ERROR_APELLIDO;   
        }
        if (nombre == null || nombre.isEmpty()) 
        {
            return ERROR_NOMBRE;   
        }
        if (clave == null || clave.isEmpty()) 
        {
            return ERROR_CLAVES;   
        }
        if (claveRepetida == null || !claveRepetida.equals(clave)) 
        {
            return ERROR_CLAVES;
        }
        if (perfil == null) 
        {
            return ERROR_PERFIL;
        }
        return VALIDACION_EXITO;
    }
    
    public String crearUsuario(String correo, String apellido,String nombre, Perfil perfil, String clave, String claveRepetida)
    {
        String verificacion = verificarDatosUsuarios(correo, apellido, nombre, perfil ,clave, claveRepetida);
        if(verificacion.equals(VALIDACION_EXITO))
        {
            Usuario u = null;
            switch(perfil)
            {
                case CLIENTE -> u = new Cliente (correo, clave, apellido, nombre);
                case EMPLEADO -> u = new Empleado (correo, clave, apellido, nombre);
                case ENCARGADO -> u = new Encargado (correo, clave, apellido, nombre);
                default -> { 
                    return ERROR_PERFIL;
                }
            }
            if (usuarios.contains(u)) 
            {
                return USUARIOS_DUPLICADOS;
            }
            else{
                usuarios.add(u);
                return EXITO;
            }
        }
        return verificacion;
    }
    
    private void ordenar(List<Usuario> ordenados){
        ordenados.sort((u1, u2) -> {
         int resultado = u1.verApellido().compareToIgnoreCase(u2.verApellido());
            if(resultado == 0){
            return u1.verNombre().compareToIgnoreCase(u2.verNombre());
            }
            return resultado;
            });
    }
    
    public List<Usuario> verUsuarios()
    {
        ordenar(usuarios);
        return usuarios;
    }
    
    public List<Usuario> buscarUsuarios(String apellido)
    {
        List <Usuario> encontrados = new ArrayList<>();
        for(Usuario u: usuarios)
        {
            if (u.verApellido().contains(apellido))
            {
                encontrados.add(u);
            }
        }
        ordenar(encontrados);
        return encontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String correo){
        for (Usuario u : usuarios) 
        {
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }
    
    public String borrarUsuario(Usuario usuario)
    {
        if (usuarios.contains(usuario)) 
        {
            for(Usuario u : usuarios)
            {
                if (u.equals(usuario) && u.verPedidos().isEmpty()) 
                {
                    usuarios.remove(usuario);
                    return EXITO;
                }
            }
        }
        
        return ERROR_USUARIO;
    }
}
