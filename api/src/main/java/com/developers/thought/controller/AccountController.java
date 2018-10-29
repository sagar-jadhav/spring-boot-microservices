package com.developers.thought.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developers.thought.model.Account;
import com.developers.thought.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService service;

	@RequestMapping(path = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		if (!service.isAccountPresent(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(service.getAccountById(id));
	}

	@RequestMapping(path = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAccounts() {
		return ResponseEntity.ok(service.getAccounts());
	}

	@RequestMapping(path = "/account", method = RequestMethod.POST)
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addAccount(account));
	}

	@RequestMapping(path = "/account/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
		if (!service.isAccountPresent(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(service.updateAccount(id, account));
	}

	@RequestMapping(path = "/account/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
		if (!service.isAccountPresent(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		service.deleteAccount(id);
		return ResponseEntity.ok(String.format("Account with ID : %d is deleted successfuly", id));
	}

}
