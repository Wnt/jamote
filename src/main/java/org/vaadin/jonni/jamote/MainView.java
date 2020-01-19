package org.vaadin.jonni.jamote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.ActualVolume;
import org.vaadin.jonni.jamote.model.NetworkStatus;
import org.vaadin.jonni.jamote.model.Status;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@Push
public class MainView extends VerticalLayout {

	private H1 volume;
	private LatestStatusKeeper latestStatusKeeper;
	private Registration registration;

	public MainView(@Autowired RestTemplate restTemplate, @Autowired LatestStatusKeeper latestStatusKeeper) {
		this.latestStatusKeeper = latestStatusKeeper;
		NetworkStatus networkStatus = restTemplate
				.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/system/getNetworkStatus", NetworkStatus.class);

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

		Component h1 = new H2(networkStatus.getNetworkName());
		volume = new H1();
		volume.getStyle().set("font-size", "70pt");
		updateVolumeDisplay();
		add(h1, volume, stepField, plusButton, minusButton);

	}

	@Override
	protected void onAttach(AttachEvent attachEvent) {
		super.onAttach(attachEvent);

		registration = latestStatusKeeper.addListener(() -> {
			getUI().get().access(() -> {
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
			volume.setText(latestStatus.getActualVolume().getValue() + "dB");
		}
	}

	private void reportVolume(RestTemplate restTemplate) {
		Status status = restTemplate.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/main/getStatus",
				Status.class);
		ActualVolume volume = status.getActualVolume();

		Notification.show("" + volume.getValue() + " dB");
	}

}
