package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 * Representa a un usuario con el rol de encargado dentro del sistema.
 * <p>
 * Hereda los datos de perfil y credenciales de la clase {@link Usuario} e implementa
 * la consulta de los pedidos
 *
 * @author foxeen
 */
public class Encargado extends Usuario {

    //==================================================
    //             Constructor de Encargado
    //==================================================

    /**
     * Constructor de Encargado 
     * <p>
     * Construye un nuevo encargado inicializando sus credenciales y datos personales.
     *
     * @param correo correo electrónico del encargado
     * @param clave contraseña de acceso del encargado
     * @param apellido apellido del encargado
     * @param nombre nombre del encargado
     */
    public Encargado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }
    
    //==================================================
    //               Métodos de Encargado
    //==================================================

    /**
     * Devuelve la lista de pedidos (Por el momento es una lista vacia)
     *
     * @return lista de instancias de {@link Pedido} asociadas al encargado
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        ArrayList<Pedido> VPedidos = new ArrayList<>();
        return VPedidos;
    }
}