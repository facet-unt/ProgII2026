/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author lourdes
 */
public enum estado {
        DISPONIBLE,
    NO_DISPONIBLE;
@Override
    public String toString() {
        switch (this) {
            case DISPONIBLE:
                return "Disponible";
            case NO_DISPONIBLE:
                return "No disponible";
            default:
                return "";
        }
    }
}
