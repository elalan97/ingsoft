/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exepciones;

/**
 *
 * @author ALAN
 */
public class CantidadExedida extends RuntimeException {

    public CantidadExedida() {
    }

    @Override
    public String getMessage() {
        return "cantidad excedida";
    }
}
