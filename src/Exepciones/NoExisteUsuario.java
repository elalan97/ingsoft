/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exepciones;

/**
 *
 * @author halan
 */
public class NoExisteUsuario extends RuntimeException{

    public NoExisteUsuario() {
    }
    
    @Override
    public String getMessage() {
        return "no existe el usuario";
    }
    
}
