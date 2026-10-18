/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author Arebalo
 */
public class Pedido { 
    private Cliente cliente;
    private int numero;
    private LocalDateTime fechaYHora;
//    fechaYHora = LocalDateTime.now();
    private String fechaACadena(LocalDate fecha){
        String patron = "dd/MM/yyyy";
        String fechaEnCadena = fecha.format(DateTimeFormatter.ofPattern(patron));
        return fechaEnCadena;
    }
    private String fechaEnCadena;
    

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

    public Pedido(int numero, LocalDateTime fechaYHora) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
    }
    public void mostrar(){
        System.out.println("Nro: " + numero);
        System.out.println("Fecha:" + fechaEnCadena);
//        System.out.println("Cliente: " + cliente);
//        System.out.println("Estado: " + estado);
        System.out.println("Producto\t\t\t\tCantidad\n=====================");
        
        
    }
}
