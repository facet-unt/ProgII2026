/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pedidos.modelos;

/**
 *
 * @author leand
 */
public enum Estado {
    CREADO("Creado"), PROCESANDO("Procesando"), ENTREGADO("Entregado");
    
    private String name;
    
    @Override
    public String toString(){
        return name;
    }
    
    Estado(String name)
    {
        this.name = name;
    }
}


