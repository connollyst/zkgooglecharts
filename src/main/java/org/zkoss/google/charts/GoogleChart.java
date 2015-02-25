package org.zkoss.google.charts;

import org.zkoss.google.charts.data.DataTable;
import org.zkoss.google.charts.event.DataTableEventListener;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.zkoss.google.charts.GoogleChartEvents.*;

/**
 * An abstract Google Chart element.
 *
 * @author Sean Connolly
 */
public abstract class GoogleChart extends XulElement {

    static {
        addClientEvent(GoogleChart.class, ON_ERROR, CE_DUPLICATE_IGNORE);
        addClientEvent(GoogleChart.class, ON_MOUSE_OVER_INTERNAL, CE_IMPORTANT);
        addClientEvent(GoogleChart.class, ON_MOUSE_OUT_INTERNAL, CE_IMPORTANT);
        addClientEvent(GoogleChart.class, ON_SELECT_INTERNAL, CE_IMPORTANT | CE_DUPLICATE_IGNORE);
    }

    {
        addEventListener(10000, ON_MOUSE_OVER_INTERNAL, new DataTableEventListener(ON_MOUSE_OVER));
        addEventListener(10000, ON_MOUSE_OUT_INTERNAL, new DataTableEventListener(ON_MOUSE_OUT));
        addEventListener(10000, ON_SELECT_INTERNAL, new DataTableEventListener(ON_SELECT));

    }

    private static final String HEIGHT = "height";
    private static final String WIDTH = "width";
    private static final String TITLE = "title";

    protected DataTable data = new DataTable();
    protected Map<String, Object> options = new HashMap<>();


    public DataTable getData() {
        return data;
    }

    public void setData(DataTable data) {
        this.data = data;
        smartUpdate("chartData", this.data);
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options.clear();
        this.options.putAll(options);
        smartUpdate("chartOptions", this.options);
    }

    public Object getOption(String name) {
        return options.get(name);
    }

    public Object getOption(String name, Object defaultValue) {
        Object value = options.get(name);
        return value != null ? value : defaultValue;
    }

    public <T> T getOption(String name, T defaultValue, Class<T> type) {
        Object value = options.get(name);
        if (value == null) {
            return defaultValue;
        }
        if (type.isInstance(value)) {
            return type.cast(value);
        }
        throw new IllegalStateException(name + " should be a " + type.getSimpleName() + " but is a "
                + value.getClass().getSimpleName());
    }

    public void setOption(String name, Object value) {
        // TODO smartUpdate single option for network efficiency
        options.put(name, value);
        smartUpdate("chartOptions", this.options);
    }

    @Override
    public void setHeight(String height) {
        super.setHeight(height);
        setOption(HEIGHT, height);
    }

    @Override
    public void setWidth(String width) {
        super.setWidth(width);
        setOption(WIDTH, width);
    }

    public void setTitle(String title) {
        setOption(TITLE, title);
    }

    @Override
    protected void renderProperties(ContentRenderer renderer) throws IOException {
        super.renderProperties(renderer);
        render(renderer, "chartData", data.toString());
        render(renderer, "chartOptions", options);
    }


}
