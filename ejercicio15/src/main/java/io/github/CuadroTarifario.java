package io.github;

public class CuadroTarifario {
    private double costoPorKWh;
    private double factorDePotencia;

    public CuadroTarifario(double costoPorKWh) {
        this.costoPorKWh = costoPorKWh;
        this.factorDePotencia = 0.8;
    }

    public double getCostoPorKWh() {
        return costoPorKWh;
    }

    public double getFactorDePotencia() {
        return factorDePotencia;
    }
}
