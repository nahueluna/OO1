package io.github;

public class CuentaCorriente extends Cuenta {
    private double limiteDeDescubierto;

    public CuentaCorriente() {
        super();
        this.limiteDeDescubierto = 0;
    }

    public double getDescubierto() {
        return this.limiteDeDescubierto;
    }

    public void setDescubierto(double descubierto) {
        this.limiteDeDescubierto = descubierto;
    }


    @Override
    protected boolean puedeExtraer(double monto) {
        return monto <= (this.getSaldo() + this.getDescubierto());
    }
}
