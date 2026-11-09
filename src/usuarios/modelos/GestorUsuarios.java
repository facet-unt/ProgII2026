/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author tobias150
 */
public class GestorUsuarios {
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
}
