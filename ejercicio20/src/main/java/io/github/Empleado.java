package io.github;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private String CUIL;
    private LocalDate fechaDeNacimiento;
    private boolean tieneHijosACargo;
    private boolean tieneConyugeACargo;
    private List<ContratoDeTrabajo> contratos;

    public Empleado(String nombre, String apellido, String CUIL, LocalDate fechaDeNacimiento, boolean tieneHijosACargo, boolean tieneConyugeACargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.tieneHijosACargo = tieneHijosACargo;
        this.tieneConyugeACargo = tieneConyugeACargo;
        this.contratos = new ArrayList<>();
    }

    public void agregarContrato(ContratoDeTrabajo contrato) {
        this.contratos.add(contrato);
    }

    public boolean isTieneHijosACargo() {
        return tieneHijosACargo;
    }

    public boolean isTieneConyugeACargo() {
        return tieneConyugeACargo;
    }

    private ContratoDeTrabajo getContratoActivo() {
        return this.contratos.stream().filter(c -> c.estaActivo()).findFirst().orElseThrow();
    }

    protected int calcularAntiguedad() {
        return this.contratos.stream().mapToInt(c -> c.getAniosDeAntiguedad()).sum();
    }

    public ReciboDeSueldo generarReciboDeSueldo() {
        double sueldoTotal = this.getContratoActivo().calcularSueldoTotal();

        return new ReciboDeSueldo(this.nombre, this.apellido, this.CUIL, this.calcularAntiguedad(), sueldoTotal);
    }
}
