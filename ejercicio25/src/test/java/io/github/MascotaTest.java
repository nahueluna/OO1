package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MascotaTest {

    Mascota mascota1, mascota2;
    Medico medico;

    @BeforeEach
    void setUp() {
        mascota1 = new Mascota("Firulais", LocalDate.of(2020, 11, 10), "Perro");
        mascota2 = new Mascota("Chimuelo", LocalDate.of(2023, 11, 10), "Gato");
        medico = new Medico("Pablo", LocalDate.of(2019, 11, 10), 50.0);

        mascota1.darDeAltaConsultaMedica(LocalDate.of(2024, 11, 10), medico);
        mascota1.darDeAltaVacunacion(LocalDate.of(2024, 11, 10), medico, "Antirabica", 100.0);
        mascota1.darDeAltaServicioGuarderia(LocalDate.of(2024, 5, 10), 20);
    }

    @Test
    void testGetRecaudacionTotalEnFecha() {
        // Mascota con una atencion en la fecha
        assertEquals(mascota1.getRecaudacionTotalEnFecha(LocalDate.of(2024, 5, 10)), 10000);

        // Mascota con más de una atencion en la fecha
        assertEquals(mascota1.getRecaudacionTotalEnFecha(LocalDate.of(2024, 11, 10)), 1900.0);

        // Mascota sin atenciones en la fecha
        assertEquals(mascota2.getRecaudacionTotalEnFecha(LocalDate.of(2024, 11, 10)), 0);
    }
}