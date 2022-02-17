/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untitleddoc.cadencecalc.web.wicket.kotlin

import com.untitleddoc.cadencecalc.jaxrs.models.Sproket
import jakarta.ws.rs.client.Client
import jakarta.ws.rs.client.WebTarget
import jakarta.ws.rs.core.GenericType;

/*

  @author kisiy
  Created on 2018/02/21
*/

class SproketClient {
    private val client: Client
    private val webTarget: WebTarget
    private val BASE_URI = "http://localhost:8080/jax-rs-kotlin/webresources"

    constructor() {
        client = jakarta.ws.rs.client.ClientBuilder.newClient()
        webTarget = client.target(BASE_URI).path("sproket")
    }

    public fun getSproket() = webTarget.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get(object : GenericType<List<Sproket>>() {})
    public fun close() = client.close()
}