/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

public class Producto {
    //Atributos
    private int codigo;
    private String descripcion;
    private String categoria;
    private String estado;
    private float precio;
    //Constructor
    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }
    
    public void mostrar(){
        System.out.println("Codigo: " + verCodigo() + "| Descripcion: " + verDescripcion() + "| Categoria: " + verCategoria() + "| Estado: " + verEstado() + "| Precio: " + verPrecio());
    }
@Override
    public String toString() {
        return this.verDescripcion();
    }

    /**
     * @return the codigo
     */
    public int verCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descripcion
     */
    public String verDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the categoria
     */
    public String verCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void asignarCategoria(String categoria) {
        this.categoria = categoria;
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

    /**
     * @return the precio
     */
    public float verPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    
    
}
