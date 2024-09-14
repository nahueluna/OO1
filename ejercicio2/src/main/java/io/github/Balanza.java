package io.github;

import java.util.LinkedList;
import java.util.List;

/*
* Las primeras tres variables de instancia pueden ser reemplazadas por métodos de "productos":
* - cantidadDeProductos = productos.size()
* - pesoTotal = for each de cada producto sumando su peso
* - precioTotal = for each de cada producto sumando su precio
*
* Esto aplicado a los getters que actualmente retornan el valor de los atributos.
* */

public class Balanza {
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private List<Producto> productos;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.pesoTotal = 0;
        this.precioTotal = 0;
        this.productos = new LinkedList<Producto>();
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    private void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    private void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    private void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public void ponerEnCero() {
        this.setPesoTotal(0);
        this.setCantidadDeProductos(0);
        this.setPrecioTotal(0);
        this.productos.clear();
    }

    public void agregarProducto(Producto producto) {
        this.cantidadDeProductos++;
        this.pesoTotal += producto.getPeso();
        this.precioTotal += producto.getPrecio();
    }

    public Ticket emitirTicket() {
        return new Ticket(this.getCantidadDeProductos(), this.getPrecioTotal(), this.getPesoTotal(), this.getProductos());
    }
}
