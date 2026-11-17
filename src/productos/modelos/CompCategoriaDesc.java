/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productos.modelos;

import java.util.Comparator;

/**
 *
 * @author Home
 */
public class CompCategoriaDesc implements Comparator<Producto> {
    @Override
    public int compare(Producto p1, Producto p2){
        if(p1.verCategoria().equals(p2.verCategoria())){
            return p1.verDescripcion().compareTo(p2.verDescripcion());
        } else return p1.verCategoria().compareTo(p2.verCategoria());
    }
}
