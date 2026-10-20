package productos.modelos;

/**
 * Representa los productos en el sistema.
 *
 * @author foxeen
 */
public class Producto {
    /** Código numérico identificador único del producto. */
    private int codigo;

    /** Nombre o detalle descriptivo del producto. */
    private String descripcion;

    /** Categoría a la que pertenece el producto dentro del menú. */
    private Categoria categoria;

    /** Estado actual de disponibilidad del producto. */
    private Estado estado;

    /** Precio unitario de venta. */
    private float precio;
    
    //====================================
    //      Constructor de Producto
    //====================================

    /**
     * Construye una nueva instancia de Producto con todos sus datos iniciales.
     *
     * @param codigo identificador único numérico del producto
     * @param descripcion detalle o nombre del producto
     * @param categoria Categoria del producto ({@link Categoria#ENTRADA}, {@link Categoria#PLATO_PRINCIPAL} o {@link Categoria#POSTRE})
     * @param estado disponibilidad del producto ({@link Estado#DISPONIBLE} o {@link Estado#NO_DISPONIBLE})
     * @param precio precio unitario del producto
     */
    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asignarEstado(estado);
        this.asignarCategoria(categoria);  
    }
    
    // ====================================
    //       Métodos Get de productos
    // ====================================

    /**
     * Obtiene la categoría del producto en formato texto.
     *
     * @return texto asociado a la categoría del producto
     */
    public String verCategoria() {
        return categoria.toString();
    }

    /**
     * Obtiene el código identificador del producto.
     *
     * @return código numérico del producto
     */
    public int verCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene la descripción del producto.
     *
     * @return texto asociado a la descripción del producto
     */
    public String verDescripcion() {
        return descripcion;
    }
    
    /**
     * Obtiene el estado del producto en formato texto.
     *
     * @return texto asociado al estado del producto
     */
    public String verEstado() {
        return estado.toString();
    }
    
    /**
     * Obtiene el precio del producto.
     *
     * @return precio unitario del producto
     */
    public float verPrecio() {
        return precio;
    }

    // ====================================
    //        Métodos Set de Producto
    // ====================================

    /**
    * Asigna la categoría correspondiente al producto.
    * <p>
    * Los valores posibles corresponden a {@link Categoria#ENTRADA}, 
    * {@link Categoria#PLATO_PRINCIPAL} o {@link Categoria#POSTRE}.
    * Si el argumento no coincide con ninguno, se asigna {@link Categoria#ENTRADA} por defecto.
    *
    * @param categoria categoría a evaluar y asignar
    */
    public void asignarCategoria(Categoria categoria) {
        switch(categoria){
            case Categoria.ENTRADA -> this.categoria=Categoria.ENTRADA;
            case Categoria.PLATO_PRINCIPAL -> this.categoria=Categoria.PLATO_PRINCIPAL;
            case Categoria.POSTRE -> this.categoria=Categoria.POSTRE;
            default -> this.categoria = Categoria.ENTRADA;
        }
    }
    
    /**
     * Asigna el código identificador del producto.
     *
     * @param codigo identificador numérico
     */
    public void asignarCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Asigna la descripción textual del producto.
     *
     * @param descripcion detalle o nombre del producto
     */
    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Asigna el estado de disponibilidad del producto.
     *
     * @param estado estado a evaluar y asignar ({@link Estado#DISPONIBLE} o {@link Estado#NO_DISPONIBLE})
     */
    public void asignarEstado(Estado estado) {
        switch (estado){
            case Estado.DISPONIBLE -> this.estado=Estado.DISPONIBLE;
            case Estado.NO_DISPONIBLE -> this.estado=Estado.NO_DISPONIBLE;
            default -> this.estado=Estado.NO_DISPONIBLE;
        }
    }
    
    /**
     * Asigna el precio unitario del producto.
     *
     * @param precio valor monetario del producto
     */
    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
    // ====================================
    //       Salida y Representación
    // ====================================

    /**
     * Muestra por consola los datos detallados del producto.
     */
    public void mostrar() {        
        System.out.println("Producto "+"<Codigo "+codigo+"> "+descripcion);
        System.out.println("Categoria: "+categoria + " Estado: "+estado +"  Precio: " +precio);
    }
    
    /**
     * Devuelve la descripción como representación textual del producto.
     *
     * @return descripción del producto
     */
    @Override
    public String toString(){
          return descripcion;
    }

    /**
     * Calcula el código hash tomando como base el código del producto.
     *
     * @return valor entero del hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

    /**
     * Compara este producto con otro objeto mediante su código.
     *
     * @param obj objeto a comparar
     * @return {@code true} si los códigos coinciden; {@code false} en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return this.codigo == other.codigo;
    } 
}
