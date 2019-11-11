/*
 * Copyright 2019 kisiy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.untitleddoc.cadencecalc.web.wicket.client;

import com.untitleddoc.cadencecalc.jaxrs.models.IC2Model;
import java.util.List;
import javax.ws.rs.ClientErrorException;

/**
 *
 * @author kisiy
 */
public interface IJaxrsClient {
	public List<? extends IC2Model> get() throws ClientErrorException;
}
