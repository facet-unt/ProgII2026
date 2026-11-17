/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorPedidos;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Arebalo
 */
public class GestorUsuarios implements IGestorUsuarios{
    
    private static GestorUsuarios gestor;
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
          
            
 //Singleton
    
    private GestorUsuarios(){
    }
    public static GestorUsuarios instanciar(){
        if(gestor == null){
            gestor = new GestorUsuarios();
        }
        return gestor;
    }
    
     //Validador de datos
            
    private String validarDatos(String correo,String apellido,String nombre,Perfil perfil,String clave,String claveRepetida){
        if(correo == null || !correo.contains("@")){
            return ERROR_CORREO;
        }
        if(apellido == null || apellido.trim().isEmpty()){
            return ERROR_APELLIDO;
        }
        if(nombre == null || nombre.trim().isEmpty()){
            return ERROR_NOMBRE;
        }
        if(perfil == null){
            return ERROR_PERFIL;
        }
        if(clave == null || clave.trim().isEmpty() || claveRepetida == null || claveRepetida.trim().isEmpty() || !clave.equals(claveRepetida)){
            return ERROR_CLAVES;
        }
        return VALIDACION_EXITO;
    }
    
    //Creador de usuarios
    
    @Override
    public String crearUsuario(String correo,String apellido,String nombre,Perfil perfil,String clave,String claveRepetida){
        String validacion = validarDatos(correo,apellido,nombre,perfil,clave,claveRepetida);
        if (!validacion.equals(VALIDACION_EXITO)){
            return validacion;
        }
        Usuario nuevoUsuario = null;
        switch(perfil){
            case CLIENTE:
            nuevoUsuario = new Cliente(correo,clave,apellido,nombre);
                break;
            case EMPLEADO:
                nuevoUsuario = new Empleado(correo,clave,apellido,nombre);
                break;
            case ENCARGADO:
                nuevoUsuario = new Encargado(correo,clave,apellido,nombre);
                break;
        }
        if(this.usuarios.contains(nuevoUsuario)){
            return USUARIOS_DUPLICADOS;
        }
        this.usuarios.add(nuevoUsuario);
        return EXITO;
    }
    
    //Devolver todos los usuarios
    
    @Override
    public ArrayList<Usuario> verUsuarios(){
        return this.usuarios;
    }
    
    //Buscar usuarios por apellido
    
    @Override
    public ArrayList<Usuario> buscarUsuarios(String apellido){
        ArrayList<Usuario> resultado = new ArrayList<>();
        if(apellido == null || apellido.trim().isEmpty()){
            return resultado;
        }
        String buscado =apellido.trim().toLowerCase();
        for(Usuario u : this.usuarios){
            if(u.verApellido() != null && u.verApellido().toLowerCase().contains(buscado)){
                resultado.add(u);
            }
        }
        return resultado;
    }
    
    //Comprobar si un usuario existe o no
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        if (usuario == null){
            return false;
        }
        return this.usuarios.contains(usuario);
    }
    
    //Obtener un usuario por su correo
    
    @Override
    public Usuario obtenerUsuario(String correo){
        if(correo == null || correo.trim().isEmpty()){
            return null;
        }
        for (Usuario u : this.usuarios){
            if (u.verCorreo() != null && u.verCorreo().equalsIgnoreCase(correo.trim())){
                return u;
            }
        }
        return null;
    }
    
    //Borrar un usuario
    
    
    @Override
public String borrarUsuario(Usuario usuario) {
    if (usuario == null || !this.usuarios.contains(usuario)) {
        return USUARIO_INEXISTENTE;
    }

    if (usuario instanceof Cliente) {
        IGestorPedidos gp = GestorPedidos.instanciar();
        if (gp.hayPedidosConEsteCliente((Cliente) usuario)) {
            return ERROR_BORRAR;
        }
    }

    this.usuarios.remove(usuario);
    return EXITO;
}
}
