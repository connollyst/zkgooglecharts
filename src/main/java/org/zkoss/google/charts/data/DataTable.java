package org.zkoss.google.charts.data;

import org.zkoss.json.JSONArray;
import org.zkoss.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Wrapper of the <a href= "https://developers.google.com/chart/interactive/docs/reference#DataTable"
 * >google.visualization.DataTable</a> JavaScript class provided in Google Charts.
 * </p>
 *
 * @author Sean Connolly
 */
public class DataTable extends JSONObject {

    private static final String COLUMNS = "cols";
    private static final String ROWS = "rows";

    // TODO base off of GWT implementation:
    // http://gwt-google-apis.googlecode.com/svn/javadoc/visualization/1.1/com/google/gwt/visualization/client/AbstractDataTable.html

    // TODO implement like ZK Grid

    private List<Column> columns = new ArrayList<Column>();
    private List<Row> rows = new ArrayList<Row>();

    @SuppressWarnings("unchecked")
    public DataTable() {
        put(COLUMNS, columns);
        put(ROWS, rows);
    }

    /**
     * @return the number of columns in the table
     */
    public int getNumberOfColumns() {
        return columns.size();
    }

    /**
     * @return the number of rows in the table
     */
    public int getNumberOfRows() {
        return rows.size();
    }

    /**
     * Returns the value of the cell at the given row and column indexes.
     *
     * @param rowIndex    should be a number greater than or equal to zero, and less than the number of rows as returned by
     *                    the {@link #getNumberOfRows()} method.
     * @param columnIndex should be a number greater than or equal to zero, and less than the number of columns as
     *                    returned by the {@link #getNumberOfColumns()} method.
     * @return The type of the returned value depends on the column type (see {@link #getColumnType()}):
     * <ul>
     * <li>If the column type is {@code 'string'}, the value is a {@code String}.</li>
     * <li>If the column type is {@code 'number'}, the value is an {@code Integer}.</li>
     * <li>If the column type is {@code 'boolean'}, the value is a {@code Boolean}.</li>
     * <li>If the column type is {@code 'date'} or {@code 'datetime'}, the value is a {@code Date} object.</li>
     * <li>If the column type is {@code 'timeofday'}, the value is an array of four numbers: [hour, minute,
     * second, milliseconds].</li>
     * <li>If the column value is a {@code null} value, an exception is thrown.</li>
     * </ul>
     */
    public Object getValue(int rowIndex, int columnIndex) {
        return getRow(rowIndex).getCell(columnIndex).getValue();
    }

    /**
     * Sets the value of a cell. In addition to overwriting any existing cell value, this method will also clear out any
     * formatted value and properties for the cell.
     *
     * @param rowIndex    should be a number greater than or equal to zero, and less than the number of rows as returned by
     *                    the {@link #getNumberOfRows()} method.
     * @param columnIndex should be a number greater than or equal to zero, and less than the number of columns as
     *                    returned by the {@link #getNumberOfColumns()} method.
     * @param value       is the value assigned to the specified cell. The type of the returned value depends on the column
     *                    type (see {@link #getColumnType()}):
     *                    <ul>
     *                    <li>If the column type is {@code 'string'}, the value is a {@code String}.</li>
     *                    <li>If the column type is {@code 'number'}, the value is an {@code Integer}.</li>
     *                    <li>If the column type is {@code 'boolean'}, the value is a {@code Boolean}.</li>
     *                    <li>If the column type is {@code 'date'} or {@code 'datetime'}, the value is a {@code Date} object.</li>
     *                    <li>If the column type is {@code 'timeofday'}, the value is an array of four numbers: [hour, minute,
     *                    second, milliseconds].</li>
     *                    <li>If the column value is a {@code null} value, an exception is thrown.</li>
     *                    </ul>
     * @see setCell
     * @see setFormattedValue
     * @see setProperty
     * @see setProperties
     */
    public void setValue(int rowIndex, int columnIndex, Object value) {
        getRow(rowIndex).getCell(columnIndex).setValue(value);
    }

    public Column addStringColumn(String label) {
        return addColumn(ColumnType.STRING, label);
    }

    public Column addNumberColumn(String label) {
        return addColumn(ColumnType.NUMBER, label);
    }

    public Column addBooleanColumn(String label) {
        return addColumn(ColumnType.BOOLEAN, label);
    }

    public Column addDateColumn(String label) {
        return addColumn(ColumnType.DATE, label);
    }

    public Column addDateTimeColumn(String label) {
        return addColumn(ColumnType.DATETIME, label);
    }

    public Column addTimeColumn(String label) {
        return addColumn(ColumnType.TIMEOFDAY, label);
    }

    public Column addColumn(ColumnType type, String label) {
        Column column = new Column(type, label);
        columns.add(column);
        for (Row row : rows) {
            row.setCapacity(columns.size());
        }
        return column;
    }

    public Column addStringColumn(String label, String id) {
        return addColumn(ColumnType.STRING, label, id);
    }

    public Column addNumberColumn(String label, String id) {
        return addColumn(ColumnType.NUMBER, label, id);
    }

    public Column addBooleanColumn(String label, String id) {
        return addColumn(ColumnType.BOOLEAN, label, id);
    }

    public Column addDateColumn(String label, String id) {
        return addColumn(ColumnType.DATE, label, id);
    }

    public Column addDateTimeColumn(String label, String id) {
        return addColumn(ColumnType.DATETIME, label, id);
    }

    public Column addTimeColumn(String label, String id) {
        return addColumn(ColumnType.TIMEOFDAY, label, id);
    }

    public Column addColumn(ColumnType type, String label, String id) {
        Column column = new Column(type, label, id);
        columns.add(column);
        for (Row row : rows) {
            row.setCapacity(columns.size());
        }
        return column;
    }

    public Column addColumn(ColumnType type, ColumnRole role) {
        Column column = new Column(type, role);
        columns.add(column);
        for (Row row : rows) {
            row.setCapacity(columns.size());
        }
        return column;
    }

    public ColumnType getColumnType(int index) {
        return columns.get(index).getType();
    }

    public String getColumnLabel(int index) {
        return columns.get(index).getLabel();
    }

    public String getColumnId(int index) {
        return columns.get(index).getId();
    }

    public Row addRow() {
        Row row = new Row(getNumberOfColumns());
        rows.add(row);
        return row;
    }

    public Row addRow(int index) {
        Row row = new Row(getNumberOfColumns());
        rows.add(index, row);
        return row;
    }

    public Row addRow(Object... values) {
        if (values.length != getNumberOfColumns()) {
            throw new IllegalArgumentException("Cannot add a row of " + values.length + " cells to a DataTable of "
                    + columns.size() + " columns.");
        }
        Row row = new Row(getNumberOfColumns());
        for (int i = 0; i < values.length; i++) {
            Object value = values[i];
            if (value instanceof FormattedValue) {
                row.setValue(i, (FormattedValue) value);
            } else {
                row.setValue(i, value);
            }
        }
        rows.add(row);
        return row;
    }

    private Row getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= getNumberOfRows()) {
            throw new IndexOutOfBoundsException("rowIndex: " + rowIndex);
        }
        return rows.get(rowIndex);
    }

    /**
     * <p>
     * A column of the {@link DataTable} contents.
     * </p>
     * <p>
     * Serializes to an object of the JSON <a href=
     * "https://developers.google.com/chart/interactive/docs/reference#dataparam" >{@code cols}</a> property.
     * </p>
     */
    public static final class Column extends JSONObject {

        private static final String TYPE = "type";
        private static final String LABEL = "label";
        private static final String ID = "id";
        private static final String PATTERN = "pattern";
        private static final String ROLE = "role";
        private static final String PROPERTIES = "p";

        /**
         * @param type  The data type of the column.
         * @param label A label for the column.
         */
        @SuppressWarnings("unchecked")
        public Column(ColumnType type, String label) {
            put(TYPE, type.toString());
            put(LABEL, label);
        }

        /**
         * @param type  The data type of the column.
         * @param label A label for the column.
         * @param id    An ID for the column.
         */
        @SuppressWarnings("unchecked")
        public Column(ColumnType type, String label, String id) {
            put(TYPE, type.toString());
            put(LABEL, label);
            put(ID, id);
        }

        /**
         * @param type    The data type of the column.
         * @param label   A label for the column.
         * @param id      An ID for the column.
         * @param pattern A number (or date) format string specifying how to display the column value.
         */
        @SuppressWarnings("unchecked")
        public Column(ColumnType type, String label, String id, String pattern) {
            put(TYPE, type.toString());
            put(LABEL, label);
            put(ID, id);
            put(PATTERN, pattern);
        }

        /**
         * @param type The data type of the column.
         * @param role The role of the column.
         */
        public Column(ColumnType type, ColumnRole role) {
            put(TYPE, type.toString());
            put(ROLE, role.toString());
        }

        public ColumnType getType() {
            Object type = get(TYPE);
            return type != null ? ColumnType.fromString(type.toString()) : null;
        }

        public String getLabel() {
            Object label = get(LABEL);
            return label != null ? label.toString() : null;
        }

        public String getId() {
            Object id = get(ID);
            return id != null ? id.toString() : null;
        }
    }

    /**
     * <p>
     * A row of the {@link DataTable} contents.
     * </p>
     * <p>
     * Serializes to an element of the JSON <a href=
     * "https://developers.google.com/chart/interactive/docs/reference#rowsproperty" >{@code rows}</a> property.
     * </p>
     */
    private static final class Row extends JSONObject {

        private static final String CELLS = "c";
        private static final String PROPERTIES = "p";

        private final Cells cells = new Cells();

        @SuppressWarnings("unchecked")
        Row(int capacity) {
            put(CELLS, cells);
            cells.setCapacity(capacity);
        }

        @SuppressWarnings("unchecked")
        void setValue(int colIndex, Object value) {
            getCell(colIndex).setValue(value);
        }

        void setValue(int colIndex, FormattedValue value) {
            setValue(colIndex, value.getValue(), value.getFormat());
        }

        @SuppressWarnings("unchecked")
        void setValue(int colIndex, Object value, String format) {
            getCell(colIndex).setValue(value).setFormat(format);
        }

        Cell getCell(int columnIndex) {
            if (columnIndex < 0 || columnIndex >= cells.size()) {
                throw new IndexOutOfBoundsException("columnIndex: " + columnIndex);
            }
            return (Cell) cells.get(columnIndex);
        }

        void setCapacity(int capacity) {
            cells.setCapacity(capacity);
        }

    }

    private static final class Cells extends JSONArray {

        void setCapacity(int capacity) {
            // TODO efficiency
            while (size() < capacity) {
                add(new Cell(null));
            }
        }

    }

    /**
     * <p>
     * A cell of the {@link DataTable} contents.
     * </p>
     * <p>
     * Serializes to an element of the JSON <a href=
     * "https://developers.google.com/chart/interactive/docs/reference#cell_object" >{@code cell}</a> object.
     * </p>
     */
    private static final class Cell extends JSONObject {

        private static final String VALUE = "v";
        private static final String FORMAT = "f";
        private static final String PROPERTIES = "p";

        Cell(Object value) {
            setValue(value);
        }

        Cell(Object value, String format) {
            setValue(value);
            setFormat(format);
        }

        Object getValue() {
            return get(VALUE);
        }

        Cell setValue(Object value) {
            if (value instanceof Date) {
                value = ((Date) value).getTime();
            }
            put(VALUE, value);
            return this;
        }

        Cell setFormat(String format) {
            put(FORMAT, format);
            return this;
        }

    }

}
