/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DAO.CategoriaDAO;
import Modelo.Categoria;
import java.util.ArrayList;

/**
 *
 * @author halan
 */
public class BoCategoria {
    CategoriaDAO categoriaDAO;

    public BoCategoria() {
        categoriaDAO = new CategoriaDAO();
    }
    
    public void guardarCategoria(Categoria categoria){
        
        categoriaDAO.guardarCategoria(categoria);
        
    }
    
    public void eliminarCategoria(String codigo){
        
        categoriaDAO.eliminarCategoria(codigo);
    }
    
    public ArrayList<Categoria> listarCategoria(){
        
        return categoriaDAO.listarCategoria();
    }
    
}
