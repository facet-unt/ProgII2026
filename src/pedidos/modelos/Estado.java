/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *Enumeracion que representa los estados posibles de un pedido
 * @author Usuario
 */
public enum Estado {
    CREADO("Creado"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");

    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * @return String con la descripcion del pedido
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
