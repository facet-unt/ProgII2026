/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.Comparator;

/**
 *
 * @author tobias150
 */
public class ComparadorDescYCat implements Comparator<Producto>{

    @Override
    public int compare(Producto t, Producto t1) {
        if(t.verCategoria().equals(t1.verCategoria())){
            return t.verDescripcion().compareToIgnoreCase(t1.verDescripcion());            
        }
        
        return t.verCategoria().compareTo(t1.verCategoria());
    }
    
}
