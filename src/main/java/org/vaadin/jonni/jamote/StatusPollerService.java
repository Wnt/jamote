package org.vaadin.jonni.jamote;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.ActualVolume;
import org.vaadin.jonni.jamote.model.PlayInfo;
import org.vaadin.jonni.jamote.model.Status;

@Service
public class StatusPollerService {
	private final RestTemplate restTemplate;
	private final LatestStatusKeeper latestStatusKeeper;
	private final Timer poller;
	private NowPlayingKeeper npKeeper;

	public StatusPollerService(@Autowired RestTemplate restTemplate, @Autowired LatestStatusKeeper latestStatusKeeper,
			@Autowired NowPlayingKeeper npKeeper) {
		this.restTemplate = restTemplate;
		this.latestStatusKeeper = latestStatusKeeper;
		this.npKeeper = npKeeper;

		poller = new Timer();

	}

	@EventListener(ApplicationReadyEvent.class)
	public void startPolling() {
		System.out.println("start polling STATUS");
		poller.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				try {
					pollStatus();
				} catch (RestClientException e) {
					System.err.println("Poll failed: " + e.getMessage());
				}
			}
		}, 1, 200);
	}

	private void pollStatus() {
		Status status = restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/getStatus",
				Status.class);
		ActualVolume volume = status.getActualVolume();

		Status latestStatus = latestStatusKeeper.getLatestStatus();
		if (latestStatus == null ||

				latestStatus.getActualVolume().getValue().compareTo(volume.getValue()) != 0

				||

				!latestStatus.getInput().equals(status.getInput())) {
			latestStatusKeeper.setLatestStatus(status);
			DisplayUtils.wakeupDisplay();
		}
		if (latestStatus != null && latestStatus.getInput().equals("spotify")) {
			updateNowPlaying();
		}
	}

	private void updateNowPlaying() {
		PlayInfo np = restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/netusb/getPlayInfo",
				PlayInfo.class);
		PlayInfo latest = npKeeper.getLatestStatus();
		if (np == null && latest != null || np != null && latest == null ||

				!np.getInput().equals(latest.getInput())

				||

				!np.getArtist().equals(latest.getArtist())

				||

				!np.getTrack().equals(latest.getTrack())

		) {
			npKeeper.setLatestStatus(np);
			DisplayUtils.wakeupDisplay();

		}
	}

}
