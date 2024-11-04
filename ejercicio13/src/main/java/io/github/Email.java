package io.github;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;

    public Email() {
        this.titulo = "";
        this.cuerpo = "";
        this.adjuntos = new ArrayList<>();
    }

    public Email(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public void agregarAdjunto(Archivo adjunto) {
        this.adjuntos.add(adjunto);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }

    public List<Archivo> adjuntos() {
        return new ArrayList<>(this.adjuntos);
    }

    public int tamanio() {
        return this.titulo.length() + this.cuerpo.length() + this.adjuntos.stream().mapToInt(a -> a.tamanio()).sum();
    }

    public boolean match(String texto) {
        return this.titulo.contains(texto) || this.cuerpo.contains(texto);
    }
}
