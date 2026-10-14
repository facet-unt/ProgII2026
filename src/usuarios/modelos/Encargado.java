///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
// this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
// template
// */
package usuarios.modelos;

/**
 * @author barti
 */
public class Encargado extends Usuario {
  // Constructor
  public Encargado(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
  }

  protected String verTipoUsuario() {
    return "Encargado";
  }
}
