///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {

    


    //====================================
    //      Metodos de Empleado
    //====================================
    @Override
       public  ArrayList verPedidos(){
//           ArrayList vacio = new ArrayList<>();
//           return vacio;
            return null;
       }
       

    //====================================
    //      Constructor de Empleado
    //====================================
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    


}
