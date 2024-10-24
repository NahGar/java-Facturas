package org.ngarcia.appfacturas;

import org.ngarcia.appfacturas.modelo.*;

import java.util.Scanner;

public class Ejecutar {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Super 9 estrellas");
        cliente.setRUT("221549521896");

        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese descripción de la factura: ");
        String descripcion = s.nextLine();

        Factura factura = new Factura(descripcion, cliente);

        Producto producto;
        //String nombre;
        //float precio;
        //int cantidad;

        System.out.println();
        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getCodigo() + ": ");
            //nombre = s.next(); //next permite solo una palabra
            //nombre = s.nextLine();
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese precio: ");
            //precio = s.nextFloat();
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese cantidad: ");
            //cantidad = s.nextInt();

            //ItemFactura item = new ItemFactura(producto, s.nextInt());

            factura.addItem(new ItemFactura(producto, s.nextInt()));

            System.out.println();

            //si se carga nombre con espacios, a la siguiente iteración pide más campos
            //se evita con esto
            s.nextLine();
        }

        System.out.println(factura);
    }
    
}
