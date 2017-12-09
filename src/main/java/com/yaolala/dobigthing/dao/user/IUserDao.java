package com.yaolala.dobigthing.dao.user;

import java.io.Serializable;
import java.util.List;

import com.yaolala.dobigthing.dao.IBaseDao;
import com.yaolala.dobigthing.entity.User;

public interface IUserDao extends IBaseDao {
	
	User findById(Serializable id);
	
	int save(User u);

	List<User> findAll();
}
