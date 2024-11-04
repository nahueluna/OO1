package io.github;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
    private String nombre;
    private List<Email> emails;

    public Carpeta() {
        this.nombre = "";
        this.emails = new ArrayList<>();
    }

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public void agregarEmail(Email email) {
        this.emails.add(email);
    }

    public List<Email> getEmails() {
        return new ArrayList<>(this.emails);
    }

    public void quitarEmail(Email email) {
        this.emails.remove(email);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void mover(Email email, Carpeta destino) {
        this.quitarEmail(email);
        destino.agregarEmail(email);
    }

    public Email buscar(String texto) {
        return this.emails.stream().filter(e -> e.match(texto)).findFirst().orElse(null);
    }

    public int espacioOcupado() {
        return this.emails.stream().mapToInt(e -> e.tamanio()).sum();
    }
}
