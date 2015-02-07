package org.zkoss.google.charts;

import java.util.Collections;
import java.util.Map;

/**
 * <p>
 * Wrapper of the <a href= "https://developers.google.com/chart/interactive/docs/gallery/timeline">Timeline</a>
 * visualization provided in Google Charts.
 * </p>
 *
 * @author Sean Connolly
 */
public class Timeline extends GoogleChart {

    private static final String AVOID_OVERLAPPING_GRID_LINES = "avoidOverlappingGridLines";
    private static final String COLORS = "colors";
    private static final String ENABLE_INTERACTIVITY = "enableInteractivity";
    private static final String TIMELINE = "timeline";
    private static final String ROW_LABEL_STYLE = "rowLabelStyle";
    private static final String BAR_LABEL_STYLE = "barLabelStyle";
    private static final String COLOR_BY_ROW_LABEL = "colorByRowLabel";
    private static final String GROUP_BY_ROW_LABEL = "groupByRowLabel";
    private static final String SHOW_BAR_LABELS = "showBarLabels";
    private static final String SHOW_ROW_LABELS = "showRowLabels";
    private static final String SINGLE_COLOR = "singleColor";

    public String[] getColors() {
        return getOption(COLORS, new String[0], String[].class);
    }

    public void setColors(String... colors) {
        setOption(COLORS, colors);
    }

    public void setEnableInteractivity(boolean interactive) {
        setOption(ENABLE_INTERACTIVITY, interactive);
    }

    public void setAvoidOverlappingGridLines(boolean avoid) {
        setOption(AVOID_OVERLAPPING_GRID_LINES, avoid);
    }

    public void setRowLabelStyle(Map<String, String> css) {
        setTimelineOption(ROW_LABEL_STYLE, css);
    }

    public void setBarLabelStyle(Map<String, String> css) {
        setTimelineOption(BAR_LABEL_STYLE, css);
    }

    public void setColorByRowLabel(boolean color) {
        setTimelineOption(COLOR_BY_ROW_LABEL, color);
    }

    public void setGroupByRowLabel(boolean group) {
        setTimelineOption(GROUP_BY_ROW_LABEL, group);
    }

    public void setShowBarLabels(boolean show) {
        setTimelineOption(SHOW_BAR_LABELS, show);
    }

    public void setShowRowLabels(boolean show) {
        setTimelineOption(SHOW_ROW_LABELS, show);
    }

    public void setSingleColor(String color) {
        setTimelineOption(SINGLE_COLOR, color);
    }

    private Map<String, Object> getTimeline() {
        // TODO avoid unchecked assignment here
        return getOption(TIMELINE, Collections.emptyMap(), Map.class);
    }

    private void setTimeline(Map<String, Object> timeline) {
        setOption(TIMELINE, timeline);
    }

    private void setTimelineOption(String name, Object value) {
        Map<String, Object> timeline = getTimeline();
        timeline.put(name, value);
        setTimeline(timeline);
    }
}
