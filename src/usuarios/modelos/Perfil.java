/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author homep
 */
public enum Perfil {

    CLIENTE("cliente"),
    EMPLEADO("empleado"),
    ENCARGADO("encargado");
    
    private final String descripcion;
    
    //=========================================
    //     Constructor de Estado del Pedido
    //=========================================

    Perfil(String descripcion){
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return descripcion;
    }
}
