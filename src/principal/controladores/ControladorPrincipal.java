/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.controladores;

import productos.modelos.Producto;

/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        Producto p1 = new Producto();
        Producto p2 = new Producto();
        p1.descripcion = "Hamburguesa";
        p2.descripcion = "Pizza";
        p1.mostrar();
        p2.mostrar();
    }
}
