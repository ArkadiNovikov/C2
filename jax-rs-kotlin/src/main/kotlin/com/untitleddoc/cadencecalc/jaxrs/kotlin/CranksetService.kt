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

        val fc9k = Crankset("FC-9000", "Shimano", listOf(34, 50))
        list.add(fc9k)
        list.add(fc9k.copy(tooths = listOf(34, 50)))
        list.add(fc9k.copy(tooths = listOf(36, 52)))
        list.add(fc9k.copy(tooths = listOf(38, 52)))
        list.add(fc9k.copy(tooths = listOf(39, 53)))

        val fc6800 = Crankset("FC-6800", "Shimano", listOf(36, 46))
        list.add(fc6800)

        val ox901d = Crankset("OX901D", "Sugino", listOf(36, 48))
        list.add(ox901d)
        list.add(ox901d.copy(tooths = listOf(36, 48)))
        list.add(ox901d.copy(tooths = listOf(34, 48)))
        list.add(ox901d.copy(tooths = listOf(32, 48)))
        list.add(ox901d.copy(tooths = listOf(34, 46)))
        list.add(ox901d.copy(tooths = listOf(32, 46)))
        list.add(ox901d.copy(tooths = listOf(30, 46)))
        list.add(ox901d.copy(tooths = listOf(36, 44)))
        list.add(ox901d.copy(tooths = listOf(34, 44)))
        list.add(ox901d.copy(tooths = listOf(32, 44)))
        list.add(ox901d.copy(tooths = listOf(30, 44)))

        val alpina2tri = Crankset("ALPINA2 Triple", "Sugino", listOf(26, 36, 48))
        list.add(alpina2tri)
        list.add(alpina2tri.copy(tooths = listOf(26, 36, 46)))
        list.add(alpina2tri.copy(tooths = listOf(22, 33, 40)))

        val fcm91002 = Crankset("FC-M9100-2", "Shimano", listOf(28, 38))
        list.add(fcm91002)

        val smcrm95 = Crankset("FC-M9100-2", "Shimano", listOf(30))
        list.add(smcrm95)
        list.add(smcrm95.copy(tooths = listOf(32)))
        list.add(smcrm95.copy(tooths = listOf(34)))
        list.add(smcrm95.copy(tooths = listOf(36)))
        list.add(smcrm95.copy(tooths = listOf(38)))

        val force1 = Crankset("Force 1", "SRAM", listOf(38))
        list.add(force1)
        list.add(force1.copy(tooths = listOf(40)))
        list.add(force1.copy(tooths = listOf(42)))
        list.add(force1.copy(tooths = listOf(44)))
        list.add(force1.copy(tooths = listOf(46)))

        return list
    }
}