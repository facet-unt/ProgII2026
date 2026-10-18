///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Empleado extends Usuario{   
    
    public Empleado(String correo, String clave, String apellido, String nombre) {
        super(correo, clave, apellido, nombre);
    }    

    @Override
    public void mostrar() {
       System.out.println("Empleado : <" + super.verApellido() + " " + super.verNombre() + ">");
       System.out.println("Correo : " + super.verCorreo());
       System.out.println("Clave : " + super.verClave());
    }
    
    
}
