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

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo,clave,apellido,nombre);
    }
    
    public void agregarPedido (Pedido p){
        if(this.pedidos.isEmpty()){
          pedidos.add(p);
          return;
        }
        if(!this.pedidos.contains(p)){
            System.out.println("se agregar el pedido");
            pedidos.add(p);
        }else{
            pedidos.set(pedidos.indexOf(p), p);
            System.out.println("se ha modificado el pedido");
        }
    }
    
    public void cancelarPedido(Pedido p){
        if(pedidos.contains(p)){
            pedidos.remove(p);
            System.out.println("se ha cancelado su pedido");
        }
    }
    
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    @Override
    public void mostrar(){
        System.out.println("\tCliente: "+verApellido() +", " +verNombre() );
        System.out.println("\tclave: "+verClave() +" | correo: " +verCorreo()+ "\n");
    }

}
