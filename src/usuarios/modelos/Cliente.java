package usuarios.modelos;

/**
 * @author barti
 */
public class Cliente {
    // Constructor
    public Cliente(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters
    public String verCorreo() { return this.correo; }
    public String verClave() { return this.clave; }
    public String verApellido() { return this.apellido; }
    public String verNombre() { return this.apellido; }

    // Setters
    public void asignarCorreo(String nuevoCorreo) { this.correo = nuevoCorreo; }
    public void asignarClave(String nuevaClave) { this.clave = nuevaClave; }
    public void asignarApellido(String nuevoApellido) { this.apellido = nuevoApellido; }
    public void asignarNombre(String nuevoNombre) { this.nombre = nuevoNombre; }

    public void mostrar() {
        System.out.printf("\n\tCliente <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido,
                          nombre, correo, clave);
    }

    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
}
