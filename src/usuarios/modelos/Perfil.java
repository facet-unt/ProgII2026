/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author tobias150
 */
public enum Perfil {
    //Constantes
    CLIENTE("Cliente"),
    ENCARGADO("Encargado"),
    EMPLEADO("Empleado");
    
    //Atributo de la clase
    private String perfil;
    
    //Constructor de la clase
    private Perfil(String perfil){
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return perfil;
    }
    
    
}
