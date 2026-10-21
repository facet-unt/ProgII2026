///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
import java.util.ArrayList;
import pedidos.modelos.Pedido;

package usuarios.modelos;

/**
 *
 * @author estudiante
 */
public class Cliente extends Usuario{
    
    private ArrayList<Pedido> pedidos;
    
    public Cliente(String correo, String clave, String apellido, String nombre) {
    super(correo, clave, apellido, nombre);
    this.pedidos = new ArrayList<>();
}
    
    public void mostrar(){
        System.out.println("Cliente: "+ verApellido() +", " + verNombre() );
        System.out.println("clave: "+ verClave() +" | correo: " + verCorreo() + "\n");
    }
    
    @Override
    public String toString() {
        return verApellido() + ", " + verNombre();
    }
    
    private ArrayList<Pedido> pedidos;

    @Override
public ArrayList<Pedido> verPedidos() {
    return pedidos;
}

public void agregarPedido(Pedido pedido) {
    int indice = pedidos.indexOf(pedido);

    if (indice == -1) {
        pedidos.add(pedido);
    } else {
        pedidos.set(indice, pedido);
    }
}

public void cancelarPedido(Pedido pedido) {
    pedidos.remove(pedido);
}
}
