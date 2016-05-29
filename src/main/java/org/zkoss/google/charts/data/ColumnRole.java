package org.zkoss.google.charts.data;

/**
 * <p>
 * A column role describes the purpose of the data in that column: for example, a column might hold data describing
 * tooltip text, data point annotations, or uncertainty indicators.
 * </p>
 * <p>
 * Refer to <a href="https://developers.google.com/chart/interactive/docs/roles">the official Google Charts documentation</a>.
 * </p>
 *
 * @author Sean Connolly
 */
public enum ColumnRole {

    ANNOTATION,

    ANNOTATION_TEXT,

    CERTAINTY,

    EMPHASIS,

    INTERVAL,

    SCOPE,

    STYLE,

    TOOLTIP;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
