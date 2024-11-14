package io.github;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cliente {
    private String nombre;
    private String direccion;
    private List<Pedido> pedidosRealizados;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidosRealizados = new ArrayList<>();
    }

    public Pedido realizarPedido(FormaDePago formaDePago, FormaDeEnvio formaDeEnvio, Producto producto, int cantidadSolicitada) {
        if(producto.decrementarStock(cantidadSolicitada)) {
            Pedido pedido = new Pedido(this, producto, formaDePago, formaDeEnvio, cantidadSolicitada);
            this.agregarPedido(pedido);

            return pedido;
        }

        return null;
    }

    private void agregarPedido(Pedido pedido) {
        this.pedidosRealizados.add(pedido);
    }

    public HashMap<String, Integer> calcularCantidadDeProductosPorCategoria() {
        HashMap<String, Integer> cantidadPorCategoria = new HashMap<>();
        this.pedidosRealizados.stream().
                forEach(p -> cantidadPorCategoria.merge(p.getCategoriaDeLaCompra(), 1, Integer::sum));

        return cantidadPorCategoria;
    }
}
