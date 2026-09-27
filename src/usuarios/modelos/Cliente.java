/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Cliente {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public void mostrar(){
        System.out.printf("\n\tCliente <%s %s>: \n||Correo: %s\n||Clave: %s\n", verApellido(), verNombre(), verCorreo(), verClave());
    }

    /**
     * @return the correo
     */
    public String verCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the clave
     */
    public String verClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void asignarClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the apellido
     */
    public String verApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the nombre
     */
    public String verNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
}
