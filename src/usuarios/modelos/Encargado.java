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
public class Encargado extends Usuario {

    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo,clave,apellido,nombre);
    }
    
    //Se redefine el metodo verPedidos de la clase Usuario para que retorne null
    @Override
    public ArrayList<Pedido> verPedidos(){
        return null;
    }

    @Override
    public void mostrar(){
        System.out.println("\tEncargado: "+verApellido() +", " +verNombre() );
        System.out.println("\tclave: "+verClave() +" | correo: " +verCorreo()+ "\n" );
    }

    
}
