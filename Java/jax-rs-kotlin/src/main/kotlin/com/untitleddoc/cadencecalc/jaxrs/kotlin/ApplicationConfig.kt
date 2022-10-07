/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.untitleddoc.cadencecalc.jaxrs.kotlin

import jakarta.ws.rs.core.Application

/**
 *
 * @author Novikov
 */
@jakarta.ws.rs.ApplicationPath("webresources")
class ApplicationConfig : Application() {
    @Override
    public override fun getClasses() : Set<Class<*>>
    {
        val resources = java.util.HashSet<Class<*>>()
        addRestResourceClasses(resources)
        return resources
    }

    
    
    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private fun addRestResourceClasses(resources: MutableSet<Class<*>>) {
        resources.add(com.untitleddoc.cadencecalc.jaxrs.kotlin.CranksetService::class.java)
        resources.add(com.untitleddoc.cadencecalc.jaxrs.kotlin.PerimeterService::class.java)
        resources.add(com.untitleddoc.cadencecalc.jaxrs.kotlin.SproketService::class.java)
    }
}