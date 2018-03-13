package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.itstep.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountDAOTest {

	Account account;

	@Before
	public void setDataToDB() {
		account = new Account("ignatenko2207", "123456", "Alex", "Ignatenko", new Date(82, 7, 22).getTime());
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);
	}

	@Test
	public void testSaveAndGet() {

		AccountDAO accountDAO = new AccountDAO();

		assertNotNull(accountDAO.get(account.getLogin()));
		assertEquals("ignatenko2207", accountDAO.get("ignatenko2207").getLogin());

	}

	@Test
	public void testGetByNameAndPassword() {
		AccountDAO accountDAO = new AccountDAO();

		List<Account> testAccounts = accountDAO.getByNameAndPassword(account.getFirstName(), account.getPassword());
		assertTrue(!testAccounts.isEmpty());
	}

	@After
	public void removeTempDataFromDB() {
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.delete(account);
	}

}
