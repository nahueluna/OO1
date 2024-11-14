package io.github;

public class AlContado implements FormaDePago {

    public AlContado(){}

    @Override
    public double calcularPrecioFinal(double precioBase) {
        return precioBase;
    }
}
