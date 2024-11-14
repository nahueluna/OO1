package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Clase Conductor

- calcularPorcentajeComision()
Particiones:
    * Antiguedad de vehiculo > 5
        Elijo caso mínimo
        Antiguedad = 6
    * Antiguedad de vehiculo <= 5
        Elijo caso máximo
        Antiguedad = 5

- cargarSaldo()
Particiones:
    * Comision = 10%
        Cualquier valor de monto sirve
        Elijo monto = 1000.0
    * Comision = 1%
        Cualquier valor de monto sirve
        Elijo monto = 1000.0

- descontarSaldo()
Particiones:
    * Monto > Bonificación
        Elijo caso mínimo
        monto = 1000.0 y bonificacion = 999.0
    * Monto <= Bonificacion
        Elijo caso donde descuento resultaría negativo
        monto = 1000.0 y bonificacion = 1100.0
 */

class ConductorTest {

    Conductor conductor1, conductor2;
    Vehiculo vehiculoMasNuevo, vehiculoMasViejo;

    @BeforeEach
    void setUp() {

        vehiculoMasNuevo =
                new Vehiculo("BMW", 4, 2020, 999_000.0);
        vehiculoMasViejo =
                new Vehiculo("Fiat", 6, 2018, 1_100_000.0);

        conductor1 = new Conductor("Pedro", vehiculoMasNuevo);
        conductor2 = new Conductor("Pablo", vehiculoMasViejo);
    }

    @Test
    void testCalcularPorcentajeComision() {
        assertEquals(conductor1.calcularPorcentajeComision(), 0.01);
        assertEquals(conductor2.calcularPorcentajeComision(), 0.1);
    }

    @Test
    void testCargarSaldo() {
        conductor1.cargarSaldo(1000.0);
        assertEquals(conductor1.getSaldo(), 990.0);

        conductor2.cargarSaldo(1000.0);
        assertEquals(conductor2.getSaldo(), 900.0);
    }

    @Test
    void testDescontarSaldo(){
        conductor1.cargarSaldo(1000.0);
        conductor1.descontarSaldo(1000.0);
        assertEquals(conductor1.getSaldo(), 989.0);

        conductor2.cargarSaldo(1000.0);
        conductor2.descontarSaldo(1000.0);
        assertEquals(conductor2.getSaldo(), 900.0);
    }
}