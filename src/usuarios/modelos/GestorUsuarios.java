/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author Usuario
 */
public class GestorUsuarios implements IGestorUsuarios {
    
    /**
     * Lista para guardar los usuarios que se ingresen
     */
    List<Usuario> listaUsuarios= new ArrayList<>();

    private static GestorUsuarios instancia;
    private GestorUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }
  
    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
    @Override
    public String crearUsuario(String correo,String apellido,String nombre,Perfil perfil,String clave,String claveRepetida){
        if(correo == null || !correo.contains("@"))
            return ERROR_CORREO;
        
        //trim() para que se recorte los espacios de los extremos,por si se ingresa solamente espacios
        if(apellido==null || apellido.trim().isEmpty())
            return ERROR_APELLIDO;
        
        if(nombre==null || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        
        if (perfil == null) 
            return ERROR_PERFIL; 
            
        if(clave==null || clave.trim().isEmpty() || claveRepetida==null || !clave.equals(claveRepetida))
            return ERROR_CLAVES;
  
        //si es distinto de null,ya hay un usuario con ese correo
        if(obtenerUsuario(correo) != null)
            return USUARIOS_DUPLICADOS;
    
        Usuario usuario;
        
        switch(perfil){
            case EMPLEADO -> usuario=new Empleado(correo,apellido,nombre,clave);
            case ENCARGADO -> usuario=new Encargado(correo,apellido,nombre,clave);
            case CLIENTE -> usuario=new Cliente(correo,apellido,nombre,clave);
            default -> {
                return ERROR_PERFIL;
            }
        }
        
        listaUsuarios.add(usuario);
        return EXITO;

    }

    /**
     * @return toda la lista de usuarios  
     */
    @Override
    public List<Usuario> verUsuarios(){
        //Collections.sort(listaUsuarios);
        return listaUsuarios;
    }
    
    /**
     * metodo para buscar un apellido en una lista de usuarios
     * @param Apellido a buscar
     * @return lista de usuarios que coincidan total o parcialmente con el ingresado
     */
    @Override
    public List<Usuario> buscarUsuarios(String Apellido){
    
       List<Usuario> encontrados = new ArrayList<>();
       
        for (Usuario u : listaUsuarios) {
            if (u.verApellido().toLowerCase().contains(Apellido.toLowerCase())) {
                encontrados.add(u);
            }
        }
        
        //Collections.sort(encontrados);
        return encontrados;
    }
    
    /**
     * Borra un usuario siempre y cuando no haya pedidos con el mismo.Devuelve una cadena con el resultado de la operacion. 
     * @param usuario
     * @return 
     */
    @Override
    public String borrarUsuario(Usuario usuario){
        if (usuario == null || !listaUsuarios.contains(usuario)) {
            return USUARIO_INEXISTENTE;
        }
        if (GestorPedidos.instanciar().hayPedidosConEsteCliente((Cliente)usuario)){
            return ERROR_ELIMINAR;
        }
        listaUsuarios.remove(usuario);
        return EXITO;
    }
    
    /**
     * 
     * @param usuario que se busca
     * @return true si existe el usuario,false en caso contrario
     */
    @Override
     public boolean existeEsteUsuario(Usuario usuario){
        //
         if(usuario==null){
            return false;
        }
        
        return (obtenerUsuario(usuario.verCorreo()) != null);
    }
   
     /**
      * @param correo utilizado para buscar un usuario
      * @return el usuario en caso de encontrarlo,null en caso contrario
      */
    @Override
    public Usuario obtenerUsuario(String correo) {
        
        for (Usuario u : listaUsuarios) {
            if (u.verCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        
        return null;
    }   
}
