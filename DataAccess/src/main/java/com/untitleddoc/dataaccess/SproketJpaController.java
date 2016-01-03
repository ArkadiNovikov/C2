/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.dataaccess;

import com.untitleddoc.dataaccess.exceptions.IllegalOrphanException;
import com.untitleddoc.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Novikov
 */
public class SproketJpaController implements Serializable {

	public SproketJpaController(EntityManagerFactory emf) {
		this.emf = emf;
	}
	private EntityManagerFactory emf = null;

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Sproket sproket) {
		if (sproket.getSproketdetailCollection() == null) {
			sproket.setSproketdetailCollection(new ArrayList<>());
		}
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Collection<SproketDetail> attachedSproketdetailCollection = new ArrayList<>();
			for (SproketDetail sproketdetailCollectionSproketDetailToAttach : sproket.getSproketdetailCollection()) {
				sproketdetailCollectionSproketDetailToAttach = em.getReference(sproketdetailCollectionSproketDetailToAttach.getClass(), sproketdetailCollectionSproketDetailToAttach.getSproketDetailPK());
				attachedSproketdetailCollection.add(sproketdetailCollectionSproketDetailToAttach);
			}
			sproket.setSproketdetailCollection(attachedSproketdetailCollection);
			em.persist(sproket);
			for (SproketDetail sproketdetailCollectionSproketDetail : sproket.getSproketdetailCollection()) {
				Sproket oldSproketOfSproketdetailCollectionSproketDetail = sproketdetailCollectionSproketDetail.getSproket();
				sproketdetailCollectionSproketDetail.setSproket(sproket);
				sproketdetailCollectionSproketDetail = em.merge(sproketdetailCollectionSproketDetail);
				if (oldSproketOfSproketdetailCollectionSproketDetail != null) {
					oldSproketOfSproketdetailCollectionSproketDetail.getSproketdetailCollection().remove(sproketdetailCollectionSproketDetail);
					oldSproketOfSproketdetailCollectionSproketDetail = em.merge(oldSproketOfSproketdetailCollectionSproketDetail);
				}
			}
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Sproket sproket) throws IllegalOrphanException, NonexistentEntityException, Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Sproket persistentSproket = em.find(Sproket.class, sproket.getIdSproket());
			Collection<SproketDetail> sproketdetailCollectionOld = persistentSproket.getSproketdetailCollection();
			Collection<SproketDetail> sproketdetailCollectionNew = sproket.getSproketdetailCollection();
			List<String> illegalOrphanMessages = null;
			for (SproketDetail sproketdetailCollectionOldSproketDetail : sproketdetailCollectionOld) {
				if (!sproketdetailCollectionNew.contains(sproketdetailCollectionOldSproketDetail)) {
					if (illegalOrphanMessages == null) {
						illegalOrphanMessages = new ArrayList<String>();
					}
					illegalOrphanMessages.add("You must retain SproketDetail " + sproketdetailCollectionOldSproketDetail + " since its sproket field is not nullable.");
				}
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			Collection<SproketDetail> attachedSproketdetailCollectionNew = new ArrayList<SproketDetail>();
			for (SproketDetail sproketdetailCollectionNewSproketDetailToAttach : sproketdetailCollectionNew) {
				sproketdetailCollectionNewSproketDetailToAttach = em.getReference(sproketdetailCollectionNewSproketDetailToAttach.getClass(), sproketdetailCollectionNewSproketDetailToAttach.getSproketDetailPK());
				attachedSproketdetailCollectionNew.add(sproketdetailCollectionNewSproketDetailToAttach);
			}
			sproketdetailCollectionNew = attachedSproketdetailCollectionNew;
			sproket.setSproketdetailCollection(sproketdetailCollectionNew);
			sproket = em.merge(sproket);
			for (SproketDetail sproketdetailCollectionNewSproketDetail : sproketdetailCollectionNew) {
				if (!sproketdetailCollectionOld.contains(sproketdetailCollectionNewSproketDetail)) {
					Sproket oldSproketOfSproketdetailCollectionNewSproketDetail = sproketdetailCollectionNewSproketDetail.getSproket();
					sproketdetailCollectionNewSproketDetail.setSproket(sproket);
					sproketdetailCollectionNewSproketDetail = em.merge(sproketdetailCollectionNewSproketDetail);
					if (oldSproketOfSproketdetailCollectionNewSproketDetail != null && !oldSproketOfSproketdetailCollectionNewSproketDetail.equals(sproket)) {
						oldSproketOfSproketdetailCollectionNewSproketDetail.getSproketdetailCollection().remove(sproketdetailCollectionNewSproketDetail);
						oldSproketOfSproketdetailCollectionNewSproketDetail = em.merge(oldSproketOfSproketdetailCollectionNewSproketDetail);
					}
				}
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			String msg = ex.getLocalizedMessage();
			if (msg == null || msg.length() == 0) {
				Integer id = sproket.getIdSproket();
				if (findSproket(id) == null) {
					throw new NonexistentEntityException("The sproket with id " + id + " no longer exists.");
				}
			}
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Sproket sproket;
			try {
				sproket = em.getReference(Sproket.class, id);
				sproket.getIdSproket();
			} catch (EntityNotFoundException enfe) {
				throw new NonexistentEntityException("The sproket with id " + id + " no longer exists.", enfe);
			}
			List<String> illegalOrphanMessages = null;
			Collection<SproketDetail> sproketdetailCollectionOrphanCheck = sproket.getSproketdetailCollection();
			for (SproketDetail sproketdetailCollectionOrphanCheckSproketDetail : sproketdetailCollectionOrphanCheck) {
				if (illegalOrphanMessages == null) {
					illegalOrphanMessages = new ArrayList<String>();
				}
				illegalOrphanMessages.add("This Sproket (" + sproket + ") cannot be destroyed since the SproketDetail " + sproketdetailCollectionOrphanCheckSproketDetail + " in its sproketdetailCollection field has a non-nullable sproket field.");
			}
			if (illegalOrphanMessages != null) {
				throw new IllegalOrphanException(illegalOrphanMessages);
			}
			em.remove(sproket);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Sproket> findSproketEntities() {
		return findSproketEntities(true, -1, -1);
	}

	public List<Sproket> findSproketEntities(int maxResults, int firstResult) {
		return findSproketEntities(false, maxResults, firstResult);
	}

	private List<Sproket> findSproketEntities(boolean all, int maxResults, int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Sproket.class));
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

	public Sproket findSproket(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Sproket.class, id);
		} finally {
			em.close();
		}
	}

	public int getSproketCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Sproket> rt = cq.from(Sproket.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}
	
}
