package com.yaolala.dobigthing.service;

import java.util.Collection;
import java.util.List;

import com.yaolala.dobigthing.dao.user.IUserDao;
import com.yaolala.dobigthing.dao.user.impl.UserDaoImpl;
import com.yaolala.dobigthing.entity.User;

public class UserService {
	private IUserDao iUserDao = new UserDaoImpl();
	/**
	 * 保存用户信息
	 * @param user
	 */
	public boolean addUser(User user){
		int result =iUserDao.save(user);
		return result>0?true:false;
	}
	public User findUserById(int id){
		return iUserDao.findUserById(id);
	}
	/**
	 * 更新用户信息
	 * @param user
	 */
	public boolean updateUser(User user){
		int result = iUserDao.update(user);
		return result>0?true:false;
	}
	/**
	 * 根据id删除用户
	 * @param id
	 */
	public boolean deleteUserById(int id){
		int result = iUserDao.deleteById(id);
		return result>0?true:false;
	}
	/**
	 * 根据id,密码查询用户，用于登录
	 * @param id
	 * @param pwd
	 * @return
	 */
	public User getUser(int id,String pwd){
		return iUserDao.getUser(id, pwd);
	}
	/**
	 * 根据id集合查询对应的用户信息集合
	 * @param ids
	 * @return
	 */
	public List<User> getUsers(Collection<Integer> ids){
		return iUserDao.findAll(ids);
		}
	/**
	 * 获取全部用户列表
	 * @return
	 */
	public List<User> getAllUser(){
		return iUserDao.findAll();
	}
	
	}


