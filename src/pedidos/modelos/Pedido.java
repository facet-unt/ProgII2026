/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
import productos.modelos.Producto;
/**
 *
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
     
    
    public Pedido(int numero, Cliente unCliente){
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

    public String verFecha() {
        DateTimeFormatter fechaConFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.fechaYHora.format(fechaConFormato);
    }
    
    public String verHora() {
        DateTimeFormatter horaConFormato = DateTimeFormatter.ofPattern("HH:mm");
        return this.fechaYHora.format(horaConFormato);
    }
    
    public void agregarProducto(Producto unProducto, int cantidad){
        ProductoDelPedido detallePedido = new ProductoDelPedido(unProducto, cantidad);
        productosDelPedido.add(detallePedido);
    }
    
    public void mostrar(){
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha() + "\t\t\t" + "Hora: " + verHora());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + estado.toString());
        System.out.println("Producto\t\t\t\t\tCantidad");
        System.out.println("================================================================");
        for (ProductoDelPedido pDP : productosDelPedido) {
            System.out.println(pDP);
        }
    }
}
