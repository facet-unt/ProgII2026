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
public class CompararNombre implements Comparator<Usuario>{
    
    @Override
    public int compare(Usuario u1, Usuario u2){
        return u1.verNombre().compareToIgnoreCase(u2.verNombre());
    }
    
}
