package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* El metodo calcularCantidadDeProductosPorCategoría contabiliza y retorna la cantidad de productos de cada categoría
* en los pedidos de un cliente.
* Las particiones equivalentes que halladas son:
* - Cliente sin pedidos
*       Dado un cliente que no posea pedidos, cuando se calcule la cantidad de productos por categoría, entonces debe
*       retornar una estructura vacía
*       Se toma cliente sin pedidos
* - Cliente con pedidos
*       Dado un cliente que posee pedidos, cuando se calcule la cantidad de productos por categoría, entonces debe
*       retornar una estructura con cada categoría de producto que pidió, junto con una cantidad >= 1
*       La cantidad de pedidos del cliente, así como la categoria a la que pertenecen no modificará el comportamiento
*       del metodo.
*       Se toma cliente con 3 pedidos, 2 de los cuales sus productos pertenecen a la misma categoría
*
* El metodo realizarPedido producirá un pedido. Se hallan dos particiones equivalentes:
* - Existe stock suficiente del producto, se genera pedido
*       Mientras el stock del producto sea mayor o igual a la cantidad solicitada, el pedido se creará y retornará.
*       Debido a que importa la relacion stock-cantidad y no un valor puntual, se toma stock = 2, cantidadSolicitada = 2
*
* - No existe stock suficiente del producto, no se genera pedido
*       Cuando el stock sea menor a la cantidad solicitada, entonces el pedido no se realizará y se retonará null.
*       Se elige stock 1 y cantidadSolicitada = 2
*
* En ambos métodos, los valores de precio, envío y precio del producto, así como los propios de cliente son irrelevantes
* para el comportamiento testeado.
* */

class ClienteTest {

    Cliente clienteSinPedidos, clienteConPedidos;
    Producto productoStockSuficienteCategoriaA, productoBCategoriaA,
            productoCCategoriaB, productoStockInsuficiente;

    @BeforeEach
    void setUp() {
        productoStockSuficienteCategoriaA = new Producto("ProductoA", "CategoriaA", 100.0, 2);
        productoBCategoriaA = new Producto( "ProductoB", "CategoriaA", 100.0, 2);
        productoCCategoriaB = new Producto("ProductoC", "CategoriaB", 100.0, 2);
        productoStockInsuficiente = new Producto("ProductoD", "CategoriaX", 100.0, 1);

        clienteConPedidos = new Cliente("Pedro", "Avenida 123");
        clienteSinPedidos = new Cliente("Pedro", "Avenida 456");
    }

    @Test
    void testRealizarPedido() {
        assertNotNull(clienteConPedidos.
                realizarPedido(new AlContado(), new RetiroEnComercio(), productoStockSuficienteCategoriaA, 2));

        assertNull(clienteConPedidos.realizarPedido(new SeisCuotas(), new RetiroEnCorreo(), productoStockInsuficiente, 2));
    }

    @Test
    void testCalcularCantidadDeProductosPorCategoria() {
        clienteConPedidos.realizarPedido(new AlContado(), new RetiroEnCorreo(), productoStockSuficienteCategoriaA, 1);
        clienteConPedidos.realizarPedido(new AlContado(), new RetiroEnCorreo(), productoBCategoriaA, 1);
        clienteConPedidos.realizarPedido(new AlContado(), new RetiroEnCorreo(), productoCCategoriaB, 1);

        assertEquals(clienteConPedidos.calcularCantidadDeProductosPorCategoria().size(), 2);

        assertEquals(clienteSinPedidos.calcularCantidadDeProductosPorCategoria().size(), 0);
    }
}