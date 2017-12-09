package com.yaolala.dobigthing.dao.user.impl;

import java.io.Serializable;
import java.util.List;

import com.yaolala.dobigthing.dao.impl.BaseDaoImpl;
import com.yaolala.dobigthing.dao.user.IUserDao;
import com.yaolala.dobigthing.entity.User;
import com.yaolala.dobigthing.mapping.UserMapping;
import com.yaolala.dobigthing.util.DBUtil;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao{

	@Override
	public User findById(Serializable id) {
		String sql = "select * from t_user where id=? ";
		List<User> users = this.query(sql, new Object[]{id}, new UserMapping());
		return users.get(0);
	}

	@Override
	public int save(User u) {
		String sql = "insert into t_user values(?, ?, ?)";
		return this.executeUpdate(sql, new Object[]{u.getId(), u.getAge(), u.getName()});
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from t_user where 1=1 ";
		List<User> users = this.query(sql, null, new UserMapping());
		return users;
	}

}
