package io.github;

import java.time.LocalDate;

public class ConsultaMedica extends IntervencionMedica{

    public ConsultaMedica(LocalDate fecha, Mascota mascota, Medico medico) {
        super(fecha, mascota, medico);
    }

    @Override
    public double calcularCostoServicio() {
        double costoIntervencion = super.calcularCostoServicio();
        double adicionalPorAnioAntiguedad = 100.0;
        double adicionalPorMateriales = 300.0;

        return costoIntervencion +
                adicionalPorMateriales +
                (this.getMedico().getAntiguedad(LocalDate.now()) * adicionalPorAnioAntiguedad);
    }
}
