package io.github;

import java.time.LocalDate;

public class Mamifero {
    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;
    private Mamifero padre;
    private Mamifero madre;

    public Mamifero() {
        this.identificador = "";
        this.especie = "";
        this.fechaNacimiento = null;
        this.padre = null;
        this.madre = null;
    }

    public Mamifero(String identificador) {
        this();
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre() {
        return padre;
    }

    public void setPadre(Mamifero padre) {
        this.padre = padre;
    }

    public Mamifero getMadre() {
        return madre;
    }

    public void setMadre(Mamifero madre) {
        this.madre = madre;
    }

    public Mamifero getAbueloMaterno() {
        return (this.getMadre() != null ? this.getMadre().getPadre() : null);
    }

    public Mamifero getAbuelaMaterna() {
        return (this.getMadre() != null ? this.getMadre().getMadre() : null);
    }

    public Mamifero getAbueloPaterno() {
        return (this.getPadre() != null ? this.getPadre().getPadre() : null);
    }

    public Mamifero getAbuelaPaterna() {
        return (this.getPadre() != null ? this.getPadre().getMadre() : null);
    }

    public boolean tieneComoAncestroA(Mamifero unMamifero) {
        if (unMamifero == null) {
            return false;
        }

        if (this.getPadre() != null && this.getPadre().equals(unMamifero)) {
            return true;
        }

        if (this.getMadre() != null && this.getMadre().equals(unMamifero)) {
            return true;
        }

        return (this.getPadre() != null && this.getPadre().tieneComoAncestroA(unMamifero)) ||
                (this.getMadre() != null && this.getMadre().tieneComoAncestroA(unMamifero));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mamifero unMamifero = (Mamifero) o;
        return this.identificador != null && this.especie != null
                && this.identificador.equals(unMamifero.getIdentificador())
                && this.especie.equals(unMamifero.getEspecie());
    }
}
