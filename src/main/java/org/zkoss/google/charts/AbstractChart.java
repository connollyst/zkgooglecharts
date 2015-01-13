package org.zkoss.google.charts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.google.charts.data.DataTable;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

/**
 * An abstract Google Chart element.
 *
 * @author Sean Connolly
 */
public abstract class AbstractChart extends XulElement {

	protected DataTable data = new DataTable();
	protected Map<String, String> options = new HashMap<String, String>();

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
		render(renderer, "chartData", data.toString());
		render(renderer, "chartOptions", options);
	}

}
