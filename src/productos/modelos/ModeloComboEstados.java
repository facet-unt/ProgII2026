/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author estudiante
 */
public class ModeloComboEstados extends DefaultComboBoxModel{
    //Constructor de la clase ModeloComboEstados
    public ModeloComboEstados(){
        for(Estado e : Estado.values()){
            this.addElement(e);
        }
    }
    
    //Metodo para obtener un estado desde el combo
    public Estado obtenerEstado(){
        return (Estado)this.getSelectedItem();
    }
}
