///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {
    private final GestorPedidos gdp = GestorPedidos.instanciar();

    //====================================
    //      Metodos de Empleado
    //====================================
    @Override
       public  ArrayList verPedidos(){
            return gdp.verPedidos();
       }
       

    //====================================
    //      Constructor de Empleado
    //====================================
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    


}
