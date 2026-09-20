/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

/**
 *
 * @author ramayo
 */
public class Cliente {
  public String correo;
  public String clave;
  public String apellido;
  public String nombre;
  
  public void mostrar(){
      System.out.println("Cliente: "+apellido+" "+nombre+"\nClave: "+clave+"\nCorreo: "+correo+"\n");
  }
}
