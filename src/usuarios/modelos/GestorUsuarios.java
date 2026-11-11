/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author homep
 */
public class GestorUsuarios {
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final String EXITO = "Usuario creado/modificado con exito";
    private static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    private static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    private static final String ERROR_NOMBRE = "Usuario creado/modificado con exito";
    private static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    private static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    private static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    private static final String VALIDACION_EXITO = "Los datos del usuario son correctos";
    //=======================
    //      Singletone
    //=======================
    private static final GestorUsuarios instancia = new GestorUsuarios();
    private GestorUsuarios(){}
    
    public static GestorUsuarios instanciar(){
        return instancia;
    }
    
    private String corroborarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        int contador = 0;
        if (correo == null || !correo.contains("@"))
            return ERROR_CORREO;
        if (apellido == null)
            return ERROR_APELLIDO;
        if (nombre == null)
            return ERROR_NOMBRE;
        if (clave.isEmpty() || clave == null || clave.equals(claveRepetida))
            return ERROR_CLAVES;
        for (Perfil p : Perfil.values()){
            if (!perfil.equals(p))
                contador ++;
        }
        if (contador == 3)
            return ERROR_PERFIL;

        return VALIDACION_EXITO;
    }
    
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String proceso = corroborarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        
        if (proceso.equals(VALIDACION_EXITO)){
            switch (perfil){
                case Perfil.CLIENTE -> {
                    Usuario u = new Cliente(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u);
                    return proceso;
                }
                
                case Perfil.EMPLEADO -> {
                    Usuario u1 = new Empleado(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u1);
                    return proceso;
                }
                
                case Perfil.ENCARGADO -> {
                    Usuario u2 = new Encargado(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u2);
                    return proceso;
                }
            }
            
        }
        return proceso;
    }
    
    public ArrayList<Usuario> verUsuarios(){
        return GestorUsuarios.usuarios;
    }
    
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> usuarios_coincidentes = new ArrayList<>();
        
        for (Usuario u : usuarios){
            if (u.verApellido().contains(apellido))
                usuarios_coincidentes.add(u);
        }
        
        if (usuarios_coincidentes.isEmpty())
            return null;
        
        return usuarios_coincidentes;
    }
    
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    public Usuario obtenerUsuario(String Correo){
        for (Usuario u: usuarios){
            if (u.verCorreo().equals(Correo))
                return u;
        }
        return null;
    }
}
