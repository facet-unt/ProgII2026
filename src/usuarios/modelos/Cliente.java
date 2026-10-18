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
    
    @Override
    public void mostrar(){
        System.out.println("\tCliente: "+verApellido() +", " +verNombre() );
        System.out.println("\tclave: "+verClave() +" | correo: " +verCorreo()+ "\n");
    }

}
