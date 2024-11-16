package io.github;

/*
* Metodo calcularAntiguedad()
* Se encuentran dos particiones equivalentes:
*   - Empleado no tiene contratos
*       Se toma empleado con lista de contratos vacía
*   - Empleado tiene uno o más contratos
*       Se toma empleado con lista de contratos con dos elementos. La cantidad
*       de contratos, mientras sea mayor a 0, es indistinta
*
* Metodo generarReciboDeSueldo()
* Se encuentran dos particiones equivalentes, las cuales modificarán el estado de montoTotal
* producido en el metodo y pasado a la instancia Recibo. No es posible que el empleado tenga más
* de un contrato activo
*   - Empleado tiene un contrato activo
*       El contrato activo calculará el correspondiente monto y lo retornará. El tipo de contrato
*       es indistinto para el caso de prueba.
*   - Empleado no tiene contratos activos
*       El empleado debe tener un contrato activo. No tenerlo implicará un ThrowException
* */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class EmpleadoTest {

    private Empleado empleadoConContratos, empleadoSinContratos;

    @BeforeEach
    void setUp() {
        empleadoConContratos =
                new Empleado("Pedro", "Perez", "CUIL1", LocalDate.now(), false, false);
        empleadoSinContratos =
                new Empleado("Pablo", "Pascal", "CUIL2", LocalDate.now(), true, true);

        ContratoDeTrabajo contratoPorHoras =
                new ContratoPorHoras(empleadoConContratos, LocalDate.now().minusDays(2), 10.0, 10, LocalDate.now().minusDays(1));
        ContratoDeTrabajo contratoDePlanta =
                new ContratoDePlanta(empleadoConContratos, LocalDate.now().minusYears(10), 100.0, 0.0, 0.0);

        empleadoConContratos.agregarContrato(contratoPorHoras);
        empleadoConContratos.agregarContrato(contratoDePlanta);
    }

    @Test
    void testCalcularAntiguedad() {
        assertEquals(empleadoConContratos.calcularAntiguedad(),
                LocalDate.now().getYear() - LocalDate.now().minusYears(10).getYear());

        assertEquals(empleadoSinContratos.calcularAntiguedad(), 0);
    }

    @Test
    void testGenerarReciboDeSueldo() {
        ReciboDeSueldo recibo = empleadoConContratos.generarReciboDeSueldo();

        assertEquals(recibo.getMontoTotal(), 150.0);

        assertThrows(Throwable.class, () -> empleadoSinContratos.generarReciboDeSueldo());
    }
}