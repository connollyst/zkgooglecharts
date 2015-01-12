package org.zkoss.google.charts;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sean Connolly
 */
public class DataTable {

	private Map<String, Map<String, Object>> data = new HashMap<String, Map<String, Object>>();

	public DataTable() {
		data.put("columns", new HashMap<String, Object>());
		data.put("rows", new HashMap<String, Object>());
		data.get("columns").put("string", "Filling");
		data.get("columns").put("number", "Pieces");
		data.get("rows").put("Custard", 20);
		data.get("rows").put("Chocolate", 50);
		data.get("rows").put("Meat", 3);
	}

	public Map<String, Map<String, Object>> toMap() {
		return data;
	}

}
