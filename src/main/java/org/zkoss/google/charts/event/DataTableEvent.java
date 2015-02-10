package org.zkoss.google.charts.event;

import org.zkoss.util.Pair;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import java.util.List;

/**
 * @author Sean Connolly
 */
public class DataTableEvent extends Event {

	private final List<Pair<Integer, Integer>> coordinates;

	public DataTableEvent(String name, Component target, List<Pair<Integer, Integer>> coordinates) {
		super(name, target, coordinates);
		this.coordinates = coordinates;
	}

	public List<Pair<Integer, Integer>> getCoordinates() {
		return coordinates;
	}

}
