package io.github;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class ContratoDeTrabajo {
    private LocalDate fechaDeInicio;
    private Empleado empleado;

    public ContratoDeTrabajo(Empleado empleado, LocalDate fechaDeInicio) {
        this.empleado = empleado;
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getAniosDeAntiguedad() {
        int antiguedad = (int)ChronoUnit.YEARS.between(this.fechaDeInicio, LocalDate.now());
        return Math.max(antiguedad, 0);
    }

    public double calcularSueldoTotal() {
        return this.calcularSueldoBasico() * this.calcularAdicionalAntiguedad();
    }

    private double calcularAdicionalAntiguedad() {
        int antiguedad = this.empleado.calcularAntiguedad();
        double bonificacion;

        if(antiguedad >= 20) {
            bonificacion = 2.0;
        }
        else {
            bonificacion = 1.3 + 0.2 * ((antiguedad - 5) / 5);
        }

        return bonificacion;
    }

    protected abstract boolean estaActivo();

    public abstract double calcularSueldoBasico();

}
