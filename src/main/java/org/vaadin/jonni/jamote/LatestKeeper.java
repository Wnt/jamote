package org.vaadin.jonni.jamote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.flow.shared.Registration;

public class LatestKeeper<K> {

	private K latestStatus = null;
	private List<StatusUpdateListener> listeners = new ArrayList<StatusUpdateListener>();

	public K getLatestStatus() {
		return latestStatus;
	}

	public void setLatestStatus(K latestStatus) {
		this.latestStatus = latestStatus;
		listeners.forEach((l) -> l.statusChanged());
	}

	public Registration addListener(StatusUpdateListener l) {
		listeners.add(l);
		return () -> listeners.remove(l);
	}
}
