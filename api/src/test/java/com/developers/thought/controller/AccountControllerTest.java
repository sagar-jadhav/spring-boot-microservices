package com.developers.thought.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.developers.thought.model.Account;
import com.developers.thought.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountControllerTest {

	@InjectMocks
	AccountController controller;

	@Mock
	AccountService service;

	@Test
	public void whenIdGivenIsPresentThenItShouldReturnAccount() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(mockAccount.getId()).thenReturn(id);
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(service.getAccountById(id)).thenReturn(mockAccount);
		when(service.isAccountPresent(id)).thenReturn(true);

		ResponseEntity<Account> responseEntity = controller.getAccountById(id);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockAccount, responseEntity.getBody());
	}

	@Test
	public void whenIdGivenIsNotPresentThenItShouldReturnResponseWithNotFoundStatusCode() {
		Long id = new Long(1);

		when(service.isAccountPresent(id)).thenReturn(false);

		ResponseEntity<Account> responseEntity = controller.getAccountById(id);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		assertEquals(null, responseEntity.getBody());
	}

	@Test
	public void whenGetAccountsInvokedItShouldReturnAccountList() {
		List<Account> accounts = new ArrayList<>();
		Account mockAccount = mock(Account.class);
		accounts.add(mockAccount);

		when(mockAccount.getId()).thenReturn(new Long(1));
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(service.getAccounts()).thenReturn(accounts);

		ResponseEntity<List<Account>> responseEntity = controller.getAccounts();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(accounts.size(), responseEntity.getBody().size());
		assertEquals(accounts.get(0), responseEntity.getBody().get(0));
	}

	@Test
	public void whenAddAccountInvokedItShouldReturnAddedAccount() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(mockAccount.getId()).thenReturn(id);
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(service.addAccount(mockAccount)).thenReturn(mockAccount);

		ResponseEntity<Account> responseEntity = controller.addAccount(mockAccount);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals(mockAccount, responseEntity.getBody());
	}

	@Test
	public void whenUpdateAccountInvokedWithIdWhichIsPresentThenItShouldReturnUpdatedAccount() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(mockAccount.getId()).thenReturn(id);
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(service.updateAccount(id, mockAccount)).thenReturn(mockAccount);
		when(service.isAccountPresent(id)).thenReturn(true);

		ResponseEntity<Account> responseEntity = controller.updateAccount(id, mockAccount);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(mockAccount, responseEntity.getBody());
	}

	@Test
	public void whenUpdateAccountInvokedWithIdWhichIsNotPresentThenItShouldReturnNotFoundStatus() {
		Long id = new Long(1);
		when(service.isAccountPresent(id)).thenReturn(false);

		ResponseEntity<Account> responseEntity = controller.updateAccount(id, null);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
		assertEquals(null, responseEntity.getBody());
	}

	@Test
	public void whenDeleteAccountInvokedWithIdWhichIsPresentThenItShouldReturnOKStatus() {
		Long id = new Long(1);

		when(service.isAccountPresent(id)).thenReturn(true);

		ResponseEntity<String> responseEntity = controller.deleteAccount(id);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void whenDeleteAccountInvokedWithIdWhichIsNotPresentThenItShouldReturnNotFoundStatus() {
		Long id = new Long(1);

		when(service.isAccountPresent(id)).thenReturn(false);

		ResponseEntity<String> responseEntity = controller.deleteAccount(id);
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
