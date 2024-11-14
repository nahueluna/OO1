package io.github;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
    private String nombre;
    private String direccion;
    private List<Producto> productosPublicados;

    public Vendedor(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productosPublicados = new ArrayList<>();
    }
}
