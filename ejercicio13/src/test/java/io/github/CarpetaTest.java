package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarpetaTest {

    Carpeta carpeta, destino;
    Email email1, email2, email3;
    Archivo adjunto1, adjunto2;

    @BeforeEach
    void setUp() {
        carpeta = new Carpeta("test1");
        destino = new Carpeta("carpeta destino");

        email1 = new Email("prueba", "esto es una prueba");
        email2 = new Email("hola", "mundo");
        email3 = new Email("hipopotomonstroses", "quipedaliofobia");

        adjunto1 = new Archivo("adjunto1");
        adjunto2 = new Archivo("adjunto2");

        email1.agregarAdjunto(adjunto1);
        email3.agregarAdjunto(adjunto2);

        carpeta.agregarEmail(email1);
        carpeta.agregarEmail(email2);
        carpeta.agregarEmail(email3);
    }

    @Test
    void testMover() {
        assertEquals(carpeta.getEmails().size(), 3);
        assertEquals(destino.getEmails().size(), 0);

        carpeta.mover(email1, destino);
        assertEquals(carpeta.getEmails().size(), 2);
        assertEquals(destino.getEmails().size(), 1);
    }

    @Test
    void testBuscar() {
        assertNotNull(carpeta.buscar("hipo"));
        assertNull(destino.buscar("prueba"));
    }

    @Test
    void testEspacioOcupado() {
        assertEquals(carpeta.espacioOcupado(), 82);
        assertEquals(destino.espacioOcupado(), 0);
    }
}