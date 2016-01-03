package com.untitleddoc.web.wicket;

import com.untitleddoc.dataaccess.Crankset;
import com.untitleddoc.dataaccess.CranksetJpaController;
import com.untitleddoc.dataaccess.PerimeterJpaController;
import com.untitleddoc.dataaccess.Sproket;
import com.untitleddoc.dataaccess.SproketDetail;
import com.untitleddoc.dataaccess.SproketDetailJpaController;
import com.untitleddoc.dataaccess.SproketJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

    private EntityManagerFactory entityManagerFactory;

    /**
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
        entityManagerFactory = Persistence.createEntityManagerFactory("com.untitleddoc.cadencecalc_PU");
		
//		final CranksetJpaController crankCtrl = new CranksetJpaController(entityManagerFactory);
//		final List<Crankset> cranks = crankCtrl.findCranksetEntities();
//		if(cranks.isEmpty())
//		{
//			log.info("crankset is empty");
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-9000");
//				crankset.setOuterGearTooth(50);
//				crankset.setInnerGearTooth(34);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-9000");
//				crankset.setOuterGearTooth(52);
//				crankset.setInnerGearTooth(36);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-9000");
//				crankset.setOuterGearTooth(52);
//				crankset.setInnerGearTooth(38);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-9000");
//				crankset.setOuterGearTooth(53);
//				crankset.setInnerGearTooth(39);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-6800");
//				crankset.setOuterGearTooth(46);
//				crankset.setInnerGearTooth(36);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("FC-M8000-3");
//				crankset.setOuterGearTooth(40);
//				crankset.setMiddleGearTooth(30);
//				crankset.setInnerGearTooth(22);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(48);
//				crankset.setInnerGearTooth(36);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(48);
//				crankset.setInnerGearTooth(34);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(48);
//				crankset.setInnerGearTooth(32);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(46);
//				crankset.setInnerGearTooth(34);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(46);
//				crankset.setInnerGearTooth(32);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(46);
//				crankset.setInnerGearTooth(30);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(44);
//				crankset.setInnerGearTooth(36);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(44);
//				crankset.setInnerGearTooth(34);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(44);
//				crankset.setInnerGearTooth(32);
//				crankCtrl.create(crankset);
//			}
//			{
//				final Crankset crankset = new Crankset();
//				crankset.setName("OX901D");
//				crankset.setOuterGearTooth(44);
//				crankset.setInnerGearTooth(30);
//				crankCtrl.create(crankset);
//			}
//		}
//		else
//		{
//			log.info("crankset is not empty");
//		}
//		
//		final PerimeterJpaController periCtrl = new PerimeterJpaController(entityManagerFactory);
//		
//		final SproketJpaController sprkCtrl = new SproketJpaController(entityManagerFactory);
//		final SproketDetailJpaController sprkDtlCtrl = new SproketDetailJpaController(entityManagerFactory);
//		{
//			Sproket sproket = new Sproket();
//			
//			//sprkCtrl.create(sproket);
//		}
//		
		
    }

    @Override
    public RuntimeConfigurationType getConfigurationType() {
        return super.getConfigurationType();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    @Override
    protected void onDestroy() {
        if(entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }    
}
