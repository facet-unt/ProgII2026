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
    System.out.println("\nProducto <Codigo " + this.codigo + "> " + this.descripcion);
    System.out.println(
        "Categoria: " + this.categoria + "  Estado: " + this.estado + "  Precio: " + this.precio);
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
  public boolean equals(Object o) {
    // Retornar falso si el objeto es nulo o es de una clase distinta a esta.
    // Retornar verdadero si es este mismo objeto.
    if (o == null) {
      return false;
    }
    if (o == this) {
      return true;
    }
    if (getClass() != o.getClass()) {
      return false;
    }
    // Si hasta este punto no se volvio, el objeto es comparable y se
    // lo convierte a la clase a comparar.
    Producto unProducto = (Producto) o;
    // Comparacion
    return this.codigo == unProducto.codigo;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 67 * hash + this.codigo;
    return hash;
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
