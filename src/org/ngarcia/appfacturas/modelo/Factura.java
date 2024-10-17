package org.ngarcia.appfacturas.modelo;

import java.util.Date;

public class Factura {
    
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    private static int ultimoFolio;
    public static final int MAX_ITEMS = 10;
    
    
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.folio = ++ultimoFolio;
        this.items = new ItemFactura[MAX_ITEMS];
        this.fecha = new Date();
        //this.indiceItems = 0;
    }
    
    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }
    
    public void addItem(ItemFactura item) {
        if( indiceItems < MAX_ITEMS ) {
            this.items[indiceItems++] = item;
        }
    }
    
    public float calcularTotal() {
        float total = 0.0f;
        for(ItemFactura item: this.items) {
            if(item == null) { //saltea líneas en null
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }
    
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura nº").append(folio)
                .append("\nCliente: ").append(this.cliente.getNombre())
                .append("\tRUT:").append(this.cliente.getRUT())
                .append("\nDescripción:").append(this.descripcion)
                .append("\nFecha:").append(this.fecha.toString())
                .append("\n\n#\tNombre\t$\tCant.\tTotal\n");
        
        return sb.toString();
    }
}