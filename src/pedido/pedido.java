/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author Home
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaHora;
    private estado estado;
    private Cliente cliente;

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaHora
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * @param fechaHora the fechaHora to set
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * @return the estado
     */
    public estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(estado estado) {
        this.estado = estado;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void mostrar(){
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");
        
        System.out.println("Nro:" + this.getNumero());
        System.out.println("Fecha: " + this.getFechaHora().toLocalDate().format(fechaFormato) + "\t\tHora: " + this.getFechaHora().toLocalDate().format(horaFormato));
        System.out.println("Cliente: " + this.cliente.getApellido() + this.cliente.getNombre());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("         Producto                                                                   Cantidad");
        System.out.println("==============================================================================================");
       
    }
}
