package org.zkoss.google.charts;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import java.io.IOException;
import java.net.URL;

import org.json.JSONException;
import org.junit.Test;
import org.zkoss.google.charts.data.DataTable;
import org.zkoss.google.charts.data.FormattedValue;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author Sean Connolly
 */
public class DataTableTest {

	private static final boolean JSON_STRICT = false;

	@Test
	public void shouldSerializeToJSON() throws IOException, JSONException {
		// Given
		DataTable data = new DataTable();
		data.addStringColumn("Task", "task");
		data.addNumberColumn("Hours per Day", "hours");
		data.addRow("Work", 11);
		data.addRow("Eat", 2);
		data.addRow("Commute", 2);
		data.addRow("Watch TV", 2);
		data.addRow("Sleep", new FormattedValue(7, "7.000"));
		// When
		String json = data.toString();
		// Then
		assertEquals(load("example.json"), json, JSON_STRICT);
	}

	private String load(String name) throws IOException {
		URL url = Resources.getResource(name);
		return Resources.toString(url, Charsets.UTF_8);
	}

}
