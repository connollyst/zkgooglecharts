package org.zkoss.google.charts.data;

/**
 * Enumeration of data types supported by Google Charts.
 *
 * @author Sean Connolly
 */
public enum ColumnType {
	STRING, NUMBER, BOOLEAN, DATE, DATETIME, TIMEOFDAY;

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}
