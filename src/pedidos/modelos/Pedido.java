
package pedidos.modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import usuarios.modelos.Cliente;

public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private Estado estado;
    private Cliente cliente;
    
    //====================================
    //      Métodos de Pedido
    //====================================
    public void mostrar(){
        System.out.println("||Informacion del cliente:");
        System.out.println("Cliente: "+ this.cliente.verApellido() +", " + this.cliente.verNombre() );
        System.out.println("clave: "+ this.cliente.verClave() +" | correo: " + this.cliente.verCorreo()+ "\n");
        System.out.println("||Informacion del pedido:");
        System.out.printf("Numero: %d, Fecha: %tF , Hora: %tR, Estado: %s", numero, fechaYHora, fechaYHora, estado);
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
    
    //====================================
    //      Constructores de Producto
    //====================================

    public Pedido(int numero, Estado estado, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.fechaYHora = LocalDateTime.now();
        this.estado = Estado.CREADO;
    }
    
    
    
}
