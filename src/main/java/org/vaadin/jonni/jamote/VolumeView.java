package org.vaadin.jonni.jamote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.ActualVolume;
import org.vaadin.jonni.jamote.model.NetworkStatus;
import org.vaadin.jonni.jamote.model.Status;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

@Route("volume")
@Push
public class VolumeView extends VerticalLayout {
	public VolumeView(@Autowired RestTemplate restTemplate, @Autowired LatestStatusKeeper latestStatusKeeper) {
		NumberField stepField = new NumberField("Step size");
		stepField.setValue(10.0);

		Button plusButton = new Button("+", e -> {
			restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/setVolume?volume=up&step="
					+ stepField.getValue().intValue(), NetworkStatus.class);
			reportVolume(restTemplate);
		});
		Button minusButton = new Button("-", e -> {
			restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/setVolume?volume=down&step="
					+ stepField.getValue().intValue(), NetworkStatus.class);

			reportVolume(restTemplate);

		});

		add(new VolumeDisplay(latestStatusKeeper), stepField, plusButton, minusButton);
	}

	private void reportVolume(RestTemplate restTemplate) {
		Status status = restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/getStatus",
				Status.class);
		ActualVolume volume = status.getActualVolume();

		Notification.show("" + volume.getValue() + " dB");
	}
}
