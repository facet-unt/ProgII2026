/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author leand
 */
public class GestorUsuarios 
{
    ArrayList<Usuario> usuarios = new ArrayList<>();
    private static GestorUsuarios gestorU;
    private GestorUsuarios(){   
    }
    
    public static GestorUsuarios instanciar()
    {
        if(gestorU == null){
            gestorU = new GestorUsuarios();
        }
        return gestorU;
    }
    
    private String verificarDatosUsuarios(String correo, String apellido,String nombre, String clave, String claveRepetida){
        if (correo == null || !correo.contains("@")) 
        {
            return "ERROR_CORREO";
        }
        if (apellido == null || apellido.isEmpty()) 
        {
            return "ERROR_APELLIDO";   
        }
        if (nombre == null || nombre.isEmpty()) 
        {
            return "ERROR_NOMBRE";   
        }
        if (clave == null || clave.isEmpty()) 
        {
            return "ERROR_CLAVES";   
        }
        if (claveRepetida == null || !claveRepetida.equals(clave)) 
        {
            return "ERROR_CLAVES";
        }
        return "VALIDACION_EXITO";
    }
    
    public String crearUsuario(String correo, String apellido,String nombre, Perfil perfil, String clave, String claveRepetida)
    {
        String verificacion = verificarDatosUsuarios(correo, apellido, nombre, clave, claveRepetida);
        if(verificacion.equals("VALIDACION_EXITO"))
        {
            Usuario u = null;
            switch(perfil)
            {
                case CLIENTE:
                    u = new Cliente (correo, clave, apellido, nombre);
                    break;
                case EMPLEADO:
                    u = new Empleado (correo, clave, apellido, nombre);
                    break;
                case ENCARGADO:
                    u = new Encargado (correo, clave, apellido, nombre);
            }
            if (usuarios.contains(u)) 
            {
                return "USUARIOS_DUPLICADOS";
            }
            else{
                usuarios.add(u);
                return "EXITO";
            }
        }
        return verificacion;
    }
    
    public ArrayList<Usuario> verUsuarios()
    {
        return usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido)
    {
        ArrayList <Usuario> encontrados = new ArrayList<>();
        for(Usuario u: usuarios)
        {
            if (u.verApellido().contains(apellido))
            {
                encontrados.add(u);
            }
        }
        return encontrados;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String correo){
        for (Usuario u : usuarios) 
        {
            if (u.verCorreo().equals(correo)) 
            {
                return u;
            }
        }
        return null;
    }
}
