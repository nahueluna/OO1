package io.github;

public class RetiroEnCorreo implements FormaDeEnvio {

    public RetiroEnCorreo() {}

    @Override
    public double calcularCostoEnvio() {
        return 3000.0;
    }
}
