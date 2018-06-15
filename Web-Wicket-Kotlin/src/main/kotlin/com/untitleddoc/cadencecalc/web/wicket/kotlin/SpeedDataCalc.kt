/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import java.math.BigDecimal

/*

  @author kisiy
  Created on 2018/02/21
*/

public data class SpeedDataCalc(val cranksetTooths: Iterable<Int>, val sproketTooths: Iterable<Double>, val perimeter: Int, var cadence: Int) {
    public fun getResult(): List<List<Double>> {
        var data: MutableList<List<Double>> = mutableListOf()

        for (crank in cranksetTooths) {
            var row = sproketTooths.map { BigDecimal(crank / it * cadence.toInt() * perimeter * 60 / 1000 / 1000).setScale(1, BigDecimal.ROUND_HALF_UP).toDouble() }
            data.add(row.toList())
        }

        return data
    }
}