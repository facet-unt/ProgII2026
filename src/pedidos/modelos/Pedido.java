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
import java.util.ArrayList;

/**
 *Representa un pedido realizado en el sistema
 * @author Usuario
 */
public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;

    //Relacion: Un pedido tiene un cliente
    private Cliente unCliente;
    private Estado estado;
    //Relacion con ProductoDelPedido
    ArrayList<ProductoDelPedido> productosDelPedido = new ArrayList<>();

    //sobrecarga de constructor
    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> productosDelPedido, Cliente unCliente) {
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.unCliente = unCliente;
        this.estado = Estado.CREADO;
        this.productosDelPedido = productosDelPedido;
    }

    public Pedido(int numero, Cliente unCliente) {
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.unCliente = unCliente;
        this.estado = Estado.CREADO;
        this.productosDelPedido = new ArrayList<>();
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate verFecha() {
        LocalDate fecha = this.fechaYHora.toLocalDate();
        return fecha;
    }

    public LocalTime verHora() {
        LocalTime hora = this.fechaYHora.toLocalTime();
        return hora;
    }
    
    /**
     * Devuelve la fecha en formato String
     * @return un objeto con la fecha formateada del tipo "dd/MM/yyyy"
     */
    //Metodos auxiliares para mostrar la fecha y la hora con el formato solicitado
    public String verFechaFormateada() {
       LocalDate fecha = this.fechaYHora.toLocalDate();
       DateTimeFormatter fechaConFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       return fecha.format(fechaConFormato);
    }
    
    /**
     *Devuelve la hora en formato String
     * @return un objeto con la hora formateada del tipo "HH:mm"
     */
    public String verHoraFormateada() {
        LocalTime hora=this.fechaYHora.toLocalTime();
        DateTimeFormatter horaConFormato = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(horaConFormato);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numero;
        return hash;
    }

    /**
     * compara este pedido con otro para verificar su igualdad segun el número.
     * @param obj a comparar con el pedido
     * @return true si ambos objetos son de la misma clase y tienen el mismo número,si no devuelve false
     */
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
        final Pedido pedido = (Pedido) obj;
        return this.numero == pedido.numero;
    }

    /**
     * Muestra por pantalla los datos del pedido
     */
    public void mostrar() {
        System.out.println("Nro: " + numero + "\t\t\t" + "Estado: " + estado.toString());
        System.out.println("Fecha: " + verFechaFormateada() + "\t" + "Hora: " + verHoraFormateada());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Producto\t\t\t\t\tCantidad");
        System.out.println("================================================================");
        for (ProductoDelPedido pDP : productosDelPedido) {
            pDP.mostrarPDP();
        }
    }
}
