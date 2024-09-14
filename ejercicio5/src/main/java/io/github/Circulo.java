package io.github;

public class Circulo implements Figura {
    private Punto punto;
    private double radio;

    public Circulo() {
        this.punto = new Punto();
        this.radio = 0;
    }

    public Circulo(Punto punto, double radio) {
        this.punto = punto;
        this.radio = radio;
    }

    public double getDiametro() {
        return this.getRadio() * 2;
    }

    public void setDiametro(double diametro) {
        this.setRadio((double) diametro / 2);
    }

    public double getRadio() {
        return this.radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public double getPerimetro() {
        return Math.PI * this.getDiametro();
    }

    public double getArea() {
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

}
