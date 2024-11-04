package io.github;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;

    public Inversor() {}

    public Inversor(String nombre) {
        this.nombre = nombre;
        this.inversiones = new ArrayList<>();
    }

    public List<Inversion> getInversiones() {
        return new ArrayList<>(this.inversiones);
    }

    public void addInversion(Inversion unaInversion) {
        this.inversiones.add(unaInversion);
    }

    public double valorActual() {
        return this.getInversiones().stream()
                .mapToDouble(inversion -> inversion.valorActual())
                .sum();
    }
}
