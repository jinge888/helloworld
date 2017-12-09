package com.yaolala.dobigthing.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库结果集到实体类的映射接口
 * @author liaoxiaojin
 *
 */
public interface ResultSet2EntityMapping {

	/**
	 * 将数据库中的一行转换成一个实体对象
	 * @param rs sql查询结果的一行
	 * @return 一个实体类对象
	 * @throws SQLException
	 */
	Object mapping(ResultSet rs) throws SQLException;
}
