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

public data class Crankset(val name: String, val manufacture: String, val tooths: List<Int>): Serializable {
    public fun displayValue(): String = name + tooths.joinToString("-", " (", ")")
}