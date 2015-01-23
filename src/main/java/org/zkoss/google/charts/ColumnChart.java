package org.zkoss.google.charts;

/**
 * <p>
 * Wrapper of the <a href= "https://developers.google.com/chart/interactive/docs/gallery/barchart">Bar Chart</a>
 * visualization provided in Google Charts.
 * </p>
 *
 * @author Sean Connolly
 */
public class ColumnChart extends GoogleChart {

	private static final String COLORS = "colors";

	public String[] getColors() {
		Object colors = getOption(COLORS);
		if(colors == null) {
			return new String[0];
		}
		if(colors instanceof String[]) {
			return (String[])colors;
		}
		throw new IllegalStateException(COLORS + " should be a String[] but is a " + colors.getClass().getSimpleName());
	}

	public void setColors(String... colors) {
		setOption(COLORS, colors);
	}

}
