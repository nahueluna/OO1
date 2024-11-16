package io.github;

import java.time.LocalDate;

public class ContratoDePlanta extends ContratoDeTrabajo {
    private double sueldoMensual;
    private double montoPorConyugeACargo;
    private double montoPorHijoACargo;

    public ContratoDePlanta(Empleado empleado, LocalDate fechaDeInicio, double sueldoMensual, double montoPorConyugeACargo, double montoPorHijoACargo) {
        super(empleado, fechaDeInicio);
        this.sueldoMensual = sueldoMensual;
        this.montoPorConyugeACargo = montoPorConyugeACargo;
        this.montoPorHijoACargo = montoPorHijoACargo;
    }

    @Override
    protected boolean estaActivo() {
        return true;
    }

    @Override
    public double calcularSueldoBasico() {
        double sueldoBasico = this.sueldoMensual;

        if(this.getEmpleado().isTieneHijosACargo()) {
            sueldoBasico += this.montoPorHijoACargo;
        }
        if(this.getEmpleado().isTieneConyugeACargo()) {
            sueldoBasico += this.montoPorConyugeACargo;
        }

        return sueldoBasico;
    }
}
