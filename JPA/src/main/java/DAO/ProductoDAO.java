/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.exceptions.NonexistentEntityException;
import Entity.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.io.Serializable;
import jakarta.persistence.Query;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class ProductoDAO implements Serializable {

    private EntityManagerFactory emf = null;

    public ProductoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void insertar(Producto producto) {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void actualizar(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            producto = em.merge(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = producto.getId();
                if (buscarid(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminar(Long id) throws NonexistentEntityException {
        EntityManager em = getEntityManager();
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> listar() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;

        } finally {
            em.close();
        }
    }

    public Producto buscarid(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
            return null;
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
            return -1;
        }
    }

}
