
package pedidos.modelos;

public enum Estado {
    CREADO("creado"), PROCESANDO("procesando"), ENTREGADO("entregado");
    
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
