/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.jaxrs;

import java.util.Set;
import jakarta.ws.rs.core.Application;

/**
 *
 * @author Novikov
 */
@jakarta.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application
{

	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	/**
	 * Do not modify addRestResourceClasses() method. It is automatically
	 * populated with all resources defined in the project. If required, comment
	 * out calling this method in getClasses().
	 */
	private void addRestResourceClasses(Set<Class<?>> resources)
	{
		resources.add(com.untitleddoc.cadencecalc.jaxrs.CranksetService.class);
		resources.add(com.untitleddoc.cadencecalc.jaxrs.PerimeterService.class);
		resources.add(com.untitleddoc.cadencecalc.jaxrs.SproketService.class);
	}

}
