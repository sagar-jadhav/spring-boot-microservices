package com.sjtech.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sjtech.domain.Account;
import com.sjtech.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerTest {

	@InjectMocks
	private AccountController controller;
	
	@Mock
	private AccountRepository repository;
	
	@Test
	public void whenGetAccountByIdThenReturnAccount() {
		Account account = mock(Account.class);
		when(account.getId()).thenReturn(1);
		when(account.getName()).thenReturn("account");
		
		when(repository.findOne(1)).thenReturn(account);
		
		ResponseEntity<Account> response = controller.getAccountById(1);
		assertEquals(account, response.getBody());
	}
	
}
