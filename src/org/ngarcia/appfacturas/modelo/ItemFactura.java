package org.ngarcia.appfacturas.modelo;

public class ItemFactura {

    private int cantidad;
    private Producto producto;

    public ItemFactura(Producto producto, int cantidad ) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public float calcularImporte() {
        return this.cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}
