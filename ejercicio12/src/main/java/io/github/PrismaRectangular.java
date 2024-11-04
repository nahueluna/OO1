package io.github;

public class PrismaRectangular extends Pieza {
    private int ladoMayor;
    private int ladoMenor;
    private int altura;

    public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
        super(material, color);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    public int getLadoMayor() {
        return ladoMayor;
    }

    public int getLadoMenor() {
        return ladoMenor;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public double calcularVolumen() {
        return this.getLadoMayor() * this.getLadoMenor() * this.getAltura();
    }

    @Override
    public double calcularSuperficie() {
        return 2 * (this.getLadoMayor() * this.getLadoMenor()
                + this.getLadoMayor() * this.getAltura()
                + this.getLadoMenor() * this.getAltura());
    }
}
