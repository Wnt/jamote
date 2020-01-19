package org.vaadin.jonni.jamote;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.vaadin.jonni.jamote.model.Status;

import com.vaadin.flow.shared.Registration;

@Component
public class LatestStatusKeeper {

	private Status latestStatus = null;
	private List<StatusUpdateListener> listeners = new ArrayList<StatusUpdateListener>();

	public Status getLatestStatus() {
		return latestStatus;
	}

	public void setLatestStatus(Status latestStatus) {
		this.latestStatus = latestStatus;
		listeners.forEach((l) -> l.statusChanged());
	}

	public Registration addListener(StatusUpdateListener l) {
		listeners.add(l);
		return () -> listeners.remove(l);
	}
}
