package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class VacunacionTest {

    Vacunacion vacunacionEnDomingo, vacunacionNoDomingo;

    @BeforeEach
    void setUp() {
        Mascota mascota = new Mascota("Chimuelo", LocalDate.of(2021, 11, 10), "Gato");
        Medico medico = new Medico("Pedro", LocalDate.of(2022, 11, 10), 50.0);

        vacunacionEnDomingo = new Vacunacion(LocalDate.of(2024, 11, 10), mascota, medico, "Antirabica", 100.0);
        vacunacionNoDomingo = new Vacunacion(LocalDate.of(2024, 11, 9), mascota, medico, "Triple Felina", 250.0);
    }

    @Test
    void calcularCostoServicio() {
        assertEquals(vacunacionEnDomingo.calcularCostoServicio(), 850.0);

        assertEquals(vacunacionNoDomingo.calcularCostoServicio(), 800.0);
    }
}