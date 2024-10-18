package org.ngarcia.appfacturas;

import org.ngarcia.appfacturas.modelo.*;

import java.util.Scanner;

public class Ejecutar {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Super 9 estrellas");
        cliente.setRUT("221549521896");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese descripción de la factura");
        String descripcion = s.nextLine();

        Factura factura = new Factura(descripcion, cliente);

        Producto producto = new Producto();
        String nombre;
        float precio;
        int cantidad;

        System.out.println();
        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese código de producto: ");
            nombre = s.next(); //permite solo una palabra
            producto.setNombre(nombre);

            System.out.print("Ingrese precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.print("Ingrese cantidad: ");
            cantidad = s.nextInt();

            ItemFactura item = new ItemFactura(producto, cantidad);

            factura.addItem(item);

            System.out.println();
        }

        System.out.println(factura.generarDetalle());
    }
    
}
