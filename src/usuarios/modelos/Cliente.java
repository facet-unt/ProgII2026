package usuarios.modelos;

/**
 * @author barti
 */
public class Cliente {
    public String correo;
    public String clave;
    public String apellido;
    public String nombre;

    public void mostrar() {
        System.out.println("Apellido y Nombre: " + apellido + " " + nombre +
                           " | Correo: " + correo + " | Clave: " + clave);
    }
}
