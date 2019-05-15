package com.sophos.poc.wsrestmongoclient.models;

import java.util.Date;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Objeto que contiene los elementos del response")
@Validated
public class ConsultaSaldoRes{

	@JsonProperty("ID_TNR")
	private String id_trn = null;

	@JsonProperty("AUTH_CODE")
	private String auth_code = null;

	@JsonProperty("CHANNEL")
	private String channel = null;

	@JsonProperty("DATE")
	private Date date = null;

	@JsonProperty("SERVER_DATE")
	private Date server_date = null;

	@JsonProperty("STATUS")
	private StatusType status = null;

	@JsonProperty("ACCOUNT")
	private AccountType account = null;

	public String getId_trn() {
		return id_trn;
	}

	public void setId_trn(String id_trn) {
		this.id_trn = id_trn;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getServer_date() {
		return server_date;
	}

	public void setServer_date(Date server_date) {
		this.server_date = server_date;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public AccountType getAccount() {
		return account;
	}

	public void setAccount(AccountType account) {
		this.account = account;
	}

	
}
