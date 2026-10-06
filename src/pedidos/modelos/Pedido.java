/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

/**
 *
 * @author leand
 */
public class Pedido {
    int Numero;
    LocalDateTime fechaYHora;
    private Cliente unCliente;
    private Estado unEstado;

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
    public LocalDateTime verHora() {
        this.fechaYHora.toLocalTime();
        return fechaYHora;
    }

    public void FechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
    private String FechaACadena (LocalDateTime fecha){
        String patron = "dd/MM/yyyy";
        String fechaEnCadena = fecha.format(DateTimeFormatter.ofPattern(patron));
        return fechaEnCadena;
        
    }
    
    private String HoraACadena (LocalDateTime hora){
        String patron = "hh:mm";
        String horaEnCadena = hora.format(DateTimeFormatter.ofPattern(patron));
        return horaEnCadena;
        
    }
    
    public void mostrar() {        
        System.out.println("Nro:"+ Numero+"\n"+"Fecha: "+ FechaACadena(verFecha())+ "\t"+"Hora: "+ HoraACadena(verHora()));
        System.out.println("Cliente: "+ unCliente.verApellido() +"," +unCliente.verNombre());
        System.out.println("Estado: "+ unEstado);
        System.out.println("");
        System.out.println("====================================");
        System.out.println("");
        System.out.println("");
    }
    
}
