package com.untitleddoc.web.wicket;

import com.untitleddoc.dataaccess.Crankset;
import com.untitleddoc.dataaccess.CranksetJpaController;
import com.untitleddoc.dataaccess.Perimeter;
import com.untitleddoc.dataaccess.PerimeterJpaController;
import com.untitleddoc.dataaccess.Sproket;
import com.untitleddoc.dataaccess.SproketJpaController;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@Slf4j
public class HomePage extends BasePage {

	private static final long serialVersionUID = 1L;
	private final DropDownChoice<Crankset> crankset;
	private final DropDownChoice<Sproket> sprocket;
	private final DropDownChoice<Perimeter> perimeter;
	private final NumberTextField cadence = new NumberTextField("cadence", new Model<>(80));
	private final Form<Void> form = new Form<Void>("input") {
		@Override
		protected void onSubmit() {
			super.onSubmit(); //To change body of generated methods, choose Tools | Templates.
		}
	};

	public HomePage(final PageParameters parameters) {
		super(parameters);

		final CranksetJpaController crankCtrl = new CranksetJpaController(getEntityManagerFactory());
		final List<Crankset> cranks = crankCtrl.findCranksetEntities();

		final SproketJpaController sprCtrl = new SproketJpaController(getEntityManagerFactory());
		final List<Sproket> sprokets = sprCtrl.findSproketEntities();

		final PerimeterJpaController periCtrl = new PerimeterJpaController(getEntityManagerFactory());
		final List<Perimeter> perimeters = periCtrl.findPerimeterEntities();

		crankset = new DropDownChoice<>("crankset", new Model<>(), cranks, new IChoiceRenderer<Crankset>() {
			@Override
			public Object getDisplayValue(Crankset object) {
				String str = StringUtils.EMPTY;
				str += object.getName();
				str += " (" + object.getOuterGearTooth() + " - " + (object.getMiddleGearTooth() != null ? object.getMiddleGearTooth() + " - " : "") + object.getInnerGearTooth() + ")";
				return str;
			}

			@Override
			public String getIdValue(Crankset arg0, int arg1) {
				return arg0.getIdCrankset().toString();
			}

			@Override
			public Crankset getObject(String arg0, IModel<? extends List<? extends Crankset>> arg1) {
				return arg1.getObject().stream().filter(periCtrl -> periCtrl.getIdCrankset().equals(Integer.valueOf(arg0))).findFirst().get();
			}

		});
		
		sprocket = new DropDownChoice<>("sprocket", new Model<>(), sprokets, new IChoiceRenderer<Sproket>() {
			@Override
			public Object getDisplayValue(Sproket object) {
				String str = StringUtils.EMPTY;
				str += object.getName();
				str += " (";
				str += object.getSproketdetailCollection().stream().min((a, b) -> Integer.compare(a.getSproketDetailPK().getToothIndex(), b.getSproketDetailPK().getToothIndex())).get().getTooth();
				str += "-";
				str += object.getSproketdetailCollection().stream().max((a, b) -> Integer.compare(a.getSproketDetailPK().getToothIndex(), b.getSproketDetailPK().getToothIndex())).get().getTooth();
				str += ")";
				return str;
			}

			@Override
			public String getIdValue(Sproket arg0, int arg1) {
				return arg0.getIdSproket().toString();
			}

			@Override
			public Sproket getObject(String arg0, IModel<? extends List<? extends Sproket>> arg1) {
				return arg1.getObject().stream().filter(periCtrl -> periCtrl.getIdSproket().equals(Integer.valueOf(arg0))).findFirst().get();
			}

		});
		perimeter = new DropDownChoice<>("perimeter", new Model<>(), perimeters, new IChoiceRenderer<Perimeter>() {
			@Override
			public Object getDisplayValue(Perimeter object) {
				return object.getEtrto() + " (" + object.getFrench() + ")";
			}

			@Override
			public String getIdValue(Perimeter arg0, int arg1) {
				return arg0.getIdPerimeter().toString();
			}

			@Override
			public Perimeter getObject(String arg0, IModel<? extends List<? extends Perimeter>> arg1) {
				return arg1.getObject().stream().filter(periCtrl -> periCtrl.getIdPerimeter().equals(Integer.valueOf(arg0))).findFirst().get();
			}
		});

		final OnChangeAjaxBehavior behavior = new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
			}
		};

//		crankset.add(behavior);
//		sprocket.add(behavior);
//		perimeter.add(behavior);
//		cadence.add(behavior);
		form.add(crankset);
		form.add(sprocket);
		form.add(perimeter);
		form.add(cadence);
		add(form);

	}
}
