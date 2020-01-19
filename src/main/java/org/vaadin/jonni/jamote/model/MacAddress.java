
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wired_lan",
    "wireless_lan",
    "wireless_direct"
})
public class MacAddress {

    @JsonProperty("wired_lan")
    private String wiredLan;
    @JsonProperty("wireless_lan")
    private String wirelessLan;
    @JsonProperty("wireless_direct")
    private String wirelessDirect;

    @JsonProperty("wired_lan")
    public String getWiredLan() {
        return wiredLan;
    }

    @JsonProperty("wired_lan")
    public void setWiredLan(String wiredLan) {
        this.wiredLan = wiredLan;
    }

    @JsonProperty("wireless_lan")
    public String getWirelessLan() {
        return wirelessLan;
    }

    @JsonProperty("wireless_lan")
    public void setWirelessLan(String wirelessLan) {
        this.wirelessLan = wirelessLan;
    }

    @JsonProperty("wireless_direct")
    public String getWirelessDirect() {
        return wirelessDirect;
    }

    @JsonProperty("wireless_direct")
    public void setWirelessDirect(String wirelessDirect) {
        this.wirelessDirect = wirelessDirect;
    }

}
