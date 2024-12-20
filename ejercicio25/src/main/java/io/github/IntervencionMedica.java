package io.github;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class IntervencionMedica extends ServicioMedico{
    private Medico medico;

    public IntervencionMedica(LocalDate fecha, Mascota mascota, Medico medico) {
        super(fecha, mascota);
        this.medico = medico;
    }

    protected Medico getMedico() {
        return this.medico;
    }

    public boolean correspondeAdicionalDomingo() {
        return this.getFecha().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    @Override
    public double calcularCostoServicio() {
        double adicionalDomingo = 0;
        if(this.correspondeAdicionalDomingo()) {
            adicionalDomingo = 200.0;
        }

        return this.medico.getHonorarios() + adicionalDomingo;
    }
}
