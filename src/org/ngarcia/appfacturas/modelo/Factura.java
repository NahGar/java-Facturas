package org.ngarcia.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
        
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Factura nº:\t").append(folio)
                .append("\nCliente:\t").append(this.cliente.getNombre())
                .append("\tRUT:\t").append(this.cliente.getRUT())
                .append("\nDescripción:\t").append(this.descripcion)
                .append("\nFecha:\t").append(df.format(this.fecha))
                .append("\n\n#\tNombre\t$\tCant.\tTotal\n");
        
        for(ItemFactura item: this.items) {
            if(item == null) {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\nTotal:\t").append(this.calcularTotal());
        
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }

    
}
