
package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "response_code",
    "power",
    "sleep",
    "volume",
    "mute",
    "max_volume",
    "input",
    "distribution_enable",
    "direct",
    "enhancer",
    "equalizer",
    "balance",
    "subwoofer_volume",
    "bass_extension",
    "link_control",
    "link_audio_delay",
    "link_audio_quality",
    "disable_flags",
    "actual_volume"
})
public class Status {

    @JsonProperty("response_code")
    private Integer responseCode;
    @JsonProperty("power")
    private String power;
    @JsonProperty("sleep")
    private Integer sleep;
    @JsonProperty("volume")
    private Integer volume;
    @JsonProperty("mute")
    private Boolean mute;
    @JsonProperty("max_volume")
    private Integer maxVolume;
    @JsonProperty("input")
    private String input;
    @JsonProperty("distribution_enable")
    private Boolean distributionEnable;
    @JsonProperty("direct")
    private Boolean direct;
    @JsonProperty("enhancer")
    private Boolean enhancer;
    @JsonProperty("equalizer")
    private Equalizer equalizer;
    @JsonProperty("balance")
    private Integer balance;
    @JsonProperty("subwoofer_volume")
    private Integer subwooferVolume;
    @JsonProperty("bass_extension")
    private Boolean bassExtension;
    @JsonProperty("link_control")
    private String linkControl;
    @JsonProperty("link_audio_delay")
    private String linkAudioDelay;
    @JsonProperty("link_audio_quality")
    private String linkAudioQuality;
    @JsonProperty("disable_flags")
    private Integer disableFlags;
    @JsonProperty("actual_volume")
    private ActualVolume actualVolume;

    @JsonProperty("response_code")
    public Integer getResponseCode() {
        return responseCode;
    }

    @JsonProperty("response_code")
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("power")
    public String getPower() {
        return power;
    }

    @JsonProperty("power")
    public void setPower(String power) {
        this.power = power;
    }

    @JsonProperty("sleep")
    public Integer getSleep() {
        return sleep;
    }

    @JsonProperty("sleep")
    public void setSleep(Integer sleep) {
        this.sleep = sleep;
    }

    @JsonProperty("volume")
    public Integer getVolume() {
        return volume;
    }

    @JsonProperty("volume")
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    @JsonProperty("mute")
    public Boolean getMute() {
        return mute;
    }

    @JsonProperty("mute")
    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    @JsonProperty("max_volume")
    public Integer getMaxVolume() {
        return maxVolume;
    }

    @JsonProperty("max_volume")
    public void setMaxVolume(Integer maxVolume) {
        this.maxVolume = maxVolume;
    }

    @JsonProperty("input")
    public String getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(String input) {
        this.input = input;
    }

    @JsonProperty("distribution_enable")
    public Boolean getDistributionEnable() {
        return distributionEnable;
    }

    @JsonProperty("distribution_enable")
    public void setDistributionEnable(Boolean distributionEnable) {
        this.distributionEnable = distributionEnable;
    }

    @JsonProperty("direct")
    public Boolean getDirect() {
        return direct;
    }

    @JsonProperty("direct")
    public void setDirect(Boolean direct) {
        this.direct = direct;
    }

    @JsonProperty("enhancer")
    public Boolean getEnhancer() {
        return enhancer;
    }

    @JsonProperty("enhancer")
    public void setEnhancer(Boolean enhancer) {
        this.enhancer = enhancer;
    }

    @JsonProperty("equalizer")
    public Equalizer getEqualizer() {
        return equalizer;
    }

    @JsonProperty("equalizer")
    public void setEqualizer(Equalizer equalizer) {
        this.equalizer = equalizer;
    }

    @JsonProperty("balance")
    public Integer getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @JsonProperty("subwoofer_volume")
    public Integer getSubwooferVolume() {
        return subwooferVolume;
    }

    @JsonProperty("subwoofer_volume")
    public void setSubwooferVolume(Integer subwooferVolume) {
        this.subwooferVolume = subwooferVolume;
    }

    @JsonProperty("bass_extension")
    public Boolean getBassExtension() {
        return bassExtension;
    }

    @JsonProperty("bass_extension")
    public void setBassExtension(Boolean bassExtension) {
        this.bassExtension = bassExtension;
    }

    @JsonProperty("link_control")
    public String getLinkControl() {
        return linkControl;
    }

    @JsonProperty("link_control")
    public void setLinkControl(String linkControl) {
        this.linkControl = linkControl;
    }

    @JsonProperty("link_audio_delay")
    public String getLinkAudioDelay() {
        return linkAudioDelay;
    }

    @JsonProperty("link_audio_delay")
    public void setLinkAudioDelay(String linkAudioDelay) {
        this.linkAudioDelay = linkAudioDelay;
    }

    @JsonProperty("link_audio_quality")
    public String getLinkAudioQuality() {
        return linkAudioQuality;
    }

    @JsonProperty("link_audio_quality")
    public void setLinkAudioQuality(String linkAudioQuality) {
        this.linkAudioQuality = linkAudioQuality;
    }

    @JsonProperty("disable_flags")
    public Integer getDisableFlags() {
        return disableFlags;
    }

    @JsonProperty("disable_flags")
    public void setDisableFlags(Integer disableFlags) {
        this.disableFlags = disableFlags;
    }

    @JsonProperty("actual_volume")
    public ActualVolume getActualVolume() {
        return actualVolume;
    }

    @JsonProperty("actual_volume")
    public void setActualVolume(ActualVolume actualVolume) {
        this.actualVolume = actualVolume;
    }

}
