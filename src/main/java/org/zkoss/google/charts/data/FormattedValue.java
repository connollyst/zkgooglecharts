package org.zkoss.google.charts.data;

/**
 * @author Sean Connolly
 */
public class FormattedValue {

	private final Object value;
	private final String format;

	public FormattedValue(Object value, String format) {
		this.value = value;
		this.format = format;
	}

	public Object getValue() {
		return value;
	}

	public String getFormat() {
		return format;
	}

}
