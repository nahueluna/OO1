package io.github;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;

    public ReporteDeConstruccion() {
        this.piezas = new ArrayList<>();
    }

    public void addPieza(Pieza unaPieza) {
        this.piezas.add(unaPieza);
    }

    public List<Pieza> getPiezas() {
        return new ArrayList<>(this.piezas);
    }

    public double getVolumenDeMaterial(String nombreDeMaterial) {
        return this.getPiezas().stream()
                .filter(pieza -> pieza.getMaterial().equals(nombreDeMaterial))
                .mapToDouble(p -> p.calcularVolumen()).sum();
    }

    public double getSuperficieDeColor(String unNombreDeColor) {
        return this.getPiezas().stream()
                .filter(pieza -> pieza.getColor().equals(unNombreDeColor))
                .mapToDouble(p -> p.calcularSuperficie()).sum();
    }
}
