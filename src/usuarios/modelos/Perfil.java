/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author Arebalo
 */
public enum Perfil {
    CLIENTE("Cliente"),
    EMPLEADO("Empleado"),
    ENCARGADO("Encargado");
    
    private String nombre;
    
    private Perfil(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    
}
