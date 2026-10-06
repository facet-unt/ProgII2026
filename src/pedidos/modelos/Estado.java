/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author estudiante
 */
public enum Estado {
    CREADO("Creado"),
    PROCESADO("Procesado"),
    ENTREGADO("Entegrado");
    
    private final String descripcion;

    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Estado: "+descripcion;
    }
    
    
    
}
