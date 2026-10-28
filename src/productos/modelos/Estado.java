/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 * *Enumeracion que representa los estados posibles de un producto
 * @author Usuario
 */
public enum Estado {
    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private final String estado;

    private Estado(String est) {
        this.estado = est;
    }

    /**
     * 
     * @return String con el estado de disponibilidad de un producto
     */
    @Override
    public String toString() {
        return estado;
    }

}
