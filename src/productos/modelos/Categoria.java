/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author ramayo
 */

public enum Categoria {
    ENTRADA("Entrada"),
    PLATO_PRINCIPAL("Plato principal"),
    POSTRE("Postre");
    
    //Lo siguiente permite que se muestre lo que está entre '()', porque queda feo usar '_' y todas las letras en mayusculas.
    private final String descripcion;

    // constructor
    private Categoria(String descripcion) {
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
