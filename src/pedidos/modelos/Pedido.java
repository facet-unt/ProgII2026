/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import usuarios.modelos.Cliente;

/**
 *
 * @author LUCRECIA
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;

    public Pedido(int numero, LocalDateTime fechaYHora, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    void mostrar(){
        /*nro 3
        fecha dd//mmm//yyyy    hora : DD:DD
        CLiente: Apellido, Nombre
        Estado: cReado
        PRoducto                cantidad
        ===================================
        milanesa         $15000     2
        pepsi             $2000     2*/
    }
}
