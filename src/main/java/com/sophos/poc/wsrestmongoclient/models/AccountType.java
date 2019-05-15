package com.sophos.poc.wsrestmongoclient.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

@Validated
public class AccountType {

	@JsonProperty("ACCOUNT_ID")
	private Integer account_id = null;

	@JsonProperty("ACCOUNT_TYPE")
	private String account_type = null;

	@JsonProperty("CARD_ID")
	private Integer card_id = null;

	@JsonProperty("PIN")
	private Integer pin = 0;

	@JsonProperty("ACCOUNT_BAL")
	private Integer account_bal = null;

	@JsonProperty("CURRENCY")
	private String currency = null;

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

	public Integer getAccount_bal() {
		return account_bal;
	}

	public void setAccount_bal(Integer account_bal) {
		this.account_bal = account_bal;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "{\"account_id\":" + account_id + ", \"account_type\":" + "\""+ account_type + "\""+ ", \"card_id\":" + card_id
				+ ", \"pin\":" + pin + ", \"account_bal\":" + account_bal + ", \"currency\":" + "\""+ currency + "\""+ "}";
	}
	
}
