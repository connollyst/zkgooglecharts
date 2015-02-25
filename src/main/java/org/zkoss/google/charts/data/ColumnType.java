package org.zkoss.google.charts.data;

/**
 * Enumeration of data types supported by Google Charts.
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
