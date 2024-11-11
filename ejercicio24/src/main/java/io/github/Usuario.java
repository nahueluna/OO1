package io.github;

public abstract class Usuario {
    private String nombre;
    private double saldo;

    public Usuario() {
        this.nombre = "";
        this.saldo = 0.0;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.saldo = 0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void cargarSaldo(double monto) {
        this.saldo = monto - (monto * this.calcularPorcentajeComision());
    }

    protected void descontarSaldo(double monto) {
        double montoADescontar = monto > this.calcularBonificacion() ?
                (monto - this.calcularBonificacion()) : 0;

        this.saldo -= montoADescontar;
    }

    protected boolean tieneSaldo() {
        return this.saldo > 0;
    }

    protected abstract double calcularPorcentajeComision();

    protected abstract double calcularBonificacion();
}
