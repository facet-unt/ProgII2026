
package pedidos.modelos;

/**
 * Representa los estados de un pedido en el sistema.
 *
 * @author foxeen
 */
public enum Estado {
    /** Indica que el pedido se encuentra creado */
    CREADO("creado"),
    /** Indica que el pedido está siendo procesado */
    PROCESANDO("procesando"),
    /** Indica que el pedido se entregó */
    ENTREGADO("entregado");
    
    /**
     * Descripción del estado.
     */
    private final String descripcion;
    
    //=========================================
    //     Constructor de Estado del Pedido
    //=========================================

    /**
     * Constructor de Estado
     * <p>
     * Inicializa la constante del enum con su descripción asociada.
     *
     * @param descripcion nombre legible del estado (ej. "creado", "procesando", "entregado")
     */
    Estado(String descripcion){
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene la descripción del estado.
     *
     * @return texto asociado al estado del Pedido
     */
    @Override
    public String toString(){
        return descripcion;
    }
}


