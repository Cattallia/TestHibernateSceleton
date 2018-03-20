package org.itstep.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoodActionDAOTest {

	GoodAction action = new GoodAction();

	Good good;
	Account account;

	@Before
	public void setDataToDB() {
		good = new Good("asin12345", "test_name", "test_shop_url", 5);
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.save(good);

		account = new Account("ignatenko2207", "123456", "Alex", "Ignatenko", new Date(82, 7, 22).getTime());
		AccountDAO accountDAO = new AccountDAO();
		accountDAO.save(account);

		GoodActionDAO actionDAO = new GoodActionDAO();
		action.setAction("test action");
		action.setAddedToCart(Boolean.TRUE);
		action.setTimeAction(System.currentTimeMillis());
		action.setAccount(account);
		action.setGood(good);

		actionDAO.save(action);
	}

	@Test
	public void testGetByAccountAndGood() {
		GoodActionDAO actionDAO = new GoodActionDAO();
		List<GoodAction> actionList = actionDAO.getByAccountAndGood(account.getLogin(), good.getAsin());

		assertNotNull(actionList);

		assertTrue(!actionList.isEmpty());
	}

	@After
	public void removeTempDataFromDB() {
		GoodActionDAO actionDAO = new GoodActionDAO();
		actionDAO.delete(action);

		GoodDAO goodDAO = new GoodDAO();
		goodDAO.delete(good);

		AccountDAO accountDAO = new AccountDAO();
		accountDAO.delete(account);
	}
}