package com.yaolala.dobigthing.dao.impl;

import java.util.List;
import java.util.Map;

import com.yaolala.dobigthing.dao.IBaseDao;
import com.yaolala.dobigthing.dao.ResultSet2EntityMapping;
import com.yaolala.dobigthing.util.DBUtil;

public class BaseDaoImpl implements IBaseDao {
	@Override
	public List<Map<String, String>> executeQuery(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> query(String sql, Object[] args) {
		DBUtil dbUtil = new DBUtil();
		List<Object[]> result = dbUtil.query(sql, args); 
		return result;
	}

	@Override
	public int executeUpdate(String sql, Object[] args) {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.executeUpdate(sql, args);
	}

	@Override
	public List query(String sql, Object[] args, ResultSet2EntityMapping mapping) {
		DBUtil dbUtil = new DBUtil();
		List list = dbUtil.query(sql, args, mapping);
		return list;
	}


}
