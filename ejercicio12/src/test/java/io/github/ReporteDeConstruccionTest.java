package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDeConstruccionTest {

    ReporteDeConstruccion reporte;
    Pieza esfera, cilindro, prisma;

    @BeforeEach
    void setUp() {
        reporte = new ReporteDeConstruccion();
        esfera = new Esfera("Hierro","Rojo",5);
        cilindro = new Cilindro("Hierro", "Verde",3, 5);
        prisma = new PrismaRectangular("Cuarzo","Verde", 4, 2, 1);

        reporte.addPieza(esfera);
        reporte.addPieza(cilindro);
        reporte.addPieza(prisma);
    }

    @Test
    void testGetVolumenDeMaterial() {
        assertEquals(664.97, reporte.getVolumenDeMaterial("Hierro"), 0.01);
        assertEquals(8, reporte.getVolumenDeMaterial("Cuarzo"), 0.01);
    }

    @Test
    void testGetSuperficieDeColor() {
        assertEquals(178.79, reporte.getSuperficieDeColor("Verde"), 0.01);
        assertEquals(314.15, reporte.getSuperficieDeColor("Rojo"), 0.01);
    }
}