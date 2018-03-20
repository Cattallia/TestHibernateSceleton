package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.GoodAction;
import org.itstep.util.HibernateUtil;

public class GoodActionDAO {

	private Session session;

	public void save(GoodAction goodAction) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(goodAction);

		session.getTransaction().commit();

		session.close();
	}

	public List<GoodAction> getByAccountAndGood(String acclogin, String goodAsin) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		Query query = session.createNativeQuery(
				"SELECT * FROM good_actions WHERE account_login= :acc_login AND good_asin= :asin", GoodAction.class);

		query.setParameter("acc_login", acclogin);

		query.setParameter("asin", goodAsin);

		List<GoodAction> result = query.getResultList();

		session.getTransaction().commit();

		session.close();

		return result;
	}

	public void delete(GoodAction goodAction) {
		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.delete(goodAction);

		session.getTransaction().commit();

		session.close();

	}
}