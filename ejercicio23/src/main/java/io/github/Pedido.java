package io.github;

public class Pedido {
    private Cliente cliente;
    private Producto producto;
    private FormaDePago formaDePago;
    private FormaDeEnvio formaDeEnvio;
    private int cantidadSolicitada;

    public Pedido(Cliente cliente, Producto producto, FormaDePago formaDePago, FormaDeEnvio formaDeEnvio, int cantidadSolicitada) {
        this.cliente = cliente;
        this.producto = producto;
        this.formaDePago = formaDePago;
        this.formaDeEnvio = formaDeEnvio;
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public String getCategoriaDeLaCompra() {
        return this.producto.getCategoria();
    }

    public double calcularCostoTotal() {
        return this.formaDePago.calcularPrecioFinal(producto.getPrecio()) +
                this.formaDeEnvio.calcularCostoEnvio();
    }
}
