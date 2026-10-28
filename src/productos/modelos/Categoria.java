/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public enum Categoria {
    ENTRADA("Entrada"), PLATO_PRINCIPAL("Plato principal"), POSTRE("Postre");
    private String name;
    
    @Override
    public String toString(){
        return name();
    }
    
    Categoria(String name)
    {
        this.name = name;
    }
    
}
