package com.sjtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sjtech.domain.Account;
import com.sjtech.repository.AccountRepository;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository repository;
	
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(repository.findOne(id));
	}
	
	@RequestMapping(value="/accounts/", method=RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok().body(repository.findAll());
	}
	
	@RequestMapping(value="/accounts/", method=RequestMethod.POST)
	public ResponseEntity<Void> createAccount(@RequestBody Account account) {
		repository.saveAndFlush(account);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value="/accounts/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
		repository.delete(id);
		return ResponseEntity.ok().build();
	}
}
