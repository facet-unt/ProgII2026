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
    

    public Cliente(String correo,String clave,String apellido,String nombre){
        super(correo,clave,apellido,nombre);
        
    }
    public void agregarPedido(Pedido pedido){
        this.pedidos.add(pedido);
        pedido.asignarCliente(this);
    }

    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }

    public void asignarPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    @Override
    public void mostrar(){
        System.out.println("Pedidos:" + pedidos);
        
    }
}
