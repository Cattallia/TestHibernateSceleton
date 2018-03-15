package org.itstep.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.itstep.model.Good;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GoodDAOTest {

	Good good = new Good();;

	@Before
	public void setDataToDB() {
		good = new Good("asin12345", "test_name", "test_shop_url", 5);
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.save(good);
	}

	@Test
	public void testSaveAndGet() {

		GoodDAO goodDAO = new GoodDAO();

		assertNotNull(good.getAsin());
		assertNotNull(goodDAO.get("asin12345").getAsin());
		assertEquals("asin12345", goodDAO.get("asin12345").getAsin());

	}

	@Test
	public void testGetByNameAndShopUrl() {
		GoodDAO goodDAO = new GoodDAO();

		List<Good> testGoods = goodDAO.getByNameAndShopUrl(good.getName(), good.getShopUrl());
		assertTrue(!testGoods.isEmpty());
	}

	@After
	public void removeTempDataFromDB() {
		GoodDAO goodDAO = new GoodDAO();
		goodDAO.delete(good);
	}

}