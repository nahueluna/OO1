package io.github;

import java.time.LocalDate;

public class ConsultaMedica extends IntervencionMedica{
    final double adicionalPorAnioAntiguedad = 100.0;
    final double adicionalPorMateriales = 300.0;

    public ConsultaMedica(LocalDate fecha, Mascota mascota, Medico medico) {
        super(fecha, mascota, medico);
    }

    @Override
    public double calcularCostoServicio() {
        double costoIntervencion = super.calcularCostoServicio();

        return costoIntervencion +
                adicionalPorMateriales +
                (this.getMedico().getAntiguedad(LocalDate.now()) * adicionalPorAnioAntiguedad);
    }
}
