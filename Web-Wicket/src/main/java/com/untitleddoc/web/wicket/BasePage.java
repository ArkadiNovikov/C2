package com.untitleddoc.web.wicket;

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

	public BasePage(final PageParameters parameters) {
	}

}
