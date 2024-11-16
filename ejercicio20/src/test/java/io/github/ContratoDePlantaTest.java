package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Aclaración: si bien el metodo calcularSueldoTotal() es importante para la clase, el comportamiento de este está
* definido en la superclase que comparte con ContratoPorHorasTest, por lo que su funcionalidad ya fue testeada
*
* Metodo getAniosDeAntiguedad()
* Debido a que los contratos de este tipos no tienen fecha de fin, siempre están activos. Esto hace que se ejecute
* siempre el metodo de la superclase, el cual compara la fecha de inicio con la actual. Existen dos particiones equivalentes:
*   - Fecha de inicio anterior a fecha actual por al menos un anio
*       Es el comportamiento esperado. El retorno será un número positivo. Se eligen valores para que haya una diferencia
*       exacta de un anio
*   - Fecha de inicio posterior a fecha actual por al menos un anio, o diferencia menor a un anio
*       El calculo de antiguedad será negativo o 0. Se retorna 0 en ambos casos. Se toma fecha de inicio posterior a fecha actual
*       por exactamente un anio
*
* Metodo calcularSueldoBasico()
* El empleado puede o no tener a cargo hijos o conyuge. Esto modificará los montos adicionales a tener en cuenta al momento del
* cálculo del sueldo total. Se identifican 4 particiones equivalentes:
*   - Empleado tiene hijos a cargo y no conyuge
*       Al cálculo del sueldo básico se adiciona el monto por hijos a cargo. El valor del sueldo y el monto es indistinto.
*   - Empleado tiene conyuge a cargo y no hijos
*       Al cálculo del sueldo básico se adiciona el monto por conyuge a cargo. El valor del sueldo y el adicional es indistinto.
*   - Empleado no tiene conyuge e hijos a cargo
*       Al cálculo del sueldo básico no se le adiciona ninguna bonificación. El valor del sueldo base es indistinto.
*   - Empleado tiene tanto conyuge como hijos a cargo
*       Al cálculo del sueldo básico se le adiciona tanto el monto por hijos como por conyuge. El valor del sueldo y el
*       adicional es indistinto.
* */

class ContratoDePlantaTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetAniosDeAntiguedad() {
    }

    @Test
    void testCalcularSueldoBasico() {
    }
}