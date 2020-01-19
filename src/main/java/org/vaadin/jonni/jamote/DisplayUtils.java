package org.vaadin.jonni.jamote;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayUtils {
	private static Timer screenOffScheduler = new Timer();
	private static Runtime rt=Runtime.getRuntime();

	public static void wakeupDisplay() {
		try {
			System.out.println("Display wakeup");
			Process pr = rt.exec("/usr/sbin/mcetool -Don");
			int retVal = pr.waitFor();

		} catch (IOException | InterruptedException e) {
			if (!e.getMessage().contains("No such file or directory")) {
				e.printStackTrace();
			}
		} finally {
			scheduleScreenOff();
		}
	}

	public static void scheduleScreenOff() {
		screenOffScheduler.cancel();
		screenOffScheduler = new Timer();
		screenOffScheduler.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					System.out.println("Display off");
					rt.exec("/usr/sbin/mcetool -Doff");

				} catch (IOException e) {
					if (!e.getMessage().contains("No such file or directory")) {
						e.printStackTrace();
					}
				}
			}
		}, 10000);
	}
}
