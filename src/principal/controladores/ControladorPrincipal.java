/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
 * this license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package principal.controladores;

import usuarios.modelos.Cliente;
import usuarios.modelos.Empleado;
import usuarios.modelos.Encargado;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class ControladorPrincipal {
    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Encargado> encargados = new ArrayList<>();

        clientes.add(new Cliente());
        clientes.add(new Cliente());
        clientes.add(new Cliente());

        empleados.add(new Empleado());
        empleados.add(new Empleado());
        empleados.add(new Empleado());

        encargados.add(new Encargado());
        encargados.add(new Encargado());
        encargados.add(new Encargado());

        for (int i = 0; i < 3; ++i) {
            clientes.get(i).mostrar();
            empleados.get(i).mostrar();
            encargados.get(i).mostrar();
        }

        clientes.get(0).apellido = "perez";
        empleados.get(0).nombre = "juan";
        encargados.get(0).clave = "1234";

        clientes.get(0).mostrar();
        empleados.get(0).mostrar();
        encargados.get(0).mostrar();
    }
}
