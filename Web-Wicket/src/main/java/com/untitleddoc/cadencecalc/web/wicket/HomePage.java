package com.untitleddoc.cadencecalc.web.wicket;

import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter;
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@Slf4j
public class HomePage extends BasePage
{

	private static final long serialVersionUID = 1L;

	private final Model<Crankset> modelCrank;
	private final Model<Sproket> modelSproket;
	private final Model<Perimeter> modelPerimeter;
	private final Model<Integer> modelCadence = new Model<>(80);

	private final DropDownChoice<Crankset> inputDropDownCrankset;
	private final DropDownChoice<Sproket> inputDropDownSprocket;
	private final DropDownChoice<Perimeter> inputDropDownPerimeter;
	private final NumberTextField inputCadence = new NumberTextField("cadence", modelCadence);
	private final DataForm form = new DataForm("input");
	private final SpeedDataPanel panelSpeedData;

	private final List<Crankset> cranks;
	private final List<Sproket> sprokets;
	private final List<Perimeter> perimeters;

	private class DataForm extends Form<Void>
	{

		private static final long serialVersionUID = HomePage.serialVersionUID;

		public DataForm(final String id)
		{
			super(id);
		}

		public DataForm(final String id, final IModel<Void> model)
		{
			super(id, model);
		}
	}

	public HomePage()
	{
		super();

		final CranksetClient cranksetClient = new CranksetClient();
		final SproketClient sproketClient = new SproketClient();
		final PerimeterClient perimeterClient = new PerimeterClient();

		cranks = cranksetClient.getCrankset();
		sprokets = sproketClient.getSproket();
		perimeters = perimeterClient.getPerimeter();

		modelCrank = new Model<>(cranks.get(0));
		modelSproket = new Model<>(sprokets.get(0));
		modelPerimeter = new Model<>(perimeters.get(0));

		inputDropDownCrankset = new DropDownChoice<>("crankset", modelCrank, cranks, new IChoiceRenderer<Crankset>()
		{
			private static final long serialVersionUID = HomePage.serialVersionUID;

			@Override
			public Object getDisplayValue(Crankset object)
			{
				return object.displayValue();
			}

			@Override
			public String getIdValue(Crankset arg0, int arg1)
			{
				return String.valueOf(arg0.hashCode());
			}

			@Override
			public Crankset getObject(String arg0, IModel<? extends List<? extends Crankset>> arg1)
			{
				return arg1.getObject().stream().filter(x
						-> String.valueOf(x.hashCode()).equals(arg0)).findFirst().get();
			}
		});

		inputDropDownSprocket = new DropDownChoice<>("sprocket", modelSproket, sprokets, new IChoiceRenderer<Sproket>()
		{
			private static final long serialVersionUID = HomePage.serialVersionUID;

			@Override
			public Object getDisplayValue(Sproket object)
			{
				return object.displayValue();
			}

			@Override
			public String getIdValue(Sproket arg0, int arg1)
			{
				return String.valueOf(arg0.hashCode());
			}

			@Override
			public Sproket getObject(String arg0, IModel<? extends List<? extends Sproket>> arg1)
			{
				return arg1.getObject().stream().filter(x
						-> String.valueOf(x.hashCode()).equals(arg0)).findFirst().get();
			}

		});

		inputDropDownPerimeter = new DropDownChoice<>("perimeter", modelPerimeter, perimeters, new IChoiceRenderer<Perimeter>()
		{
			private static final long serialVersionUID = HomePage.serialVersionUID;

			@Override
			public Object getDisplayValue(Perimeter object)
			{
				return object.displayValue();
			}

			@Override
			public String getIdValue(Perimeter arg0, int arg1)
			{
				return String.valueOf(arg0.hashCode());
			}

			@Override
			public Perimeter getObject(String arg0, IModel<? extends List<? extends Perimeter>> arg1)
			{
				return arg1.getObject().stream().filter(x
						-> String.valueOf(x.hashCode()).equals(arg0)).findFirst().get();
			}
		});

		inputCadence.setMinimum(0);
		inputCadence.setMaximum(300);

		inputDropDownCrankset.add(new OnChangeLocalBehavior());
		inputDropDownSprocket.add(new OnChangeLocalBehavior());
		inputDropDownPerimeter.add(new OnChangeLocalBehavior());
		inputCadence.add(new OnChangeLocalBehavior());
		form.add(inputDropDownCrankset);
		form.add(inputDropDownSprocket);
		form.add(inputDropDownPerimeter);
		form.add(inputCadence);
		add(form);

		panelSpeedData = new SpeedDataPanel("speedData", modelCrank, modelSproket, modelPerimeter, modelCadence);
		panelSpeedData.setOutputMarkupId(true);
		add(panelSpeedData);
	}

	private final class OnChangeLocalBehavior extends OnChangeAjaxBehavior
	{

		private static final long serialVersionUID = HomePage.serialVersionUID;

		@Override
		protected void onUpdate(final AjaxRequestTarget target)
		{
			target.add(panelSpeedData);
		}
	}
}
