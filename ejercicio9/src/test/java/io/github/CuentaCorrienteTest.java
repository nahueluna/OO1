package io.github;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class CuentaCorrienteTest {
	
	CuentaCorriente cuenta1, cuenta2;
	
	@BeforeEach
	void setUp() throws Exception {
		cuenta1 = new CuentaCorriente();
		cuenta2 = new CuentaCorriente();
		cuenta1.setDescubierto(500);
	}
	
    @Test
    public void testDepositar() {
		cuenta1.depositar(500);
        assertEquals(500, cuenta1.getSaldo());
    }

	@Test
	public void testExtraer() {
		cuenta1.depositar(500);
		cuenta2.depositar(500);
		assert(cuenta1.extraer(1000));
		assertFalse(cuenta2.extraer(501));

		assertEquals(-500, cuenta1.getSaldo());
		assertEquals(500, cuenta2.getSaldo());

		cuenta1.depositar(500);
		assertFalse(cuenta1.extraer(1000));

		assertEquals(0, cuenta1.getSaldo());
	}

	@Test
	public void testTransferirACuenta() {
		cuenta1.depositar(500);

		assert(cuenta1.transferirACuenta(1000, cuenta2));

		assertEquals(-500, cuenta1.getSaldo());
		assertEquals(1000, cuenta2.getSaldo());

		assertFalse(cuenta1.transferirACuenta(1, cuenta2));
		assertFalse(cuenta2.transferirACuenta(1001, cuenta1));

		assertEquals(1000, cuenta2.getSaldo());
	}
}
