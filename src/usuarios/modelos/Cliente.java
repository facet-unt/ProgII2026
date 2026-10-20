///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import productos.modelos.Producto;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario{
    //Relacion: un cliente tiene muchos pedidos
    private ArrayList<Producto> productos;
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
}