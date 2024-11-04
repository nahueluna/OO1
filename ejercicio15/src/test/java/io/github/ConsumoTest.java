package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConsumoTest {

    Consumo consumo1, consumo2;
    CuadroTarifario tarifas;

    @BeforeEach
    void setUp() {
        consumo1 = new Consumo(55.5, 55.5);
        consumo2 = new Consumo(70.0, 20.0);

        tarifas = new CuadroTarifario(10.0);
    }

    @Test
    void testCalcularCosto() {
        assertEquals(consumo1.calcularCosto(tarifas), 555.0);
        assertEquals(consumo2.calcularCosto(tarifas), 700.0);
    }

    @Test
    void testCalcularFactorDePotenciaEstimado() {
        assertEquals(consumo1.calcularFactorDePotenciaEstimado(), 0.7, 0.01);
        assertEquals(consumo2.calcularFactorDePotenciaEstimado(), 0.96, 0.01);
    }
}