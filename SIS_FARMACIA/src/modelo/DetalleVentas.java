/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author NANDO1
 */
public class DetalleVentas {
    int id;
    int idVentas;
    int idProductos;
    int cantidad;
    double preVenta;

    public DetalleVentas() {
    }

    public DetalleVentas(int id, int idVentas, int idProductos, int cantidad, double proVenta) {
        this.id = id;
        this.idVentas = idVentas;
        this.idProductos = idProductos;
        this.cantidad = cantidad;
        this.preVenta = proVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreVenta() {
        return preVenta;
    }

    public void setPreVenta(double proVenta) {
        this.preVenta = proVenta;
    }
    
    
}
