package io.github;

import java.time.LocalDate;

public class ReciboDeSueldo {
    private String nombre;
    private String apellido;
    private String CUIL;
    private int antiguedadEnLaEmpresa;
    private LocalDate fecha;
    private double montoTotal;

    public ReciboDeSueldo(String nombre, String apellido, String CUIL, int antiguedadEnLaEmpresa, double montoTotal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CUIL = CUIL;
        this.antiguedadEnLaEmpresa = antiguedadEnLaEmpresa;
        this.fecha = LocalDate.now();
        this.montoTotal = montoTotal;
    }

    public double getMontoTotal() {
        return this.montoTotal;
    }
}
