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

	@Command
	public void openWindow() {
		System.out.println("Adding chart to " + base);
		BarChart chart = new BarChart();
		chart.setData(getSimpleDataModel());
		base.appendChild(chart);
	}

}
