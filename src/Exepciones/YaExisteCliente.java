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
public class YaExisteCliente extends RuntimeException {

    public YaExisteCliente() {
    }

    @Override
    public String getMessage() {
        return "ya existe el cliente";
    }

}
