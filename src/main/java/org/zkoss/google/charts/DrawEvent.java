package org.zkoss.google.charts;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

/**
 * @author Sean Connolly
 */
public class DrawEvent extends Event {

	private static final String NAME = "doDraw";

	public DrawEvent(Component target, Object data) {
		super(NAME, target, data);
	}

}
