
package org.vaadin.jonni.jamote.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "response_code", "input", "play_queue_type", "playback", "repeat", "shuffle", "play_time",
		"total_time", "artist", "album", "track", "albumart_url", "albumart_id", "usb_devicetype", "auto_stopped",
		"attribute", "repeat_available", "shuffle_available" })
public class PlayInfo {

	@JsonProperty("response_code")
	private Integer responseCode;
	@JsonProperty("input")
	private String input;
	@JsonProperty("play_queue_type")
	private String playQueueType;
	@JsonProperty("playback")
	private String playback;
	@JsonProperty("repeat")
	private String repeat;
	@JsonProperty("shuffle")
	private String shuffle;
	@JsonProperty("play_time")
	private Integer playTime;
	@JsonProperty("total_time")
	private Integer totalTime;
	@JsonProperty("artist")
	private String artist;
	@JsonProperty("album")
	private String album;
	@JsonProperty("track")
	private String track;
	@JsonProperty("albumart_url")
	private String albumartUrl;
	@JsonProperty("albumart_id")
	private Integer albumartId;
	@JsonProperty("usb_devicetype")
	private String usbDevicetype;
	@JsonProperty("auto_stopped")
	private Boolean autoStopped;
	@JsonProperty("attribute")
	private Integer attribute;
	@JsonProperty("repeat_available")
	private List<Object> repeatAvailable = null;
	@JsonProperty("shuffle_available")
	private List<Object> shuffleAvailable = null;

	@JsonProperty("response_code")
	public Integer getResponseCode() {
		return responseCode;
	}

	@JsonProperty("response_code")
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	@JsonProperty("input")
	public String getInput() {
		return input;
	}

	@JsonProperty("input")
	public void setInput(String input) {
		this.input = input;
	}

	@JsonProperty("play_queue_type")
	public String getPlayQueueType() {
		return playQueueType;
	}

	@JsonProperty("play_queue_type")
	public void setPlayQueueType(String playQueueType) {
		this.playQueueType = playQueueType;
	}

	@JsonProperty("playback")
	public String getPlayback() {
		return playback;
	}

	@JsonProperty("playback")
	public void setPlayback(String playback) {
		this.playback = playback;
	}

	@JsonProperty("repeat")
	public String getRepeat() {
		return repeat;
	}

	@JsonProperty("repeat")
	public void setRepeat(String repeat) {
		this.repeat = repeat;
	}

	@JsonProperty("shuffle")
	public String getShuffle() {
		return shuffle;
	}

	@JsonProperty("shuffle")
	public void setShuffle(String shuffle) {
		this.shuffle = shuffle;
	}

	@JsonProperty("play_time")
	public Integer getPlayTime() {
		return playTime;
	}

	@JsonProperty("play_time")
	public void setPlayTime(Integer playTime) {
		this.playTime = playTime;
	}

	@JsonProperty("total_time")
	public Integer getTotalTime() {
		return totalTime;
	}

	@JsonProperty("total_time")
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	@JsonProperty("artist")
	public String getArtist() {
		return artist;
	}

	@JsonProperty("artist")
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@JsonProperty("album")
	public String getAlbum() {
		return album;
	}

	@JsonProperty("album")
	public void setAlbum(String album) {
		this.album = album;
	}

	@JsonProperty("track")
	public String getTrack() {
		return track;
	}

	@JsonProperty("track")
	public void setTrack(String track) {
		this.track = track;
	}

	@JsonProperty("albumart_url")
	public String getAlbumartUrl() {
		return albumartUrl;
	}

	@JsonProperty("albumart_url")
	public void setAlbumartUrl(String albumartUrl) {
		this.albumartUrl = albumartUrl;
	}

	@JsonProperty("albumart_id")
	public Integer getAlbumartId() {
		return albumartId;
	}

	@JsonProperty("albumart_id")
	public void setAlbumartId(Integer albumartId) {
		this.albumartId = albumartId;
	}

	@JsonProperty("usb_devicetype")
	public String getUsbDevicetype() {
		return usbDevicetype;
	}

	@JsonProperty("usb_devicetype")
	public void setUsbDevicetype(String usbDevicetype) {
		this.usbDevicetype = usbDevicetype;
	}

	@JsonProperty("auto_stopped")
	public Boolean getAutoStopped() {
		return autoStopped;
	}

	@JsonProperty("auto_stopped")
	public void setAutoStopped(Boolean autoStopped) {
		this.autoStopped = autoStopped;
	}

	@JsonProperty("attribute")
	public Integer getAttribute() {
		return attribute;
	}

	@JsonProperty("attribute")
	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	}

	@JsonProperty("repeat_available")
	public List<Object> getRepeatAvailable() {
		return repeatAvailable;
	}

	@JsonProperty("repeat_available")
	public void setRepeatAvailable(List<Object> repeatAvailable) {
		this.repeatAvailable = repeatAvailable;
	}

	@JsonProperty("shuffle_available")
	public List<Object> getShuffleAvailable() {
		return shuffleAvailable;
	}

	@JsonProperty("shuffle_available")
	public void setShuffleAvailable(List<Object> shuffleAvailable) {
		this.shuffleAvailable = shuffleAvailable;
	}

}
