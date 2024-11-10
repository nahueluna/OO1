package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MedicoTest {

    Medico medico1, medico2, medico3;

    @BeforeEach
    void setUp() {
        medico1 = new Medico("Pedro", LocalDate.of(2019, 11, 10), 50.0);
        medico2 = new Medico("Pablo", LocalDate.of(2024, 5, 10), 10.0);
        medico3 = new Medico("Julian", LocalDate.of(2023, 11, 10), 15.0);
    }

    @Test
    void testGetAntiguedad() {
        // Medico con mas de un año de antiguedad
        assertEquals(medico1.getAntiguedad(LocalDate.of(2024, 11, 10)), 5);

        // Medico con menos de un año de antiguedad
        assertEquals(medico2.getAntiguedad(LocalDate.of(2024, 11, 10)), 0);

        // Medico con un año de antiguedad
        assertEquals(medico3.getAntiguedad(LocalDate.of(2024, 11, 10)), 1);
    }
}