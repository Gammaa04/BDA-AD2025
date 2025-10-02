/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO.Interfaces;

import Entity.SuperHeroe;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public interface ISuperHeroesDAO {
    void Insertar(SuperHeroe heroe);
    void actualizar(SuperHeroe heroe);
    void eliminar(Long id);
    SuperHeroe buscar(long id);
    List<SuperHeroe> listar();
    
    
    
    
}
