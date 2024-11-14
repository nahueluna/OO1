package io.github;

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    public Producto(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getStock() {
        return this.stock;
    }

    private boolean tieneStock(int cantidadSolicitada) {
        return this.stock >= cantidadSolicitada;
    }

    protected boolean decrementarStock(int cantidadSolicitada) {
        if(this.tieneStock(cantidadSolicitada)) {
            this.stock -= cantidadSolicitada;
            return true;
        }

        return false;
    }
}
