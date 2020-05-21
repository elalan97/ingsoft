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
public class Factura {
    
    int codigo, codigoVendedor;
    String cedulaCliente, fechaEmision;

    public Factura() {
    }

    public Factura(int codigo, int codigoVendedor, String cedulaCliente, String fechaEmision) {
        this.codigo = codigo;
        this.codigoVendedor = codigoVendedor;
        this.cedulaCliente = cedulaCliente;
        this.fechaEmision = fechaEmision;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    
}
