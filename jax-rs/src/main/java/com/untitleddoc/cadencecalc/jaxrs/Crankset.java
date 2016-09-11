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
@Path("crankset")
@Stateless
public class Crankset {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<com.untitleddoc.cadencecalc.jaxrs.models.Crankset> getCrankset()
    {
        final List<com.untitleddoc.cadencecalc.jaxrs.models.Crankset> list = new ArrayList<>();
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-9000");
            item.setInnerGearTooth(34);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(50);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-9000");
            item.setInnerGearTooth(36);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(52);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-9000");
            item.setInnerGearTooth(38);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(52);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-9000");
            item.setInnerGearTooth(39);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(53);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-6800");
            item.setInnerGearTooth(36);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(46);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("FC-M8000-3");
            item.setInnerGearTooth(22);
            item.setMiddleGearTooth(30);
            item.setOuterGearTooth(40);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(36);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(48);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(34);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(48);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(32);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(48);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(34);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(46);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(32);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(46);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(30);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(46);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(36);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(44);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(34);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(44);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(32);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(44);
            list.add(item);
        }
        {
            final com.untitleddoc.cadencecalc.jaxrs.models.Crankset item = new com.untitleddoc.cadencecalc.jaxrs.models.Crankset();
            item.setName("OX901D");
            item.setInnerGearTooth(30);
            item.setMiddleGearTooth(0);
            item.setOuterGearTooth(44);
            list.add(item);
        }
        return list;
    }
}
