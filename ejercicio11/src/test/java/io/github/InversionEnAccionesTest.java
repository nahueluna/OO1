package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InversionEnAccionesTest {

    InversionEnAcciones acciones1, acciones2;

    @BeforeEach
    void setUp() {
        acciones1 = new InversionEnAcciones("YPF", 15, 200);
        acciones2 = new InversionEnAcciones("Microsoft", 1, 1777);
    }

    @Test
    void valorActual() {
        assertEquals(3000, acciones1.valorActual());
        assertEquals(1777, acciones2.valorActual());

        acciones2.setCantidad(10);

        assertEquals(17770, acciones2.valorActual());
    }
}