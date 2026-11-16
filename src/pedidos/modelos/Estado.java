
package pedidos.modelos;

public enum Estado {
    CREADO("Creado"), PROCESANDO("Procesando"), ENTREGADO("Entregado");
    
    private final String descripcion;
    
    //====================================
    //      Métodos de Estado
    //====================================
    @Override
    public String toString(){
        return descripcion;
    }
    //====================================
    //      Constructores de Estado
    //====================================
    
    Estado(String descripcion){
        this.descripcion = descripcion;
    }
}
