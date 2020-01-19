package org.vaadin.jonni.jamote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.vaadin.jonni.jamote.model.NetworkStatus;
import org.vaadin.jonni.jamote.model.PlayInfo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Theme(value = Lumo.class, variant = Lumo.DARK)
@Push
public class MainView extends VerticalLayout {

	public MainView(

			@Autowired RestTemplate restTemplate,

			@Autowired LatestStatusKeeper latestStatusKeeper,

			@Autowired NowPlayingKeeper nowPlayingKeeper) {
		NetworkStatus networkStatus = restTemplate
				.getForObject("http://10.0.0.41/YamahaExtendedControl/v1/system/getNetworkStatus", NetworkStatus.class);

		Component h1 = new H2(networkStatus.getNetworkName());
		add(h1, new NowPlayingInfo(latestStatusKeeper, nowPlayingKeeper), new VolumeDisplay(latestStatusKeeper));

	}

}
