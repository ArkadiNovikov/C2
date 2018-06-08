/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*

  @author k-aki
  Created on 2018/06/03
*/

package com.untitleddoc.cadencecalc.jaxrs.models.kotlin

import java.io.Serializable
import kotlin.math.*

public data class Sproket(val name: String, val tooths: List<Double>) : Serializable {
    public fun displayValue(): String {
        return "$name (" + (round(tooths.first()*10)/10) + "-" + (round(tooths.last()*10)/10) + ")"
    }
}