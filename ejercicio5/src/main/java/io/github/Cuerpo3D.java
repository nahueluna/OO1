package io.github;

public class Cuerpo3D {
    private double altura;
    private Figura caraBasal;

    public Cuerpo3D() {
        this.altura = 0;
        this.caraBasal = new Circulo();
    }

    public Cuerpo3D(double altura, Figura caraBasal) {
        this.altura = altura;
        this.caraBasal = caraBasal;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setCaraBasal(Figura caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getVolumen() {
        return this.caraBasal.getArea() * this.getAltura();
    }

    public double getSuperficieExterior() {
        return 2 * this.caraBasal.getArea() + this.caraBasal.getPerimetro() * this.getAltura();
    }
}
