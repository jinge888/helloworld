package com.yaolala.dobigthing.dao.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.yaolala.dobigthing.dao.IBaseDao;
import com.yaolala.dobigthing.entity.User;

public interface IUserDao extends IBaseDao {
	
	/**
	 * 根据用户id、密码查询，用于登录
	 * @param id  
	 * @param pwd 
	 * @return  查询到的唯一用户实体
	 */
    User getUser(int id, String pwd);
    /**
     * 保存用户
     * @param user
     * @return
     */
	int save(User user);
	
	int deleteById(int id);
	/**
	 * 
	 * @param user
	 */
	int update(User user);
	
	/**
	 * 根据id 获得用户实体对象
	 * @param id
	 * @return
	 */
	User findUserById(int id);
	
	/**
	 * 获取所有用户列表
	 * @return
	 */
	List<User> findAll();
	
	/**
	 * 
	 * @param ids
	 * @return
	 */
	List<User> findAll(Collection<Integer> ids);
	
	
	
}
