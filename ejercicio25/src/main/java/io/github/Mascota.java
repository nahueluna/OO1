package io.github;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private List<ServicioMedico> atenciones;

    public Mascota(String nombre, LocalDate fechaNacimiento, String especie) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.atenciones = new ArrayList<>();
    }

    public ConsultaMedica darDeAltaConsultaMedica(LocalDate fechaActual, Medico medico) {
        ConsultaMedica consulta = new ConsultaMedica(fechaActual, this, medico);
        this.atenciones.add(consulta);

        return consulta;
    }

    public Vacunacion darDeAltaVacunacion(LocalDate fechaActual, Medico medico, String nombreVacuna, double costo) {
        Vacunacion vacunacion = new Vacunacion(fechaActual, this, medico, nombreVacuna, costo);
        this.atenciones.add(vacunacion);

        return vacunacion;
    }

    public ServicioGuarderia darDeAltaServicioGuarderia(LocalDate fechaActual, int cantidadDeDias) {
        ServicioGuarderia servicioDeGuarderia = new ServicioGuarderia(fechaActual, this, cantidadDeDias);
        this.atenciones.add(servicioDeGuarderia);

        return servicioDeGuarderia;
    }

    public double getRecaudacionTotalEnFecha(LocalDate fechaSolicitada) {
        return this.atenciones.stream().filter(a -> a.getFecha().isEqual(fechaSolicitada))
                .mapToDouble(a -> a.calcularCostoServicio()).sum();
    }

    public int getCantidadServiciosUtilizados() {
        return this.atenciones.size();
    }
}
