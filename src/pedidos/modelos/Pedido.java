/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

/**
 *
 * @author tobias150
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private EstadoPedido estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> listaProductos;

    public Pedido(int numero, LocalDateTime fechaYHora, EstadoPedido estado, Cliente cliente, ArrayList<ProductoDelPedido> listaProductos) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public EstadoPedido verEstado() {
        return estado;
    }

    public void asignarEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public LocalDate verFecha(){
        return this.fechaYHora.toLocalDate();
    }
    
    public LocalTime verHora(){
        return this.fechaYHora.toLocalTime();
    }
    
    
    private String horaFormateada(){
        String formato = "hh:mm";
        String horaEnCadena = this.fechaYHora.format(DateTimeFormatter.ofPattern(formato));
        return horaEnCadena;
    }
        
    private String fechaFormateada(){
        String formato = "dd/mm/yyyy";
        String fechaEnCadena = this.fechaYHora.format(DateTimeFormatter.ofPattern(formato));
        return fechaEnCadena;
    }
    
    public void mostrar(){
        System.out.println("Nro : " + this.numero);
        System.out.println("Fecha : " + this.fechaFormateada() + "\t\t" + "Hora : " + this.horaFormateada());
        System.out.println("Cliente : " + this.cliente.verApellido() + ", " + this.cliente.verNombre());
        System.out.println("Estado : " + this.estado);
        System.out.println("\tProducto\t\t\tCantidad");
        System.out.println("=======================================================");
        for(int i = 0; i < this.listaProductos.size(); i++){
            ProductoDelPedido pdp = this.listaProductos.get(i);
            System.out.println("[" + pdp.verProducto().verCodigo() + "]" + " " + pdp.verProducto().verDescripcion() + "\t " + pdp.verProducto().verPrecio() + "\t\t " + pdp.verCantidad());
        }
    }
}
