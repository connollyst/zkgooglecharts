package org.zkoss.google.charts.data;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;

/**
 * @author Sean Connolly
 */
public class DataTable extends JSONObject {

	private static final String COLUMNS = "cols";
	private static final String ROWS = "rows";

	// TODO base off of GWT implementation:
	// http://gwt-google-apis.googlecode.com/svn/javadoc/visualization/1.1/com/google/gwt/visualization/client/AbstractDataTable.html

	// TODO implement like ZK Grid

	// TODO 'string', 'number', 'boolean', 'date', 'datetime', and 'timeofday'

	// TODO can we support compile time safety?

	// TODO we need to store as an ArrayList of ArrayLists so we can resize
	// properly

	private List<Column> columns = new ArrayList<Column>();
	private List<Row> rows = new ArrayList<Row>();

	@SuppressWarnings("unchecked")
	public DataTable() {
		put(COLUMNS, columns);
		put(ROWS, rows);
	}

	public Column addStringColumn(String label) {
		return addColumn("string", label);
	}

	public Column addNumberColumn(String label) {
		return addColumn("number", label);
	}

	public Column addBooleanColumn(String label) {
		return addColumn("boolean", label);
	}

	public Column addDateColumn(String label) {
		return addColumn("date", label);
	}

	public Column addDateTimeColumn(String label) {
		return addColumn("datetime", label);
	}

	public Column addTimeColumn(String label) {
		return addColumn("timeofday", label);
	}

	private Column addColumn(String type, String label) {
		Column column = new Column(type, label);
		columns.add(column);
		return column;
	}

	public Column addStringColumn(String label, String id) {
		return addColumn("string", label, id);
	}

	public Column addNumberColumn(String label, String id) {
		return addColumn("number", label, id);
	}

	public Column addBooleanColumn(String label, String id) {
		return addColumn("boolean", label, id);
	}

	public Column addDateColumn(String label, String id) {
		return addColumn("date", label, id);
	}

	public Column addDateTimeColumn(String label, String id) {
		return addColumn("datetime", label, id);
	}

	public Column addTimeColumn(String label, String id) {
		return addColumn("timeofday", label, id);
	}

	private Column addColumn(String type, String label, String id) {
		Column column = new Column(type, label, id);
		columns.add(column);
		return column;
	}

	public Row addRow() {
		Row row = new Row();
		rows.add(row);
		return row;
	}

	public Row addRow(int index) {
		Row row = new Row();
		rows.add(index, row);
		return row;
	}

	public Row addRow(Object... cells) {
		if (cells.length != columns.size()) {
			throw new IllegalArgumentException("Cannot add a row of "
					+ cells.length + " cells to a DataTable of "
					+ columns.size() + " columns.");
		}
		Row row = new Row();
		for (Object cell : cells) {
			if (cell instanceof FormattedValue) {
				row.addCell((FormattedValue) cell);
			} else {
				row.addCell(cell);
			}
		}
		rows.add(row);
		return row;
	}

	/**
	 * <p>
	 * A column of the {@link DataTable} contents.
	 * </p>
	 * <p>
	 * Serializes to an object of the JSON <a href=
	 * "https://developers.google.com/chart/interactive/docs/reference#dataparam"
	 * >{@code cols}</a> property.
	 * </p>
	 */
	public static final class Column extends JSONObject {

		private static final String TYPE = "type";
		private static final String LABEL = "label";
		private static final String ID = "id";
		private static final String PATTERN = "pattern";
		private static final String PROPERTIES = "p";

		/**
		 * @param type
		 *            A string describing the column data type. Same values as
		 *            type above.
		 * @param label
		 *            A label for the column.
		 */
		@SuppressWarnings("unchecked")
		public Column(String type, String label) {
			put(TYPE, type);
			put(LABEL, label);
		}

		/**
		 * @param type
		 *            A string describing the column data type. Same values as
		 *            type above.
		 * @param label
		 *            A label for the column.
		 * @param id
		 *            An ID for the column.
		 */
		@SuppressWarnings("unchecked")
		public Column(String type, String label, String id) {
			put(TYPE, type);
			put(LABEL, label);
			put(ID, id);
		}

		/**
		 * @param type
		 *            A string describing the column data type. Same values as
		 *            type above.
		 * @param label
		 *            A label for the column.
		 * @param id
		 *            An ID for the column.
		 * @param pattern
		 *            A number (or date) format string specifying how to display
		 *            the column value.
		 */
		@SuppressWarnings("unchecked")
		public Column(String type, String label, String id, String pattern) {
			put(TYPE, type);
			put(LABEL, label);
			put(ID, id);
			put(PATTERN, pattern);
		}

	}

	/**
	 * <p>
	 * A row of the {@link DataTable} contents.
	 * </p>
	 * <p>
	 * Serializes to an element of the JSON <a href=
	 * "https://developers.google.com/chart/interactive/docs/reference#rowsproperty"
	 * >{@code rows}</a> property.
	 * </p>
	 */
	public static final class Row extends JSONObject {

		private static final String CELLS = "c";
		private static final String PROPERTIES = "p";

		private final Cells cells = new Cells();

		@SuppressWarnings("unchecked")
		public Row() {
			put(CELLS, cells);
		}

		@SuppressWarnings("unchecked")
		public void addCell(Object value) {
			addCell(new Cell(value));
		}

		public void addCell(FormattedValue value) {
			addCell(value.getValue(), value.getFormat());
		}

		@SuppressWarnings("unchecked")
		public void addCell(Object value, String format) {
			addCell(new Cell(value, format));
		}

		@SuppressWarnings("unchecked")
		public void addCell(Cell cell) {
			cells.add(cell);
		}

	}

	public static final class Cells extends JSONArray {

	}

	/**
	 * <p>
	 * A cell of the {@link DataTable} contents.
	 * </p>
	 * <p>
	 * Serializes to an element of the JSON <a href=
	 * "https://developers.google.com/chart/interactive/docs/reference#cell_object"
	 * >{@code cell}</a> object.
	 * </p>
	 */
	public static final class Cell extends JSONObject {

		private static final String VALUE = "v";
		private static final String FORMAT = "f";
		private static final String PROPERTIES = "p";

		@SuppressWarnings("unchecked")
		public Cell(Object value) {
			put(VALUE, value);
		}

		@SuppressWarnings("unchecked")
		public Cell(Object value, String format) {
			put(VALUE, value);
			put(FORMAT, format);
		}

	}

}
