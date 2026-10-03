/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Usuario
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    
    public Pedido(int numero){
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public String verFecha() {
        DateTimeFormatter fechaConFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fechaYHora.format(fechaConFormato);
    }
    
    public String verHora() {
        DateTimeFormatter horaConFormato = DateTimeFormatter.ofPattern("HH:mm");
        return this.fechaYHora.format(horaConFormato);
    }
    
    public void mostrar(){
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha() + "\t\t\t" + "Hora: " + verHora());
    }
}
