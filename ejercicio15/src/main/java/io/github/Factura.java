package io.github;

import java.time.LocalDate;

public class Factura {
    private Usuario usuario;
    private LocalDate fechaDeEmision;
    private double montoFinal;
    private double bonificacion;

    public Factura(Usuario usuario, LocalDate fechaDeEmision, double bonificacion, double montoFinal) {
        this.usuario = usuario;
        this.fechaDeEmision = fechaDeEmision;
        this.montoFinal = montoFinal;
        this.bonificacion = bonificacion;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    @Override
    public String toString() {
        return "Usuario: " + this.usuario.toString() + "\n" +
                "Fecha: " + this.fechaDeEmision + "\n" +
                "Bonificacion: " + this.bonificacion + "\n" +
                "Monto final: " + this.montoFinal;
    }
}
