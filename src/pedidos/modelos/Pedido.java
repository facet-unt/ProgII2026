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
 */
public class Pedido { 
    private int numero;
    private LocalDateTime fechaYHora;
    private EstadoPedido estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> productos = new ArrayList<>();
//    fechaYHora = LocalDateTime.now();

    public Pedido(int numero, LocalDateTime fechaYHora, EstadoPedido estado, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }
    
    public void agregarProducto(Producto producto, int cantidad){
        this.productos.add(new ProductoDelPedido(producto,cantidad));
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
        System.out.println("Fecha: " + fechaFormateada + " \t\tHora: " + horaFormateada);
        
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.verApellido() + ", " + cliente.verNombre());
        } else {
            System.out.println("Cliente: Sin asignar");
        }
        
        System.out.println("Estado: " + estado);

        if (productos != null && !productos.isEmpty()) {
            System.out.println("\tProducto\t\t\t\tCantidad");
            System.out.println("=================================================================");
            
            for (ProductoDelPedido prod : productos) {
                Producto p = prod.verProducto();
                
                System.out.printf("\t[%d] %-20s \t$%.2f \t%d%n", 
                        p.verCodigo(), 
                        p.verDescripcion(), 
                        p.verPrecio(), 
                        prod.verCantidad());
            }
        
        }
    }
}

