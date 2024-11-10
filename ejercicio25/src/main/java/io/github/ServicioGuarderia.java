package io.github;

import java.time.LocalDate;

public class ServicioGuarderia extends ServicioMedico {
    private int cantidadDeDias;

    public ServicioGuarderia(LocalDate fecha, Mascota mascota, int cantidadDeDias) {
        super(fecha, mascota);
        this.cantidadDeDias = cantidadDeDias;
    }


    @Override
    public double calcularCostoServicio() {
        double descuento = 0;
        if(this.correspondeDescuento()) {
            descuento = 0.1;
        }

        double monto = 500.0 * this.cantidadDeDias;

        return monto - (monto * descuento);
    }

    public boolean correspondeDescuento() {
        return this.getMascota().getCantidadServiciosUtilizados() >= 5;
    }
}
