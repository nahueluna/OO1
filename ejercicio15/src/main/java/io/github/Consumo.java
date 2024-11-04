package io.github;

public class Consumo {
    private double consumoEnergiaActiva;
    private double consumoEnergiaReactiva;

    public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva) {
        this.consumoEnergiaActiva = consumoEnergiaActiva;
        this.consumoEnergiaReactiva = consumoEnergiaReactiva;
    }

    public double calcularCosto(CuadroTarifario cuadroTarifario) {
        return this.consumoEnergiaActiva * cuadroTarifario.getCostoPorKWh();
    }

    public double calcularFactorDePotenciaEstimado() {
        return this.consumoEnergiaActiva /
                Math.sqrt(Math.pow(this.consumoEnergiaActiva, 2) + Math.pow(this.consumoEnergiaReactiva, 2));
    }
}
