/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.IC2Model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior
import org.apache.wicket.markup.html.form.DropDownChoice
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.IChoiceRenderer
import org.apache.wicket.markup.html.form.NumberTextField
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import com.untitleddoc.cadencecalc.jaxrs.models.Crankset
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter

/*

  @author k-aki
  Created on 2018/02/12
*/

class HomePage : BasePage() {
    private val cranks: List<Crankset>
    private val sprokets: List<Sproket>
    private val perimeters: List<Perimeter>
    private val modelCrank: IModel<Crankset>
    private val modelSproket: IModel<Sproket>
    private val modelPerimeter: IModel<Perimeter>
    private val modelCadence: IModel<Int> = Model.of(80)
    private val inputDropDownCrankset: DropDownChoice<Crankset>
    private val inputDropDownSprocket: DropDownChoice<Sproket>
    private val inputDropDownPerimeter: DropDownChoice<Perimeter>
    private val inputCadence: NumberTextField<Int>
    private val form = Form<Void>("input")
    private val panelSpeedData: SpeedDataPanel

    private inner class DataForm : Form<Void> {
        constructor(id: String) : super(id)
        constructor(id: String, model: IModel<Void>) : super(id, model)
    }

    private inner class OnChangeLocalBehavior : OnChangeAjaxBehavior() {
        protected override fun onUpdate(target: AjaxRequestTarget) {
            target.add(panelSpeedData)
        }
    }

    private inner class C2ChoiceRenderer : IChoiceRenderer<IC2Model> {
        override fun getIdValue(obj: IC2Model, index: Int): String = obj.hashCode().toString()
        override fun getDisplayValue(obj: IC2Model): String = obj.displayValue()
        override fun getObject(id: String, choices: IModel<out MutableList<out IC2Model>>): IC2Model = choices.getObject().first { it.hashCode().toString() == id }
    }

    init {
        val cranksetClient = CranksetClient()
        val sproketClient = SproketClient()
        val perimeterClient = PerimeterClient()

        cranks = cranksetClient.getCrankset()
        sprokets = sproketClient.getSproket()
        perimeters = perimeterClient.getPerimeter()

        modelCrank = Model(cranks[0])
        modelSproket = Model(sprokets[0])
        modelPerimeter = Model(perimeters[0])
        inputCadence = NumberTextField<Int>("cadence", modelCadence)

        inputDropDownCrankset = DropDownChoice<Crankset>("crankset", modelCrank, cranks, C2ChoiceRenderer())
        inputDropDownSprocket = DropDownChoice("sprocket", modelSproket, sprokets, C2ChoiceRenderer())
        inputDropDownPerimeter = DropDownChoice("perimeter", modelPerimeter, perimeters, C2ChoiceRenderer())

        panelSpeedData = SpeedDataPanel("speedData", modelCrank, modelSproket, modelPerimeter, modelCadence)

        inputCadence.setMinimum(0)
        inputCadence.setMaximum(300)
        inputDropDownCrankset.add(OnChangeLocalBehavior())
        inputDropDownSprocket.add(OnChangeLocalBehavior())
        inputDropDownPerimeter.add(OnChangeLocalBehavior())
        inputCadence.add(OnChangeLocalBehavior())
        form.add(inputDropDownCrankset)
        form.add(inputDropDownSprocket)
        form.add(inputDropDownPerimeter)
        form.add(inputCadence)
        add(form)
        panelSpeedData.setOutputMarkupId(true)
        add(panelSpeedData)
    }

}