/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author tobias150
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;

    public Pedido(int numero, LocalDateTime fechaYHora, Estado estado, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String verFecha(){
        return this.fechaFormateada(fechaYHora);
    }
    
    public String verHora(){
        return this.horaFormateada(fechaYHora);
    }
    
    
    private String horaFormateada(LocalDateTime fechaYHora){
        LocalTime hora = fechaYHora.toLocalTime();
        String formato = "hh:mm";
        String horaEnCadena = hora.format(DateTimeFormatter.ofPattern(formato));
        return horaEnCadena;
    }
        
    private String fechaFormateada(LocalDateTime fechaYHora){
        LocalDate fecha = fechaYHora.toLocalDate();
        String formato = "dd/mm/yyyy";
        String fechaEnCadena = fecha.format(DateTimeFormatter.ofPattern(formato));
        return fechaEnCadena;
    }
}
