package org.zkoss.google.charts;

/**
 * <p>
 * Wrapper of the <a href= "https://developers.google.com/chart/interactive/docs/gallery/piechart">Pie Chart</a>
 * visualization provided in Google Charts.
 * </p>
 *
 * @author Sean Connolly
 */
public class PieChart extends GoogleCoreChart {

    private static final String IS_3D = "is3D";
    private static final String COLORS = "colors";

    public void set3D(boolean is3D) {
        setOption(IS_3D, Boolean.toString(is3D));
    }

    public void set2D(boolean is2D) {
        set3D(!is2D);
    }

    public boolean is3D() {
        return Boolean.valueOf((String) getOption(IS_3D, Boolean.FALSE));
    }

    public boolean is2D() {
        return !is3D();
    }

    public String[] getColors() {
        return getOption(COLORS, new String[0], String[].class);
    }

    public void setColors(String... colors) {
        setOption(COLORS, colors);
    }

}