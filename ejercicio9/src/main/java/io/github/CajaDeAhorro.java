package io.github;

public class CajaDeAhorro extends Cuenta{
    private static final double recargo = 1.02;

    @Override
    protected boolean puedeExtraer(double monto) {
        return (monto * recargo) <= this.getSaldo();
    }

    @Override
    protected void extraerSinControlar(double monto) {
        double montoConRecargo = monto * recargo;
        super.extraerSinControlar(montoConRecargo);
    }
}
