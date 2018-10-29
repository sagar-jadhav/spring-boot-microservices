package com.developers.thought.repository;

import org.springframework.data.repository.CrudRepository;

import com.developers.thought.model.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
