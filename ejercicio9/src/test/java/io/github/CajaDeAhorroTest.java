package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CajaDeAhorroTest {

    CajaDeAhorro cuenta1, cuenta2;
    CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp() throws Exception {
        cuenta1 = new CajaDeAhorro();
        cuenta2 = new CajaDeAhorro();
        cuentaCorriente = new CuentaCorriente();

        cuenta1.depositar(1020);
    }

    @Test
    public void testExtraer() {
        assertFalse(cuenta1.extraer(1020));
        assertFalse(cuenta2.extraer(1));

        assert(cuenta1.extraer(1000));
        assertEquals(0, cuenta1.getSaldo());
    }

    @Test
    public void testTransferir() {
        assertFalse(cuenta1.transferirACuenta(1020, cuenta2));
        assertFalse(cuenta2.transferirACuenta(1, cuenta2));

        assert(cuenta1.transferirACuenta(1000, cuenta2));
        assertEquals(0, cuenta1.getSaldo());
        assertEquals(1000, cuenta2.getSaldo());

        assert(cuenta2.transferirACuenta(980, cuenta2));
        assertEquals(980.4, cuenta2.getSaldo());
    }

    @Test
    public void testTransferirACuentaCorriente() {
        assert(cuenta1.transferirACuenta(1000, cuentaCorriente));

        assertEquals(1000, cuentaCorriente.getSaldo());
    }
}