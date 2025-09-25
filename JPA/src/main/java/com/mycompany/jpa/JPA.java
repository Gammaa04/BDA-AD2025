/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jpa;

import DAO.ProductoDAO;
import Entity.Producto;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class JPA {

    public static void main(String[] args) {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendita");

        ProductoDAO productoDAO = new ProductoDAO(emf);

        // Crear un nuevo producto
        Producto nuevo = new Producto();
        nuevo.setNombre("Ibuprofeno");
        nuevo.setPrecio(49.99f);
        productoDAO.insertar(nuevo);
        System.out.println("Producto insertado: " + nuevo.getId());

        // Buscar por ID
        Producto buscado = productoDAO.buscarid(nuevo.getId());
        System.out.println("Producto encontrado: " + buscado.getNombre());

        // Actualizar
        buscado.setPrecio(44.99f);
        try {
            productoDAO.actualizar(buscado);
            System.out.println("Producto actualizado.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Listar todos
        List<Producto> productos = productoDAO.listar();
        System.out.println("Listado de productos:");
        for (Producto p : productos) {
            System.out.println(p.getId() + " - " + p.getNombre() + " - $" + p.getPrecio());
        }

        // Eliminar
        try {
            productoDAO.eliminar(nuevo.getId());
            System.out.println("Producto eliminado.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar el EntityManagerFactory
        emf.close();
        
        
        
        
        
        
    }
}
