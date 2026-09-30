/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author foxeen
 */
public enum Categoria {
    ENTRADA("Entrada"),PLATO_PRINCIPAL("Plato Principal"),POSTRE("Postre");
    
    private final String descripcion;
    
    Categoria(String descripcion){
        this.descripcion = descripcion;
    }
    
@Override
    public String toString(){
        return descripcion;
    }
}
