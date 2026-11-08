/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class GestorUsuarios {
    /**
     * Lista para guardar los usuarios que se ingresen
     */
    ArrayList<Usuario> listaUsuario= new ArrayList<>();

    /**
     * Variable estática privada para guardar la única instancia
     */
    private static GestorUsuarios instancia;

    /**
     * Constructor privado para evitar que hagan 'new GestorUsuarios()' desde afuera
     */
    private GestorUsuarios() {
        this.listaUsuario = new ArrayList<>();
    }
    
    /**
     * Método estático 'instanciar()'
     * @return el objeto unico
     */
    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }
    
}
