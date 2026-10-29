/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;

import java.util.Objects;
import java.util.ArrayList;
import pedidos.modelos.Pedido;
/**
 *
 * @author estudiante
 */

public abstract class Usuario {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;
    
    public abstract ArrayList<Pedido> verPedidos();
    
    public Usuario(String correo, String clave,String apellido, String nombre){
        this.correo=correo;
        this.clave=clave;
        this.apellido=apellido;
        this.nombre=nombre;
    }
    
    public void mostrar(){
        System.out.println("Usuario: "+apellido +", " +nombre );
        System.out.println("clave: "+clave +" | correo: " +correo+ "\n" );
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos 'ver/asginar">
    public String verCorreo() {
        return correo;
    }
    public void asignarCorreo(String correo) {
        this.correo = correo;
    }
    
    public String verClave() {
        return clave;
    }
    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public String verApellido() {
        return apellido;
    }
    public void asignarApellido(String apellido) {
        this.apellido = apellido;
    }

    public String verNombre() {
        return nombre;
    }
    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos 'equals y hashCode'">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
     if(obj==null){
            return false;
        }
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Usuario)){
            return false;
        }
        Usuario otro = (Usuario) obj;
        if (this.correo == null) {
            return otro.correo == null;
        }
        return this.correo.equals(otro.correo);
    }
    //</editor-fold>

}
