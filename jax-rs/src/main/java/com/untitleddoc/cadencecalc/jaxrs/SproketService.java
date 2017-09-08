/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

import com.untitleddoc.cadencecalc.jaxrs.models.Sproket;
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
@Path("sproket")
@Stateless
public class SproketService
{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.untitleddoc.cadencecalc.jaxrs.models.Sproket> getSproket()
	{
		final List<Sproket> list = new ArrayList<>();
		{
			final Sproket item = new Sproket();
			item.setName("CS-6800");
			final List<Integer> tooths = Arrays.asList(11, 12, 13, 14, 16, 18, 19, 20, 22, 25, 32);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-6800");
			final List<Integer> tooths = Arrays.asList(11, 12, 13, 14, 15, 17, 19, 21, 23, 25, 28);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-6700");
			final List<Integer> tooths = Arrays.asList(11, 12, 13, 14, 15, 17, 19, 21, 24, 28);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-4600");
			final List<Integer> tooths = Arrays.asList(12, 13, 14, 15, 17, 19, 21, 24, 27, 30);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-HG500-10");
			final List<Integer> tooths = Arrays.asList(12, 13, 14, 15, 17, 19, 21, 23, 25, 28);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-HG500-10");
			final List<Integer> tooths = Arrays.asList(11, 12, 14, 16, 18, 20, 22, 25, 28, 32);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-HG500-10");
			final List<Integer> tooths = Arrays.asList(11, 13, 15, 17, 19, 21, 23, 26, 30, 34);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("CS-M9000");
			final List<Integer> tooths = Arrays.asList(11, 13, 15, 17, 19, 21, 24, 27, 31, 35, 40);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final Sproket item = new Sproket();
			item.setName("XG-1180");
			final List<Integer> tooths = Arrays.asList(10, 12, 14, 16, 18, 21, 24, 28, 32, 36, 42);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}

		return list;
	}
}
