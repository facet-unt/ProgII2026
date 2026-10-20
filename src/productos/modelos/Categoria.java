package productos.modelos;

/**
 * Representa las categorías disponibles para los productos del menú.
 *
 * @author foxeen
 */
public enum Categoria {

    /** Categoría correspondiente a la entrada. */
    ENTRADA("entrada"),

    /** Categoría correspondiente al plato principal. */
    PLATO_PRINCIPAL("plato principal"),

    /** Categoría correspondiente al postre. */
    POSTRE("postre");

    /**
     * Descripcion de la categoría.
     */
    private final String descripcion;

    /**
     * Constructor de Categoria
     * <p>
     * Inicializa la constante del enum con su descripción asociada.
     *
     * @param descripcion nombre legible de la categoría  (ej. "entrada", "plato principal", "postre")
     */
    Categoria(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción de la categoría.
     *
     * @return texto asociado a la categoría
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
