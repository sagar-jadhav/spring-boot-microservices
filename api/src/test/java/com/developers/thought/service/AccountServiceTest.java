package com.developers.thought.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.developers.thought.model.Account;
import com.developers.thought.repository.AccountRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest {

	@InjectMocks
	AccountService service;

	@Mock
	AccountRepository repository;

	@Test
	public void whenAccountIsPresentThenItShouldReturnTrue() {
		Long id = new Long(1);
		when(repository.existsById(id)).thenReturn(true);
		assertTrue(service.isAccountPresent(id));
	}

	@Test
	public void whenIdIsGivenThenItShouldReturnAccount() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(repository.findById(id)).thenReturn(Optional.of(mockAccount));
		assertEquals(mockAccount, service.getAccountById(id));
	}

	@Test
	public void whenAccountIsPresentThenItShouldReturnAccountList() {
		List<Account> accounts = new ArrayList<>();
		Account mockAccount = mock(Account.class);
		accounts.add(mockAccount);

		when(mockAccount.getId()).thenReturn(new Long(1));
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(repository.findAll()).thenReturn(new Iterable<Account>() {
			@Override
			public Iterator<Account> iterator() {
				return accounts.iterator();
			}
		});

		List<Account> retrievedAccounts = service.getAccounts();
		assertEquals(retrievedAccounts.size(), accounts.size());
		assertEquals(retrievedAccounts.get(0), accounts.get(0));
	}

	@Test
	public void whenAddingAccountThenAddedAccountShouldReturn() {
		Account mockAccount = mock(Account.class);

		when(mockAccount.getId()).thenReturn(new Long(1));
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(repository.save(mockAccount)).thenReturn(mockAccount);

		assertEquals(mockAccount, service.addAccount(mockAccount));
	}

	@Test
	public void whenUpdatingAccountThenUpdatedAccountShouldReturn() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(mockAccount.getId()).thenReturn(id);
		when(mockAccount.getName()).thenReturn("Sagar Jadhav");
		when(repository.findById(id)).thenReturn(Optional.of(mockAccount));
		when(repository.save(mockAccount)).thenReturn(mockAccount);

		assertEquals(mockAccount, service.updateAccount(id, mockAccount));
	}

	@Test
	public void whenDeletingAccountDeleteMethodShouldInvoked() {
		Account mockAccount = mock(Account.class);
		Long id = new Long(1);

		when(repository.findById(id)).thenReturn(Optional.of(mockAccount));

		service.deleteAccount(id);
		verify(repository, times(1)).delete(mockAccount);
	}
}
