package org.zkoss.google.charts;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.google.charts.data.DataTable;
import org.zkoss.google.charts.data.FormattedValue;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Sean Connolly
 */
public class DemoComposer {

    @Wire("#win")
    private Window base;

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
    }

    public DataTable getSimpleDataModel() {
        DataTable data = new DataTable();
        data.addStringColumn("Task", "task");
        data.addNumberColumn("Hours per Day", "hours");
        data.addRow("Work", 11);
        data.addRow("Eat", 2);
        data.addRow("Commute", 2);
        data.addRow("Watch TV", 2);
        data.addRow("Sleep", new FormattedValue(7, "7.000"));
        return data;
    }

    public DataTable getTimelineDataModel() {
        DataTable data = new DataTable();
        data.addStringColumn("Term");
        data.addStringColumn("Name");
        data.addDateColumn("Start");
        data.addDateColumn("End");
        data.addRow(1, "Washington", getDate(1789, 3, 29), getDate(1797, 2, 3));
        data.addRow(2, "Adams", getDate(1797, 2, 3), getDate(1801, 2, 3));
        data.addRow(3, "Jefferson", getDate(1801, 2, 3), getDate(1809, 2, 3));
        return data;
    }

    private Date getDate(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    @Command
    public void openWindow() {
        System.out.println("Adding chart to " + base);
        BarChart chart = new BarChart();
        chart.setData(getSimpleDataModel());
        base.appendChild(chart);
    }

}
