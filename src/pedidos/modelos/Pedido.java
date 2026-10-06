/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;
import java.util.ArrayList;
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
    //relacion pedido con el prodcto del pedido
    ArrayList<ProductoDelPedido> ListaProductoDelPedido=new ArrayList<>();
     
    
    public Pedido(int numero, Cliente unCliente){
        this.numero = numero;
        this.fechaYHora = LocalDateTime.now();
        this.unCliente = unCliente;
        this.estado = Estado.CREADO;
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
    
    public void mostrar(){
        System.out.println("Nro: " + numero);
        System.out.println("Fecha: " + verFecha() + "\t\t\t" + "Hora: " + verHora());
        System.out.println("Cliente: " + unCliente.verApellido() + ", " + unCliente.verNombre());
        System.out.println("Estado: " + estado.toString());
        System.out.println("Producto\t\t\t\t\tCantidad");
        System.out.println("================================================================");
        
    }
}
