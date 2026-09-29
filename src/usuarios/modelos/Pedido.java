/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios.modelos;
import java.time.LocalDateTime;
/**
 *
 * @author estudiante
 */
public class Pedido {
    private int numero;
    private LocalDateTime fechaYHora;
    private String estado;

    /**
     * @return the numero
     */
    public int verNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void asignarNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the fechaYHora
     */
    public LocalDateTime verFechaYHora() {
        return fechaYHora;
    }

    /**
     * @param fechaYHora the fechaYHora to set
     */
    public void asignarFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    /**
     * @return the estado
     */
    public String verEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void asignarEstado(String estado) {
        this.estado = estado;
    }
}
