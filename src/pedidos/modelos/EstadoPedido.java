/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author tobias150
 */
public enum EstadoPedido {
    CREADO("Creado"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");
    
    private final String estado;
    
    private EstadoPedido(String estado){
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado;
    }
    
    
}
