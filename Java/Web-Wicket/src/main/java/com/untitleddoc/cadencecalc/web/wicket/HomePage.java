package com.untitleddoc.cadencecalc.web.wicket;

import com.untitleddoc.cadencecalc.web.wicket.client.CranksetClient;
import com.untitleddoc.cadencecalc.web.wicket.client.PerimeterClient;
import com.untitleddoc.cadencecalc.web.wicket.client.SproketClient;
import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import com.untitleddoc.cadencecalc.jaxrs.models.IC2Model;
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

		final var cranksetClient = new CranksetClient();
		final var sproketClient = new SproketClient();
		final var perimeterClient = new PerimeterClient();

		cranks = cranksetClient.get();
		sprokets = sproketClient.get();
		perimeters = perimeterClient.get();

		modelCrank = new Model<>(cranks.get(0));
		modelSproket = new Model<>(sprokets.get(0));
		modelPerimeter = new Model<>(perimeters.get(0));

		inputDropDownCrankset = new DropDownChoice<>("crankset", modelCrank, cranks, new C2ChoiceRenderer());
		inputDropDownSprocket = new DropDownChoice<>("sprocket", modelSproket, sprokets, new C2ChoiceRenderer());
		inputDropDownPerimeter = new DropDownChoice<>("perimeter", modelPerimeter, perimeters, new C2ChoiceRenderer());

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

	private final class C2ChoiceRenderer implements IChoiceRenderer<IC2Model>
	{

		@Override
		public Object getDisplayValue(IC2Model object) {
			return object.displayValue();
		}

		@Override
		public String getIdValue(IC2Model object, int index) {
			return String.valueOf(object.hashCode());
		}

		@Override
		public IC2Model getObject(String id, IModel<? extends List<? extends IC2Model>> choices) {
			return choices.getObject().stream().filter(x -> String.valueOf(x.hashCode()).equals(id)).findFirst().get();
		}
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
