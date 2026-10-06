/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedido.modelos;

import java.time.LocalDateTime;
import usuarios.modelos.Cliente;

/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente unCliente;

    public Pedido(int numero, LocalDateTime fechaYHora, Estado estado) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    
    public void mostrar (){
        System.out.println("Nro " +numero);
        System.out.println("fecha: " + fechaYHora.toLocalDate()+ "/t/t" +fechaYHora.toLocalTime());
        System.out.println("Cliente: " +unCliente.verApellido() + ", " +unCliente.verNombre());
        System.out.println("Estado: " +estado);
        System.out.println("Producto /t /t /tCantidad");
        System.out.println("==========================");
  
    }
    
}



