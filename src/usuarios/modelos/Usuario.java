package usuarios.modelos;

import java.util.ArrayList;
import java.util.Objects;
import pedidos.modelos.Pedido;

/**
 * Representa la Clase abstracta para los distintos tipos de usuarios del sistema.
 * <p>
 * Proporciona los atributos comunes como correo electrónico, clave de acceso,
 * nombre y apellido, además de definir el metodo abstracto para la gestión de pedidos.
 *
 * @author tinytuber2
 */
public abstract class Usuario {
    
    /** Correo electrónico único del usuario utilizado como identificador de acceso. */
    private String correo;

    /** Clave de autenticación o contraseña del usuario. */
    private String clave;

    /** Apellido o apellidos del usuario. */
    private String apellido;

    /** Nombre o nombres del usuario. */
    private String nombre;
    
    //====================================
    //      Constructor de Usuario
    //====================================
    
    /**
     * Construye un nuevo usuario inicializando sus datos de perfil y credenciales.
     *
     * @param correo dirección de correo electrónico
     * @param clave contraseña de acceso
     * @param apellido apellido del usuario
     * @param nombre nombre del usuario
     */
    public Usuario(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    //====================================
    //      Métodos Get de Usuario
    //====================================

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return dirección de correo electrónico
     */
    public String verCorreo() {
        return correo;
    }

    /**
     * Obtiene la contraseña o clave del usuario.
     *
     * @return clave de acceso
     */
    public String verClave() {
        return clave;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return apellido del usuario
     */
    public String verApellido() {
        return apellido;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre del usuario
     */
    public String verNombre() {
        return nombre;
    }
    
    //====================================
    //      Métodos Set de Usuario
    //====================================

    /**
     * Asigna o actualiza el correo electrónico del usuario.
     *
     * @param correo nueva dirección de correo electrónico
     */
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Asigna o modifica la clave de acceso del usuario.
     *
     * @param clave nueva contraseña
     */
    public void asignarClave(String clave) {
        this.clave = clave;
    }

    /**
     * Asigna el apellido del usuario.
     *
     * @param apellido nuevo apellido
     */
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Asigna el nombre del usuario.
     *
     * @param nombre nuevo nombre
     */
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // ====================================
    //       Salida y Representación
    // ====================================

    /**
     * Devuelve la lista de pedidos vinculados al usuario según su rol.
     *
     * @return lista de instancias de {@link Pedido} asociadas al usuario
     */
    public abstract ArrayList<Pedido> verPedidos();
    
    /**
     * Muestra por consola los datos principales del usuario.
     */
    public void mostrar() {
        System.out.println("Usuario: " + this.verApellido() + " " + this.verNombre());
        System.out.println("Correo: " + this.verCorreo());
        System.out.println("Clave: " + this.verClave() + "\n");
    }
    
    /**
     * Calcula el código hash basado exclusivamente en el correo electrónico.
     *
     * @return valor entero del hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    /**
     * Compara este usuario con otro objeto para determinar si son Iguales.
     * <p>
     * Dos usuarios se consideran iguales si comparten la misma dirección de {@code correo}.
     *
     * @param obj objeto con el cual comparar
     * @return {@code true} si ambos tienen el mismo correo; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Usuario)) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.correo, other.correo);
    }    
}