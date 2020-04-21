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
public class NoExisteProveedor extends RuntimeException{

    public NoExisteProveedor() {
    }
    
        @Override
    public String getMessage() {
        return "ya existe el proveedor";
    }
}
