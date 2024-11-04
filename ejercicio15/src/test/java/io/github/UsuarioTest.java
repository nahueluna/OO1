package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    Usuario usuario1, usuario2;
    Consumo consumo1, consumo2;
    CuadroTarifario tarifas;

    @BeforeEach
    void setUp() {
        tarifas = new CuadroTarifario(10.0);

        usuario1 = new Usuario("Pedro", "Avenida siempre viva");
        usuario2 = new Usuario("Joaquin", "Lamadrid 1600");

        consumo1 = new Consumo(25.5, 0.1);
        consumo2 = new Consumo(55.5, 55.5);

        usuario1.setUltimoConsumo(consumo1);
        usuario2.setUltimoConsumo(consumo2);
    }

    @Test
    void testGenerarFactura() {
        Factura factura1 = usuario1.generarFactura(tarifas);
        Factura factura2 = usuario2.generarFactura(tarifas);

        assertEquals(factura1.getMontoFinal(), 229.5);
        assertEquals(factura1.getBonificacion(), 0.1);

        assertEquals(factura2.getMontoFinal(), 555.0);
        assertEquals(factura2.getBonificacion(), 0.0);
    }
}