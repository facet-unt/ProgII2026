/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
/**
 *
 * @author luciano
 */
import interfaces.IGestorPedidos;
import java.util.List;
import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import pedidos.modelos.GestorPedidos;
public class GestorUsuarios implements IGestorUsuarios{
    
    private static GestorUsuarios gestor;
    private List<Usuario> usuarios;

    private GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public static GestorUsuarios instanciar() {
        if (gestor == null) {
            gestor = new GestorUsuarios();
        }
        return gestor;
    }

    private String validarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }
        if (clave == null || clave.trim().isEmpty() || claveRepetida == null || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        return VALIDACION_EXITO;
    }

@Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida) {
        String resultadoValidacion = validarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        if (!resultadoValidacion.equals(VALIDACION_EXITO)) {
            return resultadoValidacion;
        }

        Usuario nuevoUsuario = null;
        switch (perfil) {
            case CLIENTE:
                nuevoUsuario = new Cliente(correo, clave, apellido, nombre);
                break;
            case EMPLEADO:
                nuevoUsuario = new Empleado(correo, clave, apellido, nombre);
                break;
            case ENCARGADO:
                nuevoUsuario = new Encargado(correo, clave, apellido, nombre);
                break;
        }

        if (this.usuarios.contains(nuevoUsuario)) {
            return USUARIOS_DUPLICADOS;
        }

        this.usuarios.add(nuevoUsuario);
        return EXITO;
    }
@Override
    public List<Usuario> verUsuarios() {
        return this.usuarios;
    }
@Override
    public List<Usuario> buscarUsuarios(String apellido) {
        List<Usuario> encontrados = new ArrayList<>();
        if (apellido != null) {
            for (Usuario u : this.usuarios) {
                if (u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                    encontrados.add(u);
                }
            }
        }
        return encontrados;
    }
@Override
    public boolean existeEsteUsuario(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        return this.usuarios.contains(usuario);
    }
@Override
    public Usuario obtenerUsuario(String correo) {
        if (correo != null) {
            for (Usuario u : this.usuarios) {
                if (u.verCorreo().equalsIgnoreCase(correo)) {
                    return u;
                }
            }
        }
        return null;
    }
@Override    
    public String borrarUsuario(Usuario usuario) {
 
    if (usuario instanceof Cliente cliente) {
        IGestorPedidos gp = GestorPedidos.instanciar();
        if (gp.hayPedidosConEsteCliente(cliente)) {
            return ERROR_BORRAR_USUARIO; 
        }
    }

    this.usuarios.remove(usuario);
    return USUARIO_BORRADO;
}
}
    
