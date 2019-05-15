package com.sophos.poc.wsrestmongoclient.controllers;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sophos.poc.wsrestmongoclient.dto.Accounts;
import com.sophos.poc.wsrestmongoclient.models.AccountType;
import com.sophos.poc.wsrestmongoclient.models.ConsultaSaldoReq;
import com.sophos.poc.wsrestmongoclient.models.ConsultaSaldoRes;
import com.sophos.poc.wsrestmongoclient.models.StatusType;
import com.sophos.poc.wsrestmongoclient.repositories.AccountsRepository;

@RestController
@RequestMapping("/accounts")
public class AccountsRestController {
	@Autowired
	private AccountsRepository repository;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Accounts> getAllAcct() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ConsultaSaldoRes> getAcctById(@PathVariable("id") String id) {
		try {
			ConsultaSaldoRes rs = new ConsultaSaldoRes();
			rs.setId_trn(UUID.randomUUID().toString());
			rs.setAuth_code(UUID.randomUUID().toString());
			rs.setServer_date(Calendar.getInstance().getTime());
			rs.setDate(Calendar.getInstance().getTime());
			StatusType status = new StatusType();
			status.setStatus_code(HttpStatus.OK.toString());
			status.setStatus_desc(HttpStatus.OK.name());
			status.setStatus_info(HttpStatus.OK.getReasonPhrase());
			rs.setStatus(status);
			Accounts dbAccount = repository.findBy_id(id);			
			ObjectMapper mapper = new ObjectMapper();
			AccountType account  = mapper.readValue(new StringReader(dbAccount.toString()), AccountType.class);
			rs.setAccount(account);			
			return new ResponseEntity<ConsultaSaldoRes>(rs, HttpStatus.OK);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyAcctById(@PathVariable("id") ObjectId id, @Valid @RequestBody AccountType acctRq) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Accounts acct;
			acct = mapper.readValue(new StringReader(acctRq.toString()), Accounts.class);
			acct.set_id(id);
			repository.save(acct);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AccountType> createAcct(@Valid @RequestBody ConsultaSaldoReq rq) {
		try {
			Accounts acct = new Accounts(ObjectId.get(), rq.getAccount_id(), rq.getAccount_type(), rq.getCard_id(), rq.getPin(), new BigDecimal(0), "COP");
			acct.set_id(ObjectId.get());
			repository.save(acct);
			ObjectMapper mapper = new ObjectMapper();
			AccountType acctRs;
			acctRs = mapper.readValue(acct.toString(),AccountType.class);
			return new ResponseEntity<AccountType>(acctRs,HttpStatus.OK);
		} catch (JsonParseException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteAcct(@PathVariable String id) {
		repository.delete(repository.findBy_id(id));
	}
	
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
