package io.github;

import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String domicilio;
    private Consumo ultimoConsumo;

    public Usuario(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    public void setUltimoConsumo(Consumo ultimoConsumo) {
        this.ultimoConsumo = ultimoConsumo;
    }

    public Factura generarFactura(CuadroTarifario cuadroTarifario) {
        double montoFinal = this.ultimoConsumo.calcularCosto(cuadroTarifario);

        double bonificacion = 0;
        if(this.ultimoConsumo.calcularFactorDePotenciaEstimado() > cuadroTarifario.getFactorDePotencia()) {
            bonificacion = 0.1;
            montoFinal = montoFinal - (montoFinal * bonificacion);
        }


        return new Factura(this, LocalDate.now(), bonificacion, montoFinal);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Domicilio: " + this.domicilio;
    }
}
