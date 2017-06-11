package com.wjk.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.wjk.test.User;

public class UserDaoTest {

	private UserDao userDao = new UserDao();

	@Test
	public void testSave() {
		User user = new User();
		user.setName("王五");

		userDao.save(user);
	}

	@Test
	public void testUpdate() {
		// 先从数据库获取一条存在的数据
		User user = userDao.getById(7);
		user.setName("陈六");
		// 更新
		userDao.update(user);
	}

	@Test
	public void testDelete() {
		userDao.delete(7);
	}

	@Test
	public void testGetById() {
		User user = userDao.getById(1);
		System.out.println("getById==" + user);
	}

	@Test
	public void testFindAll() {
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println("findAll==" + user);
		}
	}
	
	//------------------------
	
	@Test
	public void testSave25() {
		for (int i = 0; i < 25; i++) {
			User user = new User();
			user.setName("张七"+i);
			userDao.save(user);
		}
	}

	@Test
	public void testFindAllIntInt() {
//		QueryResult result=userDao.findAll(0, 10);
//		QueryResult result=userDao.findAll(10, 10);
		QueryResult result=userDao.findAll(20, 10);
		
		System.out.println("总记录数=="+result.getCount());
		for(User user:result.getList()){
			System.out.println("findAllByPage=="+user);
		}
	}

}
