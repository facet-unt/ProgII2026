package pedidos.modelos;

import java.util.Objects;
import productos.modelos.Producto;

/**
 * Representa la asociación entre un producto y la cantidad solicitada dentro de un pedido.
 *
 * @author foxeen
 */
public class ProductoDelPedido {

    /** Cantidad de unidades solicitadas del producto. */
    int cantidad;

    /** Instancia del producto asociado al renglón del pedido. */
    private Producto producto;
    
    //=========================================
    //     Constructor de ProductoDelPedido
    //=========================================
    
    /**
     * Constructor de ProductoDelPedido
     * <p>
     * Construye un nuevo ítem de pedido vinculando un producto con su cantidad solicitada.
     *
     * @param producto instancia de {@link Producto} a incluir en el pedido
     * @param cantidad número de unidades del producto
     */
    public ProductoDelPedido(Producto producto, int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    
    // =======================================
    //    Métodos Get de ProductoDelPedido
    // =======================================
    
    /**
     * Obtiene la cantidad de unidades registradas.
     *
     * @return número de unidades solicitadas
     */
    public int verCantidad() {
        return cantidad;
    }

    /**
     * Obtiene el producto asociado a este Producto del pedido.
     *
     * @return instancia de {@link Producto} vinculada
     */
    public Producto verProducto() {
        return producto;
    }

    // =======================================
    //    Métodos Set de ProductoDelPedido
    // =======================================
    
    /**
     * Asigna o actualiza la cantidad de unidades solicitadas.
     *
     * @param cantidad nuevo número de unidades
     */
    public void asignarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Asocia una instancia de {@link Producto} a este Producto del pedido.
     *
     * @param producto producto que se desea vincular
     */
    public void asignarProducto(Producto producto) {
        this.producto = producto;
    }
    
    // ====================================
    //       Salida y Representación
    // ====================================
    
    /**
     * Muestra por consola el renglón formateado con el código,
     * la descripción, el precio unitario y la cantidad del producto.
     */
    public void mostrar() {
        System.out.printf("[%d]   %-30s%11s %25d%n", producto.verCodigo(), producto.verDescripcion(), "$" + producto.verPrecio(), this.cantidad);
    }

    /**
     * Retorna un texto resumido del producto y la cantidad asignada.
     *
     * @return cadena con el formato "Producto: [producto] - Cant: [cantidad]"
     */
    @Override
    public String toString() {
        return "Producto: " + producto + " - Cant: " + cantidad;
    }

    /**
     * Calcula el código hash tomando como base el producto asociado.
     *
     * @return valor hash entero para la instancia
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.producto);
        return hash;
    }

    /**
     * Determina si Producto del pedido y otro objeto son iguales.
     * <p>
     * Dos instancias de {@code ProductoDelPedido} se consideran iguales si
     * hacen referencia al mismo {@link Producto}, sin importar la cantidad.
     *
     * @param obj objeto con el cual comparar
     * @return {@code true} si ambos contienen el mismo producto; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductoDelPedido other = (ProductoDelPedido) obj;
        return Objects.equals(this.producto, other.producto);
    }
}
