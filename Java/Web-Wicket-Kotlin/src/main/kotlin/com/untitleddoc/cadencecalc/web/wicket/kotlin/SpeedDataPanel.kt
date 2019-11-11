/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.Crankset
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket
import java.math.BigDecimal
import java.math.RoundingMode
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.list.ListItem
import org.apache.wicket.markup.html.list.ListView
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel

/*

  @author kisiy
  Created on 2018/02/21
*/

class SpeedDataPanel(id: String, modelCrankset: IModel<Crankset>, modelSproket: IModel<Sproket>, modelPerimeter: IModel<Perimeter>, modelCadence: IModel<Int>): Panel(id) {
    private val modelCrankset: IModel<Crankset> = modelCrankset
    private val modelSproket: IModel<Sproket> = modelSproket
    private val modelPerimeter: IModel<Perimeter> = modelPerimeter
    private val modelCadence: IModel<Int> = modelCadence
    private val modelSproketTooths: IModel<List<Double>> = object : LoadableDetachableModel<List<Double>>() {
        override fun load(): List<Double>? = modelSproket.getObject().tooths
    }
    //Pair : Tupleの無いJavaではAbstractMap.SimpleEntry使ってた
    private val modelDataTable = object : LoadableDetachableModel<List<Pair<Int, List<Double>>>>() {
        override fun load(): List<Pair<Int, List<Double>>> {
            val data = SpeedDataCalc(modelCrankset.getObject().tooths, modelSproket.getObject().tooths, modelPerimeter.getObject().perimeterValue, modelCadence.getObject())
            val calcData = data.getResult()

            val result: MutableList<Pair<Int, List<Double>>> = mutableListOf()
            for (index in calcData.indices) {
                val key = modelCrankset.getObject().tooths[index]
                val row = calcData[index]

                result.add(Pair(key, row))
            }

            return result.toList()
        }
    }
    private val headers: ListView<Double> = object : ListView<Double>("headers", modelSproketTooths) {
        override protected fun populateItem(item: ListItem<Double>) {
            item.add(Label("header", BigDecimal(item.getModelObject()).setScale(1, RoundingMode.HALF_UP).toString()).setOutputMarkupId(true))
        }
    }
    private val dataList: ListView<Pair<Int, List<Double>>> = object : ListView<Pair<Int, List<Double>>>("dataBodyRow", modelDataTable) {
        override protected fun populateItem(item: ListItem<Pair<Int, List<Double>>>) {
            val i = item.getModelObject()
            item.add(Label("dataBodyRowHeader", i.first))
            item.add(object : ListView<Double>("dataBodyColum", i.second) {
                override protected fun populateItem(item: ListItem<Double>) {
                    item.add(Label("dataBodyItem", item.getModelObject()))
                }
            })
        }
    }

    init {
        headers.setOutputMarkupId(true)
        add(headers)
        dataList.setOutputMarkupId(true)
        add(dataList)
    }
}