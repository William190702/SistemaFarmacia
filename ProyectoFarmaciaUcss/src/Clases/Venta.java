/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

public class Venta {

    private String idVenta;
    private String idCliente;
    private String idEmpleado;
    private Date fechaVenta;
    private double total;

    // Constructor con todos los campos
    public Venta(String idVenta, String idCliente, String idEmpleado, Date fechaVenta, double total) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fechaVenta = fechaVenta;
        this.total = total;
    }

    // Getters y Setters
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método para agregar un producto a la venta y actualizar el total
    public void agregarProducto(double precioUnitario, int cantidad) {
        double subtotal = precioUnitario * cantidad;
        this.total += subtotal;
    }
}
