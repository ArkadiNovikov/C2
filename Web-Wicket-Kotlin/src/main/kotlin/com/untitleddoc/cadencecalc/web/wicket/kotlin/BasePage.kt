/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.mapper.parameter.PageParameters

/*

  @author k-aki
  Created on 2018/02/12
*/

public abstract class BasePage : WebPage {
    constructor() : super()
    constructor(parameters: PageParameters) : super(parameters)
}