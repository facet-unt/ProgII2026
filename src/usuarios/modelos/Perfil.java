/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author LUCRECIA
 */
public enum Perfil {
    
    CLIENTE ("Cliente"),
    EMPLEADO ("Empleado"),
    ENCARGADO ("Encargado");
    
    private final String descripcion;

    private Perfil(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String verDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Categoria: " + descripcion;
    }
}
