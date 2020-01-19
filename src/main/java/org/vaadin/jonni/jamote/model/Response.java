package org.vaadin.jonni.jamote.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "response_code" })
public class Response {

	@JsonProperty("response_code")
	private Integer responseCode;

	@JsonProperty("response_code")
	public Integer getResponseCode() {
		return responseCode;
	}

	@JsonProperty("response_code")
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

}