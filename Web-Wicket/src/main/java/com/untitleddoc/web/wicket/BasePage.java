package com.untitleddoc.web.wicket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author Novikov
 */
@Slf4j()
public abstract class BasePage extends WebPage {

	private static final long serialVersionUID = -7565557356813846136L;
	private EntityManager entityManager = null;

	public BasePage(final PageParameters parameters) {
	}

	protected final EntityManager getEntityManager() {
		if (entityManager == null) {
			final WicketApplication app = (WicketApplication) getApplication();
			entityManager = app.getEntityManagerFactory().createEntityManager();
		}
		return entityManager;
	}

	protected final EntityManagerFactory getEntityManagerFactory() {
		return ((WicketApplication) getApplication()).getEntityManagerFactory();
	}
	
	@Override
	protected void onDetach() {
		if (entityManager != null) {
			entityManager.close();
		}
		super.onDetach();
	}
}
