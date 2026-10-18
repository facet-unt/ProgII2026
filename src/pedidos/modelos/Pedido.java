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
 * @author ramayo
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    
    //Relacion: Un pedido tiene un cliente
    private Cliente cliente;
    private Estado estado;
    
    //Relacion: Pedido tiene una cantidad
    private ArrayList<ProductoDelPedido> listaProductos = new ArrayList<>();

    //<editor-fold defaultstate="collapsed" desc="Metodos 'ver/asignar'">
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
    
    public void asignarProductoDelPedido(int cantidad, Producto p) {
        ProductoDelPedido pdp = new ProductoDelPedido(cantidad, p);
        this.listaProductos.add(pdp);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos 'equals' y 'hashCode'">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.numero;
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
    //</editor-fold>
    
    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.cliente = cliente;
        this.estado = Estado.CREADO;
    }
    
    public void mostrar(){
        System.out.println("Pedido: "+numero+"\nFecha: "+ verFecha()+"\t Hora: "+verHora());
        System.out.println("Cliente: "+cliente+"\nEstado: "+estado.toString());
        System.out.println("Producto\t\t\tCantidad");
        System.out.println("================================================");
        System.out.println("hola");
        for(ProductoDelPedido unProducto: listaProductos){
            unProducto.mostrar();
        }
        
    }
}
