package org.zkoss.google.charts;

import org.zkoss.zk.ui.event.Events;

/**
 * @author Sean Connolly
 */
public class GoogleChartEvents {

	public static final String ON_ANIMATION_FINISH = "onAnimationFinish";
	public static final String ON_CLICK = Events.ON_CLICK;
	public static final String ON_ERROR = Events.ON_ERROR;
	public static final String ON_MOUSE_OVER = Events.ON_MOUSE_OVER;
	public static final String ON_MOUSE_OUT = Events.ON_MOUSE_OUT;
	public static final String ON_READY = "onReady";
	public static final String ON_SELECT = Events.ON_SELECT;

	// Events are intercepted internally and the event data pre-processed
	static final String INTERNAL = "Internal";
	static final String ON_MOUSE_OVER_INTERNAL = ON_MOUSE_OVER + INTERNAL;
	static final String ON_MOUSE_OUT_INTERNAL = ON_MOUSE_OUT + INTERNAL;
	static final String ON_SELECT_INTERNAL = ON_SELECT + INTERNAL;

}
