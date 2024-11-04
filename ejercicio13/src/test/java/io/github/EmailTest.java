package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    Email email1, email2;
    Archivo adj1, adj2, adj3;

    @BeforeEach
    void setUp() {
        email1 = new Email("esto es", "un email");
        email2 = new Email();

        adj1 = new Archivo("test.txt");
        adj2 = new Archivo("ejecutable.exe");
        adj3 = new Archivo();

        email1.agregarAdjunto(adj1);
        email1.agregarAdjunto(adj2);
        email1.agregarAdjunto(adj3);
    }

    @Test
    void testTamanio() {
        assertEquals(email1.tamanio(), 37);
        assertEquals(email2.tamanio(), 0);
    }

    @Test
    void testMatch() {
        assert(email1.match("es"));
        assertFalse(email2.match("email"));
    }
}