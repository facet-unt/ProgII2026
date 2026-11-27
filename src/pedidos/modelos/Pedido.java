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
import java.util.List;
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
    private Estado estado;
    private List<ProductoDelPedido> productosDelPedido;
    private Cliente cliente;

    //Constructor
    
    public Pedido(int numero, LocalDateTime fechaYHora, List<ProductoDelPedido> productosDelPedido, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.productosDelPedido = (productosDelPedido != null) ? productosDelPedido : new ArrayList();
        this.cliente = cliente;
        this.estado = Estado.CREADO;
        if (cliente != null) {this.cliente.agregarPedido(this);}
                
    }
    

    public List<ProductoDelPedido> verProductosDelPedido() {
        return productosDelPedido;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public void asignarProductosDelPedido(List<ProductoDelPedido> productosDelPedido) {
        this.productosDelPedido = productosDelPedido;
    }
// Getter que retorna solo la fecha (año-mes-día)
    public LocalDate verFecha() {
        return fechaYHora != null ? fechaYHora.toLocalDate() : null;
    }

    // Getter que retorna solo la hora (hora:minuto:segundo)
    public LocalTime verHora() {
        return fechaYHora != null ? fechaYHora.toLocalTime() : null;
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

        String strEstado = (this.estado != null) ? this.estado.toString() : "-";
        String strFecha = (this.fechaYHora != null) ? this.fechaYHora.format(formatoFecha): "-";
        String strHora = (this.fechaYHora != null) ? this.fechaYHora.format(formatoHora) : "-";
        
        String  strCliente = "-";
        if(this.cliente != null){
            String apellido = (this.cliente.verApellido() != null) ? this.cliente.verApellido() : "-";
            String nombre = (this.cliente.verNombre() != null) ? this.cliente.verNombre() : "-";
            strCliente = apellido + ", " + nombre;
        }
        System.out.printf("%-25s Estado: %s%n", "Nro: " + this.numero, strEstado);
        System.out.printf("%-34s Hora: %s%n", "Fecha: " + strFecha,strHora);
        System.out.println("Cliente: " + strCliente);
        System.out.printf("\t%-48s %s%n", "Producto", "Cantidad");
        System.out.println("\t=========================================================");
        if(this.productosDelPedido != null && !this.productosDelPedido.isEmpty()){
            for(ProductoDelPedido pdp : this.productosDelPedido){
                if(pdp != null && pdp.verProducto() != null){
                    Producto prod = pdp.verProducto();
                    String desc = (prod.verDescripcion() != null) ? prod.verDescripcion() : "-";
                    String colProducto = "[" + prod.verCodigo() + "]" + desc;
                    String colPrecio = String.format(java.util.Locale.US, "$%.2f", prod.verPrecio());
                    
                    System.out.printf("\t%-28s %-20s %d%n", colProducto, colPrecio, pdp.verCantidad());
                }
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
