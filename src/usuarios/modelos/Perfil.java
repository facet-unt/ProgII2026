/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *Enumeracion que representa los valores que puede tomar un usuario
 * @author Usuario
 */
public enum Perfil {
    CLIENTE("Cliente"),
    EMPLEADO("Empleado"),
    ENCARGADO("Encargado");
    
    private final String perfil;

    private Perfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return perfil;
    }
    
    
    
  
}
