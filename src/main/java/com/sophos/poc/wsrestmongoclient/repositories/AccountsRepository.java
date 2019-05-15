package com.sophos.poc.wsrestmongoclient.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sophos.poc.wsrestmongoclient.dto.Accounts;

public interface AccountsRepository extends MongoRepository<Accounts, String> {

	Accounts findBy_id(String id);
}
