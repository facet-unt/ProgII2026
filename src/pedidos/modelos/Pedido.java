/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;

public class Pedido {

    private int numero;
    private LocalDateTime fechaYHora;
    private Cliente cliente;
    private Estado estado;
    private ArrayList<ProductoDelPedido> productos;

    public Pedido(int numero, LocalDateTime fechaYHora,
              ArrayList<ProductoDelPedido> productos,
              Cliente cliente) {
    this.numero = numero;
    this.fechaYHora = fechaYHora;
    this.cliente = cliente;
    this.estado = Estado.CREADO;
    this.productos = new ArrayList<>(productos);
}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<ProductoDelPedido> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoDelPedido> productos) {
        this.productos = productos;
    }

    public java.time.LocalDate getFecha() {
        return fechaYHora.toLocalDate();
    }

    public java.time.LocalTime getHora() {
        return fechaYHora.toLocalTime();
    }

    public void agregarProducto(ProductoDelPedido elemento) {
        if (!productos.contains(elemento)) {
            productos.add(elemento);
        }
    }

    public void mostrar() {

        DateTimeFormatter formatoFecha =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatoHora =
                DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Nro: " + numero
                + "\t\tEstado: " + estado);

        System.out.println("Fecha: "
                + fechaYHora.format(formatoFecha)
                + "\t\tHora: "
                + fechaYHora.format(formatoHora));

        System.out.println("Cliente: " + cliente);

        System.out.printf("%n%-45s %s%n",
                "Producto", "Cantidad");

        System.out.println(
                "==============================================================");

        for (ProductoDelPedido elemento : productos) {
            System.out.printf("%-45s %d%n",
                    elemento.getProducto(),
                    elemento.getCantidad());
        }

        System.out.println();
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Pedido otro = (Pedido) obj;
    return numero == otro.numero;
}

@Override
public int hashCode() {
    return Integer.hashCode(numero);
}
}
