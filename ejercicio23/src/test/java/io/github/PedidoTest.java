package io.github;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
* En el metodo CalcularCostoTotal(), el comportamiento variará dependiendo del tipo de FormaDePago y FormaDeEnvio
* Por el tipo de pago se identifican particiones:
* - Pago al contado
*       No realiza ninguna modificación sobre el precio base
* - Pago en 6 cuotas
*       Incrementa el precio base un 20%
*
* Por el tipo de envío se identifican particiones:
* - Retiro en comercio
*       Retorna 0 como precio de envío
* - Retiro en correo
*       Retorna 3000 como precio de envío
* - Retiro express en domicilio
*       Retorna 0,5 * km desde origen a destino, como precio de envío
*       Para la implementación, la cantidad de km está prefijada en un valor constante "100.0"
*
* Las combinaciones entre tipos de pago y tipos de envío dan lugar a las variaciones de comportamiento del método
* */

class PedidoTest {

    Pedido pedidoAlContadoRetiroEnComercio, pedidoAlContadoRetiroEnCorreo, pedidoAlContadoRetiroExpress,
        pedidoSeisCuotasRetiroEnComercio, pedidoSeisCuotasRetiroEnCorreo, pedidoSeisCuotasRetiroExpress;

    @BeforeEach
    void setUp() {
        Cliente cliente = new Cliente("Pedro", "Avenida 123");
        Producto producto = new Producto("ProductoA", "CategoriaA", 100.0, 1);
        FormaDeEnvio retiroEnComercio = new RetiroEnComercio();
        FormaDeEnvio retiroEnCorreo = new RetiroEnCorreo();
        FormaDeEnvio retiroExpress = new RetiroExpressADomicilio();
        FormaDePago alContado = new AlContado();
        FormaDePago seisCuotas = new SeisCuotas();

        pedidoAlContadoRetiroEnComercio = new Pedido(cliente, producto, alContado, retiroEnComercio, 1);
        pedidoAlContadoRetiroEnCorreo = new Pedido(cliente, producto, alContado, retiroEnCorreo, 1);
        pedidoAlContadoRetiroExpress = new Pedido(cliente, producto, alContado, retiroExpress, 1);
        pedidoSeisCuotasRetiroEnComercio = new Pedido(cliente, producto, seisCuotas, retiroEnComercio, 1);
        pedidoSeisCuotasRetiroEnCorreo = new Pedido(cliente, producto, seisCuotas, retiroEnCorreo, 1);
        pedidoSeisCuotasRetiroExpress = new Pedido(cliente, producto, seisCuotas, retiroExpress, 1);
    }

    @Test
    void testCalcularCostoTotal() {
        assertEquals(pedidoAlContadoRetiroEnComercio.calcularCostoTotal(), 100.0);

        assertEquals(pedidoAlContadoRetiroEnCorreo.calcularCostoTotal(), 3100.0);

        assertEquals(pedidoAlContadoRetiroExpress.calcularCostoTotal(), 150.0);

        assertEquals(pedidoSeisCuotasRetiroEnComercio.calcularCostoTotal(), 120.0);

        assertEquals(pedidoSeisCuotasRetiroEnCorreo.calcularCostoTotal(), 3120.0);

        assertEquals(pedidoSeisCuotasRetiroExpress.calcularCostoTotal(), 170.0);
    }
}