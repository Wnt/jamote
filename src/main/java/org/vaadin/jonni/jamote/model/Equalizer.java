
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
    "low",
    "mid",
    "high"
})
public class Equalizer {

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("low")
    private Integer low;
    @JsonProperty("mid")
    private Integer mid;
    @JsonProperty("high")
    private Integer high;

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("low")
    public Integer getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(Integer low) {
        this.low = low;
    }

    @JsonProperty("mid")
    public Integer getMid() {
        return mid;
    }

    @JsonProperty("mid")
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @JsonProperty("high")
    public Integer getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(Integer high) {
        this.high = high;
    }

}
