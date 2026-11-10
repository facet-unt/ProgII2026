/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author homep
 */
public class GestorUsuarios {
    private static final GestorUsuarios instancia = new GestorUsuarios();
    private GestorUsuarios(){}
    
    public static GestorUsuarios instanciar(){
        return instancia;
    }
}
