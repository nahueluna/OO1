package io.github;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteDeCorreo {
    private Carpeta inbox;
    private List<Carpeta> carpetas;

    public ClienteDeCorreo() {
        this.inbox = new Carpeta("Inbox");
        this.carpetas = new ArrayList<Carpeta>();
    }

    public Carpeta getInbox() {
        return inbox;
    }

    public List<Carpeta> getCarpetas() {
        return new ArrayList<>(carpetas);
    }

    public void agregarCarpeta(Carpeta carpeta) {
        this.carpetas.add(carpeta);
    }

    public void recibir(Email email) {
        this.inbox.agregarEmail(email);
    }

    public List<Carpeta> getTodasLasCarpetas() {
        List<Carpeta> totalCarpetas = new ArrayList<>(carpetas);
        totalCarpetas.add(inbox);

        return totalCarpetas;
    }

    public Email buscar(String texto) {
        return this.getTodasLasCarpetas().stream().map(c -> c.buscar(texto)).filter(Objects::nonNull).findFirst().orElse(null);
    }

    public int espacioOcupado() {
        return this.getTodasLasCarpetas().stream().mapToInt(c -> c.espacioOcupado()).sum();
    }
}
