package io.github;

public class SeisCuotas implements FormaDePago {

    public SeisCuotas() {}

    @Override
    public double calcularPrecioFinal(double precioBase) {
        return precioBase * 1.2;
    }
}
