package com.yaolala.dobigthing.dao.user;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.yaolala.dobigthing.dao.user.impl.UserDaoImpl;
import com.yaolala.dobigthing.entity.User;

/**
 * 测试啊
 * @author liaoxiaojin
 *
 */
public class TestUserDao {
	
	@Test
	public void testFindById() {
		IUserDao userDao = new UserDaoImpl();
		User u = userDao.findUserById(11);
		System.out.println(u);
		Assert.assertEquals("liaoxiaojin", u.getName());
	}

	@Test
	public void testSave() {
		IUserDao userDao = new UserDaoImpl();
		User u = new User();
		Random r = new Random();
		u.setId(r.nextInt(50));
		u.setName("test");
		u.setAge(r.nextInt(40));
		int rows =userDao.save(u);
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testFindAll() {
		IUserDao userDao = new UserDaoImpl();
		List<User> list = userDao.findAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
