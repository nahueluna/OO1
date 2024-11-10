package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServicioGuarderiaTest {

    ServicioGuarderia servicioSinDescuento, servicioConDescuento;
    Mascota mascotaConCincoServicios, mascotaConMenosDeCincoServicios;

    @BeforeEach
    void setUp() {
        mascotaConCincoServicios = new Mascota("Chimuelo", LocalDate.of(2023, 11, 10), "Gato");
        mascotaConMenosDeCincoServicios = new Mascota("Firulais", LocalDate.of(2023, 9, 10), "Perro");

        servicioSinDescuento = new ServicioGuarderia(LocalDate.of(2024, 11, 1), mascotaConMenosDeCincoServicios, 15);
        servicioConDescuento = new ServicioGuarderia(LocalDate.of(2024, 10, 1), mascotaConCincoServicios, 15);

        for(int i = 0; i<5; i++) {
            mascotaConCincoServicios.darDeAltaServicioGuarderia(LocalDate.now(), 10);
        }

    }

    @Test
    void testCalcularCostoServicio() {
        assertEquals(servicioSinDescuento.calcularCostoServicio(), 7500.0);

        assertEquals(servicioConDescuento.calcularCostoServicio(), 6750.0);
    }
}