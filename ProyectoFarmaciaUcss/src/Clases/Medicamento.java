/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Medicamento {
    
    private String idMedicamento;
    private String nombre;
    private String categoria;
    private String unidad;
    private double peso;
    private double precio;
    private int stock;
    private String estado;

    // Constructor sin parámetros
    public Medicamento() {
    }

    // Constructor con parámetros
    public Medicamento(String idMedicamento, String nombre, String categoria, String unidad, 
                       double peso, double precio, int stock, String estado) {
        this.idMedicamento = idMedicamento;
        this.nombre = nombre;
        this.categoria = categoria;
        this.unidad = unidad;
        this.peso = peso;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    // Getters y Setters
    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
