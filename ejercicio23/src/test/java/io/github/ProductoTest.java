package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* Se reconocen dos particiones:
* - Producto tiene stock suficiente
*       Sucede cuando la cantidad indicada para decrementar es menor o igual al stock del producto.
*       Se elegiran valores borde tal que el stock sea igual a la cantidad solicitada
*       Stock 1, cantidadSolicitada = 1
*
* - Producto no tiene stock suficiente
*       Sucede cuando la cantidad indicada para decrementar es mayor al stock del producto.
*       El valor del stock y la cantidad indicada no son relevantes en sí. La importancia está en su
*       relación. Se elegirán valores borde tal que que el stock sea mínimamente inferior a la cantidad solicitada
*       Stock = 1, cantidadSolicitada = 2
* */

class ProductoTest {

    Producto productoConStockUno;

    @BeforeEach
    void setUp() {
        productoConStockUno = new Producto("productoA", "categoriaA", 100.0, 1);
    }

    @Test
    void testDecrementarStockConStockSuficiente() {
        productoConStockUno.decrementarStock(1);
        assertEquals(productoConStockUno.getStock(), 0);
    }

    @Test
    void testDecrementarStockSinStockSuficiente() {
        productoConStockUno.decrementarStock(2);
        assertEquals(productoConStockUno.getStock(), 1);
    }
}