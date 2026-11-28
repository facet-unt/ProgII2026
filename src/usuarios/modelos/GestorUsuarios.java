/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import interfaces.IGestorUsuarios;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pedidos.modelos.GestorPedidos;

/**
 *
 * @author homep
 */
public class GestorUsuarios implements IGestorUsuarios{
    private static final List<Usuario> usuarios = new ArrayList<>();
//    private final Comparator<Usuario> comparadorApellyNom = (Usuario u1,Usuario u2)->{
//        int compApellido = u1.verApellido().compareToIgnoreCase(u2.verApellido());
//        if (compApellido != 0){
//            return compApellido;
//        }
//        return u1.verNombre().compareToIgnoreCase(u2.verNombre());
//    };
    // El metodo estatico comparing hace lo mismo que usar una clase anonima con una expresion lambda
    // Usuario::verApellido es una referencia a metodo que hace basicamene u -> u.verApelido 
    // string.CASE_INSENSITIVE_ORDER es una constante de la clase string la cual es un comparator<string>
    // Es el equivalente a usar el metodo compareToIgnoreCase
    // thencomparing Permite Añadir un Criterio Secundario, terciario de comparacion
    private final Comparator<Usuario> comparadorApellyNom = Comparator.comparing(Usuario::verApellido,String.CASE_INSENSITIVE_ORDER).thenComparing(Usuario::verNombre,String.CASE_INSENSITIVE_ORDER);
    
    //deberiamos poner collection.sort dsp de que agregamos un producto o etc

    //=======================
    //      Singleton
    //=======================
    private static final GestorUsuarios instancia = new GestorUsuarios();
    private GestorUsuarios(){}
    
    public static GestorUsuarios instanciar(){
        return instancia;
    }
    
    private String corroborarDatos(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        if (correo == null || !correo.contains("@"))
            return ERROR_CORREO;
        if (apellido == null || apellido.isBlank())
            return ERROR_APELLIDO;
        if (nombre == null || nombre.isBlank()){
            return ERROR_NOMBRE;
        }
        if (clave == null|| clave.isBlank() || !clave.equals(claveRepetida) || claveRepetida == null || claveRepetida.isBlank())
            return ERROR_CLAVES;
        if (perfil == null)
            return ERROR_PERFIL;
        Usuario u = new Cliente(correo, clave, apellido, nombre);
        if (GestorUsuarios.usuarios.contains(u))
            return USUARIOS_DUPLICADOS;
        
        return VALIDACION_EXITO;
    }
    
    
    @Override
    public String crearUsuario(String correo, String apellido, String nombre, Perfil perfil, String clave, String claveRepetida){
        String proceso = corroborarDatos(correo, apellido, nombre, perfil, clave, claveRepetida);
        System.out.println();
        
        if (proceso.equals(VALIDACION_EXITO)){
            switch (perfil){
                case Perfil.CLIENTE -> {
                    Usuario u = new Cliente(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u);
                    return EXITO;
                }
                
                case Perfil.EMPLEADO -> {
                    Usuario u1 = new Empleado(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u1);
                    return EXITO;
                }
                
                case Perfil.ENCARGADO -> {
                    Usuario u2 = new Encargado(correo, clave, apellido, nombre);
                    GestorUsuarios.usuarios.add(u2);
                    return EXITO;
                }
            }
            
        }
        return proceso;
    }
    
    @Override
    public List<Usuario> verUsuarios(){
        Collections.sort(GestorUsuarios.usuarios,comparadorApellyNom);
        return GestorUsuarios.usuarios;
    }
    
    @Override
    public List<Usuario> buscarUsuarios(String apellido) {
        List<Usuario> usuariosCoincidentes = new ArrayList<>();
        if (apellido == null) {
            return usuariosCoincidentes;
        }
        for (Usuario u : usuarios) {
            if (u.verApellido() != null && u.verApellido().toLowerCase().contains(apellido.toLowerCase())) {
                usuariosCoincidentes.add(u);
            }
        }
        Collections.sort(usuariosCoincidentes, comparadorApellyNom);
        return usuariosCoincidentes;
    }
    
    @Override
    public boolean existeEsteUsuario(Usuario usuario){
        return usuarios.contains(usuario);
    }
    
    @Override
    public Usuario obtenerUsuario(String correo){
        if (correo == null) {
            return null;
        }
        for (Usuario u: usuarios){
            if (u.verCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }
    
    @Override
    public String borrarUsuario(Usuario usuario) {
        if (usuario == null || !usuarios.contains(usuario)) {
            return ERROR_NO_EXISTE;
        }
        if (usuario instanceof Cliente && GestorPedidos.instanciar().hayPedidosConEsteCliente((Cliente) usuario)) {
            return ERROR_USUARIO_CON_PEDIDOS;
        }
        usuarios.remove(usuario);
        return EXITO_BORRAR;
    }
}
