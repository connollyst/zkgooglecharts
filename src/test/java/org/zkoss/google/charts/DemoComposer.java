package org.zkoss.google.charts;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.google.charts.data.ColumnRole;
import org.zkoss.google.charts.data.ColumnType;
import org.zkoss.google.charts.data.DataTable;
import org.zkoss.google.charts.data.FormattedValue;
import org.zkoss.google.charts.event.DataTableSelectionEvent;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * @author Sean Connolly
 */
public class DemoComposer {

    @Wire("#win")
    private Component base;
    @Wire("#pieChart")
    private PieChart pieChart;
    @Wire
    private Div chartArea;


    private final Random random = new Random();

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
    }

    public DataTable getSimpleDataModel() {
        DataTable data = new DataTable();
        data.addStringColumn("Task", "task");
        data.addNumberColumn("Hours per Day", "hours");
        data.addColumn(ColumnType.STRING, ColumnRole.TOOLTIP);
        data.addColumn(ColumnType.STRING, ColumnRole.STYLE);
        data.addRow("Work", 11, null, null);
        data.addRow("Eat", 2, "Hello world!", "opacity: 0.2");
        data.addRow("Commute", 2, null, "fill-color: #76A7FA");
        data.addRow("Watch TV", 2, "Hello world!", "color: #76A7FA");
        data.addRow("Sleep", new FormattedValue(7, "7.000"), null, "opacity: 0.7");
        return data;
    }

    public DataTable getTimelineDataModel() {
        DataTable data = new DataTable();
        data.addStringColumn("Title");
        data.addStringColumn("Name");
        data.addDateColumn("Start");
        data.addDateColumn("End");
        data.addRow("President", "Washington", getDate(1789, 3, 29), getDate(1797, 2, 3));
        data.addRow("President", "Adams", getDate(1797, 2, 3), getDate(1801, 2, 3));
        data.addRow("President", "Jefferson", getDate(1801, 2, 3), getDate(1809, 2, 3));
        return data;
    }

    private Date getDate(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    @Command
    public void addChart() {
        GoogleChart chart = randomChart();
        if (chart instanceof Timeline) {
            chart.setData(getTimelineDataModel());
        } else {
            chart.setData(getSimpleDataModel());
        }
        chart.setWidth("640");
        chart.setHeight("320");

        chart.addEventListener(GoogleChartEvents.ON_READY, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) {
                System.out.println("CHART READY");
            }
        });
        chart.addEventListener(GoogleChartEvents.ON_SELECT, new EventListener<DataTableSelectionEvent>() {
            @Override
            public void onEvent(DataTableSelectionEvent event) {
                System.out.println("CHART SELECTED: " + event.getSelections());
            }
        });
        chartArea.getChildren().clear();
        chartArea.appendChild(chart);
    }

    int chartcounter = random.nextInt(100);

    private GoogleChart randomChart() {

        chartcounter++;

        switch (chartcounter % 4) {
            case 0:
                return new PieChart();
            case 1:
                return new BarChart();
            case 2:
                return new ColumnChart();
            case 3:
                return new Timeline();
            default:
                throw new IllegalAccessError("You're gonna need a bigger boat.");
        }
    }

    @Command
    public void download() {
        Executions.sendRedirect(pieChart.getImageURI());
    }

}
