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
            final Perimeter item1 = new Perimeter();
            item1.setEtrto("25-622");
            item1.setFrench("700*25C");
            item1.setPerimeterValue(2105);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter();
            item1.setEtrto("28-622");
            item1.setFrench("700*28C");
            item1.setPerimeterValue(2136);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter();
            item1.setEtrto("40-584");
            item1.setFrench("27.5*1.50");
            item1.setPerimeterValue(2079);
            list.add(item1);
        }
        {
            final Perimeter item1 = new Perimeter();
            item1.setEtrto("25-584");
            item1.setFrench("650*25B");
            item1.setPerimeterValue(1991);
            list.add(item1);
        }

        return list;
    }
}
