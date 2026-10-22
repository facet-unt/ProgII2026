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
        switch (estado){
            case Estado.DISPONIBLE -> this.estado=Estado.DISPONIBLE;
            case Estado.NO_DISPONIBLE -> this.estado=Estado.NO_DISPONIBLE;
            default -> this.estado=Estado.NO_DISPONIBLE;
        }
    }
    
    public void asignarCategoria(Categoria categoria){
        switch(categoria){
           case Categoria.ENTRADA -> this.categoria=Categoria.ENTRADA;
           case Categoria.PLATO_PRINCIPAL -> this.categoria=Categoria.PLATO_PRINCIPAL;
           case Categoria.POSTRE -> this.categoria=Categoria.POSTRE;
           default -> this.categoria = Categoria.ENTRADA;
        }
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
    public void mostrar() {        
        System.out.println("Producto "+"<Codigo "+codigo+"> "+descripcion);
        System.out.println("Categoria: "+categoria + " Estado: "+estado +"  Precio: " +precio);
    }
    
    @Override
    public String toString(){
//        return "Producto: " + descripcion;
          return descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigo;
        return hash;
    }

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
    
    
    //====================================
    //      Constructores de Producto
    //====================================

    public Producto(int codigo, String descripcion, Categoria categoria, Estado estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asignarEstado(estado);
        this.asignarCategoria(categoria);  
    }
    
}


