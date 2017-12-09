package com.yaolala.dobigthing.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {

	/**
	 * 执行sql查询, 返回List《Map》
	 * Map就是数据库中的一行
	 * @param sql sql语句
	 * @param params 查询条件
	 * @return 结果
	 */
	List<Map<String, String>> executeQuery(String sql, Object[] params);
	
	/**
	 * 执行sql查询，返回List《Object【】》
	 * @param sql
	 * @param args
	 * @return
	 */
	List<Object[]> query(String sql, Object[] args);
	
	/**
	 * 根据sql语句查询，返回List《实体类》
	 * @param sql 
	 * @param args
	 * @param mapping ResultSet到实体类字段的映射
	 * @return
	 */
	List query(String sql, Object[] args, ResultSet2EntityMapping mapping);
	/**
	 * 执行sql更新操作
	 * @param sql
	 * @param params
	 * @return 受影响的行数
	 */
	int executeUpdate(String sql, Object[] params);
	
}
