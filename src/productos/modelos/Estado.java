/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package productos.modelos;

/**
 *
 * @author foxeen
 */
public enum Estado {
    DISPONIBLE("disponible"),NO_DISPONIBLE("no disponible");
    
    private final String descripcion;
    
    
    //====================================
    //      Metodos de Estado
    //====================================
    
@Override
    public String toString(){
        return descripcion;
    }
    //====================================
    //      Constructor de Estado
    //====================================
    
    Estado(String descripcion){
        this.descripcion = descripcion;
    }
}

