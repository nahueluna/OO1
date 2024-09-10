package io.github;

public class Balanza {
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.pesoTotal = 0;
        this.precioTotal = 0;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    private void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    private void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    private void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public void ponerEnCero() {
        this.setPesoTotal(0);
        this.setCantidadDeProductos(0);
        this.setPrecioTotal(0);
    }

    public void agregarProducto(Producto producto) {
        this.setCantidadDeProductos(this.getCantidadDeProductos() + 1);
        this.setPesoTotal(this.getPesoTotal() + producto.getPeso());
        this.setPrecioTotal(this.getPrecioTotal() + producto.getPrecio());
    }

    public Ticket emitirTicket() {
        return new Ticket(this.getCantidadDeProductos(), this.getPrecioTotal(), this.getPesoTotal());
    }
}
