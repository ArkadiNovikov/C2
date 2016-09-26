/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Novikov
 */
@Path("perimeter")
@Stateless
public class PerimeterService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Perimeter> getPerimeter() {
        final List<Perimeter> list = new ArrayList<>();
        {
            final Perimeter item1 = new Perimeter("25-622", "700*25C", 2105);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter("28-622", "700*28C", 2136);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter("40-584", "27.5*1.50", 2079);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter("25-584", "650*25B", 1991);
            list.add(item1);
        }

        return list;
    }
}
