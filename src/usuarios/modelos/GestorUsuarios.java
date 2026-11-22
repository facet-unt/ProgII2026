/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author ramayo
 */
public class GestorUsuarios implements IGestorUsuarios{
    private static final List<Usuario> listaUsuario = new ArrayList<>();
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
    
    //Valida que los datos del usuario no sean nulos/vacíos, que las claves coincidan y que no exista otro usuario registrado con el mismo correo
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
    
    @Override //Crea una instancia de Cliente, Empleado o Encargado según el perfil indicado, previa validación de datos, y lo guarda en la lista si no está duplicado
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        validacion= validarUsuario(correo, apellido, nombre, perfil, clave, claveRepetida);
        if(validacion.equals(VALIDACION_EXITO)){
            switch(perfil){
                case EMPLEADO:
                    Usuario e = new Empleado(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(e))){
                        GestorUsuarios.listaUsuario.add(e);
                    }
                    break;
                case ENCARGADO:
                    Usuario ec = new Encargado(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(ec))){
                        GestorUsuarios.listaUsuario.add(ec);
                    }
                    break;
                default:
                    Usuario c = new Cliente(correo, clave, apellido, nombre);
                    if(!(listaUsuario.contains(c))){
                        GestorUsuarios.listaUsuario.add(c);
                    }
                    break;
            }
            return EXITO;
        }
        else return validacion;
    }
    
    @Override //Ordena la lista usando el compareTo de Usuario (apellido y luego nombre) y devuelve todos los usuarios registrados
    public List<Usuario> verUsuarios(){
        Collections.sort(GestorUsuarios.listaUsuario);
        return GestorUsuarios.listaUsuario;
    }
    
    @Override//Filtra los usuarios cuyo apellido contenga el texto buscado sin distinguir mayusculas y devuelve el resultado ordenado alfabeticamente por apellido y nombre
    public List<Usuario> buscarUsuarios(String apellido){
        List<Usuario> usuarioBuscado = new ArrayList<>();
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
    
    @Override //Verifica si el usuario ya existe en la lista comparando por correo
    public boolean existeEsteUsuario(Usuario usuario){
        return listaUsuario.contains(usuario);
    }
    
    @Override //Busca y devuelve el usuario que tenga exactamente el correo indicado, o null si no existe
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

    @Override //Elimina el usuario de la lista solo si existe y no tiene pedidos asociados
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

