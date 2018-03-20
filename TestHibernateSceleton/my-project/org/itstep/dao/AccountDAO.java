package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Account;
import org.itstep.util.HibernateUtil;

public class AccountDAO {

	private Session session;

	public void save(Account account) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.save(account);

		session.getTransaction().commit();

		session.close();
	}

	public Account get(String login) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		Account account = session.get(Account.class, login);

		session.getTransaction().commit();

		session.close();

		return account;
	}

	public List<Account> getByNameAndPassword(String name, String password) {

		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		Query query = session.createNativeQuery("SELECT * FROM accounts WHERE first_name=:name AND password=:pass",
				Account.class);

		query.setParameter("name", name);

		query.setParameter("pass", password);

		List<Account> result = query.getResultList();

		session.getTransaction().commit();

		session.close();

		return result;
	}

	public void delete(Account account) {
		session = HibernateUtil.getSessionFactory().openSession();

		session.getTransaction().begin();

		session.delete(account);

		session.getTransaction().commit();

		session.close();

	}
}