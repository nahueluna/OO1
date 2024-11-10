package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Medico {
    private String nombre;
    private LocalDate fechaIngresoAVeterinaria;
    private double honorariosPorAtencion;

    public Medico(String nombre, LocalDate fechaIngresoAVeterinaria, double honorariosPorAtencion) {
        this.nombre = nombre;
        this.fechaIngresoAVeterinaria = fechaIngresoAVeterinaria;
        this.honorariosPorAtencion = honorariosPorAtencion;
    }

    public double getHonorarios() {
        return this.honorariosPorAtencion;
    }

    public int getAntiguedad(LocalDate fechaActual) {
        return (int)ChronoUnit.YEARS.between(this.fechaIngresoAVeterinaria, fechaActual);
    }
}
