package com.untitleddoc.web.wicket;

import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter;
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
    private final DataForm form = new DataForm("input");

    private final List<Crankset> cranks;
    private final List<Sproket> sprokets;
    private final List<Perimeter> perimeters;

    private class DataForm extends Form<Void> {

        private static final long serialVersionUID = -7202353439631180225L;

        public DataForm(String id) {
            super(id);
        }

        public DataForm(String id, IModel<Void> model) {
            super(id, model);
        }
    }

    public HomePage(final PageParameters parameters) {
        super(parameters);

        final CranksetClient cranksetClient = new CranksetClient();
        final SproketClient sproketClient = new SproketClient();
        final PerimeterClient perimeterClient = new PerimeterClient();

        cranks = cranksetClient.getCrankset();
        sprokets = sproketClient.getSproket();
        perimeters = perimeterClient.getPerimeter();

        crankset = new DropDownChoice<>("crankset", new Model<>(), cranks, new IChoiceRenderer<Crankset>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getDisplayValue(Crankset object) {
                return object.getDisplayValue();
            }

            @Override
            public String getIdValue(Crankset arg0, int arg1) {
                return arg0.getName() + "." + arg0.getOuterGearTooth() + "." + arg0.getMiddleGearTooth() + "." + arg0.getInnerGearTooth();
            }

            @Override
            public Crankset getObject(String arg0, IModel<? extends List<? extends Crankset>> arg1) {
                return arg1.getObject().stream().filter(periCtrl
                        -> (periCtrl.getName() + "." + periCtrl.getOuterGearTooth() + "." + periCtrl.getMiddleGearTooth() + "." + periCtrl.getInnerGearTooth()).equals(arg0)).findFirst().get();
            }
        });

        sprocket = new DropDownChoice<>("sprocket", new Model<>(), sprokets, new IChoiceRenderer<Sproket>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getDisplayValue(Sproket object) {
                return object.getDisplayValue();
            }

            @Override
            public String getIdValue(Sproket arg0, int arg1) {
                return arg0.getName() + "." + arg0.getTooths().get(0) + "." + arg0.getTooths().get(arg0.getTooths().size() - 1);
            }

            @Override
            public Sproket getObject(String arg0, IModel<? extends List<? extends Sproket>> arg1) {
                return arg1.getObject().stream().filter(periCtrl
                        -> (periCtrl.getName() + "." + periCtrl.getTooths().get(0) + "." + periCtrl.getTooths().get(periCtrl.getTooths().size())).equals(arg0)).findFirst().get();
            }

        });

        perimeter = new DropDownChoice<>("perimeter", new Model<>(), perimeters, new IChoiceRenderer<Perimeter>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Object getDisplayValue(Perimeter object) {
                return object.getDisplayValue();
            }

            @Override
            public String getIdValue(Perimeter arg0, int arg1) {
                return arg0.getEtrto();
            }

            @Override
            public Perimeter getObject(String arg0, IModel<? extends List<? extends Perimeter>> arg1) {
                return arg1.getObject().stream().filter(periCtrl -> periCtrl.getEtrto().equals(arg0)).findFirst().get();
            }
        });

        final OnChangeAjaxBehavior behavior = new OnChangeAjaxBehavior() {
            private static final long serialVersionUID = 1L;

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
