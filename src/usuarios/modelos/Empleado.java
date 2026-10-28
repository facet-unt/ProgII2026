///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;
import java.util.ArrayList;
import pedidos.modelos.Pedido;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario {
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }

    @Override
    public void mostrar() {
        System.out.println("Empleado: " + verApellido() + ", " + verNombre());
        System.out.println("clave: " + verClave() + " | correo: " + verCorreo() + "\n");
    }

    @Override
    public String toString() {
        return verApellido() + ", " + verNombre();
    }
    
    @Override
public ArrayList<Pedido> verPedidos() {
    return new ArrayList<>();
}
}
