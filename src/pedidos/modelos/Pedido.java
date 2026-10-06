/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;

/**
 *
 * @author leand
 */
public class Pedido {
    int Numero;
    LocalDateTime fechaYHora;

    public Pedido(int Numero, LocalDateTime fechaYHora) {
        this.Numero = Numero;
        this.fechaYHora = fechaYHora;
    }

    public int verNumero() {
        return Numero;
    }

    public void asignarNumero(int Numero) {
        this.Numero = Numero;
    }

    public LocalDateTime verFecha() {
        this.fechaYHora.toLocalDate();
        return fechaYHora;
    }
    public LocalDateTime VerHora() {
        this.fechaYHora.toLocalTime();
        return fechaYHora;
    }

    public void FechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
}
