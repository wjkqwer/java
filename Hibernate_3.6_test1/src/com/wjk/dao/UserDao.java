package com.wjk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wjk.test.User;

public class UserDao {

	// 保存
	public void save(User user) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit(); // 提交事物
		} catch (RuntimeException e) {
			transaction.rollback(); // 回滚事物
			throw e;
		} finally {
			session.close(); // 关闭session
		}
	}

	// 更新
	public void update(User user) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// 操作
			session.update(user);

			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	// 删除
	public void delete(int id) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// 操作
			User user = (User) session.get(User.class, id);
			session.delete(user);

			transaction.commit();
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	// 按id查找
	public User getById(int id) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// 操作
			User user = (User) session.get(User.class, id);

			transaction.commit();

			return user;
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	// 查找全部
	public List<User> findAll() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// 操作
			// 方式一：使用HQL查询
//			List<User> list = session.createQuery("FROM User").list(); 
			
			// 方式二：使用Criteria查询
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			
			transaction.commit();
			return list;
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * 分页查找,
	 * 
	 * @param fristResult
	 *            从结果列表中的哪个索引开始取数据
	 * @param maxResult
	 *            最多取多少条数据
	 * @return 一页的数据列表 和 总记录数
	 */
	public QueryResult findAll(int fristResult, int maxResult) {
		Session session = HibernateUtils.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			// 操作
			//查询数据列表
			Query query = session.createQuery("FROM User") //
					.setFirstResult(fristResult) //
					.setMaxResults(maxResult);
			
			List<User> list = query.list();
			
			//查询总记录数
			Long count=(Long) session.createQuery("SELECT COUNT(*) FROM User").uniqueResult();
			
			transaction.commit();
			return new QueryResult(count.intValue(), list);
		} catch (RuntimeException e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

}
