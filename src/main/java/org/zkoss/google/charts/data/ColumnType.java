package org.zkoss.google.charts.data;

/**
 * Data type of the data in the column.
 *
 * @author Sean Connolly
 */
public enum ColumnType {

    STRING, NUMBER, BOOLEAN, DATE, DATETIME, TIMEOFDAY;

    public static ColumnType fromString(String string) {
        for (ColumnType type : values()) {
            if (type.toString().equals(string)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Not a valid ColumnType: " + string);
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
