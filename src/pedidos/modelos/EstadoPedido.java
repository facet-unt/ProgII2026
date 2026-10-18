/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author Arebalo
 */
public enum EstadoPedido {
    CREADO("Creado"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");
    
    private String valor;

    private EstadoPedido(String valor) {
        this.valor = valor;
    }
    
     @Override
     public String toString(){
         return this.valor;
     }
    
}
