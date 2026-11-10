/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author homep
 */
public class GestorPedidos {
    private static final GestorPedidos instancia = new GestorPedidos();
    private GestorPedidos(){}
    
    public static GestorPedidos instanciar(){
        return instancia;
    }
}
