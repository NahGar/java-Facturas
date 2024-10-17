package org.ngarcia.appfacturas.modelo;

public class Ejecutar {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Super 9 estrellas");
        cliente.setRUT("221549521896");
        Factura factura = new Factura("Factura nº 123", cliente);
        Producto producto1 = new Producto();
        producto1.setNombre("Agua jane");
        producto1.setPrecio(50.50f);                
        factura.addItem(new ItemFactura(producto1,2));
        Producto producto2 = new Producto();
        producto2.setNombre("Ravioles");
        producto2.setPrecio(145.99f);                
        factura.addItem(new ItemFactura(producto2,1));
        System.out.println(factura.generarDetalle()); 
    }
    
}
