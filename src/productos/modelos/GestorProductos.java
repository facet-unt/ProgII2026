/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author homep
 */
public class GestorProductos {
    private static final GestorProductos instancia = new GestorProductos();
    private GestorProductos(){};
    
    public static GestorProductos instanciar(){
        return instancia;
    }
}
