/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author ramayo
 */
public class GestorUsuario {
    ArrayList<Usuario> usuario = new ArrayList<>();
    
    public static final String EXITO = "Usuario creado/modificado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves especificadas no coinciden o son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos de usuario son correctos";

    //<editor-fold defaultstate="collapsed" desc="Patrón Singleton">
    private static GestorUsuario gestor;
    private GestorUsuario() {
    }
    
    public static GestorUsuario instanciar() {
        if (gestor == null)
        gestor = new GestorUsuario();
        return gestor;
    }
    //</editor-fold>
    
    
}
