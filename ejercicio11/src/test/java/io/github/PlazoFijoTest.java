package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlazoFijoTest {

    PlazoFijo pf1, pf2;

    @BeforeEach
    void setUp() {
        pf1 = new PlazoFijo(1000, 1.1);
        pf2 = new PlazoFijo(5500);
    }

    @Test
    void testValorActual() {
        assertEquals(1000, pf1.valorActual());
        assertEquals(5500, pf2.valorActual());
    }
}