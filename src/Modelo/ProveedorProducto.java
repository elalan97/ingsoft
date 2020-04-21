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
public class ProveedorProducto {
    
    String proveedorCedula;
    int id, productoCodigo;

    public ProveedorProducto() {
    }

    public ProveedorProducto(String proveedorCedula, int id, int productoCodigo) {
        this.proveedorCedula = proveedorCedula;
        this.id = id;
        this.productoCodigo = productoCodigo;
    }

    public String getProveedorCedula() {
        return proveedorCedula;
    }

    public void setProveedorCedula(String proveedorCedula) {
        this.proveedorCedula = proveedorCedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(int productoCodigo) {
        this.productoCodigo = productoCodigo;
    }


    
}
