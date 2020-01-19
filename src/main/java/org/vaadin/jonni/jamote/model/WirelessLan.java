
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ssid",
    "type",
    "key",
    "ch",
    "strength"
})
public class WirelessLan {

    @JsonProperty("ssid")
    private String ssid;
    @JsonProperty("type")
    private String type;
    @JsonProperty("key")
    private String key;
    @JsonProperty("ch")
    private Integer ch;
    @JsonProperty("strength")
    private Integer strength;

    @JsonProperty("ssid")
    public String getSsid() {
        return ssid;
    }

    @JsonProperty("ssid")
    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("ch")
    public Integer getCh() {
        return ch;
    }

    @JsonProperty("ch")
    public void setCh(Integer ch) {
        this.ch = ch;
    }

    @JsonProperty("strength")
    public Integer getStrength() {
        return strength;
    }

    @JsonProperty("strength")
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

}
