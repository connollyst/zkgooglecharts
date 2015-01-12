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

	private Map<String, Map<String, Object>> data = new HashMap<String, Map<String, Object>>();
	private Map<String, String> options = new HashMap<String, String>();

	public PieChart() {
		data.put("columns", new HashMap<String, Object>());
		data.put("rows", new HashMap<String, Object>());
		data.get("columns").put("string", "Filling");
		data.get("columns").put("number", "Pieces");
		data.get("rows").put("Custard", 20);
		data.get("rows").put("Chocolate", 50);
		data.get("rows").put("Meat", 3);
		options.put("title", "Pudding");
		options.put("width", "800");
		options.put("height", "600");
	}

	public String getData() {
		return data.toString();
	}

	public void setData(String data) {
		// this.data = data;
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
		render(renderer, "chartData", data);
		render(renderer, "chartOptions", options);
	}

}