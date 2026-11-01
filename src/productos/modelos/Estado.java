/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author ramayo
 */
public enum Estado {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private final String descripcion;

    // constructor
    private Estado(String descripcion) {
        this.descripcion = descripcion;
    }

    public String verDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString(){
        return descripcion;
    }
}
    
    
