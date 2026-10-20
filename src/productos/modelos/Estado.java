package productos.modelos;

/**
 * Representa los estados de un producto en el sistema.
 *
 * @author foxeen
 */
public enum Estado {

    /** Indica que el producto se encuentra en stock y apto para la venta. */
    DISPONIBLE("disponible"),

    /** Indica que el producto no puede ser solicitado temporal o definitivamente. */
    NO_DISPONIBLE("no disponible");

    /**
     * Descripción del estado.
     */
    private final String descripcion;

    //=========================================
    //    Constructor de Estado del Producto
    //=========================================
    
    /**
     * Constructor de Estado
     * <p>
     * Inicializa la constante del enum con su descripción asociada.
     *
     * @param descripcion nombre legible del estado (ej. "disponible", "no disponible")
     */
    Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del estado.
     *
     * @return texto asociado al estado del Producto
     */
    @Override
    public String toString() {
        return descripcion;
    }
}

