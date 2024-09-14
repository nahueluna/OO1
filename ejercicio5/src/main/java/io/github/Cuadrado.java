package io.github;

public class Cuadrado implements Figura {
    public double lado;

    public Cuadrado() {
        this.lado = 0;
    }

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return this.lado;
    }

    public double getPerimetro() {
        return this.getLado() * 4;
    }

    public double getArea() {
        return Math.pow(this.getLado(), 2);
    }

    public double getDiagonal() {
        return this.getLado() * Math.sqrt(2);
    }
}
