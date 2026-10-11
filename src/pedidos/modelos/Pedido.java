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
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente unCliente;
    private ArrayList<ProductoDelPedido> productos;

    public int verNumero() {
        return numero;
    }

    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Pedido(int numero, LocalDateTime fechaYHora) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.estado = Estado.CREADO;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public ArrayList<ProductoDelPedido> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoDelPedido> productos) {
        this.productos = productos;
    }
    
    
    public void mostrar(){
      DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd/MM/yyyy");
      DateTimeFormatter formatoHora= DateTimeFormatter.ofPattern("HH:mm");
      System.out.println("Nro: "+numero + "\t\t" +estado);
      System.out.println("Fecha: "+fechaYHora.format(formatoFecha) + "\t" + "Hora: "+ fechaYHora.format(formatoHora));
      System.out.println(unCliente.verApellido()+", "+unCliente.verNombre());
      System.out.println("\t Producto \t\t\t\t\t\t\t Cantidad");
      System.out.println("\t=====================================================================");
      for(ProductoDelPedido p : productos){
          System.out.println("\t"+p.verUnProducto().verCodigo() + " " + p.verUnProducto().verDescripcion()+" \t\t\t "+p.verUnProducto().verPrecio()+" \t\t\t "+p.verCantidad());
      }
    }
    
}
