/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    private ArrayList<ProductoDelPedido> CantidadProducto;
    
    
    public Pedido(int Numero, LocalDateTime fechaYHora,ArrayList<ProductoDelPedido> CantidadProducto, Cliente unCliente) {
        this.Numero = Numero;
        this.fechaYHora = fechaYHora;
        this.CantidadProducto = CantidadProducto;
        this.unCliente = unCliente;
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
        String patron = "HH:mm";
        String horaEnCadena = hora.format(DateTimeFormatter.ofPattern(patron));
        return horaEnCadena;
        
    }
    
    public void mostrar() {        
        System.out.println("Nro:"+ Numero+"\n"+"Fecha: "+ FechaACadena(verFecha())+ "\t"+"Hora: "+ HoraACadena(verHora()));
        System.out.println("Cliente: "+ unCliente.verApellido() +"," +unCliente.verNombre());
        System.out.println("");
        System.out.println("\tProducto                      Cantidad");
        System.out.println("\t====================================");
        if (CantidadProducto.isEmpty()) {
            System.out.println("");
            return;
        }
        
        for (ProductoDelPedido p : CantidadProducto){
            p.mostrar();
        }
        System.out.println("");
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return this.Numero == other.Numero;
    }
    
}
