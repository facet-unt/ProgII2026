/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author 54381
 */
public enum categoria {
    ENTRADA,
    PLATO_PRINCIPAL,
    POSTRE;

    @Override
    public String toString() {
        switch (this) {
            case ENTRADA:
                return "Entrada";
            case PLATO_PRINCIPAL:
                return "Plato principal";
            case POSTRE:
                return "Postre";
            default:
                return "";
        }
    }
}
