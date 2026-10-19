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

    public Pedido(int numero, LocalDateTime fechaYHora, ArrayList<ProductoDelPedido> productos, Cliente unCliente) {
        this.numero = numero;
        this.fechaYHora = fechaYHora;
        this.unCliente = unCliente;
        this.productos = productos;
        this.estado=estado.CREADO;
    }
    
    //metodo mostrar para Pedido
    public void mostrar(){
      DateTimeFormatter formatoFecha= DateTimeFormatter.ofPattern("dd/MM/yyyy");
      DateTimeFormatter formatoHora= DateTimeFormatter.ofPattern("HH:mm");
      System.out.printf("Nro: %d \t\t\t\tEstado: %s%n", numero, estado);
      System.out.printf("Fecha: %s \t\tHora: %s%n", fechaYHora.format(formatoFecha), fechaYHora.format(formatoHora));
      System.out.printf("Cliente: %s, %s%n", unCliente.verApellido(), unCliente.verNombre());
      System.out.printf("%-35s %s%n", "Producto", "\t\tCantidad");
      System.out.println("================================================================");
      for(ProductoDelPedido p : productos){
          System.out.printf("[%d] %-25s $%.2f \t\t %d%n",
                p.verUnProducto().verCodigo(),
                p.verUnProducto().verDescripcion(),
                p.verUnProducto().verPrecio(),
                p.verCantidad());
      }
    }
    
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

    //equals y hashcode. Dos pedidos son iguales si tienen el mismo numero de pedido
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.numero;
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
