package io.github;

public class Item {
    private String detalle;
    private int cantidad;
    private double costoUnitario;

    public Item(String detalle, int cantidad, double costoUnitario) {
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public String getDetalle() {
        return detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public double costo() {
        return this.getCostoUnitario() * this.getCantidad();
    }
}
