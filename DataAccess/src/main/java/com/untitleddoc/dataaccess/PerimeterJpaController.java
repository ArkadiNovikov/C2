/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import com.untitleddoc.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Novikov
 */
public class PerimeterJpaController implements Serializable {

	public PerimeterJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Perimeter perimeter) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(perimeter);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Perimeter perimeter) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			perimeter = em.merge(perimeter);
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = perimeter.getIdPerimeter();
				if (findPerimeter(id) == null) {
					throw new NonexistentEntityException("The perimeter with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Integer id) throws NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Perimeter perimeter;
			try {
				perimeter = em.getReference(Perimeter.class, id);
				perimeter.getIdPerimeter();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The perimeter with id " + id + " no longer exists.", enfe);
			}
			em.remove(perimeter);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Perimeter> findPerimeterEntities() {
		return findPerimeterEntities(true, -1, -1);
	}

	public List<Perimeter> findPerimeterEntities(int maxResults, int firstResult) {
		return findPerimeterEntities(false, maxResults, firstResult);
	}

	private List<Perimeter> findPerimeterEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Perimeter.class));
			Query q = em.createQuery(cq);
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public Perimeter findPerimeter(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Perimeter.class, id);
		} finally {
			em.close();
		}
	}

	public int getPerimeterCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Perimeter> rt = cq.from(Perimeter.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}
	
}
