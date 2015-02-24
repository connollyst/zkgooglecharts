package org.zkoss.google.charts.event;

import org.zkoss.json.JSONObject;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <strong>For internal use only.</strong>
 * </p>
 * <p>
 * An event listener for raw Google Chart events, pre-processing the JSON objects into row/col data pairs.
 * </p>
 *
 * @author Sean Connolly
 */
public final class DataTableEventListener implements EventListener<Event> {

    private final String eventName;

    public DataTableEventListener(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public void onEvent(Event event) {
        List<DataTableSelection> coords = new ArrayList<>();
        Object data = event.getData();
        if (data instanceof Object[]) {
            coords.addAll(getCoordinates((Object[]) data));
        } else {
            coords.add(getCoordinates(data));
        }
        Events.sendEvent(new DataTableSelectionEvent(eventName, event.getTarget(), coords));
    }

    private List<DataTableSelection> getCoordinates(Object[] data) {
        List<DataTableSelection> coords = new ArrayList<>();
        for (Object datum : data) {
            coords.add(getCoordinates(datum));
        }
        return coords;
    }

    private DataTableSelection getCoordinates(Object datum) {
        if (datum instanceof JSONObject) {
            return getCoordinates((JSONObject) datum);
        } else {
            throw new IllegalArgumentException("Expected JSONObject, got " + datum);
        }
    }

    private DataTableSelection getCoordinates(JSONObject json) {
        Integer row = getInteger(json, "row");
        Integer col = getInteger(json, "column");
        if (row == null && col == null) {
            throw new IllegalArgumentException("Expected 'row' and/or 'column', got " + json);
        }
        return new DataTableSelection(row, col);
    }

    private Integer getInteger(JSONObject json, String key) {
        Object value = json.get(key);
        if (value == null) {
            return null;
        }
        return Integer.valueOf(value.toString());
    }

}
