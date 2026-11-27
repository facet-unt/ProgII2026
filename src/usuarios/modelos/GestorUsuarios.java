/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.ArrayList;
import interfaces.IGestorUsuarios;
import pedidos.modelos.GestorPedidos;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author lourdes
 */
public class GestorUsuarios implements IGestorUsuarios {

    private static GestorUsuarios instancia;
    private List<Usuario> usuarios;
    public static final String EXITO = "Usuario creado con éxito";
    public static final String ERROR_CORREO = "El correo del usuario es incorrecto";
    public static final String ERROR_APELLIDO = "El apellido del usuario es incorrecto";
    public static final String ERROR_NOMBRE = "El nombre del usuario es incorrecto";
    public static final String ERROR_CLAVES = "Las claves del usuario son incorrectas";
    public static final String ERROR_PERFIL = "El perfil del usuario es incorrecto";
    public static final String USUARIOS_DUPLICADOS = "Ya existe un usuario con ese correo";
    public static final String VALIDACION_EXITO = "Los datos del usuario son correctos";

    private GestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public static GestorUsuarios instanciar() {
        if (instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public String crearUsuario(String correo, String apellido,
            String nombre, Perfil perfil, String clave, String claveRepetida) {
        if (correo == null || !correo.contains("@")) {
            return ERROR_CORREO;
        }
        if (apellido == null || apellido.isEmpty()) {
            return ERROR_APELLIDO;
        }
        if (nombre == null || nombre.isEmpty()) {
            return ERROR_NOMBRE;
        }
        if (perfil == null) {
            return ERROR_PERFIL;
        }

        if (clave == null || clave.isEmpty()
                || claveRepetida == null || claveRepetida.isEmpty()
                || !clave.equals(claveRepetida)) {
            return ERROR_CLAVES;
        }
        for (Usuario usuario : usuarios) {
            if (usuario.verCorreo().equals(correo)) {
                return USUARIOS_DUPLICADOS;
            }
        }
        Usuario nuevoUsuario = null;

        if (perfil == Perfil.CLIENTE) {
            nuevoUsuario = new Cliente(correo, clave, apellido, nombre);
        } else if (perfil == Perfil.EMPLEADO) {
            nuevoUsuario = new Empleado(correo, clave, apellido, nombre);
        } else if (perfil == Perfil.ENCARGADO) {
            nuevoUsuario = new Encargado(correo, clave, apellido, nombre);
        }
        usuarios.add(nuevoUsuario);
        return EXITO;
    }

    public List<Usuario> verUsuarios() {
    List<Usuario> usuariosOrdenados = new ArrayList<>(usuarios);

    Collections.sort(usuariosOrdenados, (u1, u2) -> {
        int resultado = u1.verApellido().compareTo(u2.verApellido());

        if (resultado == 0) {
            return u1.verNombre().compareTo(u2.verNombre());
        }

        return resultado;
    });

    return usuariosOrdenados;
}

    public List<Usuario> buscarUsuarios(String apellido) {
    List<Usuario> encontrados = new ArrayList<>();

    for (Usuario usuario : usuarios) {
        if (usuario.verApellido().contains(apellido)) {
            encontrados.add(usuario);
        }
    }

    Collections.sort(encontrados, (u1, u2) -> {
        int resultado = u1.verApellido().compareTo(u2.verApellido());

        if (resultado == 0) {
            return u1.verNombre().compareTo(u2.verNombre());
        }

        return resultado;
    });

    return encontrados;
}

    public boolean existeEsteUsuario(Usuario usuario) {
        for (Usuario unUsuario : usuarios) {
            if (unUsuario.equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public Usuario obtenerUsuario(String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario.verCorreo().equals(correo)) {
                return usuario;
            }
        }
        return null;
    }
    @Override
public String borrarUsuario(Usuario usuario) {
    if (!usuarios.contains(usuario)) {
        return "No existe el usuario especificado";
    }

    if (usuario instanceof Cliente) {
        Cliente cliente = (Cliente) usuario;

        if (GestorPedidos.instanciar().hayPedidosConEsteCliente(cliente)) {
            return "No se puede borrar el usuario porque tiene pedidos asociados";
        }
    }

    usuarios.remove(usuario);
    return "Usuario eliminado con éxito";
}

}
