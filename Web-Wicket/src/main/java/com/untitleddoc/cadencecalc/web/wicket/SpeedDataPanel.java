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
package com.untitleddoc.cadencecalc.web.wicket;

import com.google.common.collect.Lists;
import com.untitleddoc.cadencecalc.jaxrs.models.Crankset;
import com.untitleddoc.cadencecalc.jaxrs.models.Perimeter;
import com.untitleddoc.cadencecalc.jaxrs.models.Sproket;
import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author Novikov
 */
public final class SpeedDataPanel extends Panel
{

	private static final long serialVersionUID = 1L;

	private final IModel<Crankset> modelCrank;
	private final IModel<Sproket> modelSproket;
	private final IModel<Perimeter> modelPerimeter;
	private final IModel<Integer> modelCadence;
	private final IModel<ArrayList<Double>> modelSproketTooths = new LoadableDetachableModel<ArrayList<Double>>()
	{
		private static final long serialVersionUID = SpeedDataPanel.serialVersionUID;

		@Override
		protected ArrayList<Double> load()
		{
			return Lists.newArrayList(modelSproket.getObject().getTooths());
		}
	};
	private final IModel<List<AbstractMap.SimpleEntry<Integer, List<Double>>>> modelDataTable = new LoadableDetachableModel<List<AbstractMap.SimpleEntry<Integer, List<Double>>>>()
	{
		private static final long serialVersionUID = SpeedDataPanel.serialVersionUID;

		@Override
		protected List<AbstractMap.SimpleEntry<Integer, List<Double>>> load()
		{
			final SpeedDataCalc data = new SpeedDataCalc(modelCrank.getObject(), modelSproket.getObject(), modelPerimeter.getObject(), modelCadence.getObject());
			final double[][] calcData = data.getResult();

			final List<AbstractMap.SimpleEntry<Integer, List<Double>>> result = new ArrayList<>();
			for (int i = 0; i < calcData.length; i++)
			{
				final Integer key = modelCrank.getObject().getTooths().get(i);
				final List<Double> value = new ArrayList<>(calcData[i].length);
				for (final double d : calcData[i])
				{
					value.add(d);
				}
				result.add(new AbstractMap.SimpleEntry<>(key, value));
			}
			return result;
		}
	};

	private final ListView<Double> headers;
	private final ListView<AbstractMap.SimpleEntry<Integer, List<Double>>> dataList;

	public SpeedDataPanel(final String id,
			final IModel<Crankset> modelCrank, final IModel<Sproket> modelSproket,
			final IModel<Perimeter> modelPerimeter, final IModel<Integer> modelCadence)
	{
		super(id);

		this.modelCrank = modelCrank;
		this.modelSproket = modelSproket;
		this.modelPerimeter = modelPerimeter;
		this.modelCadence = modelCadence;

		headers = new ListView<Double>("headers", modelSproketTooths)
		{
			private static final long serialVersionUID = SpeedDataPanel.serialVersionUID;

			@Override
			protected void populateItem(final ListItem<Double> item)
			{
				item.add(new Label("header", new BigDecimal(item.getModelObject()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue()).setOutputMarkupId(true));
			}
		};
		headers.setOutputMarkupId(true);
		add(headers);

		dataList = new ListView<AbstractMap.SimpleEntry<Integer, List<Double>>>("dataBodyRow", modelDataTable)
		{
			private static final long serialVersionUID = SpeedDataPanel.serialVersionUID;

			@Override
			protected void populateItem(final ListItem<AbstractMap.SimpleEntry<Integer, List<Double>>> item)
			{
				final AbstractMap.SimpleEntry<Integer, List<Double>> i = item.getModelObject();

				item.add(new Label("dataBodyRowHeader", i.getKey()));
				item.add(new ListView<Double>("dataBodyColum", i.getValue())
				{
					private static final long serialVersionUID = SpeedDataPanel.serialVersionUID;

					@Override
					protected void populateItem(final ListItem<Double> item)
					{
						item.add(new Label("dataBodyItem", item.getModelObject()));

					}
				});
			}
		};
		dataList.setOutputMarkupId(true);
		add(dataList);
	}

}
