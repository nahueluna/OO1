package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario {
    private List<Viaje> viajesRealizados;

    public Pasajero() {
        super();
        this.viajesRealizados = new ArrayList<>();
    }

    public Pasajero(String nombre) {
        super(nombre);
        this.viajesRealizados = new ArrayList<>();
    }

    private Viaje getUltimoViaje() {
        return this.viajesRealizados.stream().
                max((Viaje v1, Viaje v2) -> v1.getFecha().compareTo(v2.getFecha())).
                orElse(null);
    }

    @Override
    public double calcularPorcentajeComision() {
        Viaje viaje = this.getUltimoViaje();
        if(viaje == null) {
            return 0.1;
        }

        return ChronoUnit.DAYS.between(viaje.getFecha(), LocalDate.now()) <= 30 ? 0.1 : 0.0;
    }

    @Override
    public double calcularBonificacion() {
        return !this.viajesRealizados.isEmpty() ? 500.0 : 0.0;
    }

    public void registrarViaje(Viaje viaje) {
        this.viajesRealizados.add(viaje);
    }
}
