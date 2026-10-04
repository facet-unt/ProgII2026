/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change
 * this license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit
 * this template
 */
package productos.modelos;

/**
 *
 * @author estudiante
 */
public class Producto {
  public Producto(
      int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
    this.codigo = codigo;
    this.descripcion = descripcion;
    this.categoria = categoria;
    this.estado = estado;
    this.precio = precio;
  }

  public void mostrar() {
    System.out.println("Código: " + this.codigo);
    System.out.println("Descripción: " + this.descripcion);
    System.out.println("Categoría: " + this.categoria);
    System.out.println("Estado: " + this.estado);
    System.out.println("Precio: $" + this.precio);
  }

  // Getters
  public int verCodigo() {
    return this.codigo;
  }
  public String verDescripcion() {
    return this.descripcion;
  }
  public Categoria verCategoria() {
    return this.categoria;
  }
  public Estado verEstado() {
    return this.estado;
  }
  public float verPrecio() {
    return this.precio;
  }

  // Setters
  public void asignarCodigo(int nuevoCodigo) {
    this.codigo = nuevoCodigo;
  }
  public void asignarDescripcion(String nuevaDescripcion) {
    this.descripcion = nuevaDescripcion;
  }
  public void asignarCategoria(Categoria nuevaCategoria) {
    this.categoria = nuevaCategoria;
  }
  public void asignarEstado(Estado nuevoEstado) {
    this.estado = nuevoEstado;
  }
  public void asignarPrecio(float nuevoPrecio) {
    this.precio = nuevoPrecio;
  }

  @Override
  public String toString() {
    return this.descripcion;
  }

  private int codigo;
  private String descripcion;
  private Categoria categoria;
  private Estado estado;
  private float precio;
}
