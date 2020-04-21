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
public class YaExisteBodega extends RuntimeException {

    public YaExisteBodega() {
    }

    @Override
    public String getMessage() {
        return "ya existe la bodega";
    }
}
