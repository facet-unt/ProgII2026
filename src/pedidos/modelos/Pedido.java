
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import usuarios.modelos.Cliente;
import pedidos.modelos.ProductoDelPedido;
import productos.modelos.Producto;

public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    private ArrayList<ProductoDelPedido> ProductoDelPedido = new ArrayList<>();
    
    //====================================
    //      Métodos de Pedido
    //====================================
    public void mostrar(){
        System.out.printf("Nro: %d                      Estado: %s",numero,estado);
        System.out.printf("Fecha: %tF , Hora: %tR ", fechaYHora, fechaYHora );
        System.out.println("Cliente: "+ this.cliente.verApellido() +", " + this.cliente.verNombre() );
        System.out.println("clave: "+ this.cliente.verClave() +" | correo: " + this.cliente.verCorreo()+ "\n");
        System.out.println("         Producto                                                                   Cantidad");
        System.out.println("==============================================================================================");
        for(ProductoDelPedido pido: ProductoDelPedido){
            pido.mostrar();
        }
        
    }

    public int verNumero() {
        return numero;
    }

    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    public String verHora() {
        return this.fechaYHora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
    public String verFecha(){
        return this.fechaYHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Estado verEstado() {
        return estado;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente verCliente() {
        return cliente;
    }

    public void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ProductoDelPedido> verProductoDelPedido() {
        return ProductoDelPedido;
    }

    public void asignarProductoDelPedido(int cantidad, Producto p) {
        ProductoDelPedido pdp = new ProductoDelPedido(cantidad, p);
        this.ProductoDelPedido.add(pdp);
    }
    
    //====================================
    //      Constructores de Producto
    //====================================

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fechaYHora = LocalDateTime.now();
        this.estado = Estado.CREADO;
        
    }
    
    
    
}
