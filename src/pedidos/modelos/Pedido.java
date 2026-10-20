package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import usuarios.modelos.Cliente;
import productos.modelos.Producto;

/**
 * Representa una orden o pedido realizado por un cliente en el sistema.
 * <p>
 * Contiene el número identificador, la fecha y hora de emisión, el estado
 * del procesamiento, el cliente que lo solicitó y la lista de productos del pedido.
 *
 * @author foxeen
 */
public class Pedido {

    /** Número identificador único del pedido. */
    private int numero;

    /** Fecha y hora exacta de registro del pedido. */
    private final LocalDateTime fechaYHora;

    /** Estado actual de avance o procesamiento del pedido. */
    private Estado estado;

    /** Cliente que realizó la solicitud del pedido. */
    private Cliente cliente;

    /** Lista con los renglones de productos y cantidades asociadas al pedido. */
    private ArrayList<ProductoDelPedido> ProductoDelPedido = new ArrayList<>();
    
    //====================================
    //      Constructor de Pedido
    //====================================

    /**
     * Construye un nuevo pedido inicializando sus datos e iniciando su estado en {@link Estado#CREADO}.
     *
     * @param numero número único identificador del pedido
     * @param fechaYHora fecha y hora de emisión del pedido
     * @param pdp lista de renglones con los productos y sus cantidades 
     * @param cliente instancia de {@link Cliente} que realiza la compra
     */
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> pdp, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fechaYHora = fechaYHora;
        this.estado = Estado.CREADO;
        this.ProductoDelPedido = pdp;
    }
    
    //====================================
    //      Métodos Get de Pedido
    //====================================

    /**
     * Obtiene el cliente asociado a este pedido.
     *
     * @return instancia de {@link Cliente} que realizó el pedido
     */
    public Cliente verCliente() {
        return cliente;
    }

    /**
     * Obtiene el estado actual del pedido.
     *
     * @return constante de {@link Estado} (ej. {@link Estado#CREADO}, {@link Estado#PROCESANDO} o {@link Estado#ENTREGADO})
     */
    public Estado verEstado() {
        return estado;
    }

    /**
     * Obtiene el número identificador del pedido.
     *
     * @return número de orden del pedido
     */
    public int verNumero() {
        return numero;
    }

    /**
     * Obtiene la fecha en la que se generó el pedido.
     *
     * @return fecha de registro en formato {@link LocalDate}
     */
    public LocalDate verFecha() {
        return this.fechaYHora.toLocalDate();
    }

    /**
     * Obtiene la hora en la que se registró el pedido.
     *
     * @return hora de registro en formato {@link LocalTime}
     */
    public LocalTime verHora() {
        return this.fechaYHora.toLocalTime();
    }

    /**
     * Obtiene la lista completa de renglones o productos asociados al pedido.
     *
     * @return lista de instancias de {@link ProductoDelPedido}
     */
    public ArrayList<ProductoDelPedido> verProductoDelPedido() {
        return ProductoDelPedido;
    }
    
    // =======================================
    //        Métodos Set de Pedido
    // =======================================

    /**
     * Asigna un cliente al pedido.
     *
     * @param cliente nuevo cliente a asociar
     */
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Asigna un nuevo estado de procesamiento al pedido.
     *
     * @param estado nuevo estado a establecer
     */
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Asigna el número identificador al pedido.
     *
     * @param numero nuevo número de pedido
     */
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Agrega un producto con su cantidad al pedido o actualiza su cantidad si ya existía.
     *
     * @param cantidad cantidad de unidades solicitadas
     * @param p instancia de {@link Producto} a incorporar o actualizar
     */
    public void asignarProductoDelPedido(int cantidad, Producto p) {
        ProductoDelPedido pdp = new ProductoDelPedido(p, cantidad);
        if(!this.ProductoDelPedido.contains(pdp)){
            this.ProductoDelPedido.add(pdp);
        }
        else{
            this.ProductoDelPedido.set(this.ProductoDelPedido.indexOf(pdp), pdp);
        }
    }
    
    // ====================================
    //       Salida y Representación
    // ====================================

    /**
     * Muestra por consola el comprobante detallado del pedido,
     * incluyendo cabecera, datos del cliente y los productos solicitados.
     */
    public void mostrar() {
        System.out.printf("\nNro: %d                    Estado: %s", numero, estado);
        System.out.printf("\nFecha: %1$td/%1$tm/%1$tY \t\tHora: %1$tH:%1$tM\n", fechaYHora);
        System.out.println("Cliente: " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
        System.out.println("clave: " + this.cliente.verClave() + " | correo: " + this.cliente.verCorreo() + "\n");
        System.out.println("      Producto                                                Cantidad");
        System.out.println("================================================================================");
        for(ProductoDelPedido pido: ProductoDelPedido){
            pido.mostrar();
        }
        System.out.printf("\n\n");
    }

    /**
     * Calcula el código hash tomando como base el número del pedido.
     *
     * @return valor hash entero para la instancia
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.numero;
        return hash;
    }

    /**
     * Compara este pedido con otro objeto para verificar su igualdad.
     * <p>
     * Dos pedidos se consideran iguales si comparten el mismo {@code numero} de pedido.
     *
     * @param obj objeto con el cual comparar
     * @return {@code true} si ambos pedidos tienen el mismo número; {@code false} en caso contrario
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
        final Pedido other = (Pedido) obj;
        return this.numero == other.numero;
    }
}