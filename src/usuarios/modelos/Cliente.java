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
        System.out.printf("\n\tCliente <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido,
                          nombre, correo, clave);
    }
}
