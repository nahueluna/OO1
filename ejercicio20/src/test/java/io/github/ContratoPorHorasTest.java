package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Metodo calcularSueldoTotal()
* Su implementación se compone del cálculo del sueldo basico y el adicional por antiguedad. El cálculo
* del sueldo básico consiste simplemente en una multiplicación de dos valores positivos, lo cual
* no es una lógica compleja que tenga sentido testear. Por otro lado, el cálculo del adicional por
* antiguedad supone una lógica más compleja. Se identifican 5 particiones equivalentes:
*   - Antiguedad menor a 5
*       Para una antiguedad menor a 5 no corresponde adicional por antiguedad, resultando
*       unicamente en el sueldo basico. Se toma antiguedad = 4
*   - Antiguedad mayor igual a 5 y menor a 10
*       Para una antiguedad en este rango, corresponde un adicional del 30%. Se toma
*       antiguedad = 5
*   - Antiguedad mayor igual a 10 y menor a 15
*       Para una antiguedad en este rango, corresponde un adicional del 50%. Se toma
*       antiguedad = 10
*   - Antiguedad mayor igual a 15 y menor a 20
*       Para una antiguedad en este rango, corresponde un adicional del 70%. Se toma
*       antiguedad = 15
*   - Antiguedad mayor igual a 20
*       Para una antiguedad mayor o igual a 20 corresponde un adicional del 100%.
*       Se toma antiguedad = 20
*
* Metodo getAniosDeAntiguedad()
* Se identifican dos particiones equivalentes
*   - El contrato no está activo
*       Si no está activo, se compara la fecha de inicio del contrato con la de fin. Se ejecuta metodo definido
*       en la superclase
*   - El contrato está activo
*       Si está activo, se compara la fecha de inicio con la fecha actual. Se ejecuta metodo sobreescrito en la
*       propia clase
* */

class ContratoPorHorasTest {

    ContratoPorHoras contratoActivo, contratoNoActivo;
    Empleado empleadoAntiguedadCuatro, empleadoAntiguedadCinco, empleadoAntiguedadDiez,
            empleadoAntiguedadQuince, empleadoAntiguedadVeinte;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCalcularSueldoTotal() {
    }

    @Test
    void testGetAniosDeAntiguedad() {
    }
}