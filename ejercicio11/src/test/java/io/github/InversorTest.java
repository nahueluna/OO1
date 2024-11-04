package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversorTest {

    Inversor inversor1, inversor2;
    Inversion pf1, pf2, acciones1, acciones2;

    @BeforeEach
    void setUp() {
        inversor1 = new Inversor("Pedro");
        inversor2 = new Inversor("Miguel");

        pf1 = new PlazoFijo(1000, 1.1);
        pf2 = new PlazoFijo(10000, 1.05);
        acciones1 = new InversionEnAcciones("SPY", 5, 250);
        acciones2 = new InversionEnAcciones("QQQ", 10, 100);
    }

    @Test
    void valorActual() {
        assertEquals(0, inversor1.valorActual());
        assertEquals(0, inversor2.valorActual());

        inversor1.addInversion(pf1);
        inversor1.addInversion(acciones1);
        inversor2.addInversion(pf2);
        inversor2.addInversion(acciones2);

        assertEquals(2250, inversor1.valorActual());
        assertEquals(11000, inversor2.valorActual());
    }
}