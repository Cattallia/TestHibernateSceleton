package org.itstep;

import java.util.Date;

import org.hibernate.Session;
import org.itstep.model.Account;
import org.itstep.util.HibernateUtil;

/**
 * @author Katya Topol
 */
public class App {
 public static void main(String[] args) {
  
  Account account = new Account("ignatenko22071", "1234561", "Alex1", "Ignatenko1", new Date(82, 7, 22).getTime());

  Account account2 = new Account("kjdshgfks1", "skgfbshj1", "skjdhbfkjsfv1", "jshgfhjsf1", 123456789L);
  HibernateUtil hUtil = new HibernateUtil();
  
  Session session = hUtil.getSessionFactory().openSession();

  session.getTransaction().begin();

  session.save(account);
  session.save(account2);
  session.save(new Account("sfsgsrg", "wfrasgsrg", "swrfgsr", "sedfeafswf", 125874L));
  

  session.getTransaction().commit();

  session.close();

  System.out.println("Transactions completed!");
 }
}