/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import org.apache.wicket.Page
import org.apache.wicket.RuntimeConfigurationType
import org.apache.wicket.protocol.http.WebApplication

/*

  @author kisiy
  Created on 2018/02/12
*/

class WicketApplication : WebApplication() {
    /**
     * @see org.apache.wicket.Application#init()
     */
    override fun init(): Unit {
        super.init()

		//レスポンスのエンコーディング設定
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8")
    }

    override fun getHomePage(): Class<out Page> {
        return HomePage::class.java
    }

    override fun getConfigurationType() : RuntimeConfigurationType {
        return super.getConfigurationType()
    }
}