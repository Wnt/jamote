package org.vaadin.jonni.jamote;

import org.vaadin.jonni.jamote.model.Status;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.shared.Registration;

public class VolumeDisplay extends Composite<H1> {
	private LatestStatusKeeper latestStatusKeeper;
	private Registration registration;

	public VolumeDisplay(LatestStatusKeeper  latestStatusKeeper) {
		this.latestStatusKeeper = latestStatusKeeper;
		getContent().getStyle().set("font-size", "70pt");
		updateVolumeDisplay();
	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);

		registration = latestStatusKeeper.addListener(() -> {
			attachEvent.getUI().access(() -> {
				updateVolumeDisplay();
			});
		});
	}

	@Override
	protected void onDetach(DetachEvent detachEvent) {
		super.onDetach(detachEvent);
		if (registration != null) {
			registration.remove();
		}
	}

	private void updateVolumeDisplay() {
		Status latestStatus = latestStatusKeeper.getLatestStatus();
		if (latestStatus != null) {
			getContent().setText(latestStatus.getActualVolume().getValue() + "dB");
		}
	}
}
