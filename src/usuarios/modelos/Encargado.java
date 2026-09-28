package usuarios.modelos;

public class Encargado {
    private String correo;
    private String clave;
    private String apellido;
    private String nombre;

    public Encargado(String correo, String clave, String apellido, String nombre) {
        this.correo = correo;
        this.clave = clave;
        this.apellido = apellido;
        this.nombre = nombre;
    }
    
    public void mostrar(){
        System.out.printf("\n\tEncargado <%s %s>: \n||Correo: %s\n||Clave: %s\n", apellido, nombre, correo, clave);
    }
    
    public void asignarNombre(String nombre){
        this.nombre = nombre;
    }
    public void asignarApellido(String apellido){
        this.apellido = apellido;
    }
    public String mostrarNombre(){
        return this.nombre;
    }
    public String mostrarApellido(){
        return this.apellido;
    }
    public void asignarClave(String clave){
        this.clave = clave;
    }
    public String mostrarClave(){
        return this.clave;
    }
    public void asignarCorreo(String correo){
        this.correo = correo;
    }
    public String mostrarCorreo(){
        return this.correo;
    }
    
}
