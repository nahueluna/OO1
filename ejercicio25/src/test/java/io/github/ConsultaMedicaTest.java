package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaMedicaTest {

    ConsultaMedica consultaEnDomingo, consultaNoDomingo;
    Medico medicoSinAntiguedad, medicoConAntiguedad;

    @BeforeEach
    void setUp() {
        Mascota mascota = new Mascota("Chimuelo", LocalDate.of(2021, 5, 17), "Gato");
        medicoSinAntiguedad = new Medico("Pablo", LocalDate.of(2024, 5, 10), 5.0);
        medicoConAntiguedad = new Medico("Pedro", LocalDate.of(2021, 11, 10), 50.0);

        consultaEnDomingo = new ConsultaMedica(LocalDate.of(2024, 11, 10), mascota, medicoSinAntiguedad);
        consultaNoDomingo = new ConsultaMedica(LocalDate.of(2024, 11, 9), mascota, medicoConAntiguedad);
    }

    @Test
    void testCalcularCostoServicio() {
        assertEquals(consultaEnDomingo.calcularCostoServicio(), 505.0);

        assertEquals(consultaNoDomingo.calcularCostoServicio(), 650.0);
    }
}