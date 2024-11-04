package io.github;

public class Archivo {
    private String nombre;

    public Archivo() {
        this.nombre = "";
    }

    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    public int tamanio() {
        return this.nombre.length();
    }
}
