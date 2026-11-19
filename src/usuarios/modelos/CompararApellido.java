/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.Comparator;

/**
 *
 * @author Arebalo
 */
public class CompararApellido implements Comparator<Usuario> {
    
    @Override
    public int compare(Usuario u1, Usuario u2){
        return u1.verApellido().compareToIgnoreCase(u2.verApellido());
    }   
    
}
