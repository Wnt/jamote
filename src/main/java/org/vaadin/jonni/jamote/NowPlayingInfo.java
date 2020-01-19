package org.vaadin.jonni.jamote;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.PlayInfo;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class NowPlayingInfo extends Composite<VerticalLayout> {
	private NowPlayingKeeper npKeeper;
	private Registration npRegistration;
	private LatestStatusKeeper latestStatusKeeper;
	private Registration statusRegistration;

	public NowPlayingInfo(LatestStatusKeeper latestStatusKeeper, NowPlayingKeeper npKeeper) {

		this.latestStatusKeeper = latestStatusKeeper;
		this.npKeeper = npKeeper;
		updateDisplay();
	}

	private void updateDisplay() {
		getContent().removeAll();
		PlayInfo playInfo = npKeeper.getLatestStatus();
		String input = latestStatusKeeper.getLatestStatus().getInput();
		if (input.equals("spotify")) {
			getContent().add(new H2(StringUtils.capitalize(playInfo.getInput())), new H2(playInfo.getArtist()),
					new H2(playInfo.getTrack()));
		} else {

			getContent().add(new H2(StringUtils.capitalize(input)));
		}

	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);

		npRegistration = npKeeper.addListener(() -> {
			attachEvent.getUI().access(() -> {
				updateDisplay();
			});
		});
		statusRegistration = latestStatusKeeper.addListener(() -> {
			attachEvent.getUI().access(() -> {
				updateDisplay();
			});
		});
		
	}

	@Override
	protected void onDetach(DetachEvent detachEvent) {
		super.onDetach(detachEvent);
		if (npRegistration != null) {
			npRegistration.remove();
		}
		if(statusRegistration != null) {
			statusRegistration.remove();
		}
	}
}
