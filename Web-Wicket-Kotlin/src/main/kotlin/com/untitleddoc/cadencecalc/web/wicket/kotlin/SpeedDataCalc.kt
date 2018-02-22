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

/*

  @author kisiy
  Created on 2018/02/21
*/

public data class SpeedDataCalc(val crankset: Crankset, val sproket: Sproket, val perimeter: Perimeter, var cadence: Int = 0) {
    public fun getResult(): MutableList<MutableList<Double>>
    {
        var data: MutableList<MutableList<Double>> = mutableListOf()
        
        for(crank in crankset.getTooths())
		{
			var row = sproket.getTooths().map { BigDecimal(crank / it * cadence * perimeter.getPerimeterValue() * 60 / 1000 / 1000).setScale(1, BigDecimal.ROUND_HALF_UP).toDouble() }
            data.add(row.toMutableList())
        }
        
        return data
    }
}