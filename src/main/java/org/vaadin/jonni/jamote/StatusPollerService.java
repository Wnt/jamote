package org.vaadin.jonni.jamote;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.ActualVolume;
import org.vaadin.jonni.jamote.model.Status;

@Service
public class StatusPollerService {
	private final RestTemplate restTemplate;
	private final LatestStatusKeeper latestStatusKeeper;
	private final Timer poller;
	private Timer screenOffScheduler;
	private Runtime rt;

	public StatusPollerService(@Autowired RestTemplate restTemplate, @Autowired LatestStatusKeeper latestStatusKeeper) {
		this.restTemplate = restTemplate;
		this.latestStatusKeeper = latestStatusKeeper;

		rt = Runtime.getRuntime();
		poller = new Timer();
		screenOffScheduler = new Timer();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
		startPolling();
	}

	public void startPolling() {
		poller.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Status status = restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/getStatus",
						Status.class);
				ActualVolume volume = status.getActualVolume();

				Status latestStatus = latestStatusKeeper.getLatestStatus();
				if (latestStatus == null
						|| latestStatus.getActualVolume().getValue().compareTo(volume.getValue()) != 0) {
					latestStatusKeeper.setLatestStatus(status);
					wakeupDisplay();
				}
			}
		}, 1, 200);
	}

	protected void wakeupDisplay() {
		try {
			System.out.println("Display wakeup");
			Process pr = rt.exec("/usr/sbin/mcetool -Don");
			int retVal = pr.waitFor();

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scheduleScreenOff();
		}
	}

	private void scheduleScreenOff() {
		screenOffScheduler.cancel();
		screenOffScheduler = new Timer();
		screenOffScheduler.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					System.out.println("Display off");
					rt.exec("/usr/sbin/mcetool -Doff");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 10000);
	}

}
