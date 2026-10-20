package usuarios.modelos;

import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 * Representa a un usuario con el rol de Cliente dentro del sistema.
 * <p>
 * Hereda los datos de perfil y credenciales de la clase {@link Usuario} e implementa
 * la alta,baja,consulta de los pedidos
 *
 * @author foxeen
 */
public class Cliente extends Usuario {
    /** Lista de pedidos solicitados por el cliente. */
    private ArrayList<Pedido> pedidos;
    
    //==================================================
    //             Constructor de Cliente
    //==================================================

    /**
     * Constructor de Cliente
     * <p>
     * Construye un nuevo Cliente inicializando sus credenciales, datos personales, y su lista de pedidos(vacia).
     *
     * @param correo correo electrónico del Cliente
     * @param clave contraseña de acceso del Cliente
     * @param apellido apellido del Cliente 
     * @param nombre nombre del Cliente
     */

    public Cliente(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
        this.pedidos = new ArrayList<>();
    }
    
    
    //==================================================
    //               Métodos de Pedidos
    //==================================================

    /**
     * Agrega un nuevo pedido a la lista del cliente o lo actualiza si ya existía.
     *
     * @param unPedido instancia de {@link Pedido} a incorporar o actualizar
     */
    public void agregarPedido(Pedido unPedido) {
        if (!pedidos.contains(unPedido)) {
            pedidos.add(unPedido);
        } else { 
            pedidos.set(pedidos.indexOf(unPedido), unPedido);
        }
    }
    
    /**
     * Cancela y remueve un pedido de la lista del cliente si se encuentra registrado.
     *
     * @param unPedido instancia de {@link Pedido} que se desea cancelar
     */
    public void cancelarPedido(Pedido unPedido) {
        if (pedidos.contains(unPedido)) {
            pedidos.remove(unPedido);
            System.out.println("Pedido cancelado! ");
        }
    }
    
    /**
     * Devuelve la lista completa de pedidos asociados al cliente.
     *
     * @return lista de instancias de {@link Pedido} pertenecientes al cliente
     */
    @Override
    public ArrayList<Pedido> verPedidos() {
        return pedidos;
    }
}
