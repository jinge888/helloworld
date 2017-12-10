package com.yaolala.dobigthing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yaolala.dobigthing.dao.IBaseDao;
import com.yaolala.dobigthing.dao.ResultSet2EntityMapping;
import com.yaolala.dobigthing.util.DBUtil;

public class BaseDaoImpl implements IBaseDao {
	public List<Map<String, String>> executeQuery(String sql, Object[] params) {
		Connection connection =DBUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet rset=null; //结果集
		List<Map<String, String>> list = null;
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			//给SQL语句不确定参数赋值
			for(int i=1;i<params.length;i++){
				preparedStatement.setObject(i, params[i-1]);
				rset = preparedStatement.executeQuery();
			}
			//获取rset元数据
			ResultSetMetaData metaData = rset.getMetaData();
			list = new ArrayList<Map<String, String>>();
			Map<String, String> map = new HashMap<String,String>();
			
			while (rset.next()) {
				//得到表有几列
				int columnCount = metaData.getColumnCount();
				//构建map对象
				for(int i=0; i<columnCount; i++ ){  
	                String cols_name = metaData.getColumnName(i+1);  //获取列名
	                String cols_value = rset.getString(cols_name);  
	    			//通过map赋值
	                map.put(cols_name, cols_value);
	            }
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> query(String sql, Object[] args) {
		DBUtil dbUtil = new DBUtil();
		List<Object[]> result = dbUtil.query(sql, args); 
		return result;
	}

	public int executeUpdate(String sql, Object[] args) {
		DBUtil dbUtil = new DBUtil();
		return dbUtil.executeUpdate(sql, args);
	}


	public List query(String sql, Object[] args, ResultSet2EntityMapping mapping) {
		DBUtil dbUtil = new DBUtil();
		List list = dbUtil.query(sql, args, mapping);
		return list;
	}


}
