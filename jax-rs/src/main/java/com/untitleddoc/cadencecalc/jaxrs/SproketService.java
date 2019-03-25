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
public class SproketService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sproket> getSproket() {
		final List<Sproket> list = new ArrayList<Sproket>();
		{
			final var item = new Sproket();
			item.setName("CS-6800");
			final var tooths = Arrays.asList(11d, 12d, 13d, 14d, 16d, 18d, 19d, 20d, 22d, 25d, 32d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-6800");
			final var tooths = Arrays.asList(11d, 12d, 13d, 14d, 15d, 17d, 19d, 21d, 23d, 25d, 28d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-6700");
			final var tooths = Arrays.asList(11d, 12d, 13d, 14d, 15d, 17d, 19d, 21d, 24d, 28d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-4600");
			final var tooths = Arrays.asList(12d, 13d, 14d, 15d, 17d, 19d, 21d, 24d, 27d, 30d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-HG500-10");
			final var tooths = Arrays.asList(12d, 13d, 14d, 15d, 17d, 19d, 21d, 23d, 25d, 28d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-HG500-10");
			final var tooths = Arrays.asList(11d, 12d, 14d, 16d, 18d, 20d, 22d, 25d, 28d, 32d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-HG500-10");
			final var tooths = Arrays.asList(11d, 13d, 15d, 17d, 19d, 21d, 23d, 26d, 30d, 34d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-M9000");
			final var tooths = Arrays.asList(11d, 13d, 15d, 17d, 19d, 21d, 24d, 27d, 31d, 35d, 40d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-M9100-12");
			final var tooths = Arrays.asList(10d, 12d, 14d, 16d, 18d, 21d, 24d, 28d, 32d, 36d, 40d, 45d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-M9100-12");
			final var tooths = Arrays.asList(10d, 12d, 14d, 16d, 18d, 21d, 24d, 28d, 33d, 39d, 45d, 51d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("CS-M9100-11");
			final var tooths = Arrays.asList(10d, 12d, 14d, 16d, 18d, 21d, 24d, 28d, 33d, 39d, 45d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("Red AXS");
			final var tooths = Arrays.asList(10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 19d, 21d, 23d, 26d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("Red AXS");
			final var tooths = Arrays.asList(10d, 11d, 12d, 13d, 14d, 15d, 16d, 17d, 19d, 21d, 24d, 28d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("Red AXS");
			final var tooths = Arrays.asList(10d, 11d, 12d, 13d, 14d, 15d, 17d, 19d, 21d, 24d, 28d, 33d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("XG-1180");
			final var tooths = Arrays.asList(10d, 12d, 14d, 16d, 18d, 21d, 24d, 28d, 32d, 36d, 42d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var item = new Sproket();
			item.setName("XG-1299 Eagle");
			final var tooths = Arrays.asList(10d, 12d, 14d, 16d, 18d, 21d, 24d, 28d, 32d, 36d, 42d, 50d);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var cogT = 13;
			final var item = new Sproket();
			item.setName("SPEEDHUB 500/14 " + cogT + "t");
			final var tooths = Arrays.asList(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var cogT = 15;
			final var item = new Sproket();
			item.setName("SPEEDHUB 500/14 " + cogT + "t");
			final var tooths = Arrays.asList(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var cogT = 16;
			final var item = new Sproket();
			item.setName("SPEEDHUB 500/14 " + cogT + "t");
			final var tooths = Arrays.asList(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}
		{
			final var cogT = 17;
			final var item = new Sproket();
			item.setName("SPEEDHUB 500/14 " + cogT + "t");
			final var tooths = Arrays.asList(cogT / 0.279, cogT / 0.316, cogT / 0.360, cogT / 0.409, cogT / 0.464, cogT / 0.528, cogT / 0.600, cogT / 0.682, cogT / 0.774, cogT / 0.881, cogT / 1.000, cogT / 1.135, cogT / 1.292, cogT / 1.467);
			tooths.sort(Comparator.naturalOrder());
			item.setTooths(tooths);
			list.add(item);
		}

		return list;
	}
}
