/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;


public class Encargado {
    //Atributos
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    //Constructor
    public Encargado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.println("Correo: " + verCorreo() + "| Clave: " + verClave() + "| Apellido: " + verApellido() + "| Nombre: " + verNombre());
    }   

    /**
     * @return the correo
     */
    public String verCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to asignar
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
     * @param clave the clave to asignar
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
     * @param apellido the apellido to asignar
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
     * @param nombre the nombre to asignar
     */
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
}
