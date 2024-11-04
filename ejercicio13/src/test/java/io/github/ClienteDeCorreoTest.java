package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDeCorreoTest {

    ClienteDeCorreo cliente, cliente2;
    Carpeta carpeta1, carpeta2;
    Email email1, email2;
    Archivo adjunto1, adjunto2, adjunto3;

    @BeforeEach
    void setUp() {
        cliente = new ClienteDeCorreo();
        cliente2 = new ClienteDeCorreo();

        adjunto1 = new Archivo("imagenes.jpg");
        adjunto2 = new Archivo("lista.txt");
        adjunto3 = new Archivo("ejecutable.exe");

        email1 = new Email("prueba", "esto es un test, hola");
        email2 = new Email("hola", "mundo");

        email1.agregarAdjunto(adjunto1);
        email1.agregarAdjunto(adjunto2);
        email2.agregarAdjunto(adjunto3);

        carpeta1 = new Carpeta("Test1");
        carpeta2 = new Carpeta("Test2");

        carpeta1.agregarEmail(email1);
        carpeta1.agregarEmail(email2);
        carpeta2.agregarEmail(new Email());

        cliente.agregarCarpeta(carpeta1);
        cliente.agregarCarpeta(carpeta2);
        cliente.recibir(new Email("email en inbox", "te envio al inbox"));
    }

    @Test
    void testBuscar() {
        assertEquals(cliente.buscar("hola").getTitulo(), "prueba");
        assertEquals(cliente.buscar("envio").getTitulo(), "email en inbox");
        assertNull(cliente.buscar("asdf"));
    }

    @Test
    void testEspacioOcupado() {
        assertEquals(cliente.espacioOcupado(), 102);
        assertEquals(cliente2.espacioOcupado(), 0);
    }
}