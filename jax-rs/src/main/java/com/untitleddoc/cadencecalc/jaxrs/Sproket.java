/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

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
@Path("sproket")
@Stateless
public class Sproket {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<com.untitleddoc.cadencecalc.jaxrs.models.Sproket> getSproket()
    {
        final List<com.untitleddoc.cadencecalc.jaxrs.models.Sproket> list = new ArrayList<>();
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Sproket item = new com.untitleddoc.cadencecalc.jaxrs.models.Sproket();
            item.setName("CS-M9000");
            final List<Integer> tooths = new ArrayList<>();
            tooths.add(11);
            tooths.add(13);
            tooths.add(15);
            tooths.add(17);
            tooths.add(19);
            tooths.add(21);
            tooths.add(24);
            tooths.add(27);
            tooths.add(31);
            tooths.add(35);
            tooths.add(40);
            item.setTooths(tooths);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Sproket item = new com.untitleddoc.cadencecalc.jaxrs.models.Sproket();
            item.setName("CS-6800");
            final List<Integer> tooths = new ArrayList<>();
            tooths.add(11);
            tooths.add(12);
            tooths.add(13);
            tooths.add(14);
            tooths.add(16);
            tooths.add(18);
            tooths.add(19);
            tooths.add(20);
            tooths.add(22);
            tooths.add(25);
            tooths.add(32);
            item.setTooths(tooths);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Sproket item = new com.untitleddoc.cadencecalc.jaxrs.models.Sproket();
            item.setName("CS-6800");
            final List<Integer> tooths = new ArrayList<>();
            tooths.add(11);
            tooths.add(12);
            tooths.add(13);
            tooths.add(14);
            tooths.add(15);
            tooths.add(17);
            tooths.add(19);
            tooths.add(21);
            tooths.add(23);
            tooths.add(25);
            tooths.add(38);
            item.setTooths(tooths);
            list.add(item);
        }
        
        return list;
    }
}
