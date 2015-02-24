package org.zkoss.google.charts.event;

/**
 * @author Sean Connolly
 */
public class DataTableSelection {

	private final Integer row;
	private final Integer col;

	public DataTableSelection(Integer row, Integer col) {
		this.row = row;
		this.col = col;
	}

	public Integer getRow() {
		return row;
	}

	public Integer getColumn() {
		return col;
	}

}
