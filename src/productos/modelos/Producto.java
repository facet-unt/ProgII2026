
package productos.modelos;

public class Producto {

    private int codigo;
    private String descripcion;
    private Categoria categoria;
    private Estado estado;
    private float precio;

    //====================================
    //      Métodos de Producto
    //====================================

    public int verCodigo() {
        return codigo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public String verEstado() {
        return estado.toString();
    }

    public String verCategoria() {
        return categoria.toString();
    }

    public float verPrecio() {
        return precio;
    }

    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void asignarEstado(Estado estado) {
        this.estado = estado;
    }

    public void asignarCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }

    //====================================
    //      Constructor de Producto
    //====================================

    public Producto(int codigo, String descripcion,
            Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.estado = estado;
        this.precio = precio;
    }

    public void mostrar() {
        System.out.println("Producto " + "<Codigo " + codigo + "> " + descripcion);
        System.out.println("Categoria: " + categoria + " Estado: " + estado
                + "  Precio: " + precio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Producto otro = (Producto) obj;
        return codigo == otro.codigo;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Producto: " + descripcion + " | Codigo: " + codigo;
    }
}
