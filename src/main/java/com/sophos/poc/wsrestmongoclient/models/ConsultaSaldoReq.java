package com.sophos.poc.wsrestmongoclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import org.springframework.validation.annotation.Validated;

@ApiModel(description = "Objeto que contiene los elementos del request")
@Validated
public class ConsultaSaldoReq {

	@JsonProperty("ID_TNR")
	private String id_trn = null;

	@JsonProperty("ACCOUNT_ID")
	private Integer account_id = null;

	@JsonProperty("ACCOUNT_TYPE")
	private String account_type = null;

	@JsonProperty("CARD_ID")
	private Integer card_id = null;

	@JsonProperty("PIN")
	private Integer pin = null;

	@JsonProperty("DATE")
	private Object date = null;

	@JsonProperty("CHANNEL")
	private String channel = null;

	public String getId_trn() {
		return id_trn;
	}

	public void setId_trn(String id_trn) {
		this.id_trn = id_trn;
	}

	public Integer getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Integer account_id) {
		this.account_id = account_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public Integer getCard_id() {
		return card_id;
	}

	public void setCard_id(Integer card_id) {
		this.card_id = card_id;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	

}
