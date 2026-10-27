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
public class Cliente extends Usuario{
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();  

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    @Override
    public void mostrar() {
       System.out.println("Cliente : <" + super.verApellido() + " " + super.verNombre() + ">");
       System.out.println("Correo : " + super.verCorreo());
       System.out.println("Clave : " + super.verClave());
    }

    @Override
    public ArrayList<Pedido> verPedidos() {
        return this.listaPedidos;
    }
    
    public void agregarPedido(Pedido pedido){
        if(!listaPedidos.contains(pedido)){
            listaPedidos.add(pedido);
        }
        else{
            for(int i = 0; i < listaPedidos.size(); i++){
                Pedido auxiliar = listaPedidos.get(i);
                if(auxiliar.equals(pedido)){
                    listaPedidos.set(i, pedido);
                }
            }
        }
    }
    
    public void cancelarPedido(Pedido pedido){
        if(this.listaPedidos.contains(pedido)){
            this.listaPedidos.remove(pedido);
        }
    }
}
