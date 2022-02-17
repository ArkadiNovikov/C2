package com.untitleddoc.cadencecalc.web.wicket;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 *
 * @see com.untitleddoc.web.wicket.Start#main(String[])
 */
@Slf4j
public final class WicketApplication extends WebApplication {

	/**
	 * @return デフォルトページクラス
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		//レスポンスのエンコーディング設定
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
	}

	@Override
	public RuntimeConfigurationType getConfigurationType() {
		return super.getConfigurationType();
	}
}
