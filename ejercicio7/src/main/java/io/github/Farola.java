package io.github;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    private boolean encendida;
    private List<Farola> farolasVecinas;

    public Farola() {
        this.encendida = false;
        this.farolasVecinas = new ArrayList<>();
    }

    private void addNeighbor(Farola otraFarola) {
        this.farolasVecinas.add(otraFarola);
    }

    public void pairWithNeighbor(Farola otraFarola) {
        if (otraFarola != null) {
            this.addNeighbor(otraFarola);
            otraFarola.addNeighbor(this);
        }
    }

    public List<Farola> getNeighbors() {
        return new ArrayList<>(this.farolasVecinas);
    }

    public void turnOn() {
        if (!this.isOn()) {
            this.encendida = true;
            this.getNeighbors().forEach(Farola::turnOn);
        }
    }

    public void turnOff() {
        if (this.isOn()) {
            this.encendida = false;
            this.getNeighbors().forEach(Farola::turnOff);
        }
    }

    public boolean isOn() {
        return this.encendida;
    }

    // metodo innecesario pero estaba en los tests
    public boolean isOff() {
        return !this.encendida;
    }
}
