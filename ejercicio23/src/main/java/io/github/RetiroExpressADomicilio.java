package io.github;

public class RetiroExpressADomicilio implements FormaDeEnvio {
    private String direccionOrigen;
    private String direccionDestino;

    @Override
    public double calcularCostoEnvio() {
        return CalculadoraDeDistancia.distanciaEntre(this.direccionOrigen, this.direccionDestino) * 0.5;
    }
}
