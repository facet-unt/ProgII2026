/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import productos.modelos.Producto;
import usuarios.modelos.Cliente;

/**
 *
 * @author Home
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> productos = new ArrayList<>();
    
    public void agregarProducto(Producto producto, int cantidad) {
    this.productos.add(new ProductoDelPedido(producto, cantidad));
}

    public ArrayList<ProductoDelPedido> verpedido() {
    return this.productos;
}
    /**
     * @return the numero
     */
    public int verNumero() {
        return numero;
    }

    /**
     * @param numero the numero to asignar
     */
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaHora
     */
    public LocalDateTime verFechaHora() {
        return fechaYHora;
    }

    /**
     * @param fechaHora the fechaHora to asignar
     */
    public void asignarFechaHora(LocalDateTime fechaHora) {
        this.fechaYHora = fechaHora;
    }

    /**
     * @return the Estado
     */
    public Estado verEstado() {
        return estado;
    }

    /**
     * @param estado the Estado to asignar
     */
    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the cliente
     */
    public Cliente verCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to asignar
     */
    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> productos, Cliente cliente) {
    this.numero = numero;
    this.fechaYHora = fechaYHora;
    this.estado = Estado.CREADO;
    this.cliente = cliente;
    this.productos = productos;
}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.numero;
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
        return this.numero == other.numero;
    }


    public Pedido(int numero, LocalDateTime fechaYHora, Estado estado, Cliente cliente) {
    this.numero = numero;
    this.fechaYHora = fechaYHora;
    this.estado = estado;
    this.cliente = cliente;
    this.productos = new ArrayList<>();
}
    
    public void mostrar(){
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormato = DateTimeFormatter.ofPattern("HH:mm");
        
        System.out.println("Nro:" + this.verNumero()+           "Estado:" + this.verEstado());
        System.out.println("Fecha: " + this.verFechaHora().toLocalDate().format(fechaFormato) + "\t\tHora: " + this.verFechaHora().toLocalTime().format(horaFormato));
        System.out.println("Cliente: " + this.cliente.verApellido() + this.cliente.verNombre());
        System.out.println("Estado: " + this.verEstado());
        System.out.println("         Producto                                                                   Cantidad");
        System.out.println("==============================================================================================");
        for(ProductoDelPedido p : productos){
        System.out.println(" "+p.verProducto().verCodigo() + " " + p.verProducto().verDescripcion()+" "+p.verProducto().verPrecio()+" "+p.verCantidad());
      }
    }
    
}
