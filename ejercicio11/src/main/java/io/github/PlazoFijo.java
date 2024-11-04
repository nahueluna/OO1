package io.github;

import java.time.LocalDate;

public class PlazoFijo implements  Inversion {
    private LocalDate fechaDeConstitucion;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    public PlazoFijo(){}

    public PlazoFijo(double montoDepositado) {
        this.fechaDeConstitucion = LocalDate.now();
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = 0;
    }

    public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario) {
        this.fechaDeConstitucion = LocalDate.now();
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    public double getMontoDepositado() {
        return montoDepositado;
    }

    public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    public LocalDate getFechaDeConstitucion() {
        return fechaDeConstitucion;
    }

    public double getPorcentajeDeInteresDiario() {
        return porcentajeDeInteresDiario;
    }

    private int diasDesdeFechaConstitucion(LocalDate fecha) {
        return this.getFechaDeConstitucion().until(fecha).getDays();
    }

    public double valorActual() {
        int dias = this.diasDesdeFechaConstitucion(LocalDate.now());
        return this.getMontoDepositado() * Math.pow(this.porcentajeDeInteresDiario, dias);
    }
}
