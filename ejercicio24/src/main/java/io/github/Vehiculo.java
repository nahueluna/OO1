package io.github;

import java.time.LocalDate;

public class Vehiculo {
    private String descripcion;
    private int capacidadDePasajeros;
    private int anioDeFabricacion;
    private double valorDeMercado;

    public Vehiculo(String descripcion, int capacidadDePasajeros, int anioDeFabricacion, double valorDeMercado) {
        this.descripcion = descripcion;
        this.capacidadDePasajeros = capacidadDePasajeros;
        this.anioDeFabricacion = anioDeFabricacion;
        this.valorDeMercado = valorDeMercado;
    }

    public double getValorDeMercado() {
        return this.valorDeMercado;
    }

    public int getCapacidadDePasajeros() {
        return this.capacidadDePasajeros;
    }

    public int calcularAntiguedad() {
        return LocalDate.now().getYear() - this.anioDeFabricacion;
    }
}
