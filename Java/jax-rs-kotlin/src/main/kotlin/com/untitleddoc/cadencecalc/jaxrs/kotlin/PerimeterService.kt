/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.untitleddoc.cadencecalc.jaxrs.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter
import java.util.ArrayList
import jakarta.ejb.Stateless
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

/**
 *
 * @author Novikov
 */
@Path("perimeter")
class PerimeterService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getPerimeter(): List<Perimeter> {
        val list = mutableListOf<Perimeter>()

        list.add(Perimeter("23-622", "700*23C", 2096))
        list.add(Perimeter("25-622", "700*25C", 2105))
        list.add(Perimeter("28-622", "700*28C", 2136))
        list.add(Perimeter("25-584", "650*25B", 1991))
        list.add(Perimeter("28-584", "650*28B", 2010))
        list.add(Perimeter("40-584", "27.5*1.50", 2079))
        list.add(Perimeter("47-584", "650*47B", 2136))
        list.add(Perimeter("23-571", "650x23C", 1944))
        list.add(Perimeter("25-571", "650x25C", 1952))

        return list
    }
}