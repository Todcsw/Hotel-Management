package cn.hms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 连接数据库工具类
 * 
 * @author 行路
 *
 */
public class BaseJdbcForMySQL {
	// MySQL驱动类
	private static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	// 连接字符串
	private static final String URL = "jdbc:mysql://localhost:3306/hms?useunicode=true&characterEncoding=UTF-8";

	// mysql用户名
	private static final String UNAME = "root";

	// mysql 密码
	private static final String UPWD = "485226";

	/**
	 * 建立数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			// 1,加载驱动类
			Class.forName(DRIVERCLASS);
			// 2,获取连接
			conn = DriverManager.getConnection(URL, UNAME, UPWD);
		} catch (Exception ex) {
			throw ex;
		}
		return conn;
	}
    /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     * @throws Exception
     */
	public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
