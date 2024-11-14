package io.github;

import java.time.LocalDate;

public class Vacunacion extends IntervencionMedica{

    private String nombreVacuna;
    private double costo;

    public Vacunacion(LocalDate fecha, Mascota mascota, Medico medico, String nombreVacuna, double costo) {
        super(fecha, mascota, medico);
        this.nombreVacuna = nombreVacuna;
        this.costo = costo;
    }

    @Override
    public double calcularCostoServicio() {
        double adicionalPorMateriales = 500.0;

        return super.calcularCostoServicio() + adicionalPorMateriales + this.costo;
    }
}
