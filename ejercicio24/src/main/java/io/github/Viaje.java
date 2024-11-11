package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private Conductor conductor;
    private Vehiculo vehiculo;
    private List<Pasajero> pasajeros;
    private String origen;
    private String destino;
    private double costoTotal;
    private LocalDate fecha;

    public Viaje(Conductor conductor, Vehiculo vehiculo, String origen, String destino, double costoTotal, LocalDate fecha) {
        this.conductor = conductor;
        this.vehiculo = vehiculo;
        this.pasajeros = new ArrayList<>();
        this.origen = origen;
        this.destino = destino;
        this.costoTotal = costoTotal;
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean registrarPasajero(Pasajero pasajero, LocalDate fechaActual) {
        if(this.hayCapacidad() && this.getDiasHastaFechaDeViaje(fechaActual) >= 2 && pasajero.tieneSaldo()) {
            this.pasajeros.add(pasajero);
            return true;
        }

        return false;
    }

    public void procesarViaje() {
        double costoIndividual = costoTotal / (double)(this.pasajeros.size() + 1);
        this.conductor.descontarSaldo(costoIndividual);
        this.pasajeros.stream().forEach(
                p -> {p.descontarSaldo(costoIndividual);
                    p.registrarViaje(this);}
        );

    }

    private int getDiasHastaFechaDeViaje(LocalDate fechaIndicada) {
        return (int)ChronoUnit.DAYS.between(fechaIndicada, this.fecha);
    }

    private boolean hayCapacidad() {
        return this.vehiculo.getCapacidadDePasajeros() > (this.pasajeros.size() + 1);
    }
}
