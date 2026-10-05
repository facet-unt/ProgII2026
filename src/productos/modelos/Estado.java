/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author Usuario
 */
public enum Estado {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");
    
    private String estado;

    private Estado(String est) {
        this.estado = est;
    }

    @Override
    public String toString() {
        return estado;
    }
    
    
}
