package io.github;

import java.time.LocalDate;

public class Vehiculo {
    private Conductor duenio;
    private String descripcion;
    private int capacidadDePasajeros;
    private int anioDeFabricacion;
    private double valorDeMercado;

    public Vehiculo(Conductor conductor) {
        this.duenio = conductor;
        this.descripcion = "";
        this.capacidadDePasajeros = 0;
        this.anioDeFabricacion = 0;
        this.valorDeMercado = 0.0;
    }

    public Vehiculo(Conductor duenio, String descripcion, int capacidadDePasajeros, int anioDeFabricacion, double valorDeMercado) {
        this.duenio = duenio;
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
