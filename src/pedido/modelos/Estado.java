/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedido.modelos;

/**
 *
 * @author estudiante
 */
public enum Estado {
    CREADO("Creado"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");
    
    private final String descripcion;

    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return  descripcion;
    }
   

    
}
