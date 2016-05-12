package com.vaadin.addon.spreadsheet.charts.converter.confwriter;

/*
 * #%L
 * Vaadin Spreadsheet Charts Integration
 * %%
 * Copyright (C) 2016 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file license.html distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */

import com.vaadin.addon.charts.model.AbstractPlotOptions;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.Marker;
import com.vaadin.addon.charts.model.PlotOptionsArea;
import com.vaadin.addon.charts.model.Stacking;
import com.vaadin.addon.spreadsheet.charts.converter.Utils;
import com.vaadin.addon.spreadsheet.charts.converter.chartdata.AreaSeriesData;

public class AreaSeriesDataWriter extends AbstractSeriesDataWriter {

    public AreaSeriesDataWriter(AreaSeriesData series) {
        super(series);
    }

    @Override
    protected AreaSeriesData getSeriesData() {
        return (AreaSeriesData) super.getSeriesData();
    }

    @Override
    protected PlotOptionsArea getPlotOptions() {
        return (PlotOptionsArea) super.getPlotOptions();
    }

    @Override
    protected AbstractPlotOptions createPlotOptions() {
        return new PlotOptionsArea();
    }

    @Override
    protected void configureDataSeries(DataSeries dataSeriesForWriting) {
        super.configureDataSeries(dataSeriesForWriting);
        
        String stacking = getSeriesData().stacking.toString();

        getPlotOptions().setStacking(
                Utils.getEnumValueOrDefault(Stacking.class,
                        stacking, Stacking.NONE));

        getPlotOptions().setMarker(new Marker(false));
    }
}
