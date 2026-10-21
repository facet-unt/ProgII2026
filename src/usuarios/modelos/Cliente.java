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
public class Cliente extends Usuario
{
    public ArrayList<Pedido> pedidos;

    public Cliente(String correo, String clave, String apellido, String nombre) 
    {
        super(correo, clave, apellido, nombre);
        this.pedidos =  new ArrayList<>();
    }
    
    @Override
    public void mostrar()
    {
        System.out.printf("Cliente:");
        super.mostrar();
    }
    
    @Override
    public ArrayList<Pedido> verPedidos(){
        return pedidos;
    }
    
    public void agregarPedido(Pedido p)
    {
        if(pedidos.contains(p))
        {
            pedidos.set(pedidos.indexOf(p), p);
        }
        else
        {
            pedidos.add(p);
        }
    }
    
    public void cancelarPedido(Pedido p)
    {
        if(pedidos.contains(p))
            pedidos.remove(p);
    }
}
