package com.yaolala.dobigthing.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yaolala.dobigthing.dao.ResultSet2EntityMapping;
import com.yaolala.dobigthing.entity.User;

public class UserMapping implements ResultSet2EntityMapping {

	public Object mapping(ResultSet rs) throws SQLException {
		int i = 1;
		User u = new User();
		u.setId(rs.getInt(i++));
		u.setPwd(rs.getString(i++));
		u.setName(rs.getString(i++));
		return u;
	}

}
