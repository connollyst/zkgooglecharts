package org.zkoss.google.charts;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import static org.zkoss.google.charts.GoogleChartEvents.ON_READY;

/**
 * @author Sean Connolly
 */
public abstract class GoogleCoreChart extends GoogleChart {

    static {
        addClientEvent(GoogleChart.class, ON_READY, CE_IMPORTANT);
    }

    {
        addEventListener(10000, ON_READY, new LoadListener());
    }

    private String imageURI;

    public String getImageURI() {
        return imageURI;
    }

    private final class LoadListener implements EventListener<Event> {

        @Override
        public void onEvent(Event event) {
            imageURI = event.getData().toString();
        }

    }
}
