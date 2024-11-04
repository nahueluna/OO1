package io.github;

public class Esfera extends Pieza {
    private int radio;

    public Esfera(String material, String color, int radio) {
        super(material, color);
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    @Override
    public double calcularVolumen() {
        return ((double) 4 /3) * Math.PI * Math.pow(this.getRadio(), 3);
    }

    @Override
    public double calcularSuperficie() {
        return 4 * Math.PI * Math.pow(this.getRadio(), 2);
    }
}
