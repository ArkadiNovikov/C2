/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.untitleddoc.cadencecalc.jaxrs.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.kotlin.Crankset
import java.util.Comparator
import javax.ejb.Stateless
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 *
 * @author Novikov
 */
@Path("crankset")
class CranksetService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getCrankset(): List<Crankset> {

        val list = mutableListOf<Crankset>()

        val fc9k = Crankset("FC-9000", "Shimano", listOf(34, 50).sortedDescending())
        list.add(fc9k)
        list.add(fc9k.copy(tooths = listOf(36, 52).sortedDescending()))
        list.add(fc9k.copy(tooths = listOf(38, 52).sortedDescending()))
        list.add(fc9k.copy(tooths = listOf(39, 53).sortedDescending()))

        val fc6800 = Crankset("FC-6800", "Shimano", listOf(36, 46).sortedDescending())
        list.add(fc6800)

        val ox901d = Crankset("OX901D", "Sugino", listOf(36, 48).sortedDescending())
        list.add(ox901d)
        list.add(ox901d.copy(tooths = listOf(34, 48).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(32, 48).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(34, 46).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(32, 46).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(30, 46).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(36, 44).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(34, 44).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(32, 44).sortedDescending()))
        list.add(ox901d.copy(tooths = listOf(30, 44).sortedDescending()))

        val alpina2tri = Crankset("ALPINA2 Triple", "Sugino", listOf(26, 36, 48).sortedDescending())
        list.add(alpina2tri)
        list.add(alpina2tri.copy(tooths = listOf(26, 36, 46).sortedDescending()))
        list.add(alpina2tri.copy(tooths = listOf(22, 33, 40).sortedDescending()))

        val fcm91002 = Crankset("FC-M9100-2", "Shimano", listOf(28, 38).sortedDescending())
        list.add(fcm91002)

        val smcrm95 = Crankset("SM-CRM95", "Shimano", listOf(30).sortedDescending())
        list.add(smcrm95)
        list.add(smcrm95.copy(tooths = listOf(32).sortedDescending()))
        list.add(smcrm95.copy(tooths = listOf(34).sortedDescending()))
        list.add(smcrm95.copy(tooths = listOf(36).sortedDescending()))
        list.add(smcrm95.copy(tooths = listOf(38).sortedDescending()))

        val force1 = Crankset("Force 1", "SRAM", listOf(38).sortedDescending())
        list.add(force1)
        list.add(force1.copy(tooths = listOf(40).sortedDescending()))
        list.add(force1.copy(tooths = listOf(42).sortedDescending()))
        list.add(force1.copy(tooths = listOf(44).sortedDescending()))
        list.add(force1.copy(tooths = listOf(46).sortedDescending()))

        return list
    }
}