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

    // Arregle un pequeño error que habia en el codigo
    //Como en el enum las palabras estaban capitalizadas las Descapitalize para que coincida con el codigo de aca
    //Borra el comentario cuando lo veas
    public void asignarEstado(String estado) {
        switch (estado.toLowerCase()){
            case "disponible" -> this.estado=Estado.DISPONIBLE;
            case "no disponible" -> this.estado=Estado.NO_DISPONIBLE;
            default -> this.estado=Estado.NO_DISPONIBLE;
        }
    }
    
    public void asignarCategoria(String categoria){
        switch(categoria.toLowerCase()){
           case "entrada" -> this.categoria=Categoria.ENTRADA;
           case "plato principal" -> this.categoria=Categoria.PLATO_PRINCIPAL;
           case "postre" -> this.categoria=Categoria.POSTRE;
           default -> this.categoria = Categoria.ENTRADA;
        }
    }

    public void asignarPrecio(float precio) {
        this.precio = precio;
    }
    
        public void mostrar() {        
        System.out.println("Producto: "+descripcion +" |Codigo: " +codigo );
        System.out.println("Estado: "+estado +" | Precio: " +precio);
        System.out.println("Categoria: "+categoria );
    }
    
    @Override
    public String toString(){
        return "Producto: " + descripcion;
    }
    
    //====================================
    //      Constructores de Producto
    //====================================

    public Producto(int codigo, String descripcion, String categoria, String estado, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.asignarEstado(estado);
        this.asignarCategoria(categoria);  
    }
    
    
    

}


