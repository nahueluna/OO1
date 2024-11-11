package io.github;

import java.time.LocalDate;

public class Conductor extends Usuario {
    private Vehiculo vehiculo;

    public Conductor(String nombre) {
        super(nombre);
        this.vehiculo = new Vehiculo(this);
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Viaje darDeAltaViaje(String origen, String destino, double costoTotal, LocalDate fecha) {
        return new Viaje(this, this.vehiculo, origen, destino, costoTotal, fecha);
    }

    @Override
    protected double calcularPorcentajeComision() {
        return this.vehiculo.calcularAntiguedad() < 5 ? 0.01 : 0.1;
    }

    @Override
    protected double calcularBonificacion() {
        return this.vehiculo.getValorDeMercado() * 0.001;
    }
}
