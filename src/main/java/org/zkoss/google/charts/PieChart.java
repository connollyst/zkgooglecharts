package org.zkoss.google.charts;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.impl.XulElement;

/**
 * @author Sean Connolly
 */
public class PieChart extends XulElement {

	public void drawChart() {
		Events.sendEvent(this, new DrawEvent(this, "Hi"));
	}

}