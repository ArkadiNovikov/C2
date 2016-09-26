/*
 * Copyright 2016 Novikov.
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
package com.untitleddoc.web.wicket;

import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter;
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NonNull;

/**
 *
 * @author Novikov
 */
@Data
public class SpeedData
{

	@NonNull
	private final Crankset crankset;
	@NonNull
	private final Sproket sproket;
	@NonNull
	private final Perimeter perimeter;
	private final int cadence;

	public double[][] getResult()
	{
		final double[][] data = new double[crankset.getTooths().size()][];
		for (int i = 0; i < crankset.getTooths().size(); i++)
		{
			final double[] rowData = new double[sproket.getTooths().size()];
			final double crankTooth = crankset.getTooths().get(i);
			for (int j = 0; j < sproket.getTooths().size(); j++)
			{
				rowData[j]
						= new BigDecimal(crankTooth / sproket.getTooths().get(j) * cadence * perimeter.getPerimeterValue() * 60 / 1000 / 1000)
						.setScale(1, BigDecimal.ROUND_HALF_UP)
						.doubleValue();
			}
			data[i] = rowData;
		}

		return data;
	}

}
