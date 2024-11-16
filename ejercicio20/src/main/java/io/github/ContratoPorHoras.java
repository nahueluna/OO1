package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends ContratoDeTrabajo {
    private double valorHora;
    private int horasTrabajadasPorMes;
    private LocalDate fechaDeFin;

    public ContratoPorHoras(Empleado empleado, LocalDate fechaDeInicio, double valorHora, int horasTrabajadasPorMes, LocalDate fechaDeFin) {
        super(empleado, fechaDeInicio);
        this.valorHora = valorHora;
        this.horasTrabajadasPorMes = horasTrabajadasPorMes;
        this.fechaDeFin = fechaDeFin;
    }

    @Override
    public int getAniosDeAntiguedad() {
        if(!this.estaActivo()) {
            return (int)ChronoUnit.YEARS.between(this.getFechaDeInicio(), this.fechaDeFin);
        }
        else {
            return super.getAniosDeAntiguedad();
        }
    }

    @Override
    protected boolean estaActivo() {
        return this.fechaDeFin.isAfter(LocalDate.now());
    }

    @Override
    public double calcularSueldoBasico() {
        return this.valorHora * this.horasTrabajadasPorMes;
    }
}
