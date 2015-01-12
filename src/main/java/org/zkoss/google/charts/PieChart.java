package org.zkoss.google.charts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

/**
 * @author Sean Connolly
 */
public class PieChart extends XulElement {

	private DataTable data = new DataTable();
	private Map<String, String> options = new HashMap<String, String>();

	public PieChart() {
		options.put("title", "Pudding");
		options.put("width", "800");
		options.put("height", "600");
	}

	public DataTable getData() {
		return data;
	}

	public void setData(String DataTable) {
		this.data = data;
		smartUpdate("chartData", this.data);
	}

	public String getOptions() {
		return options.toString();
	}

	public void setOptions(String options) {
		// this.options = options;
		smartUpdate("chartOptions", this.options);
	}

	@Override
	protected void renderProperties(ContentRenderer renderer)
			throws IOException {
		super.renderProperties(renderer);
		render(renderer, "chartData", data.toMap());
		render(renderer, "chartOptions", options);
	}

}