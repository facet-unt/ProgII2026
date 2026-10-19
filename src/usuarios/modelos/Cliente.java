///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario {
    private ArrayList<Pedido> pedidos;
    
    //====================================
    //      Metodos de Cliente
    //====================================
    public void agregarPedido(Pedido unPedido) {
        if(!pedidos.contains(unPedido))
            pedidos.add(unPedido);
        
    }
    
    public void cancelarPedido(Pedido unPedido) {
        if(pedidos.contains(unPedido)){
            pedidos.remove(unPedido);
            System.out.println("Pedido cancelado! ");
        }
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    //====================================
    //      Constructor de Cliente
    //====================================

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }

    
    
    

}
