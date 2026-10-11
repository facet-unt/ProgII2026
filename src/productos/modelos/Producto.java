/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;


/**
 *
 * @author estudiante
 */
public class Producto {
    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asignarEstado(estado);
        this.asignarCategoria(categoria);  
    }
    
    
    
    public void mostrar() {        
        System.out.println("Producto: "+verDescripcion() +" |Codigo: " +verCodigo() );
        System.out.println("Estado: "+verEstado() +" | Precio: " +verPrecio()+ "\n");
    }
    
    @Override
    public String toString(){
        return "Producto: " + verDescripcion();
    }

    /**
     * @return the codigo
     */
    public int verCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to asignar
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
     * @param descripcion the descripcion to asignar
     */
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the categoria
     */
    public String verCategoria() {
        return categoria.toString();
    }

    /**
     * @param categoria the categoria to asignar
     */
    public void asignarCategoria(String categoria){
        switch(categoria.toLowerCase()){
           case "Entrada" -> this.categoria=Categoria.ENTRADA;
           case "Plato principal" -> this.categoria=Categoria.PLATO_PRINCIPAL;
           case "Postre" -> this.categoria=Categoria.POSTRE;
           default -> this.categoria = Categoria.ENTRADA;
        }
    }

    /**
     * @return the estado
     */
    public String verEstado() {
        return estado.toString();
    }

    /**
     * @param estado the estado to asignar
     */
    public void asignarEstado(String estado) {
        switch (estado.toLowerCase()){
            case "Disponible" -> this.estado=Estado.DISPONIBLE;
            case "No disponible" -> this.estado=Estado.NO_DISPONIBLE;
            default -> this.estado=Estado.NO_DISPONIBLE;
        }
    }

    /**
     * @return the precio
     */
    public float verPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to asignar
     */
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
}
