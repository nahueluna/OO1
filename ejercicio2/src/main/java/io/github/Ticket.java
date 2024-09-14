package io.github;

import java.time.LocalDate;
import java.util.List;

/*
* Si bien los productos poseen la información necesaria para calcular los demás atributos, sería incorrecto que Ticket calcule datos como
* el precio o peso total, pues eso es responsabilidad de Balanza. Por lo tanto, las responsabilidades de Ticket no han cambiado.
* */

public class Ticket {
    private LocalDate fecha;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;
    private List<Producto> productos;

    public Ticket(int cantidadDeProductos, double precioTotal, double pesoTotal, List<Producto> productos) {
        this.fecha = LocalDate.now();
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return fecha;
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

    public List<Producto> getProductos() {
        return this.productos;
    }

    public double impuesto() {
        return this.getPrecioTotal() * 0.21;
    }
}
