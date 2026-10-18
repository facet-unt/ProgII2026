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
    private ArrayList<Pedido> listaPedidos;  

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    public ArrayList<Pedido> verListaPedidos() {
        return listaPedidos;
    }

    public void asignarListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }   

    @Override
    public void mostrar() {
       System.out.println("Cliente : <" + super.verApellido() + " " + super.verNombre() + ">");
       System.out.println("Correo : " + super.verCorreo());
       System.out.println("Clave : " + super.verClave());
    }
    
    
}
