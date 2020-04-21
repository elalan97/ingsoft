/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoCategoria;
import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class ControladorCategoria {
    BoCategoria boCategoria;

    public ControladorCategoria() {
    boCategoria = new BoCategoria();
    }
    
    
    public void guardarCategoria(Categoria categoria){
        
        boCategoria.guardarCategoria(categoria);
    }
    
    public void eliminarCategoria(String codigo){
        
        boCategoria.eliminarCategoria(codigo);
    }
    
    public ArrayList<Categoria> listarCategoria(){
        return boCategoria.listarCategoria();
    }
}
