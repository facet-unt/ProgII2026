/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.controladores;

import javax.swing.UIManager;
import productos.vistas.VentanaAMProducto;
import usuarios.vistas.VentanaAMCliente;
import usuarios.vistas.VentanaAMEmpleado;
import usuarios.vistas.VentanaAMEncargado;

/**
 *
 * @author mariana
 */
public class ControladorPrincipalGUI {
    public static void main(String[] args) {
        //Trabajar con una ventana por vez
        //Para todas las ventanas lo pasos son:
        /*
            * Asigna el look and feel "Nimbus" a la ventana
            * Se crea la ventana
            * Se centra la ventana
            * Se asigna un título a la ventana
            * Se hace visible la ventana
        */
        establecerLookAndFeel("Nimbus"); 
        // PRODUCTO
        VentanaAMProducto ventana = new VentanaAMProducto(null);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Nuevo producto");
        ventana.setVisible(true);
       //<editor-fold defaultstate="collapsed" desc="Cliente">
        VentanaAMCliente ventanaCliente = new VentanaAMCliente(null);
        ventanaCliente.setLocationRelativeTo(null);
        ventanaCliente.setTitle("Nuevo cliente");
        ventanaCliente.setVisible(true);
        //</editor-fold>
       //<editor-fold defaultstate="collapsed" desc="Empleado">
        VentanaAMEmpleado ventanaEmp = new VentanaAMEmpleado(null);
        ventanaEmp.setLocationRelativeTo(null);
        ventanaEmp.setTitle("Nuevo empleado");
        ventanaEmp.setVisible(true);
       //</editor-fold>
       //<editor-fold defaultstate="collapsed" desc="Encargado">
       VentanaAMEncargado ventanaEnc = new VentanaAMEncargado(null);
       ventanaEnc.setLocationRelativeTo(null);
       ventanaEnc.setTitle("Nuevo encargado");
       ventanaEnc.setVisible(true);
//</editor-fold>
       }
    
    /**
     * Asigna el look and feel especificado a la ventana
     * @param laf cadena con el nombre del look and feel
     */
    public static void establecerLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } 
            catch (Exception e2) {
            }
        }
    }
}