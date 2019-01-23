/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.untitleddoc.cadencecalc.jaxrs.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.kotlin.Sproket
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
@Path("sproket")
class SproketService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getSproket(): List<Sproket> {

        val list = mutableListOf<Sproket>()

        val cs6800 = Sproket("CS-6800", listOf(11.0, 12.0, 13.0, 14.0, 16.0, 18.0, 19.0, 20.0, 22.0, 25.0, 32.0).sorted())
        list.add(cs6800)
        list.add(cs6800.copy(tooths = listOf(11.0, 12.0, 13.0, 14.0, 15.0, 17.0, 19.0, 21.0, 23.0, 25.0, 28.0).sorted()))

        val cs6700 = Sproket("CS-6700", listOf(11.0, 12.0, 13.0, 14.0, 15.0, 17.0, 19.0, 21.0, 24.0, 28.0).sorted())
        list.add(cs6700)

        val cs4600 = Sproket("CS-6700", listOf(12.0, 13.0, 14.0, 15.0, 17.0, 19.0, 21.0, 24.0, 27.0, 30.0).sorted())
        list.add(cs4600)

        val cshg500 = Sproket("CS-HG500-10", listOf(12.0, 13.0, 14.0, 15.0, 17.0, 19.0, 21.0, 23.0, 25.0, 28.0).sorted())
        list.add(cshg500)
        list.add(cshg500.copy(tooths = listOf(11.0, 12.0, 14.0, 16.0, 18.0, 20.0, 22.0, 25.0, 28.0, 32.0).sorted()))
        list.add(cshg500.copy(tooths = listOf(11.0, 13.0, 15.0, 17.0, 19.0, 21.0, 23.0, 26.0, 30.0, 34.0).sorted()))

        val csm9k = Sproket("CS-M9000", listOf(11.0, 13.0, 15.0, 17.0, 19.0, 21.0, 24.0, 27.0, 31.0, 35.0, 40.0).sorted())
        list.add(csm9k)

        val csm9100_12 = Sproket("CS-M9100-12", listOf(10.0, 12.0, 14.0, 16.0, 18.0, 21.0, 24.0, 28.0, 32.0, 36.0, 40.0, 45.0).sorted())
        list.add(csm9100_12)
        list.add(csm9100_12.copy(tooths = listOf(10.0, 12.0, 14.0, 16.0, 18.0, 21.0, 24.0, 28.0, 33.0, 39.0, 45.0, 51.0).sorted()))

        val csm9100_11 = Sproket("CS-M9100-11", listOf(10.0, 12.0, 14.0, 16.0, 18.0, 21.0, 24.0, 28.0, 33.0, 39.0, 45.0).sorted())
        list.add(csm9100_11)

        val xg1180 = Sproket("XG-1180", listOf(10.0, 12.0, 14.0, 16.0, 18.0, 21.0, 24.0, 28.0, 32.0, 36.0, 42.0).sorted())
        list.add(xg1180)

        val xg1299 = Sproket("XG-1299 Eagle", listOf(10.0, 12.0, 14.0, 16.0, 18.0, 21.0, 24.0, 28.0, 32.0, 36.0, 42.0, 50.0).sorted())
        list.add(xg1299)

        var cogT = 13
        list.add(Sproket("SPEEDHUB 500/14 {$cogT}t", listOf(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467).sorted()))
        cogT = 15
        list.add(Sproket("SPEEDHUB 500/14 {$cogT}t", listOf(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467).sorted()))
        cogT = 16
        list.add(Sproket("SPEEDHUB 500/14 {$cogT}t", listOf(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467).sorted()))
        cogT = 17
        list.add(Sproket("SPEEDHUB 500/14 {$cogT}t", listOf(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467).sorted()))

        return list
    }
}