package com.wjk.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class App {

	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setName("李四");

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);

		transaction.commit();// 提交事物
		session.close();// 关闭，释放资源
	}

	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = (User) session.get(User.class, 5);
		System.out.println("user=" + user);

		transaction.commit();// 提交事物
		session.close();// 关闭，释放资源
	}

}
