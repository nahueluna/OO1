package io.github;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Presupuesto {
    private String cliente;
    private LocalDate fecha;
    private List<Item> items;

    public Presupuesto(String cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.items = new LinkedList<>();
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarItem(Item item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        return this.items.stream().mapToDouble(Item::costo).sum();
    }
}
