package io.github;

public class InversionEnAcciones implements Inversion {
    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public InversionEnAcciones(){}

    public InversionEnAcciones(String nombre, int cantidad, double valorUnitario){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public double valorActual() {
        return this.getCantidad() * this.getValorUnitario();
    }
}
