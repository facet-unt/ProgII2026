/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author ramayo
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    
    //Relacion: Un pedido tiene un cliente
    private Cliente cliente;
    private String estado;

    public Pedido(int numero, Cliente cliente, String estado) {
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.cliente = cliente;
        this.estado = estado;
    }

    public int verNumero() {
        return numero;
    }
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public String verFecha(){
        DateTimeFormatter fechaConFormato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return this.fechaYHora.format(fechaConFormato);
    }
    
    public String verHora(){
        DateTimeFormatter horaConFormato = DateTimeFormatter.ofPattern("hh:mm");
        return this.fechaYHora.format(horaConFormato);
    }
    
    public void mostrar(){
        System.out.println("Pedido: "+numero+"\nFecha: "+ verFecha()+"\t Hora: "+verHora());
        System.out.println("Cliente: "+cliente+"\nEstado: "+estado.toString());
        System.out.println("Producto\t\t\tCantidad");
        System.out.println("================================================");
        System.out.println("(lista de objetos comprados con sus cantidades)");
        
    }
}
