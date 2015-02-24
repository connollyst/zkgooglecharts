package org.zkoss.google.charts.event;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sean Connolly
 */
public class DataTableSelectionEvent extends Event {

	public DataTableSelectionEvent(String name, Component target, DataTableSelection selection) {
		this(name, target, Arrays.asList(selection));
	}

	public DataTableSelectionEvent(String name, Component target, List<DataTableSelection> selections) {
		super(name, target, selections);
	}

	@SuppressWarnings("unchecked")
	public List<DataTableSelection> getSelections() {
		return (List<DataTableSelection>)getData();
	}

	public DataTableSelection getSelection() {
		List<DataTableSelection> selections = getSelections();
		if(selections.isEmpty()) {
			return null;
		}
		if(selections.size() > 1) {
			throw new IllegalAccessError("Expected single selection, got " + selections.size());
		}
		return selections.get(0);
	}

}
