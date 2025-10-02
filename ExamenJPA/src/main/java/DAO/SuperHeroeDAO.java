/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Config.JpaUtil;
import DAO.Interfaces.ISuperHeroesDAO;
import Entity.SuperHeroe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class SuperHeroeDAO implements ISuperHeroesDAO {

    @Override
    public void Insertar(SuperHeroe heroe) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(heroe);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public void actualizar(SuperHeroe heroe) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            SuperHeroe heroe = em.find(SuperHeroe.class, id);
            if (heroe != null) {
                em.remove(heroe);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    @Override
    public SuperHeroe buscar(long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(SuperHeroe.class, id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<SuperHeroe> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        try {

            return em.createQuery("SELECT s FROM SuperHeroe s", SuperHeroe.class).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

}
