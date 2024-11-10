package io.github;

import java.time.LocalDate;

public abstract class ServicioMedico {
    private LocalDate fecha;
    private Mascota mascota;

    public ServicioMedico(LocalDate fecha, Mascota mascota) {
        this.fecha = fecha;
        this.mascota = mascota;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    protected Mascota getMascota() {
        return this.mascota;
    }

    public abstract double calcularCostoServicio();
}
