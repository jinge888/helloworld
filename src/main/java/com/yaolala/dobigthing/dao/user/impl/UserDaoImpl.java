package com.yaolala.dobigthing.dao.user.impl;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.yaolala.dobigthing.dao.impl.BaseDaoImpl;
import com.yaolala.dobigthing.dao.user.IUserDao;
import com.yaolala.dobigthing.entity.User;
import com.yaolala.dobigthing.mapping.UserMapping;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao{
	
	public int save(User u) {
		String sql = "insert into auth_user(id,name,pwd) values(?, ?, ?)";
		return this.executeUpdate(sql, new Object[]{u.getId(), u.getName(), u.getPwd()});
	}

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		String sql = "select * from auth_user where 1=1 ";
		List<User> userList = this.query(sql, null, new UserMapping());
		return userList;
	}

	public User getUser(int id, String pwd) {
		String sql = "select * from auth_user where id = ? and pwd = ?";
		List<User> users = this.query(sql, new Object[]{id,pwd},new UserMapping());
		return users.get(0);
	}

	public int deleteById(int id) {
		String sql = "delete from auth_user where id=?";
		return this.executeUpdate(sql,new Object[]{id});
		 
	}

	public int update(User user) {
		String sql = "update auth_user set name = ? , pwd = ? where id=?"; 
		return executeUpdate(sql,new Object[]{user.getName(),user.getPwd(),user.getId()});
	}
	
	public User findUserById(int id) {
		String sql = "select * from auth_user where id=? ";
		List<User> users = this.query(sql, new Object[]{id}, new UserMapping());
		return users.get(0);
	}

	
	public List<User> findAll(Collection<Integer> ids) {
		StringBuilder sql = new StringBuilder("select * from auth_user where id in ? (");
		Object[] args = new Object[ids.size()];
		AtomicInteger index = new AtomicInteger(0);//处理多线程并发问题
		ids.forEach((id)->{  //jdk8 循环：每次循环结果赋值给变量id
		sql.append(id).append("?,");
		args[index.getAndIncrement()] = id;
		});
		sql.deleteCharAt(sql.length()-2);
		sql.append(")");
		return query(sql.toString(), ids.toArray(new Object[0]), new UserMapping());
	}


}
