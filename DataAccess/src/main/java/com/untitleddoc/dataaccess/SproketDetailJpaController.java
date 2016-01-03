/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import com.untitleddoc.dataaccess.exceptions.NonexistentEntityException;
import com.untitleddoc.dataaccess.exceptions.PreexistingEntityException;
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
public class SproketDetailJpaController implements Serializable {

	public SproketDetailJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(SproketDetail sproketDetail) throws PreexistingEntityException, Exception {
		if (sproketDetail.getSproketDetailPK() == null) {
			sproketDetail.setSproketDetailPK(new SproketDetailPK());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Sproket sproket = sproketDetail.getSproket();
			if (sproket != null) {
				sproket = em.getReference(sproket.getClass(), sproket.getIdSproket());
				sproketDetail.setSproket(sproket);
			}
			em.persist(sproketDetail);
			if (sproket != null) {
				sproket.getSproketdetailCollection().add(sproketDetail);
				sproket = em.merge(sproket);
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			if (findSproketDetail(sproketDetail.getSproketDetailPK()) != null) {
				throw new PreexistingEntityException("SproketDetail " + sproketDetail + " already exists.", ex);
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(SproketDetail sproketDetail) throws NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			SproketDetail persistentSproketDetail = em.find(SproketDetail.class, sproketDetail.getSproketDetailPK());
			Sproket sproketOld = persistentSproketDetail.getSproket();
			Sproket sproketNew = sproketDetail.getSproket();
			if (sproketNew != null) {
				sproketNew = em.getReference(sproketNew.getClass(), sproketNew.getIdSproket());
				sproketDetail.setSproket(sproketNew);
			}
			sproketDetail = em.merge(sproketDetail);
			if (sproketOld != null && !sproketOld.equals(sproketNew)) {
				sproketOld.getSproketdetailCollection().remove(sproketDetail);
				sproketOld = em.merge(sproketOld);
			}
			if (sproketNew != null && !sproketNew.equals(sproketOld)) {
				sproketNew.getSproketdetailCollection().add(sproketDetail);
				sproketNew = em.merge(sproketNew);
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				SproketDetailPK id = sproketDetail.getSproketDetailPK();
				if (findSproketDetail(id) == null) {
					throw new NonexistentEntityException("The sproketDetail with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(SproketDetailPK id) throws NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			SproketDetail sproketDetail;
			try {
				sproketDetail = em.getReference(SproketDetail.class, id);
				sproketDetail.getSproketDetailPK();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The sproketDetail with id " + id + " no longer exists.", enfe);
			}
			Sproket sproket = sproketDetail.getSproket();
			if (sproket != null) {
				sproket.getSproketdetailCollection().remove(sproketDetail);
				sproket = em.merge(sproket);
			}
			em.remove(sproketDetail);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<SproketDetail> findSproketDetailEntities() {
		return findSproketDetailEntities(true, -1, -1);
	}

	public List<SproketDetail> findSproketDetailEntities(int maxResults, int firstResult) {
		return findSproketDetailEntities(false, maxResults, firstResult);
	}

	private List<SproketDetail> findSproketDetailEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(SproketDetail.class));
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

	public SproketDetail findSproketDetail(SproketDetailPK id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(SproketDetail.class, id);
		} finally {
			em.close();
		}
	}

	public int getSproketDetailCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<SproketDetail> rt = cq.from(SproketDetail.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}
	
}
