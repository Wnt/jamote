
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ready",
    "device_type",
    "child_num",
    "ch",
    "initial_join_running"
})
public class MusiccastNetwork {

    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("device_type")
    private String deviceType;
    @JsonProperty("child_num")
    private Integer childNum;
    @JsonProperty("ch")
    private Integer ch;
    @JsonProperty("initial_join_running")
    private Boolean initialJoinRunning;

    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @JsonProperty("device_type")
    public String getDeviceType() {
        return deviceType;
    }

    @JsonProperty("device_type")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonProperty("child_num")
    public Integer getChildNum() {
        return childNum;
    }

    @JsonProperty("child_num")
    public void setChildNum(Integer childNum) {
        this.childNum = childNum;
    }

    @JsonProperty("ch")
    public Integer getCh() {
        return ch;
    }

    @JsonProperty("ch")
    public void setCh(Integer ch) {
        this.ch = ch;
    }

    @JsonProperty("initial_join_running")
    public Boolean getInitialJoinRunning() {
        return initialJoinRunning;
    }

    @JsonProperty("initial_join_running")
    public void setInitialJoinRunning(Boolean initialJoinRunning) {
        this.initialJoinRunning = initialJoinRunning;
    }

}
