package com.yaolala.dobigthing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.yaolala.dobigthing.dao.ResultSet2EntityMapping;

public class DBUtil {
	private static Logger logger = Logger.getLogger(DBUtil.class);
	/**private static final String USER_NAME = "root";
	private static final String PWD = "1";
	private static final String DBURL = "jdbc:mysql://localhost:3306/java";**/
	private Connection conn = null;//声明Connection对象的实例
	private Statement statement =null;//声明传输并执行SQL的Statement对象实例
    private PreparedStatement preparedStatment = null;//执行动态查询SQL语句，使用此对象多次查询
    private ResultSet rs = null;//声明结果集ResultSet对象实例
    
	/**
	 * 获得数据库连接
	 * @return
	*/
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DBConfig.DRIVER_NAME);
            conn = DriverManager.getConnection(DBConfig.DATABASE_URL + DBConfig.DATABASE, DBConfig.USER_NAME, DBConfig.PWD);
        } catch (ClassNotFoundException e) {
        		logger.error("找不到数据库驱动", e);
        } catch (SQLException e) {
        		logger.error("获取数据库连接异常", e);
        }
        return conn;
    } 
    
    /**
     * 
     * @param sql
     * @param args
     * @return SQLException 
     */
    public List<Object[]> query(String sql, Object[] args) {
    	List<Object[]> list = new ArrayList<Object[]>();
        try {
            Class.forName(DBConfig.DRIVER_NAME);
            conn = DriverManager.getConnection(DBConfig.DATABASE_URL + DBConfig.DATABASE, DBConfig.USER_NAME, DBConfig.PWD);
            preparedStatment = conn.prepareStatement(sql);
            if(args != null) {
	            for (int i = 0; i < args.length; i++) {
					preparedStatment.setObject(i+1, args[i]);
				}
            }
            rs = preparedStatment.executeQuery();
            ResultSetMetaData md = rs.getMetaData(); //获得结果集结构信息,元数据  
            int columnCount = md.getColumnCount();   //获得查询结果的列数 
            while (rs.next()) { //循环所有的行
            	//Map<String, Object> rowData = new HashMap<String,Object>();
            	Object[] rowData = new Object[columnCount]; //表结构信息
                for (int i = 0; i <columnCount; i++) {  
                    //rowData.put(md.getColumnName(i), rs.getObject(i));
                	rowData[i]  = rs.getObject(i+1);
                }  
                list.add(rowData); 
			}
        } catch (ClassNotFoundException e) {
            logger.error("找不到数据库驱动", e);
        } catch (SQLException e) {
        	logger.error("获取数据库连接异常", e);
        } finally {
        	this.close();
        }
        return list;
    }
  /**
   *   
   * @param sql
   * @param args 参数
   * @param mapping 数据库结果集到实体类映射
   * @return
   */
    public List query(String sql, Object[] args, ResultSet2EntityMapping mapping) {
    	List<Object> list = new ArrayList<Object>();
        try {
            Class.forName(DBConfig.DRIVER_NAME);
            conn = DriverManager.getConnection(DBConfig.DATABASE_URL + DBConfig.DATABASE, DBConfig.USER_NAME, DBConfig.PWD);
            preparedStatment = conn.prepareStatement(sql);
            if(args != null) {
            	for (int i = 0; i < args.length; i++) {
    				preparedStatment.setObject(i+1, args[i]);
    			}
    		}
            rs = preparedStatment.executeQuery();//返回查询结果  
           
            //得到表结构的信息
            ResultSetMetaData metaData =rs.getMetaData();
            //得到表的列
            int col_len = metaData.getColumnCount();
            while (rs.next()) { //循环所有的行
            	Object obj = mapping.mapping(rs);
            	list.add(obj);
			}
        } catch (ClassNotFoundException e) {
            logger.error("找不到数据库驱动", e);
        } catch (SQLException e) {
        	logger.error("数据库查询异常", e);
        } finally {
        	this.close();
        }
        return list;
    }
    
    public int executeUpdate(String sql, Object[] args) { 
    	int rows = 0;
    	try {
            Class.forName(DBConfig.DRIVER_NAME);
            conn = DriverManager.getConnection(DBConfig.DATABASE_URL + DBConfig.DATABASE, DBConfig.USER_NAME, DBConfig.PWD);
            preparedStatment = conn.prepareStatement(sql);
            if(args != null) {
	            for (int i = 0; i < args.length; i++) {
					preparedStatment.setObject(i+1, args[i]);
				}
            }
            rows = preparedStatment.executeUpdate();
        } catch (ClassNotFoundException e) {
            logger.error("找不到数据库驱动", e);
        } catch (SQLException e) {
        	logger.error("获取数据库连接异常", e);
        } finally {
        	this.close();
        }
        return rows;
    } 
    
    public void close() {
    	try {
            if(rs != null) {
	           rs.close();
            }
            if(preparedStatment != null) {
            	preparedStatment.close();
            }
            if(conn != null) {
	           conn.close();
            }
        } catch (SQLException e) {
           logger.error("关闭数据库资源对象失败", e);
        }
    }
   
    
    /**
     * 关闭数据库资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
        try {
        	if(rs!=null) {
            	rs.close();
	        }
	        if(stmt!=null) {
	            	stmt.close();
	        }
	        if(conn!=null) {
	            	conn.close();
	        }  
        } catch (SQLException e) {
           logger.error("关闭数据库资源对象失败", e);
        }
    }
}
