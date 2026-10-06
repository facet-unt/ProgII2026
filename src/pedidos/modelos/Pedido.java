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

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
}
