/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author homep
 */
public class GestorUsuarios implements IGestorUsuarios{
    private static final List<Usuario> usuarios = new ArrayList<>();
//    private final Comparator<Usuario> comparadorApellyNom = (Usuario u1,Usuario u2)->{
//        int compApellido = u1.verApellido().compareToIgnoreCase(u2.verApellido());
//        if (compApellido != 0){
//            return compApellido;
//        }
//        return u1.verNombre().compareToIgnoreCase(u2.verNombre());
//    };
    // El metodo estatico comparing hace lo mismo que usar una clase anonima con una expresion lambda
    // Usuario::verApellido es una referencia a metodo que hace basicamene u -> u.verApelido 
    // string.CASE_INSENSITIVE_ORDER es una constante de la clase string la cual es un comparator<string>
    // Es el equivalente a usar el metodo compareToIgnoreCase
    // thencomparing Permite Añadir un Criterio Secundario, terciario de comparacion
    private final Comparator<Usuario> comparadorApellyNom = Comparator.comparing(Usuario::verApellido,String.CASE_INSENSITIVE_ORDER).thenComparing(Usuario::verNombre,String.CASE_INSENSITIVE_ORDER);
    
    

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
        if (apellido == null || apellido.isEmpty())
            return ERROR_APELLIDO;
        if (nombre == null || nombre.isEmpty()){
            return ERROR_NOMBRE;
        }
        if (clave == null|| clave.isEmpty() || !clave.equals(claveRepetida))
            return ERROR_CLAVES;
        for (Perfil p : Perfil.values()){
            if (perfil == null || !perfil.equals(p))
                contador ++;
        }
        if (contador == 3)
            return ERROR_PERFIL;
        
        Usuario u = new Cliente(correo, clave, apellido, nombre);
        if (GestorUsuarios.usuarios.contains(u))
            return USUARIOS_DUPLICADOS;
        
        return VALIDACION_EXITO;
    }
    
    
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String proceso = corroborarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        System.out.println();
        
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
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(GestorUsuarios.usuarios,comparadorApellyNom);
        return GestorUsuarios.usuarios;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(String apellido){
        List<Usuario> usuarios_coincidentes = new ArrayList<>();
        
        for (Usuario u : usuarios){
            if (u.verApellido().contains(apellido))
                usuarios_coincidentes.add(u);
        }
        
        if (usuarios_coincidentes.isEmpty())
            //return null
            return usuarios_coincidentes;
        Collections.sort(usuarios_coincidentes,comparadorApellyNom);
        return usuarios_coincidentes;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    @Override
    public Usuario obtenerUsuario(String Correo){
        for (Usuario u: usuarios){
            if (u.verCorreo().equals(Correo)){
                return u;
        
            }
        }
        return null;
    }
    
    @Override
    public String borrarUsuario(Usuario usuario){
        if (!usuarios.contains(usuario)){
            return ERROR_NO_EXISTE;
        }else{
            usuarios.remove(usuario);
            return EXITO_BORRAR;
        }
    }
}
