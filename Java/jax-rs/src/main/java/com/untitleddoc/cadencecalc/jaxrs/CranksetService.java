/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

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
import lombok.var;
import lombok.val;

/**
 *
 * @author Novikov
 */
@Path("crankset")
@Stateless
public class CranksetService
{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.untitleddoc.cadencecalc.jaxrs.models.Crankset> getCrankset()
	{
		final List<Crankset> list = new ArrayList<>();
		{
			val tooths = Arrays.asList(34, 50);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-9000", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(36, 52);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-9000", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(38, 52);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-9000", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(39, 53);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-9000", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(36, 46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-6800", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(36, 48);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(34, 48);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(32, 48);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(34, 46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(32, 46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(30, 46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(36, 44);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(34, 44);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(32, 44);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(30, 44);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("OX901D", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(26, 36, 48);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("ALPINA2 Triple", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(26, 36, 46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("ALPINA2 Triple", "Sugino", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(22, 33, 40);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-M9000-3", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(28, 38);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("FC-M9100-2", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(30);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(30);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(32);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(34);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(36);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(38);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("SM-CRM95", "Shimano", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(50,37);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Red AXS", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(48,35);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Red AXS", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(46,33);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Red AXS", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(43,30);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force AXS", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(38);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force 1", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(40);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force 1", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(42);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force 1", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(44);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force 1", "SRAM", tooths);
			list.add(item);
		}
		{
			val tooths = Arrays.asList(46);
			tooths.sort(Comparator.reverseOrder());
			val item = new Crankset("Force 1", "SRAM", tooths);
			list.add(item);
		}
		return list;
	}
}
