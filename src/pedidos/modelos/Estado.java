/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author LUCRECIA
 */
public enum Estado {
    CREADO("Creado"),
    PROCESANDO("Procesando"),
    ENTREGADO("Entregado");
    
    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
    
    
}
