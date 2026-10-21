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
 * @author Arebalo
 * @author Peralta
 */
public class Pedido { 
    private int numero;
    private LocalDateTime fechaYHora;
    private EstadoPedido estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> productosDelPedido = new ArrayList<>();

    public Pedido(int numero, LocalDateTime fechaYHora, EstadoPedido estado, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
        this.productosDelPedido = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto, int cantidad){
        this.productosDelPedido.add(new ProductoDelPedido(producto,cantidad));
    }

    public ArrayList<ProductoDelPedido> verProductosDelPedido() {
        return productosDelPedido;
    }

    public void asignarProductosDelPedido(ArrayList<ProductoDelPedido> productosDelPedido) {
        this.productosDelPedido = productosDelPedido;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Pedido(int numero, LocalDateTime fechaYHora) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
    }

    public void mostrar(){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        String fechaFormateada = fechaYHora != null ? fechaYHora.format(formatoFecha) : "";
        String horaFormateada = fechaYHora != null ? fechaYHora.format(formatoHora) : "";
        
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + fechaFormateada + " Hora: " + horaFormateada);
        
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.getApellido() + ", " + cliente.verNombre());
        } else {
            System.out.println("Cliente: Sin asignar");
        }
        
        System.out.println("Estado: " + estado);

        if (productosDelPedido != null && !productosDelPedido.isEmpty()) {
            System.out.println("Producto Cantidad");
            System.out.println("==========================");
            
            for (ProductoDelPedido prod : productosDelPedido) {
                prod.mostrar();
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.numero;
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
}