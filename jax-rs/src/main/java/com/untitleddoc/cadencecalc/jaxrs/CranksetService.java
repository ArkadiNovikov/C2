/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

import com.google.common.collect.Lists;
import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
@Path("crankset")
@Stateless
public class CranksetService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<com.untitleddoc.cadencecalc.jaxrs.models.Crankset> getCrankset() {
        final List<Crankset> list = new ArrayList<>();
        {
            final List<Integer> tooths = Arrays.asList(34, 50);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-9000", "Shimano", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(36, 52);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-9000", "Shimano", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(38, 52);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-9000", "Shimano", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(39, 53);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-9000", "Shimano", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(36, 46);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-6800", "Shimano", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(36, 48);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(34, 48);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(32, 48);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(34, 46);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(32, 46);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(30, 46);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(36, 44);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(34, 44);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(32, 44);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(30, 44);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("OX901D", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(26, 36, 48);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("ALPINA2 Triple", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(26, 36, 46);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("ALPINA2 Triple", "Sugino", tooths);
            list.add(item);
        }
        {
            final List<Integer> tooths = Arrays.asList(22, 33, 40);
			tooths.sort(Comparator.reverseOrder());
            final Crankset item = new Crankset("FC-M9000-3", "Shimano", tooths);
            list.add(item);
        }
        return list;
    }
}
