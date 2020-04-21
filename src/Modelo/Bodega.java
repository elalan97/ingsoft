/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ALAN
 */
public class Bodega {

    int codigo, productoBodega;
    String nombre, direccion, telefono;

    public Bodega() {
    }

    public Bodega(int codigo, int productoBodega, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.productoBodega = productoBodega;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getProductoBodega() {
        return productoBodega;
    }

    public void setProductoBodega(int productoBodega) {
        this.productoBodega = productoBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
