///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import java.util.List;
import pedidos.modelos.GestorPedidos;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {
    private final GestorPedidos gdp = GestorPedidos.instanciar();

    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    @Override
    public List<Pedido> verPedidos() {
        return gdp.verPedidos();
    }
    
}
