/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.Crankset
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.LoadableDetachableModel

/*

  @author kisiy
  Created on 2018/02/21
*/

class SpeedDataPanel(id: String, modelCrankset: IModel<Crankset>, modelSproket: IModel<Sproket>, modelPerimeter: IModel<Perimeter>, modelCadence: IModel<Int>) : Panel(id) {
    companion object {
        @JvmStatic private val serialVersionUID: Long = 1L
    }

    private val modelCrankset: IModel<Crankset> = modelCrankset
    private val modelSproket: IModel<Sproket> = modelSproket
    private val modelPerimeter: IModel<Perimeter> = modelPerimeter
    private val modelCadence: IModel<Int> = modelCadence
    private val modelSproketTooths: IModel<List<Double>> = object : LoadableDetachableModel<List<Double>>() {
        override fun load(): List<Double>? = modelSproket.getObject().getTooths()
    }
    //Pair : Tupleの無いJavaではAbstractMap.SimpleEntry使ってた
    private val modelDataTable = object : LoadableDetachableModel<List<Pair<Int, List<Double>>>>() {
        override fun load(): List<Pair<Int, List<Double>>>
        {
            val data = SpeedDataCalc(modelCrankset.getObject(), modelSproket.getObject(), modelPerimeter.getObject(), modelCadence.getObject())
            val calcData = data.getResult()
            
            val result: MutableList<Pair<Int, List<Double>>> = mutableListOf()
            for(index in 0 until calcData.size)
            {
                val key = modelCrankset.getObject().getTooths()[index]
                val row = calcData[index]
                
                result.add(Pair(key, row))
            }
            
            return result.toList()
        }
    }

    init {
    }
}