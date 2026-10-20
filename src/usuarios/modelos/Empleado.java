///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 * Representa a un usuario con el rol de empleado dentro del sistema.
 * <p>
 * Hereda los datos de perfil y credenciales de la clase {@link Usuario} e implementa
 * la consulta de los pedidos
 *
 * @author foxeen
 */
public class Empleado extends Usuario {

    //==================================================
    //             Constructor de Empleado
    //==================================================

    /**
     * Constructor de Empleado 
     * <p>
     * Construye un nuevo empleado inicializando sus credenciales y datos personales.
     *
     * @param correo correo electrónico del empleado
     * @param clave contraseña de acceso del empleado
     * @param apellido apellido del empleado
     * @param nombre nombre del empleado
     */
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    //==================================================
    //               Métodos de Empleado
    //==================================================

    /**
     * Devuelve la lista de pedidos (Por el momento es una lista vacia)
     *
     * @return lista de instancias de {@link Pedido} asociadas al empleado
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        ArrayList<Pedido> VPedidos = new ArrayList<>();
        return VPedidos;
    }
}