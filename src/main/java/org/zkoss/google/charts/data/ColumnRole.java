package org.zkoss.google.charts.data;

/**
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
