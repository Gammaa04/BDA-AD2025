/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenjpa;

import DAO.SuperHeroeDAO;
import Entity.IdentidadSecreta;
import Entity.SuperHeroe;
import Entity.Universo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ExamenJPA {

    public static void main(String[] args) {
        SuperHeroeDAO heroeDAO = new SuperHeroeDAO();
        SuperHeroe spiterman= new SuperHeroe(
                "Spiderman",
                Universo.MARVEL,
                new IdentidadSecreta("Peter Parker", "New York ", "Fotografo"),
                "Un gran poder viene con una gran responsabilidad");
        SuperHeroe batman= new SuperHeroe(
                "Batman",
                Universo.DC,
                new IdentidadSecreta("Bruce Wayne", "GothaM ", "Empresario"),
                "Soy la venganza");
        SuperHeroe goku= new SuperHeroe(
                "Goku",
                Universo.INDEPENDIENTE,
                new IdentidadSecreta("Kakaroto", "Planeta tierra ", "Guerrero"),
                "ONDA VITAAAAAL jajja");
        
        heroeDAO.Insertar(spiterman);
        heroeDAO.Insertar(batman);
        heroeDAO.Insertar(goku);
        
        System.out.println("Enlistar todos los superheroes");
        List lista = heroeDAO.listar();
        
        for (Object object : lista) {
            System.out.println(object);
        }
        
        SuperHeroe batmanBD = heroeDAO.buscar(batman.getId());
        batmanBD.getIdentidadSecreta().setCiudad("Ciudad Gotica");
        heroeDAO.actualizar(batmanBD);
        
        
        System.out.println("Lista después de modificar a batman");
        List lista2 = heroeDAO.listar();
        for (Object object : lista2) {
            System.out.println(object);
        }
        
        heroeDAO.eliminar(spiterman.getId());
        
        System.out.println("Lista después de eliminar a batman");
        
        List list3 = heroeDAO.listar();
        for (Object object : list3) {
            System.out.println(object);
        }
        
        
        
        
        
        
        
    }
}
